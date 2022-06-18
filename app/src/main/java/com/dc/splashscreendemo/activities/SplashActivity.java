package com.dc.splashscreendemo.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.dc.splashscreendemo.R;
import com.dc.splashscreendemo.mvvm_databinding.MvvmWaterBottleActivity;
import com.dc.splashscreendemo.utils.MySharedPref;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_TIME_OUT = 3000;
    private final String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        printLog(name);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (MySharedPref.getPreferences(SplashActivity.this).getUserName().equalsIgnoreCase("NA")) {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }


    @Override
    protected void onStart() {
        super.onStart();
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        printLog(name);
    }

    @Override
    protected void onStop() {
        super.onStop();
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        printLog(name);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        printLog(name);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        printLog(name);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        printLog(name);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        printLog(name);
    }

    private void printLog(String msg) {
        Log.e(TAG, msg);
    }
}