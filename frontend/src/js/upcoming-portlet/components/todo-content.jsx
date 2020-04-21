/** @jsx React.DOM */
var UpcomingActions = require('../actions/upcoming-actions');
var Icon = require('react-font-awesome').Icon;

var TodoContent = React.createClass({
	getInitialState: function() {
	  return {
		  todos: this.props.todos,
		  noteId: this.props.noteId,
		  isTypeToday: this.props.isTypeToday,
		  eventTime: this.props.eventTime
		};
	},
	
	componentWillReceiveProps: function(nextProps){
		this.setState({
			  todos: nextProps.todos,
			  noteId: nextProps.noteId,
			  isTypeToday: nextProps.isTypeToday,
			  eventTime: nextProps.eventTime
			});
	},

	render: function(){
			
		var self = this;
		return(
			<tbody>
			{this.state.todos.map(function(item, index){
				
				var textClasses = React.addons.classSet({
				    'uc-text-cell': true,
				    'striked-text': item.isTodoDone,
				    'bold': !item.isTodoDone && self.state.isTypeToday
				});
				
				var checkClasses = checkClasses = React.addons.classSet({
					'uc-check-btn': true,
					'uc-checked-btn': item.isTodoDone
				});
					
				var iconCheck = "";
				if(item.isTodoDone){
					iconCheck = <Icon type="check"  />
				}else{
					iconCheck = <Icon type="square-o" />
				}
				
				
				return(
					<tr key={self.state.noteId+""+item.todoNoteId} data-noteid={self.state.noteId} data-todonoteid={item.todoNoteId}>
						<td onClick={self.editNote}><div>{self.state.eventTime}</div></td>
						<td onClick={self.editNote}><div className={textClasses}>{item.todoText}</div></td>
						<td onClick={self.checkTodoNote}><div className={checkClasses}>{iconCheck}</div></td>
					</tr>
				)
			})}
			</tbody>
		);
	},
	editNote: function(e){
		var noteId = jQuery(e.target).closest('tr').data("noteid");
		UpcomingActions.editNote(noteId);
	},
	checkTodoNote: function(e){
		var todoNoteId = jQuery(e.target).closest("tr").data("todonoteid");
		UpcomingActions.checkTodoNote(this.state.noteId, todoNoteId);
	}
});

module.exports = TodoContent;
