var AppDispatcher = require('../dispatcher/app-dispatcher');
var EventEmitter = Events.EventEmitter;
var NewNoteConstants = require('../constants/new-note-constants');
var UtilService = require('../services/util-service');
var ValidationService = require('../services/validation-service');

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