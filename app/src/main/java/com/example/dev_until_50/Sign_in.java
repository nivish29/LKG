package com.example.dev_until_50;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Sign_in extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText email_edt,pass_edt;
    Intent dashboar_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Log.d("Hello","1");
        mAuth = FirebaseAuth.getInstance();

        dashboar_activity=new Intent(this,Dashboard.class);
        email_edt=findViewById(R.id.email_in);
        pass_edt=findViewById(R.id.password_in);

        Button btn=findViewById(R.id.signin_btn);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String email=email_edt.getText().toString();
                        String password=pass_edt.getText().toString();

                        signIn(email,password);
                    }
                });

    }
    public void signIn(String email,String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Hello", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(dashboar_activity);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Hello", "signInWithEmail:failure", task.getException());
                            Toast.makeText(Sign_in.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }
}