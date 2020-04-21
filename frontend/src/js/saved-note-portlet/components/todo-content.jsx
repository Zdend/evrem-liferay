/** @jsx React.DOM */
var SavedNoteActions = require('../actions/saved-note-actions');
var Icon = require('react-font-awesome').Icon;

var TodoContent = React.createClass({
	getInitialState: function() {
	  return {
		  todos: this.props.todos,
		  noteId: this.props.noteId
			};
	},

	render: function(){
			
		var self = this;
		return(
			<div>
			{this.state.todos.map(function(item, index){
				var iconCheck = "";
				
				var textClasses = React.addons.classSet({
				    'sn-todo-text': true,
				    'striked-text': item.isTodoDone
				});
				
				var checkClasses = checkClasses = React.addons.classSet({
					'sn-check-btn': true
				});
					
				if(item.isTodoDone){
					iconCheck = <Icon type="check"  />
				}else{
					iconCheck = <Icon type="square-o" />
				}
				
				return(
					<div key={index}>
						<div className={checkClasses} data-todonoteid={item.todoNoteId} onClick={self.checkTodoNote}>{iconCheck}</div>
						<div className={textClasses}>{item.todoText}</div>
					</div>
				)
			})}
			</div>
		);
	},
	
	checkTodoNote: function(e){
		var todoNoteId = jQuery(e.target).closest("div").data("todonoteid");
		SavedNoteActions.checkTodoNote(this.state.noteId, todoNoteId);
	}
});

module.exports = TodoContent;
