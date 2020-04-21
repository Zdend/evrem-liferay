/** @jsx React.DOM */
var UpcomingActions = require('./actions/upcoming-actions');
var UpcomingContainer = require('./components/upcoming-container.jsx');

Liferay.Portlet.ready(
    function(portletId, node) {
    	if(portletId.indexOf('upcomingportlet_WAR_upcomingportlet') !== -1){
    		var initialData = JSON.parse(jQuery('#data-upcoming').text());
    		UpcomingActions.registerUrls(initialData.urls);
    		UpcomingActions.registerNotes(initialData.notes);
    		
    		React.renderComponent(<UpcomingContainer />, document.querySelector('#upcoming-container'));
    	}
    }
);


