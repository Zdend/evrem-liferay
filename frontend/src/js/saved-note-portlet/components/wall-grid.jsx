/** @jsx React.DOM */
var SavedNoteStore = require('../stores/saved-note-store');
var SavedNoteActions = require('../actions/saved-note-actions');
var NoteContainer = require('./note-container.jsx');

function getNotesState() {
	  return {
	    notes: SavedNoteStore.getNotes()
	  };
}

var WallGrid = React.createClass({
	getInitialState: function() {
	  return getNotesState();
	},
	componentDidMount: function() {
		jQuery(function(){
			var gridsterContainer = jQuery(".gridster ul");
			var options = {
			        widget_margins: [5, 5],
			        widget_base_dimensions: [140, 50],
		            serialize_params: function(w, wgd) { 
	                    return { 
	                           gridItemId: jQuery(w).attr('data-id'), 
	                           y: wgd.col, 
	                           x: wgd.row, 
	                           w: wgd.size_x, 
	                           h: wgd.size_y 
	                    };
	                },
	                resize:{
	                	enabled: true,
	                	stop: function(event, ui, $widget){
	                		this.$changed = this.$changed.add($widget);
	                	}
	                }
			};
			gridsterContainer.gridster(options);
		});
		
		SavedNoteStore.addChangeListener(this._onChange);
	},
	componentWillUnmount: function() {
		SavedNoteStore.removeChangeListener(this._onChange);
	},
	render: function(){
		return (
			<div className="gridster">
			    <ul>
			    	{this.state.notes.map(function(note){
			    		return (
			    				<NoteContainer note={note} key={note.noteId} />
			    				);
			    	})}
			    </ul>
			</div>
				
				
		);
	},
	
   _onChange: function() {
     this.setState(getNotesState());
   }
});

module.exports = WallGrid;
