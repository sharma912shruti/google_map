package googlemap.com.googlemap.model;

import com.google.gson.annotations.SerializedName;

import googlemap.com.googlemap.response.BaseResponse;

/**
 * Created by Srinivas Kalyani on 25/07/2017.
 */

public class LoginResponse extends BaseResponse {

    @SerializedName("data")
    public LoginData data;
}
