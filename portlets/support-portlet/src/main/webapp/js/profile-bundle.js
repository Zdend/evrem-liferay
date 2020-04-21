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
	var ProfileActions = __webpack_require__(1);
	var ProfileContainer = __webpack_require__(2);

	Liferay.Portlet.ready(
	    function(portletId, node) {
	    	if(portletId.indexOf('profileportlet_WAR_supportportlet') !== -1){
	    		var initialData = JSON.parse(jQuery('#data-profile').text());
	    		ProfileActions.registerUser(initialData.user);
	    		ProfileActions.registerTimeZones(initialData.timeZones);
	    		ProfileActions.registerUrls(initialData.urls);
	    		
	    		React.renderComponent(ProfileContainer(null), document.querySelector('#profile-container'));
	    	}
	    	
	    }
	);




/***/ },
/* 1 */
/***/ function(module, exports, __webpack_require__) {

	var AppDispatcher = __webpack_require__(3);
	var ProfileConstants = __webpack_require__(4);

	var ProfileActions = {

	  registerUser: function(user) {
		    AppDispatcher.handleViewAction({
		      actionType: ProfileConstants.REGISTER_USER,
		      user: user
		    });
	  },
	  registerTimeZones: function(timeZones) {
		  AppDispatcher.handleViewAction({
			  actionType: ProfileConstants.REGISTER_TIMEZONES,
			  timeZones: timeZones
		  });
	  },
	  registerUrls: function(urls) {
		  AppDispatcher.handleViewAction({
			  actionType: ProfileConstants.REGISTER_URLS,
			  urls: urls
		  });
	  },
	  timeZoneChange: function(timeZoneId) {
		  AppDispatcher.handleViewAction({
			  actionType: ProfileConstants.TIMEZONE_CHANGED,
			  timeZoneId: timeZoneId
		  });
	  },
	  saveUser: function() {
		  AppDispatcher.handleServerAction({
			  actionType: ProfileConstants.SAVE_USER
		  });
	  },
	  clearInfoMessage: function() {
		  AppDispatcher.handleViewAction({
			  actionType: ProfileConstants.CLEAR_INFO_MESSAGE
		  });
	  }


	 

	};

	module.exports = ProfileActions;

/***/ },
/* 2 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var ProfileStore = __webpack_require__(5);
	var ProfileActions = __webpack_require__(1);
	var ProfileConstants = __webpack_require__(4);
	var TimeZonePicker = __webpack_require__(6);
	var InfoMessage = __webpack_require__(7);
	var Button = ReactBootstrap.Button;
	var Icon = FontAwesome.Icon;

	function getUserState() {
		  return {
		    user: ProfileStore.getUser(),
		    infoMessage: ProfileStore.getInfoMessage()
		  };
	}

	var ProfileContainer = React.createClass({displayName: 'ProfileContainer',
		getInitialState: function() {
		  return getUserState();
		},
		componentDidMount: function() {
			ProfileStore.addChangeListener(this._onChange);
		},
		componentWillUnmount: function() {
			ProfileStore.removeChangeListener(this._onChange);
		},
		render: function(){
			return (
				React.DOM.div(null, 
					InfoMessage({message: this.state.infoMessage, clearMessageHandler: ProfileActions.clearInfoMessage}), 
					TimeZonePicker({timeZoneId: this.state.user.timeZoneId}), 
					Button({bsStyle: "primary", onClick: this.saveUser}, Icon({type: "save"}), " Save")
				)
					
			);
		},
		_onChange: function() {
			this.setState(getUserState());
		},
		saveUser: function(){
			ProfileActions.saveUser();
		}
	});

	module.exports = ProfileContainer;


/***/ },
/* 3 */
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
/* 4 */
/***/ function(module, exports, __webpack_require__) {

	module.exports = keyMirror({

		REGISTER_USER: null,
		REGISTER_TIMEZONES: null,
		REGISTER_URLS: null,
		TIMEZONE_CHANGED: null,
		SAVE_USER: null,
		CLEAR_INFO_MESSAGE: null
		
		
		
	});

/***/ },
/* 5 */
/***/ function(module, exports, __webpack_require__) {

	var AppDispatcher = __webpack_require__(3);
	var EventEmitter = Events.EventEmitter;
	var ProfileConstants = __webpack_require__(4);

	var _user = {};
	var _timeZones = [];
	var _urls = {};
	var _infoMessage = '';

	function saveUser(){
		Spinner.start();
		jQuery.ajax({
			type: 'POST',
			dataType : 'json',
			url: _urls['saveUser'],
			data: {jsonUser: JSON.stringify(_user)},
			success :function(result) {
				_infoMessage = 'User has been successfully saved.';
				ProfileStore.emitChange();
				return result.payload;
			},
			complete: function(){
				Spinner.stop();
			}
		});
	}


	//FUNCTIONS
	var ProfileStore = merge(EventEmitter.prototype, {
		
		getUser: function() {
			return _user;
		},
		getInfoMessage: function() {
			return _infoMessage;
		},
		getTimeZones: function() {
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
		case ProfileConstants.REGISTER_USER:
			_user = action.user;
			break;
		case ProfileConstants.REGISTER_TIMEZONES:
			_timeZones = action.timeZones;
			break;
		case ProfileConstants.REGISTER_URLS:
			_urls = action.urls;
			return true;
		case ProfileConstants.TIMEZONE_CHANGED:
			_user.timeZoneId = action.timeZoneId;
			break;
		case ProfileConstants.SAVE_USER:
			saveUser();
			return true;
		case ProfileConstants.CLEAR_INFO_MESSAGE:
			_infoMessage = '';
			break;
			
			
		default:
			return true;
		}

		ProfileStore.emitChange();

		return true;
	});

	module.exports = ProfileStore;

/***/ },
/* 6 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var Icon = FontAwesome.Icon;
	var OverlayTrigger = ReactBootstrap.OverlayTrigger;
	var OverlayMixin = ReactBootstrap.OverlayMixin;
	var Tooltip = ReactBootstrap.Tooltip;
	var Button = ReactBootstrap.Button;
	var ProfileActions = __webpack_require__(1);
	var ProfileStore = __webpack_require__(5);

	var TimezonePicker = React.createClass({displayName: 'TimezonePicker',
		 getInitialState: function(){
			 return({
				timeZones: ProfileStore.getTimeZones() || [],
			 	value: this.props.timeZoneId
			 });
		 },
		 componentWillReceiveProps: function(nextProps){
			this.setState({
				value: nextProps.timeZoneId
			}) 
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
			ProfileActions.timeZoneChange(timeZoneId);
		},
		
		_onChange: function(e){
		    this.setState({
			    value: e.target.value
			});
		}
		  
		  
		});

	module.exports = TimezonePicker;

/***/ },
/* 7 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var Icon = FontAwesome.Icon;

	var InfoMessage = React.createClass({displayName: 'InfoMessage',
		
		render: function(){
			
			  var classes = React.addons.classSet({
				'evrem-message': true,
			    'hover-transition': true,
			    'visible': this.props.message,
			    'invisible': !this.props.message
			  });
			
			return (
				React.DOM.div({className: classes}, 
					React.DOM.div({className: "message-container info-container"}, 
					React.DOM.div({className: "message-dismiss", onClick: this.dismissMessage}, Icon({type: "close"})), 
						this.props.message
					)
				)
			);		
		},
		
		dismissMessage: function(){
			this.props.clearMessageHandler();
		}

		
	});

	module.exports = InfoMessage;

/***/ }
/******/ ])