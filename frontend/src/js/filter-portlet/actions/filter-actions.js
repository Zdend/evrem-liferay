var AppDispatcher = require('../dispatcher/app-dispatcher');
var FilterConstants = require('../constants/filter-constants');

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