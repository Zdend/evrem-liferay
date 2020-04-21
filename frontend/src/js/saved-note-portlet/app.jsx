/** @jsx React.DOM */
var SavedNoteStore = require('./stores/saved-note-store');
var SavedNoteActions = require('./actions/saved-note-actions');
var WallGrid = require('./components/wall-grid.jsx');

Liferay.Portlet.ready(
    function(portletId, node) {
    	if(portletId.indexOf('savednoteportlet_WAR_savednoteportlet') !== -1){
    		var initialData = JSON.parse(jQuery('#data-wall-grid').text());
    		SavedNoteActions.registerUrls(initialData.urls);
    		SavedNoteActions.registerNotes(initialData.notes);
    		
    		React.renderComponent(<WallGrid />, document.querySelector('#wall-grid-container'));
    		Spinner.stop();
    	}
    	
    }
);


setInterval(function(){
	var gridster = jQuery(".gridster ul").gridster().data('gridster');
	SavedNoteActions.saveCoordinates(gridster.serialize_changed());
	gridster.$changed = jQuery([]);
},10000);

