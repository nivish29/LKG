package com.example.dev_until_50;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.Console;

public class Firebase_Activity extends AppCompatActivity {

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        mAuth=FirebaseAuth.getInstance();
        Handler handler = new Handler();
        Intent sign_in_intent = new Intent(this, signInActivity.class);
        FirebaseUser currentUser = mAuth.getCurrentUser();

        handler.postDelayed(new Runnable() {
            // check if user already logged in or not
            public void run() {

                    if (currentUser!= null) {
                        Log.d("Hello", "Logged in");

                    } else {
                        Log.d("Hello", "Not Logged in");
                        startActivity(sign_in_intent);
                    }

            }
        }, 2000);
    }
}