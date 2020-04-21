/** @jsx React.DOM */
var Icon = FontAwesome.Icon;
var NewNoteActions = require('../actions/new-note-actions');
var OverlayTrigger = ReactBootstrap.OverlayTrigger;
var Tooltip = ReactBootstrap.Tooltip;

var OptionButton = React.createClass({
	
	render: function(){
		var classes = React.addons.classSet({
			'active': this.props.isToggle,
			'hover-transition': true,
			'pointer-cursor': true
		});
	
		
		return (
			<OverlayTrigger placement="top" delayShow={300} overlay={<Tooltip>{this.props.msg}</Tooltip>}>
				<Icon type={this.props.icon} className={classes} onClick={this.toggleOptionButton} />
			</OverlayTrigger>
			
		);		
	},
	toggleOptionButton: function(){
		NewNoteActions.toggleOption(this.props.btnType);
	}

	
});

module.exports = OptionButton;
