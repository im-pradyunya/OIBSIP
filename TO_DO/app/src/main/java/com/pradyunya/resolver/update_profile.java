package com.pradyunya.resolver;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pradyunya.resolver.drawer.Home;

import java.util.Objects;

public class update_profile extends Home {
EditText old,nev,nm;
Button updt;
String email;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater li=LayoutInflater.from(this);
        View v=li.inflate(R.layout.activity_update_profile,null,false);
        dl.addView(v,1);
        Database db = new Database(this);
        SQLiteDatabase sq= db.getReadableDatabase();
        old= findViewById(R.id.old);
        nev=findViewById(R.id.ne);
        nm=findViewById(R.id.nm);
        updt=findViewById(R.id.bu);

        Intent intent = getIntent();
        email  = intent.getStringExtra("email");

email="ashokbhau53@gmail.com";
        updt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(old.getText().toString().equals("") || nev.getText().toString().equals("") || nm.getText().toString().equals(""))
                {
                    Toast.makeText(update_profile.this,"Enter all fields",Toast.LENGTH_LONG).show();
                }
                else
                {
                    boolean i= db.change_profile(email,old.getText().toString(),nev.getText().toString(),nm.getText().toString());
                    if(i)
                    {


                        Toast.makeText(update_profile.this,"updated",Toast.LENGTH_LONG).show();


                    }
                    else
                    {
                        Toast.makeText(update_profile.this,"Invalid Input",Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
    }
}