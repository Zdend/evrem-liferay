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
	var FilterStore = __webpack_require__(1);
	var FilterActions = __webpack_require__(2);
	var FilterContainer = __webpack_require__(3);

	Liferay.Portlet.ready(
	    function(portletId, node) {
	    	if(portletId.indexOf('filterportlet_WAR_filterportlet') !== -1){
	    		var initialData = JSON.parse(jQuery('#data-filter').text());
	    		FilterActions.registerUrls(initialData.urls);
	    		FilterActions.registerNotes(initialData.notes);
	    		
	    		React.renderComponent(FilterContainer(null), document.querySelector('#filter-container'));
	    		Spinner.stop();
	    	}
	    	
	    }
	);




/***/ },
/* 1 */
/***/ function(module, exports, __webpack_require__) {

	var AppDispatcher = __webpack_require__(4);
	var EventEmitter = Events.EventEmitter;
	var FilterConstants = __webpack_require__(5);
	var UtilService = __webpack_require__(6);

	var _notes = {};
	var _notesCount = 10;
	var _urls = {};


	function getNote(noteId){
		var i;
		for(i = 0; i < _notes.length; i++){
			if(_notes[i].noteId === noteId){
				return _notes[i];
			}
		}
	}

	function exportAll(){
		Spinner.start();
		jQuery.ajax({
			type: 'POST',
			dataType : 'json',
			url: _urls['exportAll'],
			success :function(result) {
				
				window.location.href = _urls['getExportAllFile']+'&fileName='+result.payload;
				console.log(_urls['getExportAllFile']+'&fileName='+result.payload);
				return result.payload;
			},
			complete: function(){
				Spinner.stop();
			}
		});
	}
	function emptyTrash(){
		Spinner.start();
		jQuery.ajax({
			type: 'POST',
			dataType : 'json',
			url: _urls['emptyTrash'],
			success :function(result) {
				_notes = result.payload;
				FilterStore.emitChange();
			},
			complete: function(){
				Spinner.stop();
			}
		});
	}

	function editNote(noteId){
	    Liferay.fire(
	            'editNoteEvent', {
	            note: getNote(noteId)
	        }
	    );
	}

	function moreNotes(){
		if(_notesCount + 10 > _notes.length){
			_notesCount = _notes.length;
		}else{
			_notesCount += 10;
		}
	}

	//FUNCTIONS
	var FilterStore = merge(EventEmitter.prototype, {
		getNotes: function(){
			return _notes.slice(0, _notesCount);
		},
		getAreAllNotesVisible: function(){
			return _notesCount >= _notes.length;
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
		case FilterConstants.REGISTER_NOTES:
			_notes = action.notes;
			break;
		case FilterConstants.REGISTER_URLS:
			_urls = action.urls;
			return true;
		case FilterConstants.EDIT_NOTE:
			editNote(action.noteId);
			return true;
		case FilterConstants.EXPORT_ALL:
			exportAll();
			return true;
		case FilterConstants.EMPTY_TRASH:
			emptyTrash();
			return true;
		case FilterConstants.MORE_NOTES:
			moreNotes();
			break;	
		default:
			return true;
		}

		FilterStore.emitChange();

		return true;
	});

	module.exports = FilterStore;

/***/ },
/* 2 */
/***/ function(module, exports, __webpack_require__) {

	var AppDispatcher = __webpack_require__(4);
	var FilterConstants = __webpack_require__(5);

	var FilterActions = {

	  registerNotes: function(notes) {
		    AppDispatcher.handleViewAction({
		      actionType: FilterConstants.REGISTER_NOTES,
		      notes: notes
		    });
	  },
	  registerUrls: function(urls) {
		  AppDispatcher.handleViewAction({
			  actionType: FilterConstants.REGISTER_URLS,
			  urls: urls
		  });
	  },
	  exportAll: function() {
		  AppDispatcher.handleServerAction({
			  actionType: FilterConstants.EXPORT_ALL
		  });
	  },
	  emptyTrash: function() {
		  AppDispatcher.handleServerAction({
			  actionType: FilterConstants.EMPTY_TRASH
		  });
	  },
	//  reloadNotes: function() {
	//	  AppDispatcher.handleServerAction({
	//		  actionType: FilterConstants.RELOAD_NOTES
	//	  });
	//  },
	  moreNotes: function() {
		  AppDispatcher.handleViewAction({
			  actionType: FilterConstants.MORE_NOTES
		  });
	  }



	 

	};

	module.exports = FilterActions;

/***/ },
/* 3 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var FilterStore = __webpack_require__(1);
	var FilterActions = __webpack_require__(2);
	var FilterConstants = __webpack_require__(5);
	var DataGrid = __webpack_require__(7);
	var VariableActions = __webpack_require__(8);

	function getNotesState() {
		  return {
		    notes: FilterStore.getNotes(),
		    allNotesVisible: FilterStore.getAreAllNotesVisible(),
		  };
	} 

	var FilterContainer = React.createClass({displayName: 'FilterContainer',
		getInitialState: function() {
		  return getNotesState();
		},
		componentDidMount: function() {
			FilterStore.addChangeListener(this._onChange);
		},
		componentWillUnmount: function() {
			FilterStore.removeChangeListener(this._onChange);
		},
		render: function(){
			return (
				React.DOM.div(null, 
					DataGrid({notes: this.state.notes, allNotesVisible: this.state.allNotesVisible}), 
					VariableActions(null), 
					React.DOM.div({className: "cleaner"})
				)
					
			);
		},
		_onChange: function() {
			this.setState(getNotesState());
		}
	});

	module.exports = FilterContainer;


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
		EXPORT_ALL: null,
		EMPTY_TRASH: null,
		RELOAD_NOTES: null,
		MORE_NOTES: null
		
		
		
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
	var Icon = FontAwesome.Icon;
	var SingleRow = __webpack_require__(10); 
	var FilterActions = __webpack_require__(2);
	var Button = ReactBootstrap.Button;

	var DataGrid = React.createClass({displayName: 'DataGrid',
		getInitialState: function() {
		  return {
			  notes: this.props.notes,
			  allNotesVisible: this.props.allNotesVisible
			  };
		},
		componentWillReceiveProps: function(nextProps){
		      this.setState({
		    	  notes: nextProps.notes,
		    	  allNotesVisible: nextProps.allNotesVisible
		      });
		},
		render: function(){
			
			return (
				React.DOM.div(null, 
					React.DOM.table({className: "fr-data-grid"}, 
					 React.DOM.tbody(null, 
					  React.DOM.tr(null, 
					  	React.DOM.th({className: "fr-color-th"}, "Color"), 
					  	React.DOM.th(null, "Note text"), 
					  	React.DOM.th({className: "fr-date-th"}, "Event time"), 
					  	React.DOM.th({className: "fr-date-th"}, "Remind time"), 
					  	React.DOM.th({className: "fr-date-th"}, "Repeat period"), 
					  	React.DOM.th({className: "fr-boolean-th"}, "Done"), 
					  	React.DOM.th({className: "fr-boolean-th"}, "Wall"), 
					  	React.DOM.th({className: "fr-boolean-th"}, "Deleted"), 
					  	React.DOM.th({className: "fr-date-th"}, "Creation date"), 
					  	React.DOM.th({className: "fr-date-th"}, "Last modified")
					  )
					  ), 
					  React.DOM.tbody({className: "fr-grid-body"}, 
						this.state.notes.map(function(item, index){
							
							return SingleRow({key: index, note: item});
							
						})
					  )
					), 
					Button({bsStyle: "primary", className: "fr-more-btn", onClick: this.moreNotesClick, disabled: this.state.allNotesVisible}, "More events..")
				)
			);
		},
		
		moreNotesClick: function(){
			FilterActions.moreNotes();
		}
		

		
	});

	module.exports = DataGrid;


/***/ },
/* 8 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var FilterActions = __webpack_require__(2);
	var Icon = __webpack_require__(9).Icon;
	var Button = ReactBootstrap.Button;
	var EmptyTrashConfirm = __webpack_require__(11);


	var VariableActions = React.createClass({displayName: 'VariableActions',
		
		render: function(){

			return(
					React.DOM.div({className: "fr-variable-actions"}, 
						Button({bsSize: "large", bsStyle: "primary", onClick: this.exportAll}, Icon({type: "file-excel-o"}), " Export"), 
						EmptyTrashConfirm(null)
					)
			);
		},
		exportAll: function(){
			FilterActions.exportAll();
		}

	});

	module.exports = VariableActions;


/***/ },
/* 9 */
/***/ function(module, exports, __webpack_require__) {

	module.exports = FontAwesome;

/***/ },
/* 10 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var FilterActions = __webpack_require__(2);
	var Icon = __webpack_require__(9).Icon;
	var Button = ReactBootstrap.Button;

	var SingleRow = React.createClass({displayName: 'SingleRow',
		getInitialState: function() {
		  return {
			  note: this.props.note
			};
		},

		componentWillReceiveProps: function(nextProps){
			this.setState({
			  note: nextProps.note
			});
		},
		
		render: function(){
			var note = this.state.note;
			var isDoneIcon = Icon({type: note.hasCheck?(note.isDone?"check":"close"):""});
			var isDeleted = Icon({type: note.isDeleted?"trash":""});
			var showOnWall = Icon({type: note.hasWall?"th-large":""});
			var textParsed = note.hasTodo? GlobalUtil.replaceAll(note.text,"\r\n"," | ") : note.text;
			return(
					React.DOM.tr({onClick: this.editNote}, 
						React.DOM.td(null, React.DOM.div({className: "fr-color-cell", style: {backgroundColor: note.color.colorWithHash}})), 
						React.DOM.td(null, React.DOM.div({className: "fr-text-cell"}, textParsed)), 
						React.DOM.td(null, note.eventTime), 
						React.DOM.td(null, note.remindInfo?note.remindInfo.remindDate:""), 
						React.DOM.td(null, React.DOM.div({className: "fr-centered-align"}, note.period?note.period.title:"")), 
						React.DOM.td(null, React.DOM.div({className: "fr-centered-align"}, isDoneIcon)), 
						React.DOM.td(null, React.DOM.div({className: "fr-centered-align"}, showOnWall)), 
						React.DOM.td(null, React.DOM.div({className: "fr-centered-align"}, isDeleted)), 
						React.DOM.td(null, note.createdDate), 
						React.DOM.td(null, note.modifiedDate)
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
	});

	module.exports = SingleRow;


/***/ },
/* 11 */
/***/ function(module, exports, __webpack_require__) {

	/** @jsx React.DOM */
	var Icon = FontAwesome.Icon;
	var OverlayTrigger = ReactBootstrap.OverlayTrigger;
	var OverlayMixin = ReactBootstrap.OverlayMixin;
	var Tooltip = ReactBootstrap.Tooltip;
	var Button = ReactBootstrap.Button;
	var Modal = ReactBootstrap.Modal;
	var FilterActions = __webpack_require__(2);


	var EmptyTrashConfirm = React.createClass({displayName: 'EmptyTrashConfirm',
		
		 mixins: [OverlayMixin],

		  getInitialState: function () {
		    return {
		      isModalOpen: false
		    };
		  },

		  handleToggle: function () {
		    this.setState({
		      isModalOpen: !this.state.isModalOpen
		    });
		  },
		  
		  render: function () {
		    return (
		    		Button({bsSize: "large", bsStyle: "danger", onClick: this.handleToggle}, Icon({type: "trash-o"}), " Remove permanently")
		    );
		  },

		  renderOverlay: function () {
		    if (!this.state.isModalOpen) {
		      return React.DOM.span(null);
		    }
		    
		    return (
		        Modal({title: "Throwing out your trash", onRequestHide: this.handleToggle, className: "fr-empty-trash-confirmation"}, 
		          React.DOM.div({className: "modal-body"}, 
		          	React.DOM.h5(null, "Do you really want to permanently remove all previsously deleted notes?"), 
		          	React.DOM.h5(null, "This action cannot be taken back.")
		          ), 
		          React.DOM.div({className: "modal-footer"}, 
		            Button({onClick: this.handleToggle}, "Close"), 
		            Button({bsStyle: "primary", onClick: this.emptyTrash}, "Yes, empty trash!")
		          )
		        )
		      );
		  },
			
		emptyTrash: function(){
			FilterActions.emptyTrash();
			this.handleToggle();
		}
		});

	module.exports = EmptyTrashConfirm;

/***/ }
/******/ ])