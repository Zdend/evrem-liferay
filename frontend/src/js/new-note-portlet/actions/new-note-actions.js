var AppDispatcher = require('../dispatcher/app-dispatcher');
var NewNoteConstants = require('../constants/new-note-constants');

var NewNoteActions = {


  toggleOption: function(btnType) {
    AppDispatcher.handleViewAction({
      actionType: NewNoteConstants.TOGGLE_OPTION,
      btnType: btnType
    });
  },
  registerColors: function(colors) {
	  AppDispatcher.handleViewAction({
		  actionType: NewNoteConstants.REGISTER_COLORS,
		  colors: colors
	  });
  },
  registerUrls: function(urls) {
	  AppDispatcher.handleViewAction({
		  actionType: NewNoteConstants.REGISTER_URLS,
		  urls: urls
	  });
  },
  registerPeriods: function(periods) {
	  AppDispatcher.handleViewAction({
		  actionType: NewNoteConstants.REGISTER_PERIODS,
		  periods: periods
	  });
  },

  saveNote: function(){
	  AppDispatcher.handleServerAction({
		  actionType: NewNoteConstants.SAVE_NOTE
	  });
  },
  textChange: function(text){
	  AppDispatcher.handleViewAction({
		  actionType: NewNoteConstants.TEXT_CHANGE,
		  text: text
	  });
  },
  eventTimeChange: function(time){
	  AppDispatcher.handleViewAction({
		  actionType: NewNoteConstants.EVENT_TIME_CHANGE,
		  time: time
	  });
  },
  remindTimeChange: function(time){
	  AppDispatcher.handleViewAction({
		  actionType: NewNoteConstants.REMIND_TIME_CHANGE,
		  time: time
	  });
  },
  remindSubjectChange: function(subject){
	  AppDispatcher.handleViewAction({
		  actionType: NewNoteConstants.REMIND_SUBJECT_CHANGE,
		  subject: subject
	  });
  },
  repeatPeriodChange: function(period){
	  AppDispatcher.handleViewAction({
		  actionType: NewNoteConstants.PERIOD_CHANGE,
		  period: period
	  });
  },
  colorChange: function(color){
	  AppDispatcher.handleViewAction({
		  actionType: NewNoteConstants.COLOR_CHANGE,
		  color: color
	  });
  },
  editNote: function(note){
	  AppDispatcher.handleViewAction({
		  actionType: NewNoteConstants.EDIT_NOTE,
		  note: note
	  });
  },
  deleteNote: function(){
	  AppDispatcher.handleViewAction({
		  actionType: NewNoteConstants.DELETE_NOTE
	  });
  },
  clearNote: function(){
	  AppDispatcher.handleViewAction({
		  actionType: NewNoteConstants.CLEAR_NOTE
	  });
  },
  checkNote: function(){
	  AppDispatcher.handleViewAction({
		  actionType: NewNoteConstants.CHECK_NOTE
	  });
  },
  restoreNote: function(){
	  AppDispatcher.handleServerAction({
		  actionType: NewNoteConstants.RESTORE_NOTE
	  });
  },
  restoreCurrentNote: function(){
	  AppDispatcher.handleServerAction({
		  actionType: NewNoteConstants.RESTORE_CURRENT_NOTE
	  });
  },
  clearInfoMessage: function(){
	  AppDispatcher.handleViewAction({
		  actionType: NewNoteConstants.CLEAR_INFO_MSG
	  });
  }

 

};

module.exports = NewNoteActions;