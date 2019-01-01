package googlemap.com.googlemap.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import googlemap.com.googlemap.ApiClient;
import googlemap.com.googlemap.R;
import googlemap.com.googlemap.model.LoginResponse;
import googlemap.com.googlemap.response.RequestBody;
import googlemap.com.googlemap.utils.Constants;
import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity{

    private static final String EMAIL = "email";
    private CallbackManager callbackManager;

    @BindView(R.id.login_button)
    LoginButton mLoginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initialiseValue();
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "googlemap.com.googlemap",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }

    private void initialiseValue(){
        callbackManager = CallbackManager.Factory.create();
        mLoginButton.setReadPermissions(Arrays.asList(EMAIL));
        mLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                startActivity(new Intent(LoginActivity.this, MapsActivity.class));
                finish();
                Toast.makeText(LoginActivity.this,"facebook login sucessfully",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancel() {
                // App code
                Toast.makeText(LoginActivity.this,"facebook login cancel",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Toast.makeText(LoginActivity.this,exception.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @OnClick(R.id.api_login)
    void apiLogin(){

    }

    private void performLogin(String... credentials) {
//        showProgressDialog("Logging in ...", true);
        String loginRequest;
        loginRequest = RequestBody.createLoginRequest(credentials[0], credentials[1]);
        Call<LoginResponse> loginUser = ApiClient.getApiInterface().login("application/json", loginRequest);
        loginUser.enqueue(mResponseCallback);
    }

    Callback mResponseCallback = new Callback() {
        @Override
        public void onResponse(Call call, Response response) {
            Toast.makeText(LoginActivity.this,"api login sucessfully",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onFailure(Call call, Throwable t) {
            Toast.makeText(LoginActivity.this,"api login fail",Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

}
