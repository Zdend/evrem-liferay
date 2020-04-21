/** @jsx React.DOM */
var NewNoteActions = require('../actions/new-note-actions');
var ValidationService = require('../services/validation-service');

var ReminderBlock = React.createClass({
	 getInitialState: function() {
	    return {
	    	dateValue: this.props.note.remindInfo.remindDate
	    };
	},
	 _onDateChange: function(e) {
		 this.setState({
			 dateValue: e.target.value
		 });
	 },
	componentWillReceiveProps: function(nextProps){
      this.setState({
    	  dateValue: nextProps.note.remindInfo.remindDate
      });
	},
	
	componentDidMount: function(){
		var reminderDatePicker = jQuery('#reminderDateTimePicker');
		reminderDatePicker.datetimepicker();
		reminderDatePicker.on("dp.show", function(e){
			 jQuery("#reminderDateTimeInput").focus();
		});
		
	},
	
	render: function() {
		  var classes = React.addons.classSet({
		    'invisible': !this.props.note.hasReminder,
		    'visible': this.props.note.hasReminder,
			'control-group': true,
			'error': ValidationService.hasFieldError('remindDate')
		  });
		
	    return (
	      <div className={classes}>
	      	  <label htmlFor="reminderDateTimeInput">Remind date</label>
	      	  
		      <div className="form-group">
		          <div className="input-append" id="reminderDateTimePicker">
		              <input type='text' className="form-control" id="reminderDateTimeInput" data-date-format={GlobalConstants.DATETIME_FORMAT}
		            	  onBlur={this.remindTimeChange}
		              	  value={this.state.dateValue}
		                  onChange={this._onDateChange}
		              	  />
		              <button type="submit" className="btn btn-primary" onClick={this.clickDateButton}> 
		              	<span className="fa fa-bell-o"></span>      		
					  </button>
		          </div>
	          </div>
	          
	      </div>
	    );
	 },
	 
	 remindTimeChange: function(e){
		var time = e.target.value;
		NewNoteActions.remindTimeChange(time);
	}
	
	
});

module.exports = ReminderBlock;