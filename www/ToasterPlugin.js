var exec = require('cordova/exec');

exports.defaultMethod = function (arg0, success, error) {
	setTimeout(function(){
		exec(success, error, 'ToasterPlugin', 'defaultMethod', [arg0]);
	}, 2000);
    
};

exports.showToast = function(message, success, error) {
	exec(success, error, 'ToasterPlugin', 'showToast', [message]);
}