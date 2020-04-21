var AppDispatcher = require('../dispatcher/app-dispatcher');
var EventEmitter = Events.EventEmitter;
var UpcomingConstants = require('../constants/upcoming-constants');
var UtilService = require('../services/util-service');

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