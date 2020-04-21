/** @jsx React.DOM */
var NewNoteActions = require('../actions/new-note-actions');
var ValidationService = require('../services/validation-service');

var TimeBlock = React.createClass({
	 getInitialState: function() {
	    return {
	      value: this.props.note.eventTime
	    };
	},
	componentWillReceiveProps: function(nextProps){
      this.setState({
    	  value: nextProps.note.eventTime
      });
	},
	 _onDateChange: function(e) {
		 this.setState({
			 value: e.target.value
		 });
	 },
	componentDidMount: function(){
		var eventDateTimePicker = jQuery('#eventDateTimePicker');
		eventDateTimePicker.datetimepicker();
		eventDateTimePicker.on("dp.show", function(e){
			 jQuery("#eventDateTimeInput").focus();
		});
	},
	
	render: function() {
		  var classes = React.addons.classSet({
		    'invisible': !this.props.note.hasTime,
		    'visible': this.props.note.hasTime,
			'control-group': true,
			'error': ValidationService.hasFieldError('eventTime')
		  });
		
	    return (
	      <div className={classes}>
	      	  <label htmlFor="eventDateTimeInput">Event date</label>
	      	  
		      <div className="form-group">
		          <div className="input-append" id="eventDateTimePicker">
		              <input type='text' className="form-control" id="eventDateTimeInput" data-date-format={GlobalConstants.DATETIME_FORMAT}
		            	  onBlur={this.eventTimeChange}
			              value={this.state.value}
		                  onChange={this._onDateChange}/>
		              <button type="submit" className="btn btn-primary"> 
		              	<span className="fa fa-clock-o"></span>      		
					  </button>
		          </div>
	          </div>
	          
	      </div>
	    );
	 },
	 
	eventTimeChange: function(e){
		var time = e.target.value;
		NewNoteActions.eventTimeChange(time);
	}
	
});

module.exports = TimeBlock;
