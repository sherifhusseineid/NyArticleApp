package com.example.nyarticleapp.View.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.example.nyarticleapp.R;
import java.util.Objects;

public class SplashActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
    Objects.requireNonNull(getSupportActionBar()).hide();
    navigateToMainActivity();
  }

  private void navigateToMainActivity(){
    new Handler().postDelayed(() -> {
      Intent i = new Intent(SplashActivity.this, MainActivity.class);
      startActivity(i);
      finish();
    }, 3000);
  }

}
