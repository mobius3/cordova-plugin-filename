package mobius3.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

public class Filename extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getRealFilename")) {
            String url = data.getString(0);
            String message = "Filename, " + name;
            callbackContext.success(message);

            return true;
        } else {
            return false;
        }
    }
}
