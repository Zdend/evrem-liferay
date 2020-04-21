/** @jsx React.DOM */
var Icon = FontAwesome.Icon;
var OverlayTrigger = ReactBootstrap.OverlayTrigger;
var Tooltip = ReactBootstrap.Tooltip;

var SocialLoginBlock = React.createClass({
	
	render: function(){
		var btnClass = this.props.style + '-btn';
		var classesObject = {
				'hover-transition': true,
				'pointer-cursor': true
		};
		classesObject[btnClass] = true;
		
		
		
		var classes = React.addons.classSet(classesObject);
		return (
			<div className="lg-social-login-block">
				<Icon type="facebook" />
				<Icon type="twitter" />
				<Icon type="google-plus" />
			</div>
		);		
	}

	
});

module.exports = SocialLoginBlock;