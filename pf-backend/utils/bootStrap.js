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

var async = require('async');
var Config = require('../config');
var UniversalFunctions = require('./universalFunctions');
var Service = require('../services');

exports.bootstrapAdmin = function (callbackParent) {
    var taskToRunInParallel = [];

    var adminData = [
        {
            emailId: 'launchpad@admin.com',
            password: UniversalFunctions.CryptData("123456"),
            fullName: 'Launchpad Admin',
            userType: Config.APP_CONSTANTS.DATABASE.USER_ROLES.SUPERADMIN,
            createdAt: UniversalFunctions.getTimestamp(),
            firstLogin: true
        },
        {
            emailId: 'launchpad2@admin.com',
            password: UniversalFunctions.CryptData("123456"),
            fullName: 'Launchpad Admin 2',
            userType: Config.APP_CONSTANTS.DATABASE.USER_ROLES.SUPERADMIN,
            createdAt: UniversalFunctions.getTimestamp(),
            firstLogin: true
        }
    ];

    adminData.forEach(function (dataObj) {
        taskToRunInParallel.push((function (dataObj) {
            return function (embeddedCB) {
                insertData(dataObj, embeddedCB);
            }
        })(dataObj));
    });
    async.parallel(taskToRunInParallel, function (error) {
        if (error)
            return callbackParent(error);
        return callbackParent(null);
    });
};

function insertData(adminData, callbackParent) {
    var _skip = false
    async.series([
        function(cb){
            Service.AdminService.getAdmin({emailId:adminData.emailId},{},{},function(err,data){
                if(err) cb(err)
                else {
                    if(data.length != 0) {
                        _skip = true;
                        cb()
                    }
                    else cb()
                }
            })
        },
        function(cb){
            if(!_skip){
                Service.AdminService.createAdmin(adminData, function (err, response) {
                    if(err){
                        appLogger.info("Implementation err",err);
                        cb(err)
                    }
                    else{
                        appLogger.info("Admin Added Succesfully");
                        cb()
                    }
                });
            }
            else cb()
        }
    ],function(err,result){
        if(err) return callbackParent(err)
        else {
            return callbackParent(null);
        }
    })
    
}