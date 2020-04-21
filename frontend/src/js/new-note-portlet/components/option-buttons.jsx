/** @jsx React.DOM */
var OptionButton = require('./option-button.jsx');
var Icon = FontAwesome.Icon;
var NewNoteConstants = require('../constants/new-note-constants');
var NewNoteActions = require('../actions/new-note-actions');
var ActionButton = require('./action-button.jsx');

var OptionButtons = React.createClass({
	render: function(){
		var restoreClasses = React.addons.classSet({
		    'hide': !this.props.hasDeletedNote,
		    'visible': this.props.hasDeletedNote
		  });
		var restoreCurrentClasses = React.addons.classSet({
			'hide': !this.props.note.isDeleted || !this.props.note.noteId,
			'visible': this.props.note.isDeleted && this.props.note.noteId
		});
		var deleteClasses = React.addons.classSet({
			'hide': !this.props.note.noteId || this.props.note.isDeleted,
			'visible': this.props.note.noteId && !this.props.note.isDeleted
		});
		
		return (
			<ul className="note-buttons">
				<li><ActionButton icon="save" style="save" action={NewNoteActions.saveNote} msg="Save note" /></li>
				
				<li><OptionButton icon="check" btnType={NewNoteConstants.BUTTON_CHECK} isToggle={this.props.note.hasCheck} msg="Set this note as a check task" /></li>
				<li><OptionButton icon="clock-o" btnType={NewNoteConstants.BUTTON_TIME} isToggle={this.props.note.hasTime} msg="Event time" /></li>
				<li><OptionButton icon="bell-o" btnType={NewNoteConstants.BUTTON_REMINDER} isToggle={this.props.note.hasReminder} msg="Email reminder" /></li>
				<li><OptionButton icon="repeat" btnType={NewNoteConstants.BUTTON_REPEAT} isToggle={this.props.note.hasRepeat} msg="Periodically repeating" /></li>
				<li><OptionButton icon="check-square-o" btnType={NewNoteConstants.BUTTON_TODO} isToggle={this.props.note.hasTodo} msg="Every ENTER in note text creates one task" /></li>
				<li><OptionButton icon="paint-brush" btnType={NewNoteConstants.BUTTON_COLOR} isToggle={this.props.note.hasColor} msg="Color switch" /></li>
				<li><OptionButton icon="th" btnType={NewNoteConstants.BUTTON_WALL} isToggle={this.props.note.hasWall} msg="Show on the wall" /></li>
				
				<li><ActionButton icon="eraser" style="clear" action={NewNoteActions.clearNote} msg="New blank note" /></li>
				<li className={deleteClasses}><ActionButton icon="close" style="delete" action={NewNoteActions.deleteNote} msg="Remove note" /></li>
				<li className={restoreCurrentClasses}><ActionButton icon="undo" style="restore" action={NewNoteActions.restoreCurrentNote} msg="Restore this specific note" /></li>
				<li className={restoreClasses}><ActionButton icon="history" style="restore" action={NewNoteActions.restoreNote} msg="Restore previously deleted note" /></li>
			</ul>

		);		
	}
	
});

module.exports = OptionButtons;
