var AppDispatcher = require('../dispatcher/app-dispatcher');
var SavedNoteConstants = require('../constants/saved-note-constants');

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