package com.pradyunya.resolver;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pradyunya.resolver.drawer.Home;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    EditText email,pw;
    Button login;
String name=null;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1= findViewById(R.id.register);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Register.class);
                startActivity(i);
            }

        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");
        }

        Database db = new Database(this);
        SQLiteDatabase sq= db.getReadableDatabase();
        email= findViewById(R.id.email);
        pw= findViewById(R.id.pw);
        login= findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals("") || pw.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Enter all fields",Toast.LENGTH_LONG).show();
                }
                else
                {
                    boolean i= db.verify_login(email.getText().toString(),pw.getText().toString());
                    if(i)
                    {
                        Toast.makeText(MainActivity.this,"Login successfully",Toast.LENGTH_SHORT).show();
                        email.setText("");
                        pw.setText("");
                        Intent j= new Intent(MainActivity.this, Home.class);
                        j.putExtra("email", email.getText().toString());
                        j.putExtra("name", name);
                        startActivity(j);


                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Invalid Input",Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
    }
    @Override
    public void onBackPressed() {

        if (getClass().equals(MainActivity.class)) {
            finishAffinity();
        } else {
            super.onBackPressed();
        }
    }

}