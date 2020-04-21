/** @jsx React.DOM */
var NewNoteActions = require('../actions/new-note-actions');
var ValidationService = require('../services/validation-service');

var IsdoneBlock = React.createClass({
	
	render: function() {
		  var classes = React.addons.classSet({
		    'invisible': !this.props.note.hasCheck,
		    'visible': this.props.note.hasCheck
		  });
		  var classesInput = React.addons.classSet({
			  'form-control': true,
			  'isdone-checked': this.props.note.isDone,
			  'isdone-unchecked': !this.props.note.isDone
		  });
		
		  
	    return (
	      <div className={classes}>
	      	  <label htmlFor="isdone-input">Is task finished</label>
	      	  
		      <div className="form-group">
		          <div className="input-append">
		              <input type='text' className={classesInput} id="isdone-input"
			              value={this.props.note.isDone?'Task is finished! :-)':'Not done yet :-('}
		              	  onClick={this.onClick}
		              	  readOnly="true" />
		              <button type="submit" className="btn btn-primary" onClick={this.onClick}> 
		              	<span className="fa fa-check"></span>      		
					  </button>
		          </div>
	          </div>
	          
	      </div>
	    );
	 },
	 
	onClick: function(){
		NewNoteActions.checkNote();
	}
	
});

module.exports = IsdoneBlock;
