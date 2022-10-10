package com.example.dev_until_50;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Firebase_Activity extends AppCompatActivity {

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        mAuth=FirebaseAuth.getInstance();
        Handler handler = new Handler();
        Intent Dashboard_intent = new Intent(this, Dashboard.class);
        Intent Sign_up_intent=new Intent(this, signUpActivity.class);
        FirebaseUser currentUser = mAuth.getCurrentUser();
        getSupportActionBar().hide();
        handler.postDelayed(new Runnable() {
            // check if user already logged in or not
            public void run() {

                    if (currentUser!= null) {
                        Log.d("Hello", "Logged in");
                        startActivity(Dashboard_intent);
                        finish();
                    } else {
                        Log.d("Hello", "Not Logged in");
                        startActivity(Sign_up_intent);
                        finish();
                    }

            }
        }, 2000);
    }
}