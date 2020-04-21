var AppDispatcher = require('../dispatcher/app-dispatcher');
var LoginConstants = require('../constants/login-constants');

var LoginActions = {

	registerInitialData: function(initialData) {
		AppDispatcher.handleViewAction({
			actionType: LoginConstants.REGISTER_INITIAL_DATA,
			initialData: initialData
		});
	},
  userEmailChange: function(email) {
	    AppDispatcher.handleViewAction({
	      actionType: LoginConstants.USER_EMAIL_CHANGE,
	      email: email
	    });
  },
  userPasswordChange: function(password) {
	  AppDispatcher.handleViewAction({
		  actionType: LoginConstants.USER_PASSWORD_CHANGE,
		  password: password
	  });
  },
  userRememberMeChange: function(rememberMe) {
	  AppDispatcher.handleViewAction({
		  actionType: LoginConstants.USER_REMEMBERME_CHANGE,
		  rememberMe: rememberMe
	  });
  },
  newUserEmailChange: function(email) {
	  AppDispatcher.handleViewAction({
		  actionType: LoginConstants.NEWUSER_EMAIL_CHANGE,
		  email: email
	  });
  },
  newUserPassword1Change: function(password1) {
	  AppDispatcher.handleViewAction({
		  actionType: LoginConstants.NEWUSER_PASSWORD1_CHANGE,
		  password1: password1
	  });
  },
  newUserPassword2Change: function(password2) {
	  AppDispatcher.handleViewAction({
		  actionType: LoginConstants.NEWUSER_PASSWORD2_CHANGE,
		  password2: password2
	  });
  },
  evremLogIn: function() {
	  AppDispatcher.handleServerAction({
		  actionType: LoginConstants.EVREM_LOG_IN
	  });
  },
  signUp: function() {
	  AppDispatcher.handleServerAction({
		  actionType: LoginConstants.EVREM_SIGN_UP
	  });
  },
  setCaptchaToken: function(token) {
	  AppDispatcher.handleViewAction({
		  actionType: LoginConstants.SET_CAPTCHA_TOKEN,
		  token: token
	  });
  },
  loadTimeZones: function() {
	  AppDispatcher.handleServerAction({
		  actionType: LoginConstants.LOAD_TIME_ZONES
	  });
  },
  timeZoneChange: function(timeZoneId) {
	  AppDispatcher.handleServerAction({
		  actionType: LoginConstants.TIME_ZONE_CHANGE,
		  timeZoneId: timeZoneId
	  });
  },


 

};

module.exports = LoginActions;