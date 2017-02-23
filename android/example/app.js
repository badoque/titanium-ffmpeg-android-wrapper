// This is a test harness for your module
// You should do something interesting in this harness
// to test out the module and to provide instructions
// to users on how to use it by example.


// open a single window
var win = Ti.UI.createWindow({
	backgroundColor:'white'
});
var label = Ti.UI.createLabel();
win.add(label);
win.open();

// TODO: write your module tests here
var ffmpeg_android_wrapper = require('com.badoque.ffmpeg.android');
Ti.API.info("module is => " + ffmpeg_android_wrapper);

label.text = ffmpeg_android_wrapper.example();

Ti.API.info("module exampleProp is => " + ffmpeg_android_wrapper.exampleProp);
ffmpeg_android_wrapper.exampleProp = "This is a test value";

if (Ti.Platform.name == "android") {
	var proxy = ffmpeg_android_wrapper.createExample({
		message: "Creating an example Proxy",
		backgroundColor: "red",
		width: 100,
		height: 100,
		top: 100,
		left: 150
	});

	proxy.printMessage("Hello world!");
	proxy.message = "Hi world!.  It's me again.";
	proxy.printMessage("Hello world!");
	win.add(proxy);
}

