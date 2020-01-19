/**
 * Created by Navit on 15/11/16.
 */
var mongoose = require("mongoose");
var Schema = mongoose.Schema;
var Config = require("../config");

var user = new Schema({
  firstName: { type: String, trim: true, required: true },
  lastName: { type: String, trim: true, required: true },
  emailId: { type: String, trim: true, required: true, unique: true },
  accessToken: {
    type: String,
    trim: true,
    index: true,
    unique: true,
    sparse: true
  },
  phoneNumber: {
    type: String,
    required: true,
    trim: true,
    index: true,
    min: 5,
    max: 15
  },
  password: { type: String },
  tempPassword:{type: String},
  firstLogin:{type: Boolean, default: false},
  countryCode: { type: String },
  code: { type: String, trim: true },
  OTPCode: { type: String, trim: true },
  emailVerified: { type: Boolean, default: false },
  registrationDate: { type: Date, default: Date.now },
  codeUpdatedAt: { type: Date, default: Date.now, required: true },
  updatedAt: {type: Date},
  isBlocked: {type: Boolean, default: false, required: true}
});

module.exports = mongoose.model("user", user);
