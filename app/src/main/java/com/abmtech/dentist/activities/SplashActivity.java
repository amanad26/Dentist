package com.abmtech.dentist.activities;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.abmtech.dentist.R;
import com.abmtech.dentist.Session.Session;
import com.abmtech.dentist.doctors.DoctorWelcomeActivity;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    Session session;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        activity = this;
        session = new Session(activity);



//        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(instanceIdResult -> {
//            String fcm_id = instanceIdResult.getToken();
//            // send it to server
//            Log.e("refresh_tokentoken", fcm_id);
//        });

      //  FirebaseMessaging.getInstance().subscribeToTopic("all");

        new Thread(() -> {
            try {
                sleep(2000);
                if (session.isLoggedIn()) {
                    startActivity(new Intent(SplashActivity.this, DoctorWelcomeActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, DoctorWelcomeActivity.class));

                }
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}