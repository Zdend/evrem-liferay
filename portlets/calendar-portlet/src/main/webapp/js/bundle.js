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
	var CalendarStore = __webpack_require__(1);
	var CalendarActions = __webpack_require__(2);
	var CalendarContainer = __webpack_require__(3);



	Liferay.Portlet.ready(
	    function(portletId, node) {
	    	if(portletId.indexOf('calendarportlet_WAR_calendarportlet') !== -1){
	    		var events = JSON.parse(jQuery('#data-calendar').text());
	    		CalendarActions.registerEvents(events);
	    		
	    		React.renderComponent(CalendarContainer(null), document.querySelector('#calendar-container'));
	    	}
	    	
	    }
	);




/***/ },
/* 1 */
/***/ function(module, exports, __webpack_require__) {

	var AppDispatcher = __webpack_require__(4);
	var EventEmitter = Events.EventEmitter;
	var CalendarConstants = __webpack_require__(5);

	var _events = {};



	//FUNCTIONS
	var CalendarStore = merge(EventEmitter.prototype, {
		
		getEvents: function() {
			return _events;
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
		case CalendarConstants.REGISTER_EVENTS:
			_events = action.events;
			break;
			
			
		default:
			return true;
		}

		CalendarStore.emitChange();

		return true;
	});

	module.exports = CalendarStore;

/***/ },
/* 2 */
/***/ function(module, exports, __webpack_require__) {

	var AppDispatcher = __webpack_require__(4);
	var CalendarConstants = __webpack_require__(5);

	var CalendarActions = {

	  registerEvents: function(events) {
		    AppDispatcher.handleViewAction({
		      actionType: CalendarConstants.REGISTER_EVENTS,
		      events: events
		    });
	  },


	 

	};

	module.exports = CalendarActions;

/***/ },
/* 3 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var CalendarStore = __webpack_require__(1);
	var CalendarActions = __webpack_require__(2);

	function getEventsState() {
		  return {
		    events: CalendarStore.getEvents()
		  };
	}

	var CalendarContainer = React.createClass({displayName: 'CalendarContainer',
		getInitialState: function() {
		  return getEventsState();
		},
		componentDidMount: function() {


			jQuery('#calendar').fullCalendar({
				header: {
					left: 'prev,next today',
					center: 'title',
					right: 'month,basicWeek,basicDay'
				},
				height: 650,
				editable: false,
				eventLimit: true,
				events: this.state.events,
				timeFormat: 'H(:mm)',
				dayClick: function(date, allDay, jsEvent, view) { 
					jQuery('#calendar').fullCalendar('gotoDate', date );
					jQuery('#calendar').fullCalendar('changeView', 'basicDay');
					
				},
				eventRender: function( event, element, view ) {
			    	jQuery(element).attr('title', event.title);
			    }
			});

			

			
			
			
		},
		render: function(){
			return (
				React.DOM.div(null, 
					React.DOM.div({id: "calendar"})
				)
					
			);
		}
	});

	module.exports = CalendarContainer;


/***/ },
/* 4 */
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
/* 5 */
/***/ function(module, exports, __webpack_require__) {

	module.exports = keyMirror({

		REGISTER_EVENTS: null,
		
	});

/***/ }
/******/ ])