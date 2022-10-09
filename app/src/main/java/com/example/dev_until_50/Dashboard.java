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
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.Console;

public class Dashboard extends AppCompatActivity {

    FloatingActionButton add_project_fab;
    GoogleSignInClient mGoogleSignInClient;

    DrawerLayout drawer_layout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    FirebaseAuth mAuth;


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
        Log.d("Hello",currentUser.getDisplayName());


        add_project_fab=findViewById(R.id.add_project_fab);
        drawer_layout=findViewById(R.id.drawer_layout);

        navigationView =findViewById(R.id.nav_view);
        View headerView=navigationView.getHeaderView(0);
        TextView name=(TextView)headerView.findViewById(R.id.nav_name_txt);
        name.setText(currentUser.getDisplayName());

        drawerToggle=new ActionBarDrawerToggle(this,drawer_layout,R.string.open,R.string.close);
        drawer_layout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Glide.with(this).load(currentUser.getPhotoUrl().toString())
                .placeholder(R.drawable.avatar)
                .into((ImageView) headerView.findViewById(R.id.nav_dp));

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.all_project:
                        Intent ap=new Intent(Dashboard.this,all_projects.class);
                        startActivity(ap);

                    case R.id.pending:
                        Intent pendingint=new Intent(Dashboard.this,pending.class);
                        startActivity(pendingint);

                    case R.id.Logout:
                        Log.d("Hello","Logged out clicked");

                }
                return false;
            }
        });

        add_project_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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