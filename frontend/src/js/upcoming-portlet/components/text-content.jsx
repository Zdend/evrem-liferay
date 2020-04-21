/** @jsx React.DOM */
var UpcomingActions = require('../actions/upcoming-actions');
var Icon = require('react-font-awesome').Icon;


var TextContent = React.createClass({
	getInitialState: function() {
	  return {
		  note: this.props.note,
		  isTypeToday: this.props.isTypeToday,
		  eventTime: this.props.eventTime
		};
	},

	componentWillReceiveProps: function(nextProps){
		this.setState({
		  note: nextProps.note,
		  isTypeToday: nextProps.isTypeToday,
		  eventTime: nextProps.eventTime
		});
	},
	
	render: function(){
		
		var isDone = this.state.note.hasCheck && this.state.note.isDone;
		var textClasses = React.addons.classSet({
		    'uc-text-cell': true,
		    'striked-text': isDone,
		    'bold': !this.state.note.isDone && this.state.isTypeToday
		});
		
		var checkClasses = React.addons.classSet({
			'uc-check-btn': this.state.note.hasCheck,
			'uc-checked-btn': isDone
		});
			
		var iconCheck = "";
		if(this.state.note.hasCheck){
			if(this.state.note.isDone){
				iconCheck = <Icon type="check" />
			}else{
				iconCheck = <Icon type="square-o" />
			}
		}
		
		return(
			<tbody>
				<tr>
					<td onClick={this.editNote}><div>{this.state.eventTime}</div></td>
					<td onClick={this.editNote}><div className={textClasses}>{this.state.note.text}</div></td>
					<td onClick={this.checkNote}><div className={checkClasses}>{iconCheck}</div></td>
				</tr>
			</tbody>
		);
	},
	
	editNote: function(e){
		UpcomingActions.editNote(this.state.note.noteId);
	},
	checkNote: function(e){
		UpcomingActions.checkNote(this.state.note.noteId);
	}
});

module.exports = TextContent;
