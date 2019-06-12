package cordova.plugin.toasterplugin;

import android.widget.Toast;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class ToasterPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if (action.equals("defaultMethod")) {
            String message = args.getString(0);
            this.defaultMethod(message, callbackContext);
            return true;
        }

        if (action.equals("showToast")) {
            String message = args.getString(0);
            this.showToast(message, callbackContext);
            return true;
        }

        return false;
    }

    private void defaultMethod(String message, CallbackContext callbackContext) {

        if (message != null && message.length() > 0) {

            callbackContext.success(message);

            // Create the toast
            Toast toast = Toast.makeText(cordova.getActivity(), message, Toast.LENGTH_SHORT);
            // Display toast
            toast.show();

        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void showToast(String message, CallbackContext callbackContext) {

        if (message != null && message.length() > 0) {

            // Create and display toast
            Toast.makeText(cordova.getActivity(), message, Toast.LENGTH_SHORT).show();

            callbackContext.success("Successful toasting...");

        } else {
            callbackContext.error("Something wrong happened.");
        }
    }

}
