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
	var SavedNoteStore = __webpack_require__(1);
	var SavedNoteActions = __webpack_require__(2);
	var WallGrid = __webpack_require__(3);

	Liferay.Portlet.ready(
	    function(portletId, node) {
	    	if(portletId.indexOf('savednoteportlet_WAR_savednoteportlet') !== -1){
	    		var initialData = JSON.parse(jQuery('#data-wall-grid').text());
	    		SavedNoteActions.registerUrls(initialData.urls);
	    		SavedNoteActions.registerNotes(initialData.notes);
	    		
	    		React.renderComponent(WallGrid(null), document.querySelector('#wall-grid-container'));
	    		Spinner.stop();
	    	}
	    	
	    }
	);


	setInterval(function(){
		var gridster = jQuery(".gridster ul").gridster().data('gridster');
		SavedNoteActions.saveCoordinates(gridster.serialize_changed());
		gridster.$changed = jQuery([]);
	},10000);



/***/ },
/* 1 */
/***/ function(module, exports, __webpack_require__) {

	var AppDispatcher = __webpack_require__(4);
	var EventEmitter = Events.EventEmitter;
	var SavedNoteConstants = __webpack_require__(5);

	var _notes = {};
	var _urls = {};


	function saveCoordinates(coordinates){
		if(typeof coordinates == 'undefined' || jQuery.isEmptyObject(coordinates)){
			return;
		}
		var gridItems = {gridItems: coordinates};
		
		jQuery.ajax({
			type: 'POST',
			dataType : 'json',
			url: _urls['saveCoordinates'],
			data: {jsonCoordinates: JSON.stringify(gridItems)},
			success :function(result) {
				_hasBeenSavedCoordinates = true;
				return result.payload;
			}
		});
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
				if(note.hasTodo){
					var i;
					for(i = 0; i < note.todos.length; i++){
						note.todos[i].isTodoDone = note.isDone;
					}
				}
				
				SavedNoteStore.emitChange();
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
				SavedNoteStore.emitChange();
				return result.payload;
			}
		});
	}

	function getNote(noteId){
		var i;
		for(i = 0; i < _notes.length; i++){
			if(_notes[i].noteId === noteId){
				return _notes[i];
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

	//FUNCTIONS
	var SavedNoteStore = merge(EventEmitter.prototype, {
		getNotes: function() {
			return _notes;
		},

		emitChange: function() {
			this.emit(GlobalConstants.CHANGE_EVENT);
		},
		addChangeListener: function(callback) {
			this.on(GlobalConstants.CHANGE_EVENT, callback);
		},
		removeChangeListener: function(callback) {
			this.removeListener(GlobalConstants.CHANGE_EVENT, callback);
		},
		addListenerCount: function(incrementNumber){
			this.setMaxListeners(this._events.change.length);
		}
	});

	AppDispatcher.register(function(payload) {
		var action = payload.action;

		switch(action.actionType) {
		case SavedNoteConstants.REGISTER_NOTES:
			_notes = action.notes;
			break;
		case SavedNoteConstants.REGISTER_URLS:
			_urls = action.urls;
			break;
		case SavedNoteConstants.SAVE_COORDINATES:
			saveCoordinates(action.coordinates);
			return true;
		case SavedNoteConstants.CHECK_NOTE:
			checkNote(action.noteId);
			return true;
		case SavedNoteConstants.CHECK_TODONOTE:
			checkTodoNote(action.noteId, action.todoNoteId);
			return true;
			
			
		default:
			return true;
		}

		SavedNoteStore.emitChange();

		return true;
	});

	module.exports = SavedNoteStore;

/***/ },
/* 2 */
/***/ function(module, exports, __webpack_require__) {

	var AppDispatcher = __webpack_require__(4);
	var SavedNoteConstants = __webpack_require__(5);

	var SavedNoteActions = {

	  registerNotes: function(notes) {
		    AppDispatcher.handleViewAction({
		      actionType: SavedNoteConstants.REGISTER_NOTES,
		      notes: notes
		    });
	  },
	  registerUrls: function(urls) {
		  AppDispatcher.handleViewAction({
			  actionType: SavedNoteConstants.REGISTER_URLS,
			  urls: urls
		  });
	  },
		saveCoordinates: function(coordinates) {
			AppDispatcher.handleViewAction({
				actionType: SavedNoteConstants.SAVE_COORDINATES,
				coordinates: coordinates
			});
		},
	  checkNote: function(noteId) {
			AppDispatcher.handleServerAction({
				actionType: SavedNoteConstants.CHECK_NOTE,
				noteId: noteId
			});
		},
		checkTodoNote: function(noteId, todoNoteId) {
			AppDispatcher.handleServerAction({
				actionType: SavedNoteConstants.CHECK_TODONOTE,
				noteId: noteId,
				todoNoteId: todoNoteId
			});
		}


	};

	module.exports = SavedNoteActions;

/***/ },
/* 3 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var SavedNoteStore = __webpack_require__(1);
	var SavedNoteActions = __webpack_require__(2);
	var NoteContainer = __webpack_require__(6);

	function getNotesState() {
		  return {
		    notes: SavedNoteStore.getNotes()
		  };
	}

	var WallGrid = React.createClass({displayName: 'WallGrid',
		getInitialState: function() {
		  return getNotesState();
		},
		componentDidMount: function() {
			jQuery(function(){
				var gridsterContainer = jQuery(".gridster ul");
				var options = {
				        widget_margins: [5, 5],
				        widget_base_dimensions: [140, 50],
			            serialize_params: function(w, wgd) { 
		                    return { 
		                           gridItemId: jQuery(w).attr('data-id'), 
		                           y: wgd.col, 
		                           x: wgd.row, 
		                           w: wgd.size_x, 
		                           h: wgd.size_y 
		                    };
		                },
		                resize:{
		                	enabled: true,
		                	stop: function(event, ui, $widget){
		                		this.$changed = this.$changed.add($widget);
		                	}
		                }
				};
				gridsterContainer.gridster(options);
			});
			
			SavedNoteStore.addChangeListener(this._onChange);
		},
		componentWillUnmount: function() {
			SavedNoteStore.removeChangeListener(this._onChange);
		},
		render: function(){
			return (
				React.DOM.div({className: "gridster"}, 
				    React.DOM.ul(null, 
				    	this.state.notes.map(function(note){
				    		return (
				    				NoteContainer({note: note, key: note.noteId})
				    				);
				    	})
				    )
				)
					
					
			);
		},
		
	   _onChange: function() {
	     this.setState(getNotesState());
	   }
	});

	module.exports = WallGrid;


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
		SAVE_COORDINATES: null,
		CHECK_NOTE: null,
		CHECK_TODONOTE: null
		
	});

/***/ },
/* 6 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var React = __webpack_require__(7);
	var SavedNoteStore = __webpack_require__(1);
	var SavedNoteActions = __webpack_require__(2);
	var Icon = __webpack_require__(8).Icon;
	var TodoContent = __webpack_require__(9);

	var NoteContainer = React.createClass({displayName: 'NoteContainer',
		getInitialState: function() {
		  return {
			  note: this.props.note
				};
		},

		render: function(){
			var classesCheckBtn = React.addons.classSet({
			    'sn-action-button': true,
			    'hide': !this.state.note.hasCheck,
			    'sn-checked-btn': this.state.note.isDone
			  });
			var classesCheckText = React.addons.classSet({
				'sn-inner-note-container': true,
				'striked-text': this.state.note.isDone
			});
			
			var noteContent;
			if(this.state.note.hasTodo){
				noteContent = TodoContent({todos: this.state.note.todos, noteId: this.state.note.noteId});
			}else{
				noteContent = React.DOM.div({className: classesCheckText}, this.state.note.text);
			}
			
			
			return (
				React.DOM.li({key: this.state.note.noteId, style: {backgroundColor: this.state.note.color.colorWithHash}, 
					'data-row': this.state.note.gridItem.x, 'data-col': this.state.note.gridItem.y, 
					'data-sizex': this.state.note.gridItem.w, 'data-sizey': this.state.note.gridItem.h, 'data-id': this.state.note.gridItem.gridItemId}, 
				
					React.DOM.div({className: "sn-actions-container"}, 
						React.DOM.div({className: "sn-action-button"}, Icon({type: "pencil", onClick: this.editNote})), 
						React.DOM.div({className: classesCheckBtn}, Icon({type: "check", onClick: this.checkNote}))
					), 
					
					noteContent
				)	
			);
		},
		
		editNote: function(){
		    Liferay.fire(
		            'editNoteEvent', {
		            note: this.state.note
		        }
		    );
		},
		checkNote: function(){
			SavedNoteActions.checkNote(this.state.note.noteId);
		}
	});

	module.exports = NoteContainer;


/***/ },
/* 7 */
/***/ function(module, exports, __webpack_require__) {

	module.exports = React;

/***/ },
/* 8 */
/***/ function(module, exports, __webpack_require__) {

	module.exports = FontAwesome;

/***/ },
/* 9 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var SavedNoteActions = __webpack_require__(2);
	var Icon = __webpack_require__(8).Icon;

	var TodoContent = React.createClass({displayName: 'TodoContent',
		getInitialState: function() {
		  return {
			  todos: this.props.todos,
			  noteId: this.props.noteId
				};
		},

		render: function(){
				
			var self = this;
			return(
				React.DOM.div(null, 
				this.state.todos.map(function(item, index){
					var iconCheck = "";
					
					var textClasses = React.addons.classSet({
					    'sn-todo-text': true,
					    'striked-text': item.isTodoDone
					});
					
					var checkClasses = checkClasses = React.addons.classSet({
						'sn-check-btn': true
					});
						
					if(item.isTodoDone){
						iconCheck = Icon({type: "check"})
					}else{
						iconCheck = Icon({type: "square-o"})
					}
					
					return(
						React.DOM.div({key: index}, 
							React.DOM.div({className: checkClasses, 'data-todonoteid': item.todoNoteId, onClick: self.checkTodoNote}, iconCheck), 
							React.DOM.div({className: textClasses}, item.todoText)
						)
					)
				})
				)
			);
		},
		
		checkTodoNote: function(e){
			var todoNoteId = jQuery(e.target).closest("div").data("todonoteid");
			SavedNoteActions.checkTodoNote(this.state.noteId, todoNoteId);
		}
	});

	module.exports = TodoContent;


/***/ }
/******/ ])