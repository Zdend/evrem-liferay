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
	var UpcomingStore = __webpack_require__(1);
	var UpcomingActions = __webpack_require__(2);
	var UpcomingContainer = __webpack_require__(3);

	Liferay.Portlet.ready(
	    function(portletId, node) {
	    	if(portletId.indexOf('upcomingportlet_WAR_upcomingportlet') !== -1){
	    		var initialData = JSON.parse(jQuery('#data-upcoming').text());
	    		UpcomingActions.registerUrls(initialData.urls);
	    		UpcomingActions.registerNotes(initialData.notes);
	    		
	    		React.renderComponent(UpcomingContainer(null), document.querySelector('#upcoming-container'));
	    	}
	    	
	    }
	);




/***/ },
/* 1 */
/***/ function(module, exports, __webpack_require__) {

	var AppDispatcher = __webpack_require__(4);
	var EventEmitter = Events.EventEmitter;
	var UpcomingConstants = __webpack_require__(5);
	var UtilService = __webpack_require__(6);

	var _todayNotes = {};
	var _futureNotes = {};
	var _pastNotes = {};
	var _allNotes = {};

	var _eventsCount = 10;

	var _urls = {};


	function registerNotes(notes){
		_allNotes = notes;
		
		var todayNotesUnsorted = UtilService.getNotesBetween(notes, moment().startOf('day'), moment().endOf('day'));
		_todayNotes = UtilService.sortNotesByDate(todayNotesUnsorted, true);
		
		var futureNotesUnsorted = UtilService.getNotesBetween(notes, moment().startOf('day').add(1, 'd'), null);
		_futureNotes = UtilService.sortNotesByDate(futureNotesUnsorted, true);
		
		var pastNotesUnsorted = UtilService.getNotesBetween(notes, null, moment().endOf('day').subtract(1, 'd'));
		_pastNotes = UtilService.sortNotesByDate(pastNotesUnsorted, false);
		
	}

	function getNote(noteId){
		var i;
		for(i = 0; i < _allNotes.length; i++){
			if(_allNotes[i].noteId === noteId){
				return _allNotes[i];
			}
		}
	}

	function getTodoNote(noteId, todoNoteId){
		var note = getNote(noteId);
		var i;
		for(i = 0; i < note.todos.length; i++){
			if(note.todos[i].todoNoteId === todoNoteId){
				return note.todos[i];
			}
		}
	}

	function editNote(noteId){
	    Liferay.fire(
	            'editNoteEvent', {
	            note: getNote(noteId)
	        }
	    );
	}

	function checkNote(noteId){
		jQuery.ajax({
			type: 'POST',
			dataType : 'json',
			url: _urls['checkNote'],
			data: {noteId: noteId},
			success :function(result) {
				var note = getNote(noteId);
				note.isDone = !note.isDone;
				UpcomingStore.emitChange();
				return result.payload;
			}
		});
	}

	function checkTodoNote(noteId, todoNoteId){
		jQuery.ajax({
			type: 'POST',
			dataType : 'json',
			url: _urls['checkTodoNote'],
			data: {noteId: noteId, todoNoteId: todoNoteId},
			success: function(result) {
				var todoNote = getTodoNote(noteId, todoNoteId);
				todoNote.isTodoDone = !todoNote.isTodoDone;
				UpcomingStore.emitChange();
				return result.payload;
			}
		});
	}

	function moreEvents(){
		var mostNotes = UtilService.getMaximumEventsCount(_todayNotes, _futureNotes, _pastNotes);
		if(_eventsCount + 10 > mostNotes){
			_eventsCount = mostNotes;
		}else{
			_eventsCount += 10;
		}
	}

	//FUNCTIONS
	var UpcomingStore = merge(EventEmitter.prototype, {
		
		getTodayNotes: function() {
			return UtilService.getEventsSlicedByCount(_todayNotes, _eventsCount);
		},
		getFutureNotes: function() {
			return UtilService.getEventsSlicedByCount(_futureNotes, _eventsCount);
		},
		getPastNotes: function() {
			return UtilService.getEventsSlicedByCount(_pastNotes, _eventsCount);
		},
		getAreAllNotesVisible: function(){
			return _eventsCount >= UtilService.getMaximumEventsCount(_todayNotes, _futureNotes, _pastNotes);
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
		case UpcomingConstants.REGISTER_NOTES:
			registerNotes(action.notes);
			break;
		case UpcomingConstants.REGISTER_URLS:
			_urls = action.urls;
			return true;
		case UpcomingConstants.EDIT_NOTE:
			editNote(action.noteId);
			return true;
		case UpcomingConstants.CHECK_NOTE:
			checkNote(action.noteId);
			return true;
		case UpcomingConstants.CHECK_TODONOTE:
			checkTodoNote(action.noteId, action.todoNoteId);
			return true;
		case UpcomingConstants.MORE_EVENTS:
			moreEvents();
			break;
			
			
		default:
			return true;
		}

		UpcomingStore.emitChange();

		return true;
	});

	module.exports = UpcomingStore;

/***/ },
/* 2 */
/***/ function(module, exports, __webpack_require__) {

	var AppDispatcher = __webpack_require__(4);
	var UpcomingConstants = __webpack_require__(5);

	var UpcomingActions = {

	  registerNotes: function(notes) {
		    AppDispatcher.handleViewAction({
		      actionType: UpcomingConstants.REGISTER_NOTES,
		      notes: notes
		    });
	  },
	  registerUrls: function(urls) {
		  AppDispatcher.handleViewAction({
			  actionType: UpcomingConstants.REGISTER_URLS,
			  urls: urls
		  });
	  },
	  editNote: function(noteId) {
		  AppDispatcher.handleViewAction({
			  actionType: UpcomingConstants.EDIT_NOTE,
			  noteId: noteId
		  });
	  },
	  checkNote: function(noteId) {
		  AppDispatcher.handleServerAction({
			  actionType: UpcomingConstants.CHECK_NOTE,
			  noteId: noteId
		  });
	  },
	  checkTodoNote: function(noteId, todoNoteId) {
		  AppDispatcher.handleServerAction({
			  actionType: UpcomingConstants.CHECK_TODONOTE,
			  noteId: noteId,
			  todoNoteId: todoNoteId
		  });
	  },
	  moreEvents: function() {
		  AppDispatcher.handleViewAction({
			  actionType: UpcomingConstants.MORE_EVENTS
		  });
	  }


	 

	};

	module.exports = UpcomingActions;

/***/ },
/* 3 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var UpcomingStore = __webpack_require__(1);
	var UpcomingActions = __webpack_require__(2);
	var UpcomingConstants = __webpack_require__(5);
	var TermBlock = __webpack_require__(7);
	var Button = ReactBootstrap.Button;

	function getNotesState() {
		  return {
		    today: UpcomingStore.getTodayNotes(),
		    future: UpcomingStore.getFutureNotes(),
		    past: UpcomingStore.getPastNotes(),
		    allNotesVisible: UpcomingStore.getAreAllNotesVisible()
		  };
	}

	var UpcomingContainer = React.createClass({displayName: 'UpcomingContainer',
		getInitialState: function() {
		  return getNotesState();
		},
		componentDidMount: function() {
			UpcomingStore.addChangeListener(this._onChange);
		},
		componentWillUnmount: function() {
			UpcomingStore.removeChangeListener(this._onChange);
		},
		render: function(){
			return (
				React.DOM.div(null, 
					React.DOM.ul({className: "uc-termblocks-list"}, 
					React.DOM.li(null, TermBlock({notes: this.state.past, title: "Past", type: UpcomingConstants.PAST})), 
						React.DOM.li(null, TermBlock({notes: this.state.today, title: "Today", type: UpcomingConstants.TODAY})), 
						React.DOM.li(null, TermBlock({notes: this.state.future, title: "Future", type: UpcomingConstants.FUTURE}))
					), 
					Button({bsStyle: "primary", className: "uc-more-btn", onClick: this.moreEventClick, disabled: this.state.allNotesVisible}, "More events..")
				)
					
			);
		},
		_onChange: function() {
			this.setState(getNotesState());
		},
		moreEventClick: function(){
			UpcomingActions.moreEvents();
		}
	});

	module.exports = UpcomingContainer;


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

		REGISTER_NOTES: null,
		REGISTER_URLS: null,
		EDIT_NOTE: null,
		CHECK_NOTE: null,
		MORE_EVENTS: null,
		CHECK_TODONOTE: null,
		
		TODAY: null,
		FUTURE: null,
		PAST: null
		
		
		
	});

/***/ },
/* 6 */
/***/ function(module, exports, __webpack_require__) {

	var UtilService = {

			sortNotesByDate: function(notes, isAscending){
				var i;
				
				notes.sort(function(a,b){
					var aEventTime = moment(a.eventTime, GlobalConstants.DATETIME_FORMAT, true);
					var bEventTime = moment(b.eventTime, GlobalConstants.DATETIME_FORMAT, true);
					if(isAscending){
						return aEventTime.isAfter(bEventTime);
					}else{
						return aEventTime.isBefore(bEventTime);
					}
				});

				return notes;
			},
			getNotesBetween: function(notes, from, to){
				var i;
				var resultNotes = [];
				for(i = 0; i < notes.length; i++){
					var m = moment(notes[i].eventTime, GlobalConstants.DATETIME_FORMAT, true);
					var isAfter = false;
					if(m.isAfter(from) || m.isSame(from) || from === null){
						isAfter = true;
					}
					
					var isBefore = false;
					if(m.isBefore(to) || m.isSame(to) || to === null){
						isBefore = true;
					}
					
					if(isAfter && isBefore){
						resultNotes.push(notes[i]);
					}
					
				}
				
				return resultNotes;
			},
			
			getMaximumEventsCount: function(todayNotes, pastNotes, futureNotes){
				var mostNotes = this.getEventsCount(futureNotes);
				
				if(this.getEventsCount(todayNotes) > mostNotes){
					mostNotes = this.getEventsCount(todayNotes);
				}
				if(this.getEventsCount(pastNotes) > mostNotes){
					mostNotes = this.getEventsCount(pastNotes);
				}
				return mostNotes;
			},
			
			getEventsCount: function(notes){
				var eventsCount = 0;
				var i;
				for(i=0; i < notes.length; i++){
					if(notes[i].hasTodo){
						eventsCount += notes[i].todos.length;
					}else{
						eventsCount += 1;
					}
				}
				return eventsCount;
			},
			
			getEventsSlicedByCount: function(notes, count){
				var newNotes = jQuery.extend(true, [], notes);
				var resultArray = [];
				var eventsCount = 0;
				var i;
				for(i=0; i < newNotes.length && eventsCount < count; i++){
					var noteEventsCount = this.getEventsCount([newNotes[i]]);
					if(noteEventsCount <= count){
						resultArray.push(newNotes[i]);
						eventsCount += noteEventsCount;
					}else{
						if(newNotes[i].hasTodo){
							var residueCount = count - eventsCount;
							var todos = newNotes[i].todos.slice(0, residueCount);
							newNotes[i].todos = todos;
							eventsCount += residueCount;
						}
						resultArray.push(newNotes[i]);
					}
				}
				return resultArray;
			}
			
	}
	module.exports = UtilService;

/***/ },
/* 7 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var UpcomingActions = __webpack_require__(2);
	var Icon = FontAwesome.Icon;
	var UpcomingConstants = __webpack_require__(5);
	var TodoContent = __webpack_require__(8); 
	var TextContent = __webpack_require__(9); 

	var TermBlock = React.createClass({displayName: 'TermBlock',
		getInitialState: function() {
		  return { notes: this.props.notes };
		},
		componentWillReceiveProps: function(nextProps){
		      this.setState({
		    	  notes: nextProps.notes
		      });
		},
		render: function(){
			var isTypeToday = this.props.type === UpcomingConstants.TODAY;
			var headerTitle = this.props.title + (isTypeToday ? (" "+moment().format(GlobalConstants.DAYMONTH_FORMAT)):"");
			
			return (
				React.DOM.div(null, 
					React.DOM.h2(null, headerTitle), 
					React.DOM.hr(null), 
					React.DOM.table(null, 
					    React.DOM.colgroup(null, 
					       React.DOM.col({span: "1", className: isTypeToday?"uc-time-col":"uc-date-col"}), 
					       React.DOM.col({span: "1", className: "uc-text-col"}), 
					       React.DOM.col({span: "1", className: "uc-check-col"})
					    ), 
						this.state.notes.map(function(item, index){
							var mEventTime;
							if(isTypeToday){
								mEventTime = moment(item.eventTime, GlobalConstants.DATETIME_FORMAT, true).format(GlobalConstants.TIME_FORMAT);
							}else{
								mEventTime = moment(item.eventTime, GlobalConstants.DATETIME_FORMAT, true).format(GlobalConstants.DATETIME_SHORT_FORMAT);
							}
							
							var rowContent;
							if(item.hasTodo){
								rowContent = TodoContent({todos: item.todos, noteId: item.noteId, eventTime: mEventTime, isTypeToday: isTypeToday});
							}else{
								rowContent = TextContent({note: item, eventTime: mEventTime, isTypeToday: isTypeToday});
							}
							
							rowContent.props.key = index;
							return rowContent;
							
						})
					)
					
					
				)
					
			);
		}
		

		
	});

	module.exports = TermBlock;


/***/ },
/* 8 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var UpcomingActions = __webpack_require__(2);
	var Icon = __webpack_require__(10).Icon;

	var TodoContent = React.createClass({displayName: 'TodoContent',
		getInitialState: function() {
		  return {
			  todos: this.props.todos,
			  noteId: this.props.noteId,
			  isTypeToday: this.props.isTypeToday,
			  eventTime: this.props.eventTime
			};
		},
		
		componentWillReceiveProps: function(nextProps){
			this.setState({
				  todos: nextProps.todos,
				  noteId: nextProps.noteId,
				  isTypeToday: nextProps.isTypeToday,
				  eventTime: nextProps.eventTime
				});
		},

		render: function(){
				
			var self = this;
			return(
				React.DOM.tbody(null, 
				this.state.todos.map(function(item, index){
					
					var textClasses = React.addons.classSet({
					    'uc-text-cell': true,
					    'striked-text': item.isTodoDone,
					    'bold': !item.isTodoDone && self.state.isTypeToday
					});
					
					var checkClasses = checkClasses = React.addons.classSet({
						'uc-check-btn': true,
						'uc-checked-btn': item.isTodoDone
					});
						
					var iconCheck = "";
					if(item.isTodoDone){
						iconCheck = Icon({type: "check"})
					}else{
						iconCheck = Icon({type: "square-o"})
					}
					
					
					return(
						React.DOM.tr({key: self.state.noteId+""+item.todoNoteId, 'data-noteid': self.state.noteId, 'data-todonoteid': item.todoNoteId}, 
							React.DOM.td({onClick: self.editNote}, React.DOM.div(null, self.state.eventTime)), 
							React.DOM.td({onClick: self.editNote}, React.DOM.div({className: textClasses}, item.todoText)), 
							React.DOM.td({onClick: self.checkTodoNote}, React.DOM.div({className: checkClasses}, iconCheck))
						)
					)
				})
				)
			);
		},
		editNote: function(e){
			var noteId = jQuery(e.target).closest('tr').data("noteid");
			UpcomingActions.editNote(noteId);
		},
		checkTodoNote: function(e){
			var todoNoteId = jQuery(e.target).closest("tr").data("todonoteid");
			UpcomingActions.checkTodoNote(this.state.noteId, todoNoteId);
		}
	});

	module.exports = TodoContent;


/***/ },
/* 9 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var UpcomingActions = __webpack_require__(2);
	var Icon = __webpack_require__(10).Icon;


	var TextContent = React.createClass({displayName: 'TextContent',
		getInitialState: function() {
		  return {
			  note: this.props.note,
			  isTypeToday: this.props.isTypeToday,
			  eventTime: this.props.eventTime
			};
		},

		componentWillReceiveProps: function(nextProps){
			this.setState({
			  note: nextProps.note,
			  isTypeToday: nextProps.isTypeToday,
			  eventTime: nextProps.eventTime
			});
		},
		
		render: function(){
			
			var isDone = this.state.note.hasCheck && this.state.note.isDone;
			var textClasses = React.addons.classSet({
			    'uc-text-cell': true,
			    'striked-text': isDone,
			    'bold': !this.state.note.isDone && this.state.isTypeToday
			});
			
			var checkClasses = React.addons.classSet({
				'uc-check-btn': this.state.note.hasCheck,
				'uc-checked-btn': isDone
			});
				
			var iconCheck = "";
			if(this.state.note.hasCheck){
				if(this.state.note.isDone){
					iconCheck = Icon({type: "check"})
				}else{
					iconCheck = Icon({type: "square-o"})
				}
			}
			
			return(
				React.DOM.tbody(null, 
					React.DOM.tr(null, 
						React.DOM.td({onClick: this.editNote}, React.DOM.div(null, this.state.eventTime)), 
						React.DOM.td({onClick: this.editNote}, React.DOM.div({className: textClasses}, this.state.note.text)), 
						React.DOM.td({onClick: this.checkNote}, React.DOM.div({className: checkClasses}, iconCheck))
					)
				)
			);
		},
		
		editNote: function(e){
			UpcomingActions.editNote(this.state.note.noteId);
		},
		checkNote: function(e){
			UpcomingActions.checkNote(this.state.note.noteId);
		}
	});

	module.exports = TextContent;


/***/ },
/* 10 */
/***/ function(module, exports, __webpack_require__) {

	module.exports = FontAwesome;

/***/ }
/******/ ])