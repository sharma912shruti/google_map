package googlemap.com.googlemap.response;

import android.content.ContentValues;
import android.text.TextUtils;


import org.json.JSONObject;

import java.util.Set;

import googlemap.com.googlemap.utils.Constants;

/**
 * Created by Srinivas Kalayani on 25/07/2017.
 */

public class RequestBody {


    private static String convertRequestToJSON(ContentValues queryParams) {
        JSONObject requestObject = new JSONObject();
        Set<String> keySet = queryParams.keySet();
        String requestString = null;
        try {
            for (String key : keySet) {
                requestObject.put(key, queryParams.get(key));
            }
            requestString = requestObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requestString;
    }

    public static String createLoginRequest(String userName, String password) {
        ContentValues nameValuePairs = new ContentValues();
        nameValuePairs.put(Constants.USERNAME, userName);
        nameValuePairs.put(Constants.PASSWORD, password);
        return convertRequestToJSON(nameValuePairs);
    }

    public static String createLogoutRequest() {
        ContentValues nameValuePairs = new ContentValues();
        return convertRequestToJSON(nameValuePairs);
    }

    public static String createSignupRequest(String userName, String password, String mobile, String email) {
        ContentValues nameValuePairs = new ContentValues();
        nameValuePairs.put(Constants.USERNAME, userName);
        nameValuePairs.put(Constants.PASSWORD, password);
        nameValuePairs.put(Constants.EMAIL, email);
        return convertRequestToJSON(nameValuePairs);
    }

    public static String createSocialLoginRequest(String email, String googleId, String facebookId) {
        ContentValues nameValuePairs = new ContentValues();
        if (!TextUtils.isEmpty(email)) {
            nameValuePairs.put(Constants.EMAIL, email);
        }
        if (!TextUtils.isEmpty(googleId)) {
            nameValuePairs.put(Constants.GOOGLE_ID, googleId);
        }
        if (!TextUtils.isEmpty(facebookId)) {
            nameValuePairs.put(Constants.FACEBOOK_ID, facebookId);
        }
        return convertRequestToJSON(nameValuePairs);
    }

    public static String createUserFeedbackRequest(String errorMessage, String model,
                                                   String buildNumber, String osVersion, String status,
                                                   String dumpUrl,
                                                   String imageUrl, String description, String title) {
        ContentValues nameValuePairs = new ContentValues();
        if (!TextUtils.isEmpty(errorMessage)) {
            nameValuePairs.put(Constants.ERROR_MSG, errorMessage);
        }
        if (!TextUtils.isEmpty(model)) {
            nameValuePairs.put(Constants.MODEL, model);
        }
        if (!TextUtils.isEmpty(buildNumber)) {
            nameValuePairs.put(Constants.BUILD_NUMBER, buildNumber);
        }
        if (!TextUtils.isEmpty(osVersion)) {
            nameValuePairs.put(Constants.OS_VERSION, osVersion);
        }
        nameValuePairs.put(Constants.PLATFORM, Constants.ANDROID_PLATFORM);
        if (!TextUtils.isEmpty(status)) {
            nameValuePairs.put(Constants.STATUS, status);
        }
        if (!TextUtils.isEmpty(dumpUrl)) {
            nameValuePairs.put(Constants.DUMP_URL, dumpUrl);
        }
        if (!TextUtils.isEmpty(imageUrl)) {
            nameValuePairs.put(Constants.IMAGE_URL, imageUrl);
        }
        if (!TextUtils.isEmpty(description)) {
            nameValuePairs.put(Constants.DESCRIPTION, description);
        }
        if (!TextUtils.isEmpty(title)) {
            nameValuePairs.put(Constants.TITLE, title);
        }
        return convertRequestToJSON(nameValuePairs);
    }


}
