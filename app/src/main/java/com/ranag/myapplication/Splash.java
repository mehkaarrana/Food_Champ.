package com.ranag.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
                boolean result=sharedPreferences.getBoolean("check",false);
                if(!result) {
                    startActivity(new Intent(Splash.this, Login.class));
                }else {
                    startActivity(new Intent(Splash.this, MainActivity.class));
                }
            }
        },4000);
    }
}