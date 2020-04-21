var AppDispatcher = require('../dispatcher/app-dispatcher');
var EventEmitter = Events.EventEmitter;
var SavedNoteConstants = require('../constants/saved-note-constants');

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