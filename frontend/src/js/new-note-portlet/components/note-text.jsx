/** @jsx React.DOM */
var NewNoteActions = require('../actions/new-note-actions');
var ValidationService = require('../services/validation-service');

var NoteText = React.createClass({
	 getInitialState: function() {
	    return {
	      value: this.props.value
	    };
	},
	
	componentWillReceiveProps: function(nextProps){
		var self = this;
		this.setState({
			  value: nextProps.value
		},self.refs.autoTextArea.recalculateSize);
		
	},
	
	render: function(){
		var classes = React.addons.classSet({
			'control-group': true,
			'error': ValidationService.hasFieldError('noteText')
		});		
		
		return (
			<AutoTextarea 
				ref="autoTextArea"
				id="new-note-input"
				placeholder="Note text.." 
				onBlur={this.updateText}
				onChange={this._onChange}
				value={this.state.value}
				className={classes}></AutoTextarea>
		);
	},
	
	updateText: function(e){
		var text = e.target.value;
		NewNoteActions.textChange(text);
	},
	
	_onChange: function(e) {
	    this.setState({
	      value: e.target.value
	    });
	 }
	
	
});

module.exports = NoteText;
