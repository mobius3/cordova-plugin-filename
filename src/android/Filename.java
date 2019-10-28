package mobius3.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

public class Filename extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getFileName")) {
            String uri = args.getString(0);
            this.getRealPathFromURI(uri, callbackContext);
            return true;
        }
        return false;
    }

    private void getRealPathFromURI(String uri, CallbackContext callbackContext) {
        if (uri != null && uri.length() > 0) {
            callbackContext.success(this.getFile(uri));
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private String getFile(String uri) {
        Uri contentUri = Uri.parse(uri);
        String[] proj = { MediaStore.Images.Media.DATA };
        CursorLoader loader = new CursorLoader(cordova.getActivity(), contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String fileName = cursor.getString(column_index);
        return fileName;
    }
}
