package googlemap.com.googlemap.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import googlemap.com.googlemap.R;

public class SplashScreen extends AppCompatActivity {

    private static final int DELAY = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        launchMainScreen();
    }

    private void launchMainScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                finish();
            }
        },DELAY);
    }
}
