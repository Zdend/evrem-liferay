/** @jsx React.DOM */
var NewNoteActions = require('./actions/new-note-actions');
var NoteContainer = require('./components/note-container.jsx');

Liferay.Portlet.ready(
    function(portletId, node) {
    	if(portletId.indexOf('newnoteportlet_WAR_newnoteportlet') !== -1){
    		var initialData = JSON.parse(jQuery('#data-new-note').text());
    		NewNoteActions.registerUrls(initialData.urls);
    		NewNoteActions.registerColors(initialData.colors);
    		NewNoteActions.registerPeriods(initialData.periods);
    		
    		React.renderComponent(<NoteContainer />, document.querySelector('#new-note-container'));
    	}
    	
    }
);
