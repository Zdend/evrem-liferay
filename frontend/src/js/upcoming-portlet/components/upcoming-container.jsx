/** @jsx React.DOM */
var UpcomingStore = require('../stores/upcoming-store');
var UpcomingActions = require('../actions/upcoming-actions');
var UpcomingConstants = require('../constants/upcoming-constants');
var TermBlock = require('./term-block.jsx');
var Button = ReactBootstrap.Button;

function getNotesState() {
	  return {
	    today: UpcomingStore.getTodayNotes(),
	    future: UpcomingStore.getFutureNotes(),
	    past: UpcomingStore.getPastNotes(),
	    allNotesVisible: UpcomingStore.getAreAllNotesVisible()
	  };
}

var UpcomingContainer = React.createClass({
	getInitialState: function() {
	  return getNotesState();
	},
	componentDidMount: function() {
		UpcomingStore.addChangeListener(this._onChange);
	},
	componentWillUnmount: function() {
		UpcomingStore.removeChangeListener(this._onChange);
	},
	render: function(){
		return (
			<div>
				<ul className="uc-termblocks-list">
				<li><TermBlock notes={this.state.past} title="Past" type={UpcomingConstants.PAST} /></li>
					<li><TermBlock notes={this.state.today} title="Today" type={UpcomingConstants.TODAY} /></li>
					<li><TermBlock notes={this.state.future} title="Future" type={UpcomingConstants.FUTURE} /></li>
				</ul>
				<Button bsStyle="primary" className="uc-more-btn" onClick={this.moreEventClick} disabled={this.state.allNotesVisible}>More events..</Button>
			</div>
				
		);
	},
	_onChange: function() {
		this.setState(getNotesState());
	},
	moreEventClick: function(){
		UpcomingActions.moreEvents();
	}
});

module.exports = UpcomingContainer;
