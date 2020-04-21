/** @jsx React.DOM */
var CollorPalette = require('./color-palette.jsx');
var Popover = ReactBootstrap.Popover;
var OverlayTrigger = ReactBootstrap.OverlayTrigger;
var Tooltip = ReactBootstrap.Tooltip;
var NewNoteActions = require('../actions/new-note-actions');


var ColorBlock = React.createClass({
	getInitialState: function(){
		return {
			colors: []
		};
	},
	
	componentWillReceiveProps: function(nextProps){
		if(typeof this.props.colors != 'undefined' && this.props.colors.length > 0){
          this.setState({
        	  colors: nextProps.colors
          });
		}
	},
	
	render: function() {
		  var classes = React.addons.classSet({
			'white-popover': true,
		    'invisible': !this.props.note.hasColor,
		    'visible': this.props.note.hasColor
		  });
		
		  var overlay = <Popover><CollorPalette selectColor={this.selectColor} colors={this.state.colors} /></Popover>;
 		   
		  
	    return (
	      <div className={classes}>
	      <label htmlFor="noteColorSelect">Note color</label>
	      	  
		      <div className="form-group">
		          <div className="input-append">
		              <input type='text' className="form-control" id="note-color-select" value="Sample text.." readOnly={true} style={{backgroundColor: this.props.note.color.colorWithHash}} />
		              <OverlayTrigger trigger="focus" placement="bottom" 
		            	  overlay={overlay}>
			              <button type="submit" className="btn btn-primary" id="color-selector">
			              	<span className="fa fa-paint-brush"></span>      		
						  </button>
		              </OverlayTrigger>
		          </div>
	          </div>
	          
	      </div>
	    );
	 }, 
	 
	 selectColor: function(e){
		 var color = {
			 name: e.target.attributes["data-color-name"].value,
			 colorWithHash: e.target.attributes["data-color-id"].value
		};
		 NewNoteActions.colorChange(color);
	 }
	 
	
});


module.exports = ColorBlock;