/** @jsx React.DOM */

var ColorPalette = React.createClass({
	
	 render: function(){
		 var colors = this.props.colors;
		 var colCount = 6;
		 var rows = [];
		 
		 for(var row = 0; row < (colors.length/colCount); row++){
			var columns = [];
			for(var col = 0; col < colCount && (row*colCount + col) < colors.length; col++){
				var color = colors[row*colCount + col];
				columns.push(<td key={col}><div className="hover-transition color-square" style={{backgroundColor: color.colorWithHash}} data-color-id={color.colorWithHash} data-color-name={color.name} onMouseOver={this.props.selectColor}></div></td>);
			}
			rows.push(<tr key={row}>{columns}</tr>);
		 }
		 
		 return (
				 <table className="color-palette">
				 	{rows}
				 </table>
				);
	 }
	
});

module.exports = ColorPalette;