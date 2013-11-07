//
//  AppVersion.java
//
//  The MIT License
//
//  Copyright (c) 2013 Yann Lugrin
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy of this
//  software and associated documentation files (the "Software"), to deal in the Software
//  without restriction, including without limitation the rights to use, copy, modify, merge,
//  publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to
//  whom the Software is furnished to do so, subject to the following conditions:
//
//  The above copyright notice and this permission notice shall be included in all copies or
//  substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
//  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
//  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
//  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
//  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
//  IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
//  IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
//  SOFTWARE.
//

package ch.liquidconcept.cordova.appversion;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class AppVersion extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    	PluginResult result = new PluginResult(PluginResult.Status.INVALID_ACTION);
    	PackageManager packageManager = cordova.getActivity().getPackageManager();

    	if (action.equals("name")) {
	    	try {
	            PackageInfo packageInfo = packageManager.getPackageInfo(cordova.getActivity().getApplicationContext().getPackageName(), 0);
	            result = new PluginResult(PluginResult.Status.OK, packageInfo.versionName);
	        }
	        catch (PackageManager.NameNotFoundException exception) {
	            result = new PluginResult(PluginResult.Status.ERROR, exception.getMessage());
	        }
    	}

    	callbackContext.sendPluginResult(result);
    	return true;
    }
}

