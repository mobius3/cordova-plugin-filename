/*global cordova, module*/

module.exports = {
    getFilename: function (url, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Filename", "getFilename", [url]);
    }
};
