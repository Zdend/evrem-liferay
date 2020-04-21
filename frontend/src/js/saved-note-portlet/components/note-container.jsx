/** @jsx React.DOM */
var React = require('react');
var SavedNoteStore = require('../stores/saved-note-store');
var SavedNoteActions = require('../actions/saved-note-actions');
var Icon = require('react-font-awesome').Icon;
var TodoContent = require('./todo-content.jsx');

var NoteContainer = React.createClass({
	getInitialState: function() {
	  return {
		  note: this.props.note
			};
	},

	render: function(){
		var classesCheckBtn = React.addons.classSet({
		    'sn-action-button': true,
		    'hide': !this.state.note.hasCheck,
		    'sn-checked-btn': this.state.note.isDone
		  });
		var classesCheckText = React.addons.classSet({
			'sn-inner-note-container': true,
			'striked-text': this.state.note.isDone
		});
		
		var noteContent;
		if(this.state.note.hasTodo){
			noteContent = <TodoContent todos={this.state.note.todos} noteId={this.state.note.noteId} />;
		}else{
			noteContent = <div className={classesCheckText}>{this.state.note.text}</div>;
		}
		
		
		return (
			<li key={this.state.note.noteId} style={{backgroundColor: this.state.note.color.colorWithHash}} 
				data-row={this.state.note.gridItem.x} data-col={this.state.note.gridItem.y} 
				data-sizex={this.state.note.gridItem.w} data-sizey={this.state.note.gridItem.h} data-id={this.state.note.gridItem.gridItemId}>
			
				<div className="sn-actions-container">
					<div className="sn-action-button"><Icon type="pencil" onClick={this.editNote} /></div>
					<div className={classesCheckBtn}><Icon type="check" onClick={this.checkNote} /></div>
				</div>
				
				{noteContent}
			</li>	
		);
	},
	
	editNote: function(){
	    Liferay.fire(
	            'editNoteEvent', {
	            note: this.state.note
	        }
	    );
	},
	checkNote: function(){
		SavedNoteActions.checkNote(this.state.note.noteId);
	}
});

module.exports = NoteContainer;
