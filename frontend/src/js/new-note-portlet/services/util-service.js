var UtilService = {
	getRandomColor: function(colors){
		var color = {
				name: 'BLUE_NAVY',
				colorWithHash: '#185287'
		};
		
		if(typeof colors != 'undefined'){
			var randomIndex = this.randomIntFromInterval(0, colors.length - 1);
			color.name = colors[randomIndex].name;
			color.colorWithHash = colors[randomIndex].colorWithHash;
		}
		return color;
	},
	
	randomIntFromInterval: function(min,max){
	    return Math.floor(Math.random()*(max-min+1)+min);
	}
}
module.exports = UtilService;