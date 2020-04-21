/** @jsx React.DOM */
var FilterActions = require('../actions/filter-actions');
var Icon = require('react-font-awesome').Icon;
var Button = ReactBootstrap.Button;
var EmptyTrashConfirm = require('./empty-trash-confirm.jsx');


var VariableActions = React.createClass({
	
	render: function(){

		return(
				<div className="fr-variable-actions">
					<Button bsSize="large" bsStyle="primary" onClick={this.exportAll}><Icon type="file-excel-o" /> Export</Button>
					<EmptyTrashConfirm />
				</div>
		);
	},
	exportAll: function(){
		FilterActions.exportAll();
	}

});

module.exports = VariableActions;
