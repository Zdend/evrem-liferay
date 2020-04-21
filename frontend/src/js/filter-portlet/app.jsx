/** @jsx React.DOM */
var FilterStore = require('./stores/filter-store');
var FilterActions = require('./actions/filter-actions');
var FilterContainer = require('./components/filter-container.jsx');

Liferay.Portlet.ready(
    function(portletId, node) {
    	if(portletId.indexOf('filterportlet_WAR_filterportlet') !== -1){
    		var initialData = JSON.parse(jQuery('#data-filter').text());
    		FilterActions.registerUrls(initialData.urls);
    		FilterActions.registerNotes(initialData.notes);
    		
    		React.renderComponent(<FilterContainer />, document.querySelector('#filter-container'));
    		Spinner.stop();
    	}
    	
    }
);


