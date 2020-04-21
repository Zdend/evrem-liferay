var AppDispatcher = require('../dispatcher/app-dispatcher');
var EventEmitter = Events.EventEmitter;
var LoginConstants = require('../constants/login-constants');
var UtilService = require('../services/util-service');

var _user = {
		email: '',
		password: '',
		rememberMe: false
};
var _newUser = UtilService.getEmptyNewUser();

var _urls = {};
var _timeZones = [];

function logIn(){
	Spinner.start();
	var data = {
			saveLastPath: false,
			cmd: 'update',
			rememberMe: _user.rememberMe,
			login: _user.email,
			password: _user.password
	};
	
	jQuery.ajax({
		type: 'POST',
		url: _urls['logIn'],
		data: data,
		success: function(result) {
			window.location.href = "/group/evrem/home";
			return result.payload;
		},
		complete: function(){
			Spinner.stop();
		}
	});
}

function signUp(){
	Spinner.start();
	jQuery.ajax({
		type: 'POST',
		url: _urls['signUp'],
		data: _newUser,
		success :function(result) {
//			window.location.replace("/group/evrem/home");
			_newUser = UtilService.getEmptyNewUser();
			LoginStore.emitChange();
			return result.payload;
		},
		complete: function(){
			Spinner.stop();
		}
	});
	
	console.log('Signing up...');
}
function loadTimeZones(){
	if(typeof _timeZones != 'undefined' && _timeZones.length !== 0 ){
		return;
	}
	jQuery.ajax({
		type: 'POST',
		dataType : 'json',
		url: _urls['loadTimeZones'],
		success: function(result) {
			_timeZones = result.payload;
			LoginStore.emitChange();
			return result.payload;
		}
	});
	
}


//FUNCTIONS
var LoginStore = merge(EventEmitter.prototype, {
	
	getUser: function() {
		return _user;
	},
	getNewUser: function() {
		return _newUser;
	},
	getTimeZones: function(){
		return _timeZones;
	},
	emitChange: function() {
		this.emit(GlobalConstants.CHANGE_EVENT);
	},
	addChangeListener: function(callback) {
		this.on(GlobalConstants.CHANGE_EVENT, callback);
	},
	removeChangeListener: function(callback) {
		this.removeListener(GlobalConstants.CHANGE_EVENT, callback);
	}
});

AppDispatcher.register(function(payload) {
	var action = payload.action;

	switch(action.actionType) {
	case LoginConstants.REGISTER_INITIAL_DATA:
		_user.email = action.initialData.email;
		_user.rememberMe = action.initialData.rememberMe;
		_urls = action.initialData.urls;
		break;
	case LoginConstants.USER_EMAIL_CHANGE:
		_user.email = action.email;
		break;
	case LoginConstants.USER_PASSWORD_CHANGE:
		_user.password = action.password;
		break;
	case LoginConstants.USER_REMEMBERME_CHANGE:
		_user.rememberMe = action.rememberMe;
		break;
	case LoginConstants.NEWUSER_EMAIL_CHANGE:
		_newUser.email = action.email;
		loadTimeZones();
		break;
	case LoginConstants.NEWUSER_PASSWORD1_CHANGE:
		_newUser.password1 = action.password1;
		break;
	case LoginConstants.NEWUSER_PASSWORD2_CHANGE:
		_newUser.password2 = action.password2;
		break;
	case LoginConstants.EVREM_LOG_IN:
		logIn();
		break;
	case LoginConstants.EVREM_SIGN_UP:
		signUp();
		break;
	case LoginConstants.SET_CAPTCHA_TOKEN:
		_newUser.token = action.token;
		break;
	case LoginConstants.LOAD_TIME_ZONES:
		loadTimeZones();
		return true;
	case LoginConstants.TIME_ZONE_CHANGE:
		_newUser.timeZoneId = action.timeZoneId;
		break;
		
	default:
		return true;
	}

	LoginStore.emitChange();

	return true;
});

module.exports = LoginStore;