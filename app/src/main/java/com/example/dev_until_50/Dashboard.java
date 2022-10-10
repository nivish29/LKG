package com.example.dev_until_50;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.io.Console;

public class Dashboard extends AppCompatActivity {

    FloatingActionButton add_project_fab;
    GoogleSignInClient mGoogleSignInClient;

    ImageView nav_dp_header;

    DrawerLayout drawer_layout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    FirebaseAuth mAuth;

    FirebaseDatabase database;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);




        mAuth=FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        FirebaseUser user=mAuth.getCurrentUser();
        Log.d("Hello",user.getDisplayName());
        add_project_fab=findViewById(R.id.add_project_fab);
        drawer_layout=findViewById(R.id.drawer_layout);


        drawerToggle=new ActionBarDrawerToggle(this,drawer_layout,R.string.open,R.string.close);
        drawer_layout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigationView =findViewById(R.id.nav_view);
        View headerView=navigationView.getHeaderView(0);

        nav_dp_header=(ImageView)headerView.findViewById(R.id.nav_dp_header);

        TextView name=(TextView)headerView.findViewById(R.id.nav_name_txt);
        name.setText(currentUser.getDisplayName());
        try {
        Glide.with(this).load(currentUser.getPhotoUrl().toString())
                .placeholder(R.drawable.avatar)
                .into((ImageView) headerView.findViewById(R.id.nav_dp_header));
        }
        catch (Exception e){
            Log.d("Hello","Image error");
        }

        nav_dp_header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Hello","1");
                Intent khuljasimsim=new Intent(Dashboard.this,Account_info.class);
                startActivity(khuljasimsim);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.all_project:
                        Intent ap=new Intent(Dashboard.this,project_after.class);
                        startActivity(ap);

                    case R.id.pending:
                        Intent pendingint=new Intent(Dashboard.this,pending.class);
                        startActivity(pendingint);

                    case R.id.Logout:
                        Log.d("Hello","Signed out");


                }
                return false;
            }
        });

        Intent prdetails = new Intent(this,project_details.class);
        add_project_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(prdetails);
            }

        });

    }

    @Override
    public void onBackPressed() {
        if(drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }


}