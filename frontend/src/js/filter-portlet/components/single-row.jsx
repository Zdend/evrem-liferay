/** @jsx React.DOM */
var FilterActions = require('../actions/filter-actions');
var Icon = require('react-font-awesome').Icon;
var Button = ReactBootstrap.Button;

var SingleRow = React.createClass({
	getInitialState: function() {
	  return {
		  note: this.props.note
		};
	},

	componentWillReceiveProps: function(nextProps){
		this.setState({
		  note: nextProps.note
		});
	},
	
	render: function(){
		var note = this.state.note;
		var isDoneIcon = <Icon type={note.hasCheck?(note.isDone?"check":"close"):""} />;
		var isDeleted = <Icon type={note.isDeleted?"trash":""} />;
		var showOnWall = <Icon type={note.hasWall?"th-large":""} />;
		var textParsed = note.hasTodo? GlobalUtil.replaceAll(note.text,"\r\n"," | ") : note.text;
		return(
				<tr onClick={this.editNote}>
					<td><div className="fr-color-cell" style={{backgroundColor: note.color.colorWithHash}}></div></td>
					<td><div className="fr-text-cell">{textParsed}</div></td>
					<td>{note.eventTime}</td>
					<td>{note.remindInfo?note.remindInfo.remindDate:""}</td>
					<td><div className="fr-centered-align">{note.period?note.period.title:""}</div></td>
					<td><div className="fr-centered-align">{isDoneIcon}</div></td>
					<td><div className="fr-centered-align">{showOnWall}</div></td>
					<td><div className="fr-centered-align">{isDeleted}</div></td>
					<td>{note.createdDate}</td>
					<td>{note.modifiedDate}</td>
				</tr>
		);
	},
	
	editNote: function(){
	    Liferay.fire(
	            'editNoteEvent', {
	            note: this.state.note
	        }
	    );
	},
});

module.exports = SingleRow;
