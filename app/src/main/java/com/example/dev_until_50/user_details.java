package com.example.dev_until_50;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class user_details extends AppCompatActivity {

    AppCompatButton signup_btn,googlesignup_btn;
    EditText email_edt,firstname_edt,lastname_edt,phonenumber_edt,password_edt,cpassword_edt;
    TextView login_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
}