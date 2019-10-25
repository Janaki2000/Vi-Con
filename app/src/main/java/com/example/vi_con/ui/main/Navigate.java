package com.example.vi_con.ui.main;

import android.os.Bundle;

import com.example.vi_con.R;
import com.example.vi_con.ui.main.ui.tools.aboutFragment;
import com.example.vi_con.ui.main.ui.tools.addFragment;
import com.example.vi_con.ui.main.ui.tools.askAdminFragment;
import com.example.vi_con.ui.main.ui.tools.callFragment;
import com.example.vi_con.ui.main.ui.tools.helpFragment;
import com.example.vi_con.ui.main.ui.tools.historyFragment;
import com.example.vi_con.ui.main.ui.tools.settingsFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class Navigate extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        drawer.requestLayout();
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.bringToFront();
        // Passin        // menu should be considered as top level destinations.g each menu ID as a set of Ids because each
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_call_message, R.id.nav_history, R.id.nav_add_student,
                R.id.nav_settings, R.id.nav_ask_admin, R.id.nav_help,R.id.nav_about)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigate, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
