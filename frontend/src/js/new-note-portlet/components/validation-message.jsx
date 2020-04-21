/** @jsx React.DOM */
var Icon = FontAwesome.Icon;
var NewNoteActions = require('../actions/new-note-actions');
var ValidationService = require('../services/validation-service');

var ValidationMessage = React.createClass({
	
	render: function(){
		
		  var classes = React.addons.classSet({
		    'nn-message-container': true,
		    'nn-validation-container': true,
		    'hover-transition': true,
		    'invisible': !ValidationService.hasError(),
		    'visible': ValidationService.hasError()
		  });
		
		var messages = ValidationService.getMessages();
		  
		return (
			<div className={classes}>
				<div className="nn-message-dismiss" onClick={this.dismissMessage}><Icon type="close" /></div>
				<div>
					<ul>
					{
						messages.map(function(msg, i){
							return (<li key={i}>{msg}</li>);
					})}
					</ul>
				</div>
			</div>
		);		
	},
	dismissMessage: function(){
		ValidationService.clearResult();
		this.setState({});
	}
	

	
});

module.exports = ValidationMessage;