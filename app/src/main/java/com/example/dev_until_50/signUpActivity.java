package com.example.dev_until_50;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

public class signUpActivity extends AppCompatActivity {

    GoogleSignInClient mGoogleSignInClient;
    FirebaseAuth auth;
    Button googlesignup_btn;
    FirebaseDatabase database;
    Intent kuchbhi;

    EditText email_edt,first_name,last_name,phone_edt,pass_edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextView login_btn=findViewById(R.id.login_txt);
        Intent login_page=new Intent(this,Sign_in.class);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(login_page);
            }
        });

        kuchbhi = new Intent(signUpActivity.this,Dashboard.class);

        email_edt=findViewById(R.id.email_edt);
        pass_edt=findViewById(R.id.password_edt);
        googlesignup_btn = findViewById(R.id.googlesignup_btn);

        googlesignup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        Button btn2=findViewById(R.id.signup_btn);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sign_up();
            }
        });
        getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    int RC_SIGN_IN = 65;

    public void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {

            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user =auth.getCurrentUser();
                            Users users = new Users();
                            users.setUserId(user.getUid());
                            users.setName(user.getDisplayName());
                            users.setEmailid(user.getEmail());
                            users.setPhone_number(users.getPhone_number());
                            users.setDp(user.getPhotoUrl().toString());
                            startActivity(kuchbhi);
                            database.getReference().child("Users").child(user.getUid()).setValue(users);
                        }
                        else {

                        }
                    }
                });

    }
    public void signOut() {

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(this, gso);
        googleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Log.d("Hello","Signed_out");
                    }
                });
    }

    public void sign_up(){


        String email=email_edt.getText().toString();
        String password=pass_edt.getText().toString();

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()) {
                            email_edt=findViewById(R.id.email_edt);
                            first_name=findViewById(R.id.firstname_edt);
                            last_name=findViewById(R.id.lastname_edt);
                            phone_edt=findViewById(R.id.phonenumber_edt);
                            pass_edt=findViewById(R.id.password_edt);



                            Users users = new Users();
                            users.setUserId(first_name.getText().toString()+last_name.getText().toString()+phone_edt.getText().toString());
                            users.setName(first_name.getText().toString()+last_name.getText().toString());
                            users.setEmailid(first_name.getText().toString()+last_name.getText().toString());
                            users.setPhone_number(phone_edt.getText().toString());
                            Log.d("Hello",database.getReference().child("users").child("name").get().toString());
                            database.getReference().child("Users").child(users.getUserId()).setValue(users);

                        } else {
                            startActivity(kuchbhi);
                            finish();
                        }
                    }
                });
    }
}
