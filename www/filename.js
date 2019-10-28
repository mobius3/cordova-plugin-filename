/*global cordova, module*/

module.exports = {
    getRealFilename: function (url, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Filename", "getRealFilename", [url]);
    }
};
