package com.pradyunya.resolver.drawer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.navigation.NavigationView;
import com.pradyunya.resolver.Database;
import com.pradyunya.resolver.Item;
import com.pradyunya.resolver.MainActivity;
import com.pradyunya.resolver.MyAdapter;
import com.pradyunya.resolver.R;
import com.pradyunya.resolver.Task;
import com.pradyunya.resolver.update_profile;

import java.util.Objects;


public class Home extends AppCompatActivity {
Toolbar tb;
NavigationView nv;
public DrawerLayout dl;
TextView name,mail;
String email=null,nm=null;
ActionBarDrawerToggle toggle;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        tb=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        nv=findViewById(R.id.navigation_view);
        dl=findViewById(R.id.drawer);
        toggle=new ActionBarDrawerToggle(this,dl,tb,R.string.open,R.string.close);
        dl.addDrawerListener(toggle);
        toggle.syncState();
       name=findViewById(R.id.raj);
        mail=findViewById(R.id.mail);

        Intent intent = getIntent();
        email = intent.getStringExtra("email");



        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                        Toast.makeText(Home.this,"List",Toast.LENGTH_SHORT).show();
                        dl.closeDrawer(GravityCompat.START);
                        break;


                    case R.id.task:
                        Toast.makeText(Home.this,"Home",Toast.LENGTH_SHORT).show();

                        Intent i=new Intent(Home.this, Task.class);
                        i.putExtra("email",email);
                        startActivity(i);

                        break;

                    case R.id.profile:

                        Intent intnt= new Intent(Home.this, update_profile.class);
                        startActivity(intnt);
                        intnt.putExtra("email",email);
                        dl.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.logout:
                        Intent j=new Intent(Home.this, MainActivity.class);
                        startActivity(j);
                        Toast.makeText(Home.this,"Logout Successfully",Toast.LENGTH_SHORT).show();
                        dl.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {

        if (getClass().equals(Home.class)) {
            finishAffinity();
        } else {
            super.onBackPressed();
        }
    }
}