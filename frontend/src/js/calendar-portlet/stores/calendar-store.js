var AppDispatcher = require('../dispatcher/app-dispatcher');
var EventEmitter = Events.EventEmitter;
var CalendarConstants = require('../constants/calendar-constants');

var _events = {};



//FUNCTIONS
var CalendarStore = merge(EventEmitter.prototype, {
	
	getEvents: function() {
		return _events;
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
	case CalendarConstants.REGISTER_EVENTS:
		_events = action.events;
		break;
		
		
	default:
		return true;
	}

	CalendarStore.emitChange();

	return true;
});

module.exports = CalendarStore;