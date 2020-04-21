var AppDispatcher = require('../dispatcher/app-dispatcher');
var UpcomingConstants = require('../constants/upcoming-constants');

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