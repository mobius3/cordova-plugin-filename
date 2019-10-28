package mobius3.plugin;

import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.support.v4.content.CursorLoader;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

public class Filename extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getFilename")) {
            String uri = args.getString(0);
            this.getFileNameAndSendToContext(uri, callbackContext);
            return true;
        }
        return false;
    }

    private void getFileNameAndSendToContext(String uri, CallbackContext callbackContext) {
      if (uri != null && uri.length() > 0) {
        Uri contentUri = Uri.parse(uri);
        Cursor returnCursor = cordova.getContext().getContentResolver().query(contentUri, null, null, null, null);
        int nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
        returnCursor.moveToFirst();
        callbackContext.success(returnCursor.getString(nameIndex));
      } else {
        callbackContext.error("Expected one non-empty string argument.");
      }
    }
}


