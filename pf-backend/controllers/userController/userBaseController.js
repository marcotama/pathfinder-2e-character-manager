/**
 * Created by Navit
 */

/**
 * Please use appLogger for logging in this file try to abstain from console
 * levels of logging:
 * - TRACE - ‘blue’
 * - DEBUG - ‘cyan’
 * - INFO - ‘green’
 * - WARN - ‘yellow’
 * - ERROR - ‘red’
 * - FATAL - ‘magenta’
 */

var Service = require("../../services");
var UniversalFunctions = require("../../utils/universalFunctions");
var async = require("async");
// var UploadManager = require('../../lib/uploadManager');
var TokenManager = require("../../lib/tokenManager");
var CodeGenerator = require("../../lib/codeGenerator");
var CONFIG = require("../../config");
var ERROR = UniversalFunctions.CONFIG.APP_CONSTANTS.STATUS_MSG.ERROR;
var _ = require("underscore");

var createUser = function (payloadData, callback) {
  var accessToken = null;
  var uniqueCode = null;
  var dataToSave = payloadData;
  if (dataToSave.password)
    dataToSave.password = UniversalFunctions.CryptData(dataToSave.password);
  var customerData = null;
  var appVersion = null;
  async.series(
    [
      function (cb) {
        var query = {
          $or: [{ emailId: payloadData.emailId }]
        };
        Service.UserService.getUser(query, {}, { lean: true }, function (
          error,
          data
        ) {
          if (error) {
            cb(error);
          } else {
            if (data && data.length > 0) {
              if (data[0].emailVerified == true) {
                cb(ERROR.USER_ALREADY_REGISTERED);
              } else {
                Service.UserService.deleteUser({ _id: data[0]._id }, function (
                  err,
                  updatedData
                ) {
                  if (err) cb(err);
                  else cb(null);
                });
              }
            } else {
              cb(null);
            }
          }
        });
      },
      function (cb) {
        //Validate for facebookId and password
        if (!dataToSave.password) {
          cb(ERROR.PASSWORD_REQUIRED);
        } else {
          cb();
        }
      },
      function (cb) {
        //Validate countryCode
        if (dataToSave.countryCode.lastIndexOf("+") == 0) {
          if (!isFinite(dataToSave.countryCode.substr(1))) {
            cb(ERROR.INVALID_COUNTRY_CODE);
          } else {
            cb();
          }
        } else {
          cb(ERROR.INVALID_COUNTRY_CODE);
        }
      },
      function (cb) {
        //Validate phone No
        if (
          dataToSave.phoneNumber &&
          dataToSave.phoneNumber.split("")[0] == 0
        ) {
          cb(ERROR.INVALID_PHONE_NO_FORMAT);
        } else {
          cb();
        }
      },
      function (cb) {
        CodeGenerator.generateUniqueCode(
          6,
          UniversalFunctions.CONFIG.APP_CONSTANTS.DATABASE.USER_ROLES.USER,
          function (err, numberObj) {
            if (err) {
              cb(err);
            } else {
              if (!numberObj || numberObj.number == null) {
                cb(ERROR.UNIQUE_CODE_LIMIT_REACHED);
              } else {
                uniqueCode = numberObj.number;
                cb();
              }
            }
          }
        );
      },
      function (cb) {
        //Insert Into DB
        dataToSave.OTPCode = uniqueCode;
        dataToSave.phoneNumber = payloadData.phoneNumber;
        dataToSave.registrationDate = new Date().toISOString();
        dataToSave.firstLogin = true;
        Service.UserService.createUser(dataToSave, function (
          err,
          customerDataFromDB
        ) {
          if (err) {
            if (err.code == 11000 && err.message.indexOf("emailId_1") > -1) {
              cb(ERROR.EMAIL_NO_EXIST);
            } else {
              cb(err);
            }
          } else {
            customerData = customerDataFromDB;
            cb();
          }
        });
      },
      // function (cb) {
      //     //Send SMS to User
      //     if (customerData) {
      //         NotificationManager.sendSMSToUser(uniqueCode, dataToSave.countryCode, dataToSave.mobileNo, function (err, data) {
      //             cb();
      //         })
      //     } else {
      //         cb(ERROR.IMP_ERROR)
      //     }
      //
      // },
      function (cb) {
        //Set Access Token
        if (customerData) {
          var tokenData = {
            id: customerData._id,
            type:
              UniversalFunctions.CONFIG.APP_CONSTANTS.DATABASE.USER_ROLES.USER
          };
          TokenManager.setToken(tokenData, function (err, output) {
            if (err) {
              cb(err);
            } else {
              accessToken = (output && output.accessToken) || null;
              cb();
            }
          });
        } else {
          cb(ERROR.IMP_ERROR);
        }
      },
      function (cb) {
        appVersion = {
          latestIOSVersion: 100,
          latestAndroidVersion: 100,
          criticalAndroidVersion: 100,
          criticalIOSVersion: 100
        };
        cb(null);
      }
    ],
    function (err, data) {
      if (err) {
        callback(err);
      } else {
        callback(null, {
          accessToken: accessToken,
          otpCode: customerData.OTPCode,
          userDetails: UniversalFunctions.deleteUnnecessaryUserData(
            customerData
          ),
          appVersion: appVersion
        });
      }
    }
  );
};

var verifyOTP = function (userData, payloadData, callback) {
  var customerData;
  async.series(
    [
      function (cb) {
        var query = {
          _id: userData._id
        };
        var options = { lean: true };
        Service.UserService.getUser(query, {}, options, function (err, data) {
          if (err) {
            cb(err);
          } else {
            if (data.length == 0) cb(ERROR.INCORRECT_ACCESSTOKEN);
            else {
              customerData = (data && data[0]) || null;
              cb();
            }
          }
        });
      },
      function (cb) {
        //Check verification code :
        if (payloadData.OTPCode == customerData.OTPCode) {
          cb();
        } else {
          cb(ERROR.INVALID_CODE);
        }
      },
      function (cb) {
        //trying to update customer
        var criteria = {
          _id: userData._id,
          OTPCode: payloadData.OTPCode
        };
        var setQuery = {
          $set: { emailVerified: true },
          $unset: { OTPCode: 1 }
        };
        var options = { new: true };
        Service.UserService.updateUser(criteria, setQuery, options, function (
          err,
          updatedData
        ) {
          if (err) {
            cb(err);
          } else {
            if (!updatedData) {
              cb(ERROR.INVALID_CODE);
            } else {
              cb();
            }
          }
        });
      }
    ],
    function (err, result) {
      if (err) {
        callback(err);
      } else {
        callback();
      }
    }
  );
};

var loginUser = function (payloadData, callback) {
  var userFound = false;
  var accessToken = null;
  var successLogin = false;
  var updatedUserDetails = null;
  var userSessionData;
  var appVersion = null;
  var userEnrolledStatus = CONFIG.APP_CONSTANTS.DATABASE.USER_ENROL_STATE.PROGRAM_NOT_ENROLLED;
  var programEnrolledId, moduleEnrolledId, userActiveProgram, userActiveModule;
  async.series(
    [
      function (cb) {
        var criteria = {
          emailId: payloadData.emailId
        };
        var option = {
          lean: true
        };
        Service.UserService.getUser(criteria, {}, option, function (
          err,
          result
        ) {
          if (err) {
            cb(err);
          } else {
            userFound = (result && result[0]) || null;
            cb();
          }
        });
      },
      function (cb) {
        //validations
        if (!userFound) {
          cb(ERROR.USER_NOT_FOUND);
        } else {
          if (userFound.isBlocked) cb(ERROR.ACCOUNT_BLOCKED);
          else {
            if (
              userFound &&
              userFound.password !=
              UniversalFunctions.CryptData(payloadData.password)
            ) {
              cb(ERROR.INCORRECT_PASSWORD);
            } else if (userFound.emailVerified == false) {
              cb(ERROR.NOT_REGISTERED);
            } else {
              successLogin = true;
              cb();
            }
          }
        }
      },
      function (cb) {
        var criteria = {
          _id: userFound._id
        };
        var setQuery = {
          deviceToken: payloadData.deviceToken,
          deviceType: payloadData.deviceType
        };
        Service.UserService.updateUser(
          criteria,
          setQuery,
          { new: true },
          function (err, data) {
            updatedUserDetails = data;
            cb(err, data);
          }
        );
      },
      function (cb) {
        var criteria = {
          emailId: payloadData.emailId
        };
        var projection = {
          password: 0,
          accessToken: 0,
          tempPassword: 0,
          OTPCode: 0,
          code: 0,
          codeUpdatedAt: 0
        };
        var option = {
          lean: true
        };
        Service.UserService.getUser(criteria, projection, option, function (
          err,
          result
        ) {
          if (err) {
            cb(err);
          } else {
            userFound = (result && result[0]) || null;
            cb();
          }
        });
      },
      function (cb) {
        if (successLogin) {
          var tokenData = {
            id: userFound._id,
            type:
              UniversalFunctions.CONFIG.APP_CONSTANTS.DATABASE.USER_ROLES.USER
          };
          TokenManager.setToken(tokenData, function (err, output) {
            if (err) {
              cb(err);
            } else {
              if (output && output.accessToken) {
                accessToken = output && output.accessToken;
                cb();
              } else {
                cb(ERROR.IMP_ERROR);
              }
            }
          });
        } else {
          cb(ERROR.IMP_ERROR);
        }
      },
      function (cb) {
        var criteria = {
          userId: userFound._id,
          sessionStatus: CONFIG.APP_CONSTANTS.DATABASE.SESSION_STATUS.ACTIVE
        }
        Service.UserSessionService.getUserSession(criteria, { _id: 1 }, {}, function (err, data) {
          if (err) cb(err)
          else {
            if (data.length == 0) {
              var dataToSave = {
                userId: userFound._id
              }
              Service.UserSessionService.createUserSession(dataToSave, function (err, data) {
                if (err) cb(err)
                else {
                  userSessionData = data
                  cb()
                }
              })
            }
            else {
              userSessionData = data && data[0] || null;
              cb()
            }
          }
        })
      },
      function (cb) {
        var criteria = {
          userId: userFound._id
        }
        Service.UserExtendedProfileService.getUserExtendedProfile(criteria, {}, {}, function (err, data) {
          if (err) cb(err)
          else {
            if (data.length == 0) {
              userEnrolledStatus = CONFIG.APP_CONSTANTS.DATABASE.USER_ENROL_STATE.PROGRAM_NOT_ENROLLED;
              programEnrolledId = null;
              moduleEnrolledId = null;
              cb()
            }
            else {
              userActiveProgram = (_.findWhere(data[0].program, { status: CONFIG.APP_CONSTANTS.DATABASE.MODULE_STATUS.ACTIVE }));
              if (userActiveProgram == undefined) {
                userEnrolledStatus = CONFIG.APP_CONSTANTS.DATABASE.USER_ENROL_STATE.PROGRAM_NOT_ENROLLED;
                programEnrolledId = null;
                moduleEnrolledId = null;
              }
              else {
                userActiveModule = (_.findWhere(userActiveProgram.module, { status: CONFIG.APP_CONSTANTS.DATABASE.MODULE_STATUS.ACTIVE }));
                if (userActiveModule == undefined) {
                  userEnrolledStatus = CONFIG.APP_CONSTANTS.DATABASE.USER_ENROL_STATE.MODULE_NOT_ENROLLED;
                  programEnrolledId = userActiveProgram.programId;
                  moduleEnrolledId = null;
                }
                else {
                  userEnrolledStatus = CONFIG.APP_CONSTANTS.DATABASE.USER_ENROL_STATE.USER_ENROLLED;
                  programEnrolledId = userActiveProgram.programId;
                  moduleEnrolledId = userActiveModule.moduleId;
                }
              }
              cb()
            }
          }
        })
      },
      function (cb) {
        appVersion = {
          latestIOSVersion: 100,
          latestAndroidVersion: 100,
          criticalAndroidVersion: 100,
          criticalIOSVersion: 100
        };
        userEnrolState = {
          userEnrolledStatus: userEnrolledStatus,
          programEnrolledId: programEnrolledId,
          moduleEnrolledId: moduleEnrolledId
        }
        cb(null);
      }
    ],
    function (err, data) {
      if (err) {
        callback(err);
      } else {
        callback(null, {
          accessToken: accessToken,
          userDetails: UniversalFunctions.deleteUnnecessaryUserData(userFound),
          appVersion: appVersion,
          userSession: userSessionData._id,
          userEnrolState: userEnrolState
        });
      }
    }
  );
};

var resendOTP = function (userData, callback) {
  /*
     Create a Unique 6 digit code
     Insert It Into Customer DB
     Send Back Response
     */
  var uniqueCode = null;
  var customerData;
  async.series(
    [
      function (cb) {
        var query = {
          _id: userData._id
        };
        var options = { lean: true };
        Service.UserService.getUser(query, {}, options, function (err, data) {
          if (err) {
            cb(err);
          } else {
            if (data.length == 0) cb(ERROR.INCORRECT_ACCESSTOKEN);
            else {
              customerData = (data && data[0]) || null;
              if (customerData.emailVerified == true) {
                cb(ERROR.EMAIL_VERIFICATION_COMPLETE);
              } else {
                cb();
              }
            }
          }
        });
      },
      function (cb) {
        CodeGenerator.generateUniqueCode(
          6,
          UniversalFunctions.CONFIG.APP_CONSTANTS.DATABASE.USER_ROLES.USER,
          function (err, numberObj) {
            if (err) {
              cb(err);
            } else {
              if (!numberObj || numberObj.number == null) {
                cb(ERROR.UNIQUE_CODE_LIMIT_REACHED);
              } else {
                uniqueCode = numberObj.number;
                cb();
              }
            }
          }
        );
      },
      function (cb) {
        var criteria = {
          _id: userData._id
        };
        var setQuery = {
          $set: {
            OTPCode: uniqueCode,
            codeUpdatedAt: new Date().toISOString()
          }
        };
        var options = {
          lean: true
        };
        Service.UserService.updateUser(criteria, setQuery, options, cb);
      }
    ],
    function (err, result) {
      callback(err, { OTPCode: uniqueCode });
    }
  );
};

var getOTP = function (payloadData, callback) {
  var query = {
    emailId: payloadData.emailId
  };
  var projection = {
    _id: 0,
    OTPCode: 1
  };
  var options = { lean: true };
  Service.UserService.getUser(query, projection, options, function (err, data) {
    if (err) {
      callback(err);
    } else {
      var customerData = (data && data[0]) || null;
      if (customerData == null || customerData.OTPCode == undefined) {
        callback(ERROR.OTP_CODE_NOT_FOUND);
      } else {
        callback(null, customerData);
      }
    }
  });
};

var accessTokenLogin = function (userData, callback) {
  var appVersion;
  var userdata = {};
  var userFound = null;
  var userSessionData;
  var userEnrolledStatus = CONFIG.APP_CONSTANTS.DATABASE.USER_ENROL_STATE.PROGRAM_NOT_ENROLLED;
  var programEnrolledId, moduleEnrolledId, userActiveProgram, userActiveModule;
  async.series(
    [
      function (cb) {
        var criteria = {
          _id: userData._id
        };
        Service.UserService.getUser(criteria, { password: 0 }, {}, function (
          err,
          data
        ) {
          if (err) cb(err);
          else {
            if (data.length == 0) cb(ERROR.INCORRECT_ACCESSTOKEN);
            else {
              userFound = (data && data[0]) || null;
              if (userFound.isBlocked) cb(ERROR.ACCOUNT_BLOCKED);
              else cb();
            }
          }
        });
      },
      function (cb) {
        var criteria = {
          userId: userFound._id,
          sessionStatus: CONFIG.APP_CONSTANTS.DATABASE.SESSION_STATUS.ACTIVE
        }
        Service.UserSessionService.getUserSession(criteria, { _id: 1 }, {}, function (err, data) {
          if (err) cb(err)
          else {
            if (data.length == 0) {
              var dataToSave = {
                userId: userFound._id
              }
              Service.UserSessionService.createUserSession(dataToSave, function (err, data) {
                if (err) cb(err)
                else {
                  userSessionData = data
                  cb()
                }
              })
            }
            else {
              userSessionData = data && data[0] || null;
              cb()
            }
          }
        })
      },
      function (cb) {
        var criteria = {
          userId: userFound._id
        }
        Service.UserExtendedProfileService.getUserExtendedProfile(criteria, {}, {}, function (err, data) {
          if (err) cb(err)
          else {
            if (data.length == 0) {
              userEnrolledStatus = CONFIG.APP_CONSTANTS.DATABASE.USER_ENROL_STATE.PROGRAM_NOT_ENROLLED;
              programEnrolledId = null;
              moduleEnrolledId = null;
              cb()
            }
            else {
              userActiveProgram = (_.findWhere(data[0].program, { status: CONFIG.APP_CONSTANTS.DATABASE.MODULE_STATUS.ACTIVE }));
              if (userActiveProgram == undefined) {
                userEnrolledStatus = CONFIG.APP_CONSTANTS.DATABASE.USER_ENROL_STATE.PROGRAM_NOT_ENROLLED;
                programEnrolledId = null;
                moduleEnrolledId = null;
              }
              else {
                userActiveModule = (_.findWhere(userActiveProgram.module, { status: CONFIG.APP_CONSTANTS.DATABASE.MODULE_STATUS.ACTIVE }));
                if (userActiveModule == undefined) {
                  userEnrolledStatus = CONFIG.APP_CONSTANTS.DATABASE.USER_ENROL_STATE.MODULE_NOT_ENROLLED;
                  programEnrolledId = userActiveProgram.programId;
                  moduleEnrolledId = null;
                }
                else {
                  userEnrolledStatus = CONFIG.APP_CONSTANTS.DATABASE.USER_ENROL_STATE.USER_ENROLLED;
                  programEnrolledId = userActiveProgram.programId;
                  moduleEnrolledId = userActiveModule.moduleId;
                }
              }
              cb()
            }
          }
        })
      },
      function (cb) {
        appVersion = {
          latestIOSVersion: 100,
          latestAndroidVersion: 100,
          criticalAndroidVersion: 100,
          criticalIOSVersion: 100
        };
        userEnrolState = {
          userEnrolledStatus: userEnrolledStatus,
          programEnrolledId: programEnrolledId,
          moduleEnrolledId: moduleEnrolledId
        }
        cb(null);
      }
    ],
    function (err, user) {
      if (!err)
        callback(null, {
          accessToken: userdata.accessToken,
          userDetails: UniversalFunctions.deleteUnnecessaryUserData(userFound),
          appVersion: appVersion,
          userSession: userSessionData._id,
          userEnrolState: userEnrolState
        });
      else callback(err);
    }
  );
};

var logoutCustomer = function (userData, callbackRoute) {
  var userSessionData
  async.series(
    [
      function (cb) {
        var criteria = {
          _id: userData._id
        };
        Service.UserService.getUser(criteria, {}, {}, function (err, data) {
          if (err) cb(err);
          else {
            if (data.length == 0) cb(ERROR.INCORRECT_ACCESSTOKEN);
            else {
              cb();
            }
          }
        });
      },
      function (callback) {
        var condition = { _id: userData._id };
        var dataToUpdate = { $unset: { accessToken: 1 } };
        Service.UserService.updateUser(condition, dataToUpdate, {}, function (
          err,
          result
        ) {
          if (err) {
            callback(err);
          } else {
            callback();
          }
        });
      },
      function (cb) {
        var criteria = {
          userId: userData._id
        }
        var dataToUpdate = {
          $set: {
            sessionStatus: CONFIG.APP_CONSTANTS.DATABASE.SESSION_STATUS.FINISHED,
            endedAt: new Date().toISOString()
          }
        }
        Service.UserSessionService.updateMultiUserSessions(criteria, dataToUpdate, { multi: true }, function (err, data) {
          if (err) cb(err)
          else cb()
        })
      }
    ],
    function (error, result) {
      if (error) {
        return callbackRoute(error);
      } else {
        return callbackRoute(null);
      }
    }
  );
};

var getProfile = function (userData, callback) {
  var customerData;
  async.series(
    [
      function (cb) {
        var query = {
          _id: userData._id
        };
        var projection = {
          __v: 0,
          password: 0,
          accessToken: 0,
          codeUpdatedAt: 0
        };
        var options = { lean: true };
        Service.UserService.getUser(query, projection, options, function (
          err,
          data
        ) {
          if (err) {
            cb(err);
          } else {
            if (data.length == 0) cb(ERROR.INCORRECT_ACCESSTOKEN);
            else {
              customerData = (data && data[0]) || null;
              if (customerData.isBlocked) cb(ERROR.ACCOUNT_BLOCKED);
              else cb();
            }
          }
        });
      }
    ],
    function (err, result) {
      if (err) callback(err);
      else callback(null, { customerData: customerData });
    }
  );
};

var changePassword = function (userData, payloadData, callbackRoute) {
  var oldPassword = UniversalFunctions.CryptData(payloadData.oldPassword);
  var newPassword = UniversalFunctions.CryptData(payloadData.newPassword);
  var customerData;
  async.series(
    [
      function (cb) {
        var query = {
          _id: userData._id
        };
        var options = { lean: true };
        Service.UserService.getUser(query, {}, options, function (err, data) {
          if (err) {
            cb(err);
          } else {
            if (data.length == 0) cb(ERROR.INCORRECT_ACCESSTOKEN);
            else {
              customerData = (data && data[0]) || null;
              if (customerData.isBlocked) cb(ERROR.ACCOUNT_BLOCKED);
              else cb();
            }
          }
        });
      },
      function (callback) {
        var query = {
          _id: userData._id
        };
        var projection = {
          password: 1,
          firstLogin: 1
        };
        var options = { lean: true };
        Service.UserService.getUser(query, projection, options, function (
          err,
          data
        ) {
          if (err) {
            callback(err);
          } else {
            customerData = (data && data[0]) || null;
            if (customerData == null) {
              callback(ERROR.NOT_FOUND);
            } else {
              if (payloadData.skip == false) {
                if (
                  data[0].password == oldPassword &&
                  data[0].password != newPassword
                ) {
                  callback(null);
                } else if (data[0].password != oldPassword) {
                  callback(ERROR.WRONG_PASSWORD);
                } else if (data[0].password == newPassword) {
                  callback(ERROR.NOT_UPDATE);
                }
              }
              else callback(null)
            }
          }
        });
      },
      function (callback) {
        var dataToUpdate;
        if (payloadData.skip == true && customerData.firstLogin == false) {
          dataToUpdate = { $set: { firstLogin: true, tempPassword: null } };
        }
        else if (payloadData.skip == false && customerData.firstLogin == false) {
          dataToUpdate = { $set: { password: newPassword, firstLogin: true, tempPassword: null } };
        }
        else if (payloadData.skip == true && customerData.firstLogin == true) {
          dataToUpdate = {}
        }
        else {
          dataToUpdate = { $set: { password: newPassword } };
        }
        var condition = { _id: userData._id };
        Service.UserService.updateUser(condition, dataToUpdate, {}, function (
          err,
          user
        ) {
          if (err) {
            callback(err);
          } else {
            if (!user || user.length == 0) {
              callback(ERROR.NOT_FOUND);
            } else {
              callback(null);
            }
          }
        });
      }
    ],
    function (error, result) {
      if (error) {
        return callbackRoute(error);
      } else {
        return callbackRoute(null);
      }
    }
  );
};

var forgetPassword = function (payloadData, callback) {
  var dataFound = null;
  var code;
  var forgotDataEntry;
  async.series(
    [
      function (cb) {
        var query = {
          emailId: payloadData.emailId
        };
        Service.UserService.getUser(
          query,
          {
            _id: 1,
            emailId: 1,
            emailVerified: 1
          },
          {},
          function (err, data) {
            if (err) {
              cb(ERROR.PASSWORD_CHANGE_REQUEST_INVALID);
            } else {
              dataFound = (data && data[0]) || null;
              if (dataFound == null) {
                cb(ERROR.USER_NOT_REGISTERED);
              } else {
                if (dataFound.emailVerified == false) {
                  cb(ERROR.NOT_VERFIFIED);
                } else {
                  userFound = (data && data[0]) || null;
                  if (userFound.isBlocked) cb(ERROR.ACCOUNT_BLOCKED);
                  else cb();
                }
              }
            }
          }
        );
      },
      function (cb) {
        CodeGenerator.generateUniqueCode(
          6,
          UniversalFunctions.CONFIG.APP_CONSTANTS.DATABASE.USER_ROLES.USER,
          function (err, numberObj) {
            if (err) {
              cb(err);
            } else {
              if (!numberObj || numberObj.number == null) {
                cb(ERROR.UNIQUE_CODE_LIMIT_REACHED);
              } else {
                code = numberObj.number;
                cb();
              }
            }
          }
        );
      },
      function (cb) {
        var dataToUpdate = {
          code: code
        };
        var query = {
          _id: dataFound._id
        };
        Service.UserService.updateUser(query, dataToUpdate, {}, function (
          err,
          data
        ) {
          if (err) {
            cb(err);
          } else {
            cb();
          }
        });
      },
      function (cb) {
        Service.ForgetPasswordService.getForgetPasswordRequest(
          { customerID: dataFound._id },
          {
            _id: 1,
            isChanged: 1
          },
          { lean: 1 },
          function (err, data) {
            if (err) {
              cb(err);
            } else {
              forgotDataEntry = (data && data[0]) || null;
              cb();
            }
          }
        );
      },
      function (cb) {
        var data = {
          customerID: dataFound._id,
          requestedAt: Date.now(),
          userType:
            UniversalFunctions.CONFIG.APP_CONSTANTS.DATABASE.USER_ROLES.USER
        };
        if (forgotDataEntry == null) {
          Service.ForgetPasswordService.createForgetPasswordRequest(
            data,
            function (err, data) {
              if (err) {
                cb(err);
              } else {
                appLogger.info("<<<<<<<<<<<<<< created successfully");
                cb();
              }
            }
          );
        } else {
          if (forgotDataEntry.isChanged == true) {
            data.isChanged = false;
          }
          Service.ForgetPasswordService.updateForgetPasswordRequest(
            { _id: forgotDataEntry._id },
            data,
            {},
            cb
          );
        }
      }
    ],
    function (error, result) {
      if (error) {
        callback(error);
      } else {
        callback(null, { emailId: payloadData.emailId, OTPCode: code });
      }
    }
  );
};

var resetPassword = function (payloadData, callbackRoute) {
  var foundData;
  var customerId = null;
  var data;
  async.series(
    [
      function (callback) {
        var query = {
          emailId: payloadData.emailId
        };
        Service.UserService.getUser(
          query,
          {
            _id: 1,
            code: 1,
            emailVerified: 1
          },
          { lean: true },
          function (err, result) {
            if (err) {
              callback(err);
            } else {
              data = (result && result[0]) || null;
              if (data == null) {
                callback(ERROR.INCORRECT_ID);
              } else {
                if (payloadData.OTPCode != data.code) {
                  callback(ERROR.INVALID_CODE);
                } else {
                  if (data.phoneVerified == false) {
                    callback(ERROR.NOT_VERFIFIED);
                  } else {
                    customerId = data._id;
                    callback();
                  }
                }
              }
            }
          }
        );
      },
      function (callback) {
        var query = { customerID: customerId, isChanged: false };
        Service.ForgetPasswordService.getForgetPasswordRequest(
          query,
          { __v: 0 },
          {
            limit: 1,
            lean: true
          },
          function (err, data) {
            if (err) {
              callback(err);
            } else {
              foundData = (data && data[0]) || null;
              callback();
            }
          }
        );
      },
      function (callback) {
        if (!UniversalFunctions.isEmpty(foundData)) {
          var minutes = UniversalFunctions.getRange(
            foundData.requestedAt,
            UniversalFunctions.getTimestamp(),
            UniversalFunctions.CONFIG.APP_CONSTANTS.TIME_UNITS.MINUTES
          );
          if (minutes < 0 || minutes > 30) {
            return callback(ERROR.PASSWORD_CHANGE_REQUEST_EXPIRE);
          } else {
            callback();
          }
        } else {
          return callback(ERROR.PASSWORD_CHANGE_REQUEST_INVALID);
        }
      },
      function (callback) {
        var dataToUpdate = {
          password: UniversalFunctions.CryptData(payloadData.password)
        };
        appLogger.info(dataToUpdate);
        Service.UserService.updateUser(
          { _id: customerId },
          dataToUpdate,
          {},
          function (error, result) {
            if (error) {
              callback(error);
            } else {
              if (result.n === 0) {
                callback(ERROR.USER_NOT_FOUND);
              } else {
                callback();
              }
            }
          }
        );
      },
      function (callback) {
        var dataToUpdate = {
          isChanged: true,
          changedAt: UniversalFunctions.getTimestamp()
        };
        Service.ForgetPasswordService.updateForgetPasswordRequest(
          { customerID: customerId },
          dataToUpdate,
          {
            lean: true
          },
          callback
        );
      }
    ],
    function (error) {
      if (error) {
        callbackRoute(error);
      } else {
        callbackRoute(null);
      }
    }
  );
};

var flushSession = function (userData, callback) {
  var customerData;
  async.series(
    [
      function (cb) {
        var query = {
          _id: userData._id
        };
        var options = { lean: true };
        Service.UserService.getUser(query, {}, options, function (err, data) {
          if (err) {
            cb(err);
          } else {
            if (data.length == 0) cb(ERROR.INCORRECT_ACCESSTOKEN);
            else {
              customerData = (data && data[0]) || null;
              if (customerData.isBlocked) cb(ERROR.ACCOUNT_BLOCKED);
              else cb();
            }
          }
        });
      },
      function (cb) {
        var criteria = {
          userId: userData._id
        }
        var dataToUpdate = {
          $set: {
            sessionStatus: CONFIG.APP_CONSTANTS.DATABASE.SESSION_STATUS.FINISHED,
            endedAt: new Date().toISOString()
          }
        }
        Service.UserSessionService.updateMultiUserSessions(criteria, dataToUpdate, { multi: true }, function (err, data) {
          if (err) cb(err)
          else cb()
        })
      }
    ],
    function (error, result) {
      if (error) {
        return callback(error);
      } else {
        return callback(null);
      }
    }
  );
}

module.exports = {
  createUser: createUser,
  verifyOTP: verifyOTP,
  loginUser: loginUser,
  resendOTP: resendOTP,
  getOTP: getOTP,
  accessTokenLogin: accessTokenLogin,
  logoutCustomer: logoutCustomer,
  getProfile: getProfile,
  changePassword: changePassword,
  forgetPassword: forgetPassword,
  resetPassword: resetPassword,
  flushSession: flushSession,
};
