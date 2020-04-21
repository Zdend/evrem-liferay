/** @jsx React.DOM */
var Icon = FontAwesome.Icon;

var InfoMessage = React.createClass({
	
	render: function(){
		
		  var classes = React.addons.classSet({
			'evrem-message': true,
		    'hover-transition': true,
		    'visible': this.props.message,
		    'invisible': !this.props.message
		  });
		
		return (
			<div className={classes}>
				<div className="message-container info-container">
				<div className="message-dismiss" onClick={this.dismissMessage}><Icon type="close" /></div>
					{this.props.message}
				</div>
			</div>
		);		
	},
	
	dismissMessage: function(){
		this.props.clearMessageHandler();
	}

	
});

module.exports = InfoMessage;