package com.example.dev_until_50;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {

    FloatingActionButton add_project_fab;

    DrawerLayout drawer_layout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        add_project_fab=findViewById(R.id.add_project_fab);
        drawer_layout=findViewById(R.id.drawer_layout);
        navigationView =findViewById(R.id.nav_view);
        drawerToggle=new ActionBarDrawerToggle(this,drawer_layout,R.string.open,R.string.close);
        drawer_layout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
                        signInActivity ok=new signInActivity();
                        ok.signout();
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
}