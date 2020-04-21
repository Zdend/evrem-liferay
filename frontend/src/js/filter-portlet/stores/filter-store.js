var AppDispatcher = require('../dispatcher/app-dispatcher');
var EventEmitter = Events.EventEmitter;
var FilterConstants = require('../constants/filter-constants');
var UtilService = require('../services/util-service');

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