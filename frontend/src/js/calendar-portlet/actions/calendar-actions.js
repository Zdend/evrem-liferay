var AppDispatcher = require('../dispatcher/app-dispatcher');
var CalendarConstants = require('../constants/calendar-constants');

var CalendarActions = {

  registerEvents: function(events) {
	    AppDispatcher.handleViewAction({
	      actionType: CalendarConstants.REGISTER_EVENTS,
	      events: events
	    });
  },


 

};

module.exports = CalendarActions;