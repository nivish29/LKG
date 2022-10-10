package com.example.dev_until_50;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Account_info extends AppCompatActivity {
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        mAuth=FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        EditText name=findViewById(R.id.info_change_name);
        EditText phone=findViewById(R.id.info_phone_change);
        EditText email=findViewById(R.id.info_email);
        name.setText(currentUser.getDisplayName());
        phone.setText(currentUser.getPhoneNumber());
        email.setText(currentUser.getEmail());
    }
}