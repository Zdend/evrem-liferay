/** @jsx React.DOM */
var Icon = FontAwesome.Icon;
var OverlayTrigger = ReactBootstrap.OverlayTrigger;
var Tooltip = ReactBootstrap.Tooltip;

var ActionButton = React.createClass({
	
	render: function(){
		var btnClass = this.props.style + '-btn';
		var classesObject = {
				'hover-transition': true,
				'pointer-cursor': true
		};
		classesObject[btnClass] = true;
		
		var classes = React.addons.classSet(classesObject);
		return (
			<OverlayTrigger placement="top" delayShow={300} overlay={<Tooltip>{this.props.msg}</Tooltip>}>
				<Icon type={this.props.icon} className={classes} onClick={this.props.action} />
			</OverlayTrigger>
		);		
	}

	
});

module.exports = ActionButton;