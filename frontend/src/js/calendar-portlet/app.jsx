/** @jsx React.DOM */
var CalendarStore = require('./stores/calendar-store');
var CalendarActions = require('./actions/calendar-actions');
var CalendarContainer = require('./components/calendar-container.jsx');



Liferay.Portlet.ready(
    function(portletId, node) {
    	if(portletId.indexOf('calendarportlet_WAR_calendarportlet') !== -1){
    		var events = JSON.parse(jQuery('#data-calendar').text());
    		CalendarActions.registerEvents(events);
    		
    		React.renderComponent(<CalendarContainer />, document.querySelector('#calendar-container'));
    	}
    	
    }
);


