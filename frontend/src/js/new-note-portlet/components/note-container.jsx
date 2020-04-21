/** @jsx React.DOM */
var NoteText = require('./note-text.jsx');
var OptionButtons = require('./option-buttons.jsx');
var NewNoteStore = require('../stores/new-note-store');
var NewNoteActions = require('../actions/new-note-actions');
var TimeBlock = require('./time-block.jsx');
var ReminderBlock = require('./reminder-block.jsx');
var ReminderSubjectBlock = require('./reminder-subject-block.jsx');
var RepeatBlock = require('./repeat-block.jsx');
var ColorBlock = require('./color-block.jsx');
var IsdoneBlock = require('./isdone-block.jsx');
var ValidationMessage = require('./validation-message.jsx');
var InfoMessage = require('../../shared-components/info-message.jsx');

function getNoteState() {
	  return {
	    note: NewNoteStore.getNote(),
	    colors: NewNoteStore.getColors(),
	    periods: NewNoteStore.getPeriods(),
	    hasDeletedNote: NewNoteStore.getHasDeletedNote(),
	    infoMessage: NewNoteStore.getInfoMessage()
	  };
}

Liferay.on('editNoteEvent', function(event) {
	var body = jQuery('body');
	var noteInput = jQuery('#new-note-input');
	body.animate({
	    scrollTop: noteInput.offset().top
	});
	noteInput.focus();
    NewNoteActions.editNote(event.note);
});

var NoteContainer = React.createClass({
	getInitialState: function() {
	  return getNoteState();
	},
	componentDidMount: function() {
		NewNoteStore.addChangeListener(this._onChange);
	},
	componentWillUnmount: function() {
		NewNoteStore.removeChangeListener(this._onChange);
	},
	render: function(){
		return (
			<div>
				<ValidationMessage validation={this.state.validation} />
				<InfoMessage message={this.state.infoMessage} clearMessageHandler={NewNoteActions.clearInfoMessage} />
			
				<ul className="text-options-container">
					<li className="note-textarea-wrapper"><NoteText value={this.state.note.text} /></li>
					<li className="note-buttons-wrapper"><OptionButtons note={this.state.note} hasDeletedNote={this.state.hasDeletedNote} /></li>
				</ul>
				<div className="cleaner"></div>
				<hr />
				
				<div className="block-container">
					<IsdoneBlock note={this.state.note} />
					<TimeBlock note={this.state.note} />
					<ReminderBlock note={this.state.note} />
					<ReminderSubjectBlock note={this.state.note} />
					<ColorBlock note={this.state.note} colors={this.state.colors} />
					<RepeatBlock note={this.state.note} periods={this.state.periods} />
				</div>			
				<div className="cleaner"></div>
			</div>
		);
	},
	
   _onChange: function() {
     this.setState(getNoteState());
   }
});
module.exports = NoteContainer;
