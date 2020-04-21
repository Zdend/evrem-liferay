//GULP TOOLS
var gulp = require('gulp');
var yargs = require('yargs');
var gulpif = require('gulp-if');
var concat = require("gulp-concat");
var rename = require("gulp-rename");
var args = yargs.alias('p', 'production').argv;
var minifycss = require('gulp-minify-css');
var uglify = require("gulp-uglify");
var gulpWebpack = require("gulp-webpack");
var webpack = require("webpack");
var del = require('del');
var path = require('path');
var sass = require('gulp-sass');
var compass = require('gulp-compass');

config = {
    paths : {
    	root : __dirname,
    	frontendDir : '/frontend',
        jsPath: '/js',
        css: '/css',
        fonts: '/fonts',
        workDir: './work',
        srcDir: './src',
        bundleFileName : 'bundle.js',
    	evremTheme : '../evrem-theme/src/main/webapp',
    	evremThemeTarget : '../evrem-theme/target/m2e-liferay/theme-resources',
        portlets:[
        	{
        		entry: './src/js/new-note-portlet/app.jsx',
        		output: '../portlets/new-note-portlet/src/main/webapp'
        	},
        	{
        		entry: './src/js/saved-note-portlet/app.jsx',
        		output: '../portlets/saved-note-portlet/src/main/webapp'
        	},
        	{
        		entry: './src/js/calendar-portlet/app.jsx',
        		output: '../portlets/calendar-portlet/src/main/webapp'
        	},
        	{
        		entry: './src/js/upcoming-portlet/app.jsx',
        		output: '../portlets/upcoming-portlet/src/main/webapp'
        	},
        	{
        		entry: './src/js/login-portlet/app.jsx',
        		output: '../portlets/login-portlet/src/main/webapp'
        	},
        	{
        		entry: './src/js/filter-portlet/app.jsx',
        		output: '../portlets/filter-portlet/src/main/webapp',
          	},
        	{
        		entry: './src/js/profile-portlet/app.jsx',
        		output: '../portlets/support-portlet/src/main/webapp',
        		name: 'profile-bundle'
        	}
        ],
        jsDirs:
		    [
		     'bower_components/gridster.js/dist/jquery.gridster.js',
		     'src/js/lib/bootstrap-datetimepicker.js',
		     'src/js/lib/bootstrap.js',
		     'bower_components/fullcalendar/dist/fullcalendar.js',
		     'src/js/lib/timezones.js',
		     'src/js/lib/timezone-data.js',
		     'src/js/lib/spinner.js'
		     ],
		vendorCssDirs:
		    [
	        'bower_components/fontawesome/scss/font-awesome.scss',
	        'bower_components/gridster.js/dist/jquery.gridster.css',
	        'src/css/lib/roboto-fontface.scss',
	        'src/css/lib/raleway-fontface.scss',
	        'bower_components/fullcalendar/dist/fullcalendar.css'
	        ],
		customCssDirs:
			[
			 'src/css/new-note-portlet/*.scss',
			 'src/css/saved-note-portlet/*.scss',
			 'src/css/calendar-portlet/*.scss',
			 'src/css/upcoming-portlet/*.scss',
			 'src/css/login-portlet/*.scss',
			 'src/css/filter-portlet/*.scss',
			 'src/css/profile-portlet/*.scss',
			 'src/css/*.scss'
			 ],
		fontDirs:
		    [
		     'bower_components/fontawesome/fonts'
		     ]
    },
    externals:{
    	"react": "React",
  		"jquery": "jQuery",
  		"moment": "moment",
  		"react-font-awesome": "FontAwesome",
  		"react-textarea-autosize": "AutoTextarea",
  		"flux": "Flux",
  		"events": "Events",
  		"react/lib/copyProperties": "copyProperties",
  		"react/lib/keyMirror": "keyMirror",
  		"react/lib/merge": "merge",
  		"react-bootstrap": "ReactBootstrap",
  		"./js/global-constants": "GlobalConstants"
    }
};

var compassConfig = {
	      project: path.join(__dirname, 'src'),
	      css: '../dist',
	      sass: 'css'
}

var displayError = function(error) {
    var errorString = '[' + error.plugin + ']';
    errorString += ' ' + error.message.replace("\n",''); // Removes new line at the end
    if(error.fileName)
        errorString += ' in ' + error.fileName;

    if(error.lineNumber)
        errorString += ' on line ' + error.lineNumber;
    console.error(errorString);
}

gulp.task('global-css', function(){
	return gulp.src(config.paths.vendorCssDirs)
		.pipe(sass())
		.pipe(concat('global-styles.css'))
        .pipe(gulpif(args.production, minifycss()))
        .pipe(gulp.dest(config.paths.evremTheme + config.paths.css))
});

gulp.task('css', function(){
	return gulp.src(config.paths.customCssDirs)
		.pipe(compass(compassConfig))
		.pipe(concat('custom.css'))
        .pipe(gulpif(args.production, minifycss()))
        .pipe(gulp.dest(config.paths.evremTheme + config.paths.css))
        .pipe(gulp.dest(config.paths.evremThemeTarget + config.paths.css))
});

gulp.task('fonts', function() {
    var fonts = config.paths.fontDirs.map(function (item) {return item+='/*.*'});    
    return gulp.src(fonts)
        	.pipe(gulp.dest(config.paths.evremTheme + config.paths.fonts))
});

gulp.task('watch-css', function() {
	var srcCssPath = config.paths.srcDir + config.paths.css + '/**/*.*';
	console.log('Watching: '+ srcCssPath);
	gulp.watch(srcCssPath, ['css']);
});

// --------------JS TASKS--------------

gulp.task('js', function () {
	config.paths.portlets.map(function(portlet){
		return gulp.src(['./'])
        .pipe(gulpWebpack({
        	  entry: {
        		    bundle: portlet.entry
        	  },
              module: {
                  loaders: [
                      { test: /\.jsx$/, loader: 'jsx-loader' }
                  ]
              },
              externals: config.externals,
    		  output: {
    		    filename: (portlet.name || "[name]") + ".js"
    		  }
        	}))
        .pipe(gulpif(args.production, uglify()))
        .pipe(gulp.dest(portlet.output + config.paths.jsPath))
	});
});


gulp.task('watch', function() {
	var srcJsPath = config.paths.srcDir + config.paths.jsPath + '/**/*.js*';
	console.log('Watching: '+ srcJsPath);
	gulp.watch(srcJsPath, ['js']);
});

gulp.task('global-js', function(){
	/**This will be accessible globally*/
	var sources = config.paths.jsDirs;
	sources.push(config.paths.srcDir + config.paths.jsPath + '/global-libs.js');
	return gulp.src(sources)
    .pipe(gulpWebpack())
    .pipe(rename('global-libs.js'))
    .pipe(gulpif(args.production, uglify()))
    .pipe(gulp.dest(config.paths.evremTheme + config.paths.jsPath))
});

gulp.task('clean-js', function(cb){
	config.paths.portlets.map(function(portlet){
		return del([
		   portlet.output + config.paths.jsPath + "/" + config.paths.bundleFileName
		 ], {
		  force: true
		}, function (err) {
		    console.log('Files deletion error: '+ err);
		});
	});
});

gulp.task('clean-build', ['clean-js', 'js']);
gulp.task('default', ['js']);
gulp.task('global', ['global-js','global-css', 'fonts']);

