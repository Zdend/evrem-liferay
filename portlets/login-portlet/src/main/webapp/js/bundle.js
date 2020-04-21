/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;
/******/
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */

	var LoginStore = __webpack_require__(1);
	var LoginActions = __webpack_require__(2);
	var LoginBlock = __webpack_require__(3);
	var SocialLoginBlock = __webpack_require__(4);
	var SignupBlock = __webpack_require__(5);

	function getUserState() {
		  return {
		    user: LoginStore.getUser(),
		    newUser: LoginStore.getNewUser()
		  };
	}

	var App = React.createClass({displayName: 'App',
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
				React.DOM.div({className: "lg-centered-box"}, 
					React.DOM.div({className: "lg-header-wrapper"}, 
						React.DOM.div({className: "lg-header-logo"}), 
					
						React.DOM.h1({className: "lg-title-welcome"}, "Welcome to evrem"), 
						React.DOM.p({className: "lg-title-description"}, "Organise your life and never forget anything with this awesome",  
						React.DOM.span({className: "lg-desc-bold"}, " event reminder"), ".."
						)
					), 
					React.DOM.div({className: "lg-login-wrapper"}, 
						React.DOM.div({className: "lg-login-inner"}, 
							LoginBlock({user: this.state.user}), 
							React.DOM.hr(null), 
							SocialLoginBlock(null), 
							React.DOM.hr(null), 
							SignupBlock({newUser: this.state.newUser})
						)
					), 
					React.DOM.div({className: "lg-footer-wrapper"}, 
						"Made with love in 2015"
					)
				)
			);
		},
		
	   _onChange: function() {
	     this.setState(getUserState());
	   }
	});

	React.renderComponent(App(null),document.querySelector('#login-container'));

/***/ },
/* 1 */
/***/ function(module, exports, __webpack_require__) {

	var AppDispatcher = __webpack_require__(6);
	var EventEmitter = Events.EventEmitter;
	var LoginConstants = __webpack_require__(7);
	var UtilService = __webpack_require__(8);

	var _user = {
			email: '',
			password: '',
			rememberMe: false
	};
	var _newUser = UtilService.getEmptyNewUser();

	var _urls = {};
	var _timeZones = [];

	function logIn(){
		Spinner.start();
		var data = {
				saveLastPath: false,
				cmd: 'update',
				rememberMe: _user.rememberMe,
				login: _user.email,
				password: _user.password
		};
		
		jQuery.ajax({
			type: 'POST',
			url: _urls['logIn'],
			data: data,
			success: function(result) {
				window.location.href = "/group/evrem/home";
				return result.payload;
			},
			complete: function(){
				Spinner.stop();
			}
		});
	}

	function signUp(){
		Spinner.start();
		jQuery.ajax({
			type: 'POST',
			url: _urls['signUp'],
			data: _newUser,
			success :function(result) {
	//			window.location.replace("/group/evrem/home");
				_newUser = UtilService.getEmptyNewUser();
				LoginStore.emitChange();
				return result.payload;
			},
			complete: function(){
				Spinner.stop();
			}
		});
		
		console.log('Signing up...');
	}
	function loadTimeZones(){
		if(typeof _timeZones != 'undefined' && _timeZones.length !== 0 ){
			return;
		}
		jQuery.ajax({
			type: 'POST',
			dataType : 'json',
			url: _urls['loadTimeZones'],
			success: function(result) {
				_timeZones = result.payload;
				LoginStore.emitChange();
				return result.payload;
			}
		});
		
	}


	//FUNCTIONS
	var LoginStore = merge(EventEmitter.prototype, {
		
		getUser: function() {
			return _user;
		},
		getNewUser: function() {
			return _newUser;
		},
		getTimeZones: function(){
			return _timeZones;
		},
		emitChange: function() {
			this.emit(GlobalConstants.CHANGE_EVENT);
		},
		addChangeListener: function(callback) {
			this.on(GlobalConstants.CHANGE_EVENT, callback);
		},
		removeChangeListener: function(callback) {
			this.removeListener(GlobalConstants.CHANGE_EVENT, callback);
		}
	});

	AppDispatcher.register(function(payload) {
		var action = payload.action;

		switch(action.actionType) {
		case LoginConstants.REGISTER_INITIAL_DATA:
			_user.email = action.initialData.email;
			_user.rememberMe = action.initialData.rememberMe;
			_urls = action.initialData.urls;
			break;
		case LoginConstants.USER_EMAIL_CHANGE:
			_user.email = action.email;
			break;
		case LoginConstants.USER_PASSWORD_CHANGE:
			_user.password = action.password;
			break;
		case LoginConstants.USER_REMEMBERME_CHANGE:
			_user.rememberMe = action.rememberMe;
			break;
		case LoginConstants.NEWUSER_EMAIL_CHANGE:
			_newUser.email = action.email;
			loadTimeZones();
			break;
		case LoginConstants.NEWUSER_PASSWORD1_CHANGE:
			_newUser.password1 = action.password1;
			break;
		case LoginConstants.NEWUSER_PASSWORD2_CHANGE:
			_newUser.password2 = action.password2;
			break;
		case LoginConstants.EVREM_LOG_IN:
			logIn();
			break;
		case LoginConstants.EVREM_SIGN_UP:
			signUp();
			break;
		case LoginConstants.SET_CAPTCHA_TOKEN:
			_newUser.token = action.token;
			break;
		case LoginConstants.LOAD_TIME_ZONES:
			loadTimeZones();
			return true;
		case LoginConstants.TIME_ZONE_CHANGE:
			_newUser.timeZoneId = action.timeZoneId;
			break;
			
		default:
			return true;
		}

		LoginStore.emitChange();

		return true;
	});

	module.exports = LoginStore;

/***/ },
/* 2 */
/***/ function(module, exports, __webpack_require__) {

	var AppDispatcher = __webpack_require__(6);
	var LoginConstants = __webpack_require__(7);

	var LoginActions = {

		registerInitialData: function(initialData) {
			AppDispatcher.handleViewAction({
				actionType: LoginConstants.REGISTER_INITIAL_DATA,
				initialData: initialData
			});
		},
	  userEmailChange: function(email) {
		    AppDispatcher.handleViewAction({
		      actionType: LoginConstants.USER_EMAIL_CHANGE,
		      email: email
		    });
	  },
	  userPasswordChange: function(password) {
		  AppDispatcher.handleViewAction({
			  actionType: LoginConstants.USER_PASSWORD_CHANGE,
			  password: password
		  });
	  },
	  userRememberMeChange: function(rememberMe) {
		  AppDispatcher.handleViewAction({
			  actionType: LoginConstants.USER_REMEMBERME_CHANGE,
			  rememberMe: rememberMe
		  });
	  },
	  newUserEmailChange: function(email) {
		  AppDispatcher.handleViewAction({
			  actionType: LoginConstants.NEWUSER_EMAIL_CHANGE,
			  email: email
		  });
	  },
	  newUserPassword1Change: function(password1) {
		  AppDispatcher.handleViewAction({
			  actionType: LoginConstants.NEWUSER_PASSWORD1_CHANGE,
			  password1: password1
		  });
	  },
	  newUserPassword2Change: function(password2) {
		  AppDispatcher.handleViewAction({
			  actionType: LoginConstants.NEWUSER_PASSWORD2_CHANGE,
			  password2: password2
		  });
	  },
	  evremLogIn: function() {
		  AppDispatcher.handleServerAction({
			  actionType: LoginConstants.EVREM_LOG_IN
		  });
	  },
	  signUp: function() {
		  AppDispatcher.handleServerAction({
			  actionType: LoginConstants.EVREM_SIGN_UP
		  });
	  },
	  setCaptchaToken: function(token) {
		  AppDispatcher.handleViewAction({
			  actionType: LoginConstants.SET_CAPTCHA_TOKEN,
			  token: token
		  });
	  },
	  loadTimeZones: function() {
		  AppDispatcher.handleServerAction({
			  actionType: LoginConstants.LOAD_TIME_ZONES
		  });
	  },
	  timeZoneChange: function(timeZoneId) {
		  AppDispatcher.handleServerAction({
			  actionType: LoginConstants.TIME_ZONE_CHANGE,
			  timeZoneId: timeZoneId
		  });
	  },


	 

	};

	module.exports = LoginActions;

/***/ },
/* 3 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var Icon = FontAwesome.Icon;
	var OverlayTrigger = ReactBootstrap.OverlayTrigger;
	var Tooltip = ReactBootstrap.Tooltip;
	var LoginActions = __webpack_require__(2);

	var LoginBlock = React.createClass({displayName: 'LoginBlock',
		 getInitialState: function() {
		    return {
		      email: this.props.user.email,
		      password: this.props.user.password,
		      rememberMe: this.props.user.rememberMe,
		    };
		},
		componentWillReceiveProps: function(nextProps){
	      this.setState({
	    	  email: nextProps.user.email,
	    	  password: nextProps.user.password,
	    	  rememberMe: nextProps.user.rememberMe
	      });
		},
		
		render: function(){
			return (
				React.DOM.div({className: "lg-login-block"}, 
					React.DOM.h2(null, "Log in"), 
					React.DOM.input({type: "text", value: this.state.email, placeholder: "Email", onChange: this.onEmailChange, onBlur: this.updateEmail}), 
					React.DOM.br(null), 
					React.DOM.input({type: "password", value: this.state.password, placeholder: "Password", onChange: this.onPasswordChange, onBlur: this.updatePassword}), 
					React.DOM.br(null), 
					
					React.DOM.button({className: "btn btn-primary lg-login-btn", onClick: this.logIn}, "Log in"), 
					React.DOM.ul({className: "lg-remember-forgotten"}, 
						React.DOM.li(null, React.DOM.a({href: "#"}, "Forgotten password")), 
						React.DOM.li(null, 
							React.DOM.div({className: "checkbox"}, 
					          React.DOM.label(null, 
					            React.DOM.input({type: "checkbox", checked: this.state.rememberMe, onClick: this.updateRememberMe, onChange: this.updateRememberMe}), " Remember me"
					          )
					        )
					    )
					), 
					React.DOM.div({className: "cleaner"})
				)
			);		
		},
		
		updateEmail: function(e){
			LoginActions.userEmailChange(e.target.value);
		},
		
		onEmailChange: function(e) {
		    this.setState({
		      email: e.target.value
		    });
		},
		
		updatePassword: function(e){
			LoginActions.userPasswordChange(e.target.value);
		},
		
		onPasswordChange: function(e) {
			this.setState({
				password: e.target.value
			});
		},

		updateRememberMe: function(e){
			LoginActions.userRememberMeChange(e.target.checked);
		},
		
		logIn: function(){
			LoginActions.evremLogIn();
		}
		
	});

	module.exports = LoginBlock;

/***/ },
/* 4 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var Icon = FontAwesome.Icon;
	var OverlayTrigger = ReactBootstrap.OverlayTrigger;
	var Tooltip = ReactBootstrap.Tooltip;

	var SocialLoginBlock = React.createClass({displayName: 'SocialLoginBlock',
		
		render: function(){
			var btnClass = this.props.style + '-btn';
			var classesObject = {
					'hover-transition': true,
					'pointer-cursor': true
			};
			classesObject[btnClass] = true;
			
			
			
			var classes = React.addons.classSet(classesObject);
			return (
				React.DOM.div({className: "lg-social-login-block"}, 
					Icon({type: "facebook"}), 
					Icon({type: "twitter"}), 
					Icon({type: "google-plus"})
				)
			);		
		}

		
	});

	module.exports = SocialLoginBlock;

/***/ },
/* 5 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var Icon = FontAwesome.Icon;
	var OverlayTrigger = ReactBootstrap.OverlayTrigger;
	var Tooltip = ReactBootstrap.Tooltip;
	var LoginActions = __webpack_require__(2);

	var SignupCaptcha = __webpack_require__(9);

	var SignupBlock = React.createClass({displayName: 'SignupBlock',
		 getInitialState: function() {
		    return {
		      email: this.props.newUser.email,
		      password1: this.props.newUser.password1,
		      password2: this.props.newUser.password2,
		      captcha: this.props.newUser.captcha
		    };
		},
		componentWillReceiveProps: function(nextProps){
	      this.setState({
	    	  email: nextProps.newUser.email,
	    	  password1: nextProps.newUser.password1,
	    	  password2: nextProps.newUser.password2,
	    	  captcha: nextProps.newUser.captcha
	      });
		},

		render: function(){
			return (
				React.DOM.div(null, 
					React.DOM.h2(null, "Sign up"), 
					React.DOM.input({type: "text", value: this.state.email, placeholder: "Email", onChange: this.onEmailChange, onBlur: this.updateEmail, bsStyle: "error"}), 
					React.DOM.br(null), 
					React.DOM.input({type: "password", value: this.state.password1, placeholder: "Password", onChange: this.onPassword1Change, onBlur: this.updatePassword1}), 
					React.DOM.br(null), 
					React.DOM.input({type: "password", value: this.state.password2, placeholder: "Password again", onChange: this.onPassword2Change, onBlur: this.updatePassword2}), 
					React.DOM.br(null), 
					SignupCaptcha({newUser: this.state})
				)
			);		
		},
		
		updateEmail: function(e){
			LoginActions.newUserEmailChange(e.target.value);
		},
		
		onEmailChange: function(e) {
		    this.setState({
		      email: e.target.value
		    });
		},
		
		updatePassword1: function(e){
			LoginActions.newUserPassword1Change(e.target.value);
		},
		
		onPassword1Change: function(e) {
			this.setState({
				password1: e.target.value
			});
		},
		
		updatePassword2: function(e){
			LoginActions.newUserPassword2Change(e.target.value);
		},
		
		onPassword2Change: function(e) {
			this.setState({
				password2: e.target.value
			});
		}
		

		
	});

	module.exports = SignupBlock;

/***/ },
/* 6 */
/***/ function(module, exports, __webpack_require__) {

	var Dispatcher = Flux.Dispatcher;
	var AppDispatcher = copyProperties(new Dispatcher(), {

	  /**
	   * A bridge function between the views and the dispatcher, marking the action
	   * as a view action.  Another variant here could be handleServerAction.
	   * @param  {object} action The data coming from the view.
	   */
	  handleViewAction: function(action) {
	    this.dispatch({
	      source: 'VIEW_ACTION',
	      action: action
	    });
	  },
	  handleServerAction: function(action) {
		    this.dispatch({
		      source: 'SERVER_ACTION',
		      action: action
		    });
		  }
	  
	});

	module.exports = AppDispatcher;

/***/ },
/* 7 */
/***/ function(module, exports, __webpack_require__) {

	module.exports = keyMirror({
		REGISTER_INITIAL_DATA: null,
		USER_EMAIL_CHANGE: null,
		USER_PASSWORD_CHANGE: null,
		USER_REMEMBERME_CHANGE: null,
		
		NEWUSER_EMAIL_CHANGE: null,
		NEWUSER_PASSWORD1_CHANGE: null,
		NEWUSER_PASSWORD2_CHANGE: null,
		EVREM_LOG_IN: null,
		EVREM_SIGN_UP: null,
		SET_CAPTCHA_TOKEN: null,
		LOAD_TIME_ZONES: null,
		TIME_ZONE_CHANGE: null
		
	});

/***/ },
/* 8 */
/***/ function(module, exports, __webpack_require__) {

	var UtilService = {
			getEmptyNewUser: function(){
				return {
					email: '',
					password1: '',
					password2: '',
					token: '',
					timeZoneId: ''
				};
			}
			
	}
	module.exports = UtilService;

/***/ },
/* 9 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var Icon = FontAwesome.Icon;
	var OverlayTrigger = ReactBootstrap.OverlayTrigger;
	var OverlayMixin = ReactBootstrap.OverlayMixin;
	var Tooltip = ReactBootstrap.Tooltip;
	var Button = ReactBootstrap.Button;
	var Modal = ReactBootstrap.Modal;
	var LoginActions = __webpack_require__(2);
	var LoginStore = __webpack_require__(1);
	var TimeZonePicker = __webpack_require__(10);

	var SignupCaptcha = React.createClass({displayName: 'SignupCaptcha',
		
		 mixins: [OverlayMixin],

		  getInitialState: function () {
		    return {
		      isModalOpen: false,
		      termsAgreement: false
		    };
		  },

		  handleToggle: function () {
		    this.setState({
		      isModalOpen: !this.state.isModalOpen
		    },this.loadModalComponents);
		  },
		  
		  loadModalComponents: function(){
			  if(this.state.isModalOpen){
				  var self = this;
				  var captchaContainer = grecaptcha.render('lg-signup-captcha', {
				    'sitekey' : '6LfNQ_8SAAAAAKt6_kksQNfkXSZCGX68H1oASSkx',
				    'callback' : function(response) {
				    	LoginActions.setCaptchaToken(response);
				    	self.setState({
				    		termsAgreement: true
				    	});
				    }
				  });
			  }
		  },
		  
		  render: function () {
			 var disabled = this.props.newUser.email === '' || this.props.newUser.password1 === '' || this.props.newUser.password2 === '';
			  
		    return (
				    Button({onClick: this.handleToggle, bsStyle: "primary", disabled: disabled}, "Sign up")
		    );
		  },

		  renderOverlay: function () {
		    if (!this.state.isModalOpen) {
		      return React.DOM.span(null);
		    }
		    
		    return (
		        Modal({title: "Confirm your registration", onRequestHide: this.handleToggle, className: "lg-registration-confirmation"}, 
		          React.DOM.div({className: "modal-body"}, 
		          	React.DOM.h4(null, "Are you human?"), 
		          	React.DOM.div({id: "lg-signup-captcha"}), 
			        TimeZonePicker(null)
			      ), 
		          
		          React.DOM.div({className: "modal-footer"}, 
		            Button({onClick: this.handleToggle}, "Close"), 
		            Button({bsStyle: "primary", onClick: this.signUp}, "Register")
		          )
		        )
		      );
		  },
		  
		  signUp: function(){
			  if(this.state.termsAgreement){
				  LoginActions.signUp();
				  this.handleToggle();
			  }
		  },
		  
		  checkTerms: function(){
			  this.setState({
				  termsAgreement: !this.state.termsAgreement
			  });
		  }
		  
		});

	module.exports = SignupCaptcha;

/***/ },
/* 10 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var Icon = FontAwesome.Icon;
	var OverlayTrigger = ReactBootstrap.OverlayTrigger;
	var OverlayMixin = ReactBootstrap.OverlayMixin;
	var Tooltip = ReactBootstrap.Tooltip;
	var Button = ReactBootstrap.Button;
	var LoginActions = __webpack_require__(2);
	var LoginStore = __webpack_require__(1);


	var TimezonePicker = React.createClass({displayName: 'TimezonePicker',
		 getInitialState: function(){
			 return({
				timeZones: LoginStore.getTimeZones() || [],
			 	value: ''
			 });
		 },
		  componentDidMount: function(){
			var offset = new Date().getTimezoneOffset();
			var offsetMillis = offset * 60 * 1000 * (-1);
			
			var i;
			for(i=0;i < this.state.timeZones.length; i++){
				var timeZone = this.state.timeZones[i];
				if(timeZone.offset === offsetMillis){
					this.setState({value: timeZone.timeZoneId});
					LoginActions.timeZoneChange(timeZone.timeZoneId);
					break;
				}
			}
		  },
		  render: function () {
			  
		    return (
			       React.DOM.div({className: "lg-timezone-picker"}, 
			      	  React.DOM.h4({onClick: this.showOptions}, "Pick your timezone"), 

					  React.DOM.div({className: "form-group"}, 
						  React.DOM.div({className: "input-append"}, 
						      React.DOM.select({type: "text", className: "form-control", id: "timezone-select", 
						    	  onBlur: this.timeZoneChange, 
						          onChange: this._onChange, 
						      	  value: this.state.value}, 
						      	this.state.timeZones.map(function(item, index){
						      		return (React.DOM.option({key: index, value: item.timeZoneId}, item.timeZoneId, " ", item.offsetTitle))
						      	})
						      ), 
						      React.DOM.button({type: "submit", className: "btn btn-primary nocursor", onClick: this.showOptions}, 
						      	React.DOM.span({className: "fa fa-globe"})		
						      )
						  )
					  )
				 )
		    );
		  },

		 showOptions: function(){
			 jQuery('#timezone-select').show().focus().click();
		 },
		
		timeZoneChange: function(e){
			jQuery("#timezone-select").prop('size', 1);
			var timeZoneId = e.target.value;
			LoginActions.timeZoneChange(timeZoneId);
		},
		
		_onChange: function(e){
		    this.setState({
			    value: e.target.value
			});
		}
		  
		  
		});

	module.exports = TimezonePicker;

/***/ }
/******/ ])