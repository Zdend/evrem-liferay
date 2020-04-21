var AppDispatcher = require('../dispatcher/app-dispatcher');
var ProfileConstants = require('../constants/profile-constants');

var ProfileActions = {

  registerUser: function(user) {
	    AppDispatcher.handleViewAction({
	      actionType: ProfileConstants.REGISTER_USER,
	      user: user
	    });
  },
  registerTimeZones: function(timeZones) {
	  AppDispatcher.handleViewAction({
		  actionType: ProfileConstants.REGISTER_TIMEZONES,
		  timeZones: timeZones
	  });
  },
  registerUrls: function(urls) {
	  AppDispatcher.handleViewAction({
		  actionType: ProfileConstants.REGISTER_URLS,
		  urls: urls
	  });
  },
  timeZoneChange: function(timeZoneId) {
	  AppDispatcher.handleViewAction({
		  actionType: ProfileConstants.TIMEZONE_CHANGED,
		  timeZoneId: timeZoneId
	  });
  },
  saveUser: function() {
	  AppDispatcher.handleServerAction({
		  actionType: ProfileConstants.SAVE_USER
	  });
  },
  clearInfoMessage: function() {
	  AppDispatcher.handleViewAction({
		  actionType: ProfileConstants.CLEAR_INFO_MESSAGE
	  });
  }


 

};

module.exports = ProfileActions;