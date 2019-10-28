# Cordova Filename Plugin

Simple plugin that returns the real file name of an android `content://` URI or any other return from file picking intent API.

It uses the method described at https://developer.android.com/training/secure-file-sharing/retrieve-info

## Install

Install it via cordova CLI:

```
cordova plugin add cordova-plugin-filename
```

## Use

A new function will be available at `window.cordova.plugins.filename` with the following prototype: `getFilename(url, successCallback, errorCallback)`

```
cordova.plugins.filename.getFilename(`<return from file picker/writer>`, name => console.log('file name is:', name))
```

Be sure to pass a `content://` URL rather than a `cdvfile://` or `file://` URL. You might need to call `window.resolveLocalFileSystemURL` before.
