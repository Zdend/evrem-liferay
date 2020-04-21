/** @jsx React.DOM */
var Icon = FontAwesome.Icon;
var NewNoteActions = require('../actions/new-note-actions');

var RestoreButton = React.createClass({
	
	render: function(){
	  var classes = React.addons.classSet({
		    'restore-btn': true,
		    'hover-transition': true,
		    'pointer-cursor': true
		});

	  
		return (
			<Icon type="undo" className={classes} onClick={this.restoreNote} />
		);		
	},
	
	restoreNote: function(){
		NewNoteActions.restoreNote();
	}

	
});

module.exports = RestoreButton;