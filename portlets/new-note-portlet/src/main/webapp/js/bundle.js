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
	var NewNoteActions = __webpack_require__(1);
	var NoteContainer = __webpack_require__(2);

	Liferay.Portlet.ready(
	    function(portletId, node) {
	    	if(portletId.indexOf('newnoteportlet_WAR_newnoteportlet') !== -1){
	    		var initialData = JSON.parse(jQuery('#data-new-note').text());
	    		NewNoteActions.registerUrls(initialData.urls);
	    		NewNoteActions.registerColors(initialData.colors);
	    		NewNoteActions.registerPeriods(initialData.periods);
	    		
	    		React.renderComponent(NoteContainer(null), document.querySelector('#new-note-container'));
	    	}
	    	
	    }
	);


/***/ },
/* 1 */
/***/ function(module, exports, __webpack_require__) {

	var AppDispatcher = __webpack_require__(3);
	var NewNoteConstants = __webpack_require__(4);

	var NewNoteActions = {


	  toggleOption: function(btnType) {
	    AppDispatcher.handleViewAction({
	      actionType: NewNoteConstants.TOGGLE_OPTION,
	      btnType: btnType
	    });
	  },
	  registerColors: function(colors) {
		  AppDispatcher.handleViewAction({
			  actionType: NewNoteConstants.REGISTER_COLORS,
			  colors: colors
		  });
	  },
	  registerUrls: function(urls) {
		  AppDispatcher.handleViewAction({
			  actionType: NewNoteConstants.REGISTER_URLS,
			  urls: urls
		  });
	  },
	  registerPeriods: function(periods) {
		  AppDispatcher.handleViewAction({
			  actionType: NewNoteConstants.REGISTER_PERIODS,
			  periods: periods
		  });
	  },

	  saveNote: function(){
		  AppDispatcher.handleServerAction({
			  actionType: NewNoteConstants.SAVE_NOTE
		  });
	  },
	  textChange: function(text){
		  AppDispatcher.handleViewAction({
			  actionType: NewNoteConstants.TEXT_CHANGE,
			  text: text
		  });
	  },
	  eventTimeChange: function(time){
		  AppDispatcher.handleViewAction({
			  actionType: NewNoteConstants.EVENT_TIME_CHANGE,
			  time: time
		  });
	  },
	  remindTimeChange: function(time){
		  AppDispatcher.handleViewAction({
			  actionType: NewNoteConstants.REMIND_TIME_CHANGE,
			  time: time
		  });
	  },
	  remindSubjectChange: function(subject){
		  AppDispatcher.handleViewAction({
			  actionType: NewNoteConstants.REMIND_SUBJECT_CHANGE,
			  subject: subject
		  });
	  },
	  repeatPeriodChange: function(period){
		  AppDispatcher.handleViewAction({
			  actionType: NewNoteConstants.PERIOD_CHANGE,
			  period: period
		  });
	  },
	  colorChange: function(color){
		  AppDispatcher.handleViewAction({
			  actionType: NewNoteConstants.COLOR_CHANGE,
			  color: color
		  });
	  },
	  editNote: function(note){
		  AppDispatcher.handleViewAction({
			  actionType: NewNoteConstants.EDIT_NOTE,
			  note: note
		  });
	  },
	  deleteNote: function(){
		  AppDispatcher.handleViewAction({
			  actionType: NewNoteConstants.DELETE_NOTE
		  });
	  },
	  clearNote: function(){
		  AppDispatcher.handleViewAction({
			  actionType: NewNoteConstants.CLEAR_NOTE
		  });
	  },
	  checkNote: function(){
		  AppDispatcher.handleViewAction({
			  actionType: NewNoteConstants.CHECK_NOTE
		  });
	  },
	  restoreNote: function(){
		  AppDispatcher.handleServerAction({
			  actionType: NewNoteConstants.RESTORE_NOTE
		  });
	  },
	  restoreCurrentNote: function(){
		  AppDispatcher.handleServerAction({
			  actionType: NewNoteConstants.RESTORE_CURRENT_NOTE
		  });
	  },
	  clearInfoMessage: function(){
		  AppDispatcher.handleViewAction({
			  actionType: NewNoteConstants.CLEAR_INFO_MSG
		  });
	  }

	 

	};

	module.exports = NewNoteActions;

/***/ },
/* 2 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var NoteText = __webpack_require__(5);
	var OptionButtons = __webpack_require__(6);
	var NewNoteStore = __webpack_require__(14);
	var NewNoteActions = __webpack_require__(1);
	var TimeBlock = __webpack_require__(7);
	var ReminderBlock = __webpack_require__(8);
	var ReminderSubjectBlock = __webpack_require__(9);
	var RepeatBlock = __webpack_require__(10);
	var ColorBlock = __webpack_require__(11);
	var IsdoneBlock = __webpack_require__(12);
	var ValidationMessage = __webpack_require__(13);
	var InfoMessage = __webpack_require__(15);

	function getNoteState() {
		  return {
		    note: NewNoteStore.getNote(),
		    colors: NewNoteStore.getColors(),
		    periods: NewNoteStore.getPeriods(),
		    hasDeletedNote: NewNoteStore.getHasDeletedNote(),
		    infoMessage: NewNoteStore.getInfoMessage()
		  };
	}

	Liferay.on('editNoteEvent', function(event) {
		var body = jQuery('body');
		var noteInput = jQuery('#new-note-input');
		body.animate({
		    scrollTop: noteInput.offset().top
		});
		noteInput.focus();
	    NewNoteActions.editNote(event.note);
	});

	var NoteContainer = React.createClass({displayName: 'NoteContainer',
		getInitialState: function() {
		  return getNoteState();
		},
		componentDidMount: function() {
			NewNoteStore.addChangeListener(this._onChange);
		},
		componentWillUnmount: function() {
			NewNoteStore.removeChangeListener(this._onChange);
		},
		render: function(){
			return (
				React.DOM.div(null, 
					ValidationMessage({validation: this.state.validation}), 
					InfoMessage({message: this.state.infoMessage, clearMessageHandler: NewNoteActions.clearInfoMessage}), 
				
					React.DOM.ul({className: "text-options-container"}, 
						React.DOM.li({className: "note-textarea-wrapper"}, NoteText({value: this.state.note.text})), 
						React.DOM.li({className: "note-buttons-wrapper"}, OptionButtons({note: this.state.note, hasDeletedNote: this.state.hasDeletedNote}))
					), 
					React.DOM.div({className: "cleaner"}), 
					React.DOM.hr(null), 
					
					React.DOM.div({className: "block-container"}, 
						IsdoneBlock({note: this.state.note}), 
						TimeBlock({note: this.state.note}), 
						ReminderBlock({note: this.state.note}), 
						ReminderSubjectBlock({note: this.state.note}), 
						ColorBlock({note: this.state.note, colors: this.state.colors}), 
						RepeatBlock({note: this.state.note, periods: this.state.periods})
					), 			
					React.DOM.div({className: "cleaner"})
				)
			);
		},
		
	   _onChange: function() {
	     this.setState(getNoteState());
	   }
	});
	module.exports = NoteContainer;


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
		TOGGLE_OPTION: null,
		REGISTER_COLORS: null,
		REGISTER_URLS: null,
		REGISTER_PERIODS: null,
		SAVE_NOTE: null,
		TEXT_CHANGE: null,
		EVENT_TIME_CHANGE: null,
		REMIND_TIME_CHANGE: null,
		COLOR_CHANGE: null,
		PERIOD_CHANGE: null,
		REMIND_SUBJECT_CHANGE: null,
		EDIT_NOTE: null,
		DELETE_NOTE: null,
		CLEAR_NOTE: null,
		CHECK_NOTE: null,
		RESTORE_NOTE: null,
		RESTORE_CURRENT_NOTE: null,
		CLEAR_INFO_MSG: null,
		
		//OPTION TYPES
		
		BUTTON_CHECK: null,
		BUTTON_TIME: null,
		BUTTON_REMINDER: null,
		BUTTON_REPEAT: null,
		BUTTON_TODO: null,
		BUTTON_COLOR: null,
		BUTTON_WALL: null
	  
	});

/***/ },
/* 5 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var NewNoteActions = __webpack_require__(1);
	var ValidationService = __webpack_require__(19);

	var NoteText = React.createClass({displayName: 'NoteText',
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
				AutoTextarea({
					ref: "autoTextArea", 
					id: "new-note-input", 
					placeholder: "Note text..", 
					onBlur: this.updateText, 
					onChange: this._onChange, 
					value: this.state.value, 
					className: classes})
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


/***/ },
/* 6 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var OptionButton = __webpack_require__(16);
	var Icon = FontAwesome.Icon;
	var NewNoteConstants = __webpack_require__(4);
	var NewNoteActions = __webpack_require__(1);
	var ActionButton = __webpack_require__(17);

	var OptionButtons = React.createClass({displayName: 'OptionButtons',
		render: function(){
			var restoreClasses = React.addons.classSet({
			    'hide': !this.props.hasDeletedNote,
			    'visible': this.props.hasDeletedNote
			  });
			var restoreCurrentClasses = React.addons.classSet({
				'hide': !this.props.note.isDeleted || !this.props.note.noteId,
				'visible': this.props.note.isDeleted && this.props.note.noteId
			});
			var deleteClasses = React.addons.classSet({
				'hide': !this.props.note.noteId || this.props.note.isDeleted,
				'visible': this.props.note.noteId && !this.props.note.isDeleted
			});
			
			return (
				React.DOM.ul({className: "note-buttons"}, 
					React.DOM.li(null, ActionButton({icon: "save", style: "save", action: NewNoteActions.saveNote, msg: "Save note"})), 
					
					React.DOM.li(null, OptionButton({icon: "check", btnType: NewNoteConstants.BUTTON_CHECK, isToggle: this.props.note.hasCheck, msg: "Set this note as a check task"})), 
					React.DOM.li(null, OptionButton({icon: "clock-o", btnType: NewNoteConstants.BUTTON_TIME, isToggle: this.props.note.hasTime, msg: "Event time"})), 
					React.DOM.li(null, OptionButton({icon: "bell-o", btnType: NewNoteConstants.BUTTON_REMINDER, isToggle: this.props.note.hasReminder, msg: "Email reminder"})), 
					React.DOM.li(null, OptionButton({icon: "repeat", btnType: NewNoteConstants.BUTTON_REPEAT, isToggle: this.props.note.hasRepeat, msg: "Periodically repeating"})), 
					React.DOM.li(null, OptionButton({icon: "check-square-o", btnType: NewNoteConstants.BUTTON_TODO, isToggle: this.props.note.hasTodo, msg: "Every ENTER in note text creates one task"})), 
					React.DOM.li(null, OptionButton({icon: "paint-brush", btnType: NewNoteConstants.BUTTON_COLOR, isToggle: this.props.note.hasColor, msg: "Color switch"})), 
					React.DOM.li(null, OptionButton({icon: "th", btnType: NewNoteConstants.BUTTON_WALL, isToggle: this.props.note.hasWall, msg: "Show on the wall"})), 
					
					React.DOM.li(null, ActionButton({icon: "eraser", style: "clear", action: NewNoteActions.clearNote, msg: "New blank note"})), 
					React.DOM.li({className: deleteClasses}, ActionButton({icon: "close", style: "delete", action: NewNoteActions.deleteNote, msg: "Remove note"})), 
					React.DOM.li({className: restoreCurrentClasses}, ActionButton({icon: "undo", style: "restore", action: NewNoteActions.restoreCurrentNote, msg: "Restore this specific note"})), 
					React.DOM.li({className: restoreClasses}, ActionButton({icon: "history", style: "restore", action: NewNoteActions.restoreNote, msg: "Restore previously deleted note"}))
				)

			);		
		}
		
	});

	module.exports = OptionButtons;


/***/ },
/* 7 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var NewNoteActions = __webpack_require__(1);
	var ValidationService = __webpack_require__(19);

	var TimeBlock = React.createClass({displayName: 'TimeBlock',
		 getInitialState: function() {
		    return {
		      value: this.props.note.eventTime
		    };
		},
		componentWillReceiveProps: function(nextProps){
	      this.setState({
	    	  value: nextProps.note.eventTime
	      });
		},
		 _onDateChange: function(e) {
			 this.setState({
				 value: e.target.value
			 });
		 },
		componentDidMount: function(){
			var eventDateTimePicker = jQuery('#eventDateTimePicker');
			eventDateTimePicker.datetimepicker();
			eventDateTimePicker.on("dp.show", function(e){
				 jQuery("#eventDateTimeInput").focus();
			});
		},
		
		render: function() {
			  var classes = React.addons.classSet({
			    'invisible': !this.props.note.hasTime,
			    'visible': this.props.note.hasTime,
				'control-group': true,
				'error': ValidationService.hasFieldError('eventTime')
			  });
			
		    return (
		      React.DOM.div({className: classes}, 
		      	  React.DOM.label({htmlFor: "eventDateTimeInput"}, "Event date"), 
		      	  
			      React.DOM.div({className: "form-group"}, 
			          React.DOM.div({className: "input-append", id: "eventDateTimePicker"}, 
			              React.DOM.input({type: "text", className: "form-control", id: "eventDateTimeInput", 'data-date-format': GlobalConstants.DATETIME_FORMAT, 
			            	  onBlur: this.eventTimeChange, 
				              value: this.state.value, 
			                  onChange: this._onDateChange}), 
			              React.DOM.button({type: "submit", className: "btn btn-primary"}, 
			              	React.DOM.span({className: "fa fa-clock-o"})		
						  )
			          )
		          )
		          
		      )
		    );
		 },
		 
		eventTimeChange: function(e){
			var time = e.target.value;
			NewNoteActions.eventTimeChange(time);
		}
		
	});

	module.exports = TimeBlock;


/***/ },
/* 8 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var NewNoteActions = __webpack_require__(1);
	var ValidationService = __webpack_require__(19);

	var ReminderBlock = React.createClass({displayName: 'ReminderBlock',
		 getInitialState: function() {
		    return {
		    	dateValue: this.props.note.remindInfo.remindDate
		    };
		},
		 _onDateChange: function(e) {
			 this.setState({
				 dateValue: e.target.value
			 });
		 },
		componentWillReceiveProps: function(nextProps){
	      this.setState({
	    	  dateValue: nextProps.note.remindInfo.remindDate
	      });
		},
		
		componentDidMount: function(){
			var reminderDatePicker = jQuery('#reminderDateTimePicker');
			reminderDatePicker.datetimepicker();
			reminderDatePicker.on("dp.show", function(e){
				 jQuery("#reminderDateTimeInput").focus();
			});
			
		},
		
		render: function() {
			  var classes = React.addons.classSet({
			    'invisible': !this.props.note.hasReminder,
			    'visible': this.props.note.hasReminder,
				'control-group': true,
				'error': ValidationService.hasFieldError('remindDate')
			  });
			
		    return (
		      React.DOM.div({className: classes}, 
		      	  React.DOM.label({htmlFor: "reminderDateTimeInput"}, "Remind date"), 
		      	  
			      React.DOM.div({className: "form-group"}, 
			          React.DOM.div({className: "input-append", id: "reminderDateTimePicker"}, 
			              React.DOM.input({type: "text", className: "form-control", id: "reminderDateTimeInput", 'data-date-format': GlobalConstants.DATETIME_FORMAT, 
			            	  onBlur: this.remindTimeChange, 
			              	  value: this.state.dateValue, 
			                  onChange: this._onDateChange}
			              	  ), 
			              React.DOM.button({type: "submit", className: "btn btn-primary", onClick: this.clickDateButton}, 
			              	React.DOM.span({className: "fa fa-bell-o"})		
						  )
			          )
		          )
		          
		      )
		    );
		 },
		 
		 remindTimeChange: function(e){
			var time = e.target.value;
			NewNoteActions.remindTimeChange(time);
		}
		
		
	});

	module.exports = ReminderBlock;

/***/ },
/* 9 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var NewNoteActions = __webpack_require__(1);
	var ValidationService = __webpack_require__(19);

	var ReminderSubjectBlock = React.createClass({displayName: 'ReminderSubjectBlock',
		 getInitialState: function() {
		    return {
		    	remindSubject: this.props.note.remindInfo.remindSubject
		    };
		},
		 _onSubjectChange: function(e) {
			 this.setState({
				 remindSubject: e.target.value
			 });
		 },
		componentWillReceiveProps: function(nextProps){
	      this.setState({
	    	  remindSubject: nextProps.note.remindInfo.remindSubject
	      });
		},
		
		
		render: function() {
			  var classes = React.addons.classSet({
			    'invisible': !this.props.note.hasReminder,
			    'visible': this.props.note.hasReminder,
				'control-group': true
			  });
			
		    return (
		      React.DOM.div({className: classes}, 
		          React.DOM.label({htmlFor: "reminderSubjectInput"}, "Email subject"), 
		          
		          React.DOM.div({className: "form-group"}, 
			          React.DOM.div({className: "input-append"}, 
			              React.DOM.input({type: "text", className: "form-control", id: "reminderSubjectInput", 
			            	  onBlur: this.remindSubjectChange, 
			              	  onChange: this._onSubjectChange, 
			              	  value: this.state.remindSubject}), 
			              React.DOM.button({type: "submit", className: "btn btn-primary", onClick: this.clickSubjectButton}, 
			              	React.DOM.span({className: "fa fa-pencil"})		
						  )
			          )
		          )
		          
		      )
		    );
		 },
		 
		remindSubjectChange: function(e){
			 var subject = e.target.value;
			 NewNoteActions.remindSubjectChange(subject);
		 },
		 
		 clickSubjectButton: function(){
			 jQuery("#reminderSubjectInput").focus();
		 }
		
	});

	module.exports = ReminderSubjectBlock;

/***/ },
/* 10 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var NewNoteActions = __webpack_require__(1);

	var RepeatBlock = React.createClass({displayName: 'RepeatBlock',
		getInitialState: function(){
			return {
				periods: [],
				value: this.props.note.period
			};
		},
		
		componentWillReceiveProps: function(nextProps){
			if(typeof this.props.periods !== 'undefined' && this.props.periods.length > 0){
	          this.setState({
	        	 periods: nextProps.periods,
	        	 value: nextProps.note.period
	          });
			}
		},
		
		_onChange: function(e) {
		    this.setState({
		      value: e.target.value
		    });
		 },
		
		render: function() {
			  var classes = React.addons.classSet({
			    'invisible': !this.props.note.hasRepeat,
			    'visible': this.props.note.hasRepeat
			  });
			
		    return (
		      React.DOM.div({className: classes}, 
		      	  React.DOM.label({htmlFor: "repeatSelect", onClick: this.showOptions}, "Repeat period"), 
		      	  
			      React.DOM.div({className: "form-group"}, 
			          React.DOM.div({className: "input-append"}, 
			              React.DOM.select({type: "text", className: "form-control", id: "repeatSelect", 
			            	  onBlur: this.repeatPeriodChange, 
				              onChange: this._onChange, 
			              	  value: this.state.value}, 
			              	this.state.periods.map(function(item, index){
			              		return (React.DOM.option({key: index, value: item.name}, item.title))
			              	})
			              ), 
			              React.DOM.button({type: "submit", className: "btn btn-primary nocursor", onClick: this.showOptions}, 
			              	React.DOM.span({className: "fa fa-repeat"})		
			              )
			          )
		          )
		          
		      )
		    );
		 },

		 showOptions: function(){
			 jQuery('#repeatSelect').show().focus().click();
			 jQuery("#repeatSelect").prop('size', this.state.periods.length);
		 },
		
		repeatPeriodChange: function(e){
			jQuery("#repeatSelect").prop('size', 1);
			var period = e.target.value;
			NewNoteActions.repeatPeriodChange(period);
		}
	});

	module.exports = RepeatBlock;

/***/ },
/* 11 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var CollorPalette = __webpack_require__(18);
	var Popover = ReactBootstrap.Popover;
	var OverlayTrigger = ReactBootstrap.OverlayTrigger;
	var Tooltip = ReactBootstrap.Tooltip;
	var NewNoteActions = __webpack_require__(1);


	var ColorBlock = React.createClass({displayName: 'ColorBlock',
		getInitialState: function(){
			return {
				colors: []
			};
		},
		
		componentWillReceiveProps: function(nextProps){
			if(typeof this.props.colors != 'undefined' && this.props.colors.length > 0){
	          this.setState({
	        	  colors: nextProps.colors
	          });
			}
		},
		
		render: function() {
			  var classes = React.addons.classSet({
				'white-popover': true,
			    'invisible': !this.props.note.hasColor,
			    'visible': this.props.note.hasColor
			  });
			
			  var overlay = Popover(null, CollorPalette({selectColor: this.selectColor, colors: this.state.colors}));
	 		   
			  
		    return (
		      React.DOM.div({className: classes}, 
		      React.DOM.label({htmlFor: "noteColorSelect"}, "Note color"), 
		      	  
			      React.DOM.div({className: "form-group"}, 
			          React.DOM.div({className: "input-append"}, 
			              React.DOM.input({type: "text", className: "form-control", id: "note-color-select", value: "Sample text..", readOnly: true, style: {backgroundColor: this.props.note.color.colorWithHash}}), 
			              OverlayTrigger({trigger: "focus", placement: "bottom", 
			            	  overlay: overlay}, 
				              React.DOM.button({type: "submit", className: "btn btn-primary", id: "color-selector"}, 
				              	React.DOM.span({className: "fa fa-paint-brush"})		
							  )
			              )
			          )
		          )
		          
		      )
		    );
		 }, 
		 
		 selectColor: function(e){
			 var color = {
				 name: e.target.attributes["data-color-name"].value,
				 colorWithHash: e.target.attributes["data-color-id"].value
			};
			 NewNoteActions.colorChange(color);
		 }
		 
		
	});


	module.exports = ColorBlock;

/***/ },
/* 12 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var NewNoteActions = __webpack_require__(1);
	var ValidationService = __webpack_require__(19);

	var IsdoneBlock = React.createClass({displayName: 'IsdoneBlock',
		
		render: function() {
			  var classes = React.addons.classSet({
			    'invisible': !this.props.note.hasCheck,
			    'visible': this.props.note.hasCheck
			  });
			  var classesInput = React.addons.classSet({
				  'form-control': true,
				  'isdone-checked': this.props.note.isDone,
				  'isdone-unchecked': !this.props.note.isDone
			  });
			
			  
		    return (
		      React.DOM.div({className: classes}, 
		      	  React.DOM.label({htmlFor: "isdone-input"}, "Is task finished"), 
		      	  
			      React.DOM.div({className: "form-group"}, 
			          React.DOM.div({className: "input-append"}, 
			              React.DOM.input({type: "text", className: classesInput, id: "isdone-input", 
				              value: this.props.note.isDone?'Task is finished! :-)':'Not done yet :-(', 
			              	  onClick: this.onClick, 
			              	  readOnly: "true"}), 
			              React.DOM.button({type: "submit", className: "btn btn-primary", onClick: this.onClick}, 
			              	React.DOM.span({className: "fa fa-check"})		
						  )
			          )
		          )
		          
		      )
		    );
		 },
		 
		onClick: function(){
			NewNoteActions.checkNote();
		}
		
	});

	module.exports = IsdoneBlock;


/***/ },
/* 13 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var Icon = FontAwesome.Icon;
	var NewNoteActions = __webpack_require__(1);
	var ValidationService = __webpack_require__(19);

	var ValidationMessage = React.createClass({displayName: 'ValidationMessage',
		
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
				React.DOM.div({className: classes}, 
					React.DOM.div({className: "nn-message-dismiss", onClick: this.dismissMessage}, Icon({type: "close"})), 
					React.DOM.div(null, 
						React.DOM.ul(null, 
						
							messages.map(function(msg, i){
								return (React.DOM.li({key: i}, msg));
						})
						)
					)
				)
			);		
		},
		dismissMessage: function(){
			ValidationService.clearResult();
			this.setState({});
		}
		

		
	});

	module.exports = ValidationMessage;

/***/ },
/* 14 */
/***/ function(module, exports, __webpack_require__) {

	var AppDispatcher = __webpack_require__(3);
	var EventEmitter = Events.EventEmitter;
	var NewNoteConstants = __webpack_require__(4);
	var UtilService = __webpack_require__(20);
	var ValidationService = __webpack_require__(19);

	var _note = getEmptyNote();

	var _colors = {};
	var _periods = {};
	var _codelist = {};
	var _urls = {};
	var _deletedNote = {};
	var _infoMessage = '';

	function getEmptyNote(){
		return {
			text: '',
			
			hasCheck: false,
			hasTime: false,
			hasReminder: false,
			hasRepeat: false,
			hasTodo: false,
			hasColor: false,
			hasWall: typeof jQuery('#p_p_id_savednoteportlet_WAR_savednoteportlet_')[0]  != 'undefined',
			
			isDone: false,
			period: 'YEARLY',
			eventTime: '',
			color: UtilService.getRandomColor(_colors),
			remindInfo:{
				remindDate: '',
				remindSubject: ''
			},
			gridItem:{}
		}
	}

	function getEmptyGridItem(){
		return {
			w:2,
			h:1,
			x:1,
			y:1
		}
	}

	function toggleOption(btnType){
		
		switch(btnType){
		case NewNoteConstants.BUTTON_CHECK:
			 _note.hasCheck = !_note.hasCheck;
			 break;
		case NewNoteConstants.BUTTON_TIME:
			_note.hasTime = !_note.hasTime;
			break;
		case NewNoteConstants.BUTTON_REMINDER:
			_note.hasReminder = !_note.hasReminder;
			break;
		case NewNoteConstants.BUTTON_REPEAT:
			_note.hasRepeat = !_note.hasRepeat;
			break;
		case NewNoteConstants.BUTTON_TODO:
			_note.hasTodo = !_note.hasTodo;
			break;
		case NewNoteConstants.BUTTON_COLOR:
			_note.hasColor = !_note.hasColor;
			break;
		case NewNoteConstants.BUTTON_WALL:
			_note.hasWall = !_note.hasWall;
			break;
		default:
			return;
		}
		
	};


	function saveNote(){
		ValidationService.validateNote(_note);
		
		if(ValidationService.hasError()){
			console.log("Cannot save this note, it contains errors: "+ValidationService.getMessages());
			return;
		}
		Spinner.start();
		console.log("Starting saving note..")
		jQuery.ajax({
			type: "POST",
			dataType : 'json',
			async: false,
			url: _urls['saveNote'],
			data: {jsonNote: JSON.stringify(_note)},
			success :function(result) {
				console.log("Ajax success!! Note saving")
				_note = getEmptyNote();
				_infoMessage = 'Note has been successfully saved.';
				
				refreshPortletsOnPage();
				setTimeout(function(){
					_infoMessage = '';
					NewNoteStore.emitChange();
				}, 3000);
				NewNoteStore.emitChange();
				return result.payload;
			},
			complete: function(){
				Spinner.stop();
			}
		});

	}

	function deleteNote(){
		if(_note.noteId){
			console.log("Starting deleting note..")
			jQuery.ajax({
				type: "POST",
				dataType : 'json',
				async: false,
				url: _urls['deleteNote'],
				data: {jsonNote: JSON.stringify(_note)},
				success :function(result) {
					console.log("Note has been deleted.");
					
					refreshPortletsOnPage();
		
					NewNoteStore.emitChange();
					return result.payload;
				}
			});
		}
		_note = getEmptyNote();
	}
	function editNote(note){
		_note = note;
		ValidationService.clearResult();
		_note.period = note.period || 'YEARLY';
		_note.remindInfo = note.remindInfo || {};
		_note.eventTime = note.eventTime || '';
	}
	function refreshPortletsOnPage(){
		Liferay.Portlet.refresh('#p_p_id_savednoteportlet_WAR_savednoteportlet_');
		Liferay.Portlet.refresh('#p_p_id_upcomingportlet_WAR_upcomingportlet_');
		Liferay.Portlet.refresh('#p_p_id_calendarportlet_WAR_calendarportlet_');
		Liferay.Portlet.refresh('#p_p_id_filterportlet_WAR_filterportlet_');
	}

	function restoreNote(){
		_note = _deletedNote;
		saveNote();
		_deletedNote = {};
	}
	function restoreCurrentNote(){
		if(_deletedNote.noteId === _note.noteId){
			_deletedNote = {};
		}
		
		saveNote();
	}


	//FUNCTIONS
	var NewNoteStore = merge(EventEmitter.prototype, {
		
		getPeriods: function(){
			return _periods;
		},
		getColors: function(){
			return _colors;
		},
		getNote: function() {
			return _note;
		},
		getHasDeletedNote: function(){
			return !jQuery.isEmptyObject(_deletedNote);
		},
		getInfoMessage: function(){
			return _infoMessage;
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

	// Register to handle all updates
	AppDispatcher.register(function(payload) {
		var action = payload.action;

		switch(action.actionType) {
		case NewNoteConstants.TOGGLE_OPTION:
			toggleOption(action.btnType);
			break;
		case NewNoteConstants.REGISTER_COLORS:
			_colors = action.colors;
			break;
		case NewNoteConstants.REGISTER_URLS:
			_urls = action.urls;
			break;
		case NewNoteConstants.REGISTER_PERIODS:
			_periods = action.periods;
			break;
		case NewNoteConstants.SAVE_NOTE: 
			saveNote();
			break;
		case NewNoteConstants.TEXT_CHANGE:
			_note.text = action.text;
			break;
		case NewNoteConstants.EVENT_TIME_CHANGE:
			_note.eventTime = action.time;
			break;
		case NewNoteConstants.REMIND_TIME_CHANGE:
			_note.remindInfo.remindDate = action.time;
			break;
		case NewNoteConstants.REMIND_SUBJECT_CHANGE:
			_note.remindInfo.remindSubject = action.subject;
			break;
		case NewNoteConstants.COLOR_CHANGE:
			_note.color = action.color;
			break;
		case NewNoteConstants.PERIOD_CHANGE:
			_note.period = action.period;
			break;
		case NewNoteConstants.EDIT_NOTE:
			editNote(action.note);
			break;
		case NewNoteConstants.DELETE_NOTE:
			_deletedNote = jQuery.extend(true, {}, _note);
			deleteNote();
			break;
		case NewNoteConstants.CLEAR_NOTE:
			_note = getEmptyNote();
			break;
		case NewNoteConstants.CHECK_NOTE:
			_note.isDone = !_note.isDone;
			break;
		case NewNoteConstants.RESTORE_NOTE:
			restoreNote();
			break;
		case NewNoteConstants.RESTORE_CURRENT_NOTE:
			restoreCurrentNote();
			break;
		case NewNoteConstants.CLEAR_INFO_MSG:
			_infoMessage = '';
			break;
			
			
		default:
			return true;
		}

		// This often goes in each case that should trigger a UI change. This store
		// needs to trigger a UI change after every view action, so we can make the
		// code less repetitive by putting it here.  We need the default case,
		// however, to make sure this only gets called after one of the cases above.
		NewNoteStore.emitChange();

		return true; // No errors.  Needed by promise in Dispatcher.
	});

	module.exports = NewNoteStore;

/***/ },
/* 15 */
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

/***/ },
/* 16 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var Icon = FontAwesome.Icon;
	var NewNoteActions = __webpack_require__(1);
	var OverlayTrigger = ReactBootstrap.OverlayTrigger;
	var Tooltip = ReactBootstrap.Tooltip;

	var OptionButton = React.createClass({displayName: 'OptionButton',
		
		render: function(){
			var classes = React.addons.classSet({
				'active': this.props.isToggle,
				'hover-transition': true,
				'pointer-cursor': true
			});
		
			
			return (
				OverlayTrigger({placement: "top", delayShow: 300, overlay: Tooltip(null, this.props.msg)}, 
					Icon({type: this.props.icon, className: classes, onClick: this.toggleOptionButton})
				)
				
			);		
		},
		toggleOptionButton: function(){
			NewNoteActions.toggleOption(this.props.btnType);
		}

		
	});

	module.exports = OptionButton;


/***/ },
/* 17 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var Icon = FontAwesome.Icon;
	var OverlayTrigger = ReactBootstrap.OverlayTrigger;
	var Tooltip = ReactBootstrap.Tooltip;

	var ActionButton = React.createClass({displayName: 'ActionButton',
		
		render: function(){
			var btnClass = this.props.style + '-btn';
			var classesObject = {
					'hover-transition': true,
					'pointer-cursor': true
			};
			classesObject[btnClass] = true;
			
			var classes = React.addons.classSet(classesObject);
			return (
				OverlayTrigger({placement: "top", delayShow: 300, overlay: Tooltip(null, this.props.msg)}, 
					Icon({type: this.props.icon, className: classes, onClick: this.props.action})
				)
			);		
		}

		
	});

	module.exports = ActionButton;

/***/ },
/* 18 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */

	var ColorPalette = React.createClass({displayName: 'ColorPalette',
		
		 render: function(){
			 var colors = this.props.colors;
			 var colCount = 6;
			 var rows = [];
			 
			 for(var row = 0; row < (colors.length/colCount); row++){
				var columns = [];
				for(var col = 0; col < colCount && (row*colCount + col) < colors.length; col++){
					var color = colors[row*colCount + col];
					columns.push(React.DOM.td({key: col}, React.DOM.div({className: "hover-transition color-square", style: {backgroundColor: color.colorWithHash}, 'data-color-id': color.colorWithHash, 'data-color-name': color.name, onMouseOver: this.props.selectColor})));
				}
				rows.push(React.DOM.tr({key: row}, columns));
			 }
			 
			 return (
					 React.DOM.table({className: "color-palette"}, 
					 	rows
					 )
					);
		 }
		
	});

	module.exports = ColorPalette;

/***/ },
/* 19 */
/***/ function(module, exports, __webpack_require__) {

	var ValidationService = {
		result: {},
		validateNote: function(note){
			this.result = {};
			
			if(note.text.trim().length<1){
				this.addMsg('noteText', 'Note text is empty, you have to write something.');
			}
			if(note.text.length > 2000){
				this.addMsg('noteText', 'Text is too long.');
			}
			if(note.hasTime){
				if(note.eventTime.trim().length<1){
					this.addMsg('eventTime', "Event date is empty. If you don't want to use it, disable it.");
				}else{
					var m = moment(note.eventTime, GlobalConstants.DATETIME_FORMAT, true);
					if(!m.isValid()){
						this.addMsg('eventTime', "Bad date format. Example 24/12/2014 22:30");
					}
				}
			}
			
			if(note.hasReminder){
				if(!note.remindInfo || !note.remindInfo.remindDate || note.remindInfo.remindDate.trim().length<1){
					this.addMsg('remindDate', "Remind date is empty. If you don't want to use it, disable it.");
				}else{
					var m = moment(note.remindInfo.remindDate, GlobalConstants.DATETIME_FORMAT, true);
					if(!m.isValid()){
						this.addMsg('remindDate', "Bad date format. Example 24/12/2014 22:30");
					}
				}
			}
			
			return this.result;
		},
		addMsg: function(fieldId, msg){
			if(typeof this.result[fieldId] === 'undefined'){
				this.result[fieldId] = {};
			}
			if(typeof this.result[fieldId].msg === 'undefined'){
				this.result[fieldId].msg = [];
			}
			this.result[fieldId].msg.push(msg);
		},
		hasError: function(){
			return !jQuery.isEmptyObject(this.result);
		},
		hasFieldError: function(fieldId){
			return typeof this.result[fieldId] !== 'undefined' && !jQuery.isEmptyObject(this.result[fieldId]);
		},
		getStringMessage: function(){
			if(!this.hasError()){
				return '';
			}
			var message = '';
			for (id in this.result) {
				if(this.result[id].msg){
					message += ' '+ this.result[id].msg.join();
				}
			}
			return message;
		},
		getMessages: function(){
			if(!this.hasError()){
				return [];
			}
			var messages = [];
			for (id in this.result) {
				if(this.result[id].msg){
					messages = messages.concat(this.result[id].msg);
				}
			}
			return messages;
		},
		clearResult: function(){
			this.result = {};
		},
	}
	module.exports = ValidationService;

/***/ },
/* 20 */
/***/ function(module, exports, __webpack_require__) {

	var UtilService = {
		getRandomColor: function(colors){
			var color = {
					name: 'BLUE_NAVY',
					colorWithHash: '#185287'
			};
			
			if(typeof colors != 'undefined'){
				var randomIndex = this.randomIntFromInterval(0, colors.length - 1);
				color.name = colors[randomIndex].name;
				color.colorWithHash = colors[randomIndex].colorWithHash;
			}
			return color;
		},
		
		randomIntFromInterval: function(min,max){
		    return Math.floor(Math.random()*(max-min+1)+min);
		}
	}
	module.exports = UtilService;

/***/ }
/******/ ])