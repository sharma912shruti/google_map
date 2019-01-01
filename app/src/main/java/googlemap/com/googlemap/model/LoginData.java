package googlemap.com.googlemap.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ssharma on 19/9/17.
 */

public class LoginData {

    @SerializedName("user")
    public User user;

    public class User{
        @SerializedName("userId")
        public String userId;

        @SerializedName("username")
        public  String username;

        @SerializedName("email")
        public String email;
    }

}
