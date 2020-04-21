/** @jsx React.DOM */
var NewNoteActions = require('../actions/new-note-actions');
var ValidationService = require('../services/validation-service');

var ReminderSubjectBlock = React.createClass({
	 getInitialState: function() {
	    return {
	    	remindSubject: this.props.note.remindInfo.remindSubject
	    };
	},
	 _onSubjectChange: function(e) {
		 this.setState({
			 remindSubject: e.target.value
		 });
	 },
	componentWillReceiveProps: function(nextProps){
      this.setState({
    	  remindSubject: nextProps.note.remindInfo.remindSubject
      });
	},
	
	
	render: function() {
		  var classes = React.addons.classSet({
		    'invisible': !this.props.note.hasReminder,
		    'visible': this.props.note.hasReminder,
			'control-group': true
		  });
		
	    return (
	      <div className={classes}>
	          <label htmlFor="reminderSubjectInput">Email subject</label>
	          
	          <div className="form-group">
		          <div className="input-append">
		              <input type='text' className="form-control" id="reminderSubjectInput"
		            	  onBlur={this.remindSubjectChange}
		              	  onChange={this._onSubjectChange}
		              	  value={this.state.remindSubject}/>
		              <button type="submit" className="btn btn-primary" onClick={this.clickSubjectButton}> 
		              	<span className="fa fa-pencil"></span>      		
					  </button>
		          </div>
	          </div>
	          
	      </div>
	    );
	 },
	 
	remindSubjectChange: function(e){
		 var subject = e.target.value;
		 NewNoteActions.remindSubjectChange(subject);
	 },
	 
	 clickSubjectButton: function(){
		 jQuery("#reminderSubjectInput").focus();
	 }
	
});

module.exports = ReminderSubjectBlock;