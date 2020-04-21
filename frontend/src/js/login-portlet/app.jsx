/** @jsx React.DOM */

var LoginStore = require('./stores/login-store');
var LoginActions = require('./actions/login-actions');
var LoginBlock = require('./components/login-block.jsx');
var SocialLoginBlock = require('./components/social-login-block.jsx');
var SignupBlock = require('./components/signup-block.jsx');

function getUserState() {
	  return {
	    user: LoginStore.getUser(),
	    newUser: LoginStore.getNewUser()
	  };
}

var App = React.createClass({
	getInitialState: function() {
	  return getUserState();
	},
	componentDidMount: function() {
		LoginStore.addChangeListener(this._onChange);
  		var initialData = JSON.parse(jQuery('#data-login').text());
  		LoginActions.registerInitialData(initialData);
	},
	componentWillUnmount: function() {
		LoginStore.removeChangeListener(this._onChange);
	},
	render: function(){
		return (
			<div className="lg-centered-box">
				<div className="lg-header-wrapper">
					<div className="lg-header-logo"></div>
				
					<h1 className="lg-title-welcome">Welcome to evrem</h1>
					<p className="lg-title-description">Organise your life and never forget anything with this awesome 
					<span className="lg-desc-bold"> event reminder</span>..
					</p>
				</div>
				<div className="lg-login-wrapper">
					<div className="lg-login-inner">
						<LoginBlock user={this.state.user} />
						<hr />
						<SocialLoginBlock />
						<hr />
						<SignupBlock newUser={this.state.newUser} />
					</div>
				</div>
				<div className="lg-footer-wrapper">
					Made with love in 2015
				</div>
			</div>
		);
	},
	
   _onChange: function() {
     this.setState(getUserState());
   }
});

React.renderComponent(<App />,document.querySelector('#login-container'));