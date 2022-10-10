package com.example.dev_until_50;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Account_info extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        mAuth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        EditText name=findViewById(R.id.info_change_name);
        EditText phone=findViewById(R.id.info_phone_change);
        EditText email=findViewById(R.id.info_email);
        name.setText(currentUser.getDisplayName());
        email.setText(currentUser.getEmail());
        phone.setText(currentUser.getPhoneNumber());

        Glide.with(this).load(currentUser.getPhotoUrl().toString())
                .placeholder(R.drawable.avatar)
                .into((ImageView) findViewById(R.id.nav_dp));

        Button update_data=findViewById(R.id.Update_data);
        update_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Users user=new Users();
                user.setUserId(currentUser.getUid());
                user.setName(name.getText().toString());
                user.setEmailid(email.getText().toString());
                user.setPhone_number(phone.getText().toString());
                database.getReference().child("Users").child(currentUser.getUid()).setValue(user);
            }
        });
    }
}