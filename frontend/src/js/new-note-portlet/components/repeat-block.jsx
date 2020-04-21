/** @jsx React.DOM */
var NewNoteActions = require('../actions/new-note-actions');

var RepeatBlock = React.createClass({
	getInitialState: function(){
		return {
			periods: [],
			value: this.props.note.period
		};
	},
	
	componentWillReceiveProps: function(nextProps){
		if(typeof this.props.periods !== 'undefined' && this.props.periods.length > 0){
          this.setState({
        	 periods: nextProps.periods,
        	 value: nextProps.note.period
          });
		}
	},
	
	_onChange: function(e) {
	    this.setState({
	      value: e.target.value
	    });
	 },
	
	render: function() {
		  var classes = React.addons.classSet({
		    'invisible': !this.props.note.hasRepeat,
		    'visible': this.props.note.hasRepeat
		  });
		
	    return (
	      <div className={classes}>
	      	  <label htmlFor="repeatSelect" onClick={this.showOptions}>Repeat period</label>
	      	  
		      <div className="form-group">
		          <div className="input-append">
		              <select type='text' className="form-control" id="repeatSelect" 
		            	  onBlur={this.repeatPeriodChange}
			              onChange={this._onChange}
		              	  value={this.state.value}>
		              	{this.state.periods.map(function(item, index){
		              		return (<option key={index} value={item.name}>{item.title}</option>)
		              	})}
		              </select>
		              <button type="submit" className="btn btn-primary nocursor" onClick={this.showOptions}> 
		              	<span className="fa fa-repeat"></span>      		
		              </button>
		          </div>
	          </div>
	          
	      </div>
	    );
	 },

	 showOptions: function(){
		 jQuery('#repeatSelect').show().focus().click();
		 jQuery("#repeatSelect").prop('size', this.state.periods.length);
	 },
	
	repeatPeriodChange: function(e){
		jQuery("#repeatSelect").prop('size', 1);
		var period = e.target.value;
		NewNoteActions.repeatPeriodChange(period);
	}
});

module.exports = RepeatBlock;