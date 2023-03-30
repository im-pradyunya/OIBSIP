package com.pradyunya.resolver;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Register extends AppCompatActivity {
    EditText email,name,password,cp;
    Button reg;
    TextView log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Database db = new Database(this);
        email= findViewById(R.id.email);
        name= findViewById(R.id.app_name);
        password= findViewById(R.id.pw);
        cp=findViewById(R.id.cpw);
        reg= findViewById(R.id.register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals("") || name.getText().toString().equals("") || password.getText().toString().equals("") )
                {
                    Toast.makeText(Register.this,"Enter all fields",Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(!email.getText().toString().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"))
                    {
                        Toast.makeText(Register.this,"Enter Valid Email ID",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Boolean i=    db.insert_data(email.getText().toString(),name.getText().toString(),password.getText().toString());
                        if(i)
                        {
                            Toast.makeText(Register.this,"Registered successfully",Toast.LENGTH_SHORT).show();
                            email.setText("");
                            name.setText("");
                            password.setText("");
                            cp.setText("");
                            Intent j= new Intent(Register.this,MainActivity.class);
                            j.putExtra("name", name.getText().toString());

                            startActivity(j);
                        }
                        else
                        {
                            Toast.makeText(Register.this,"failed",Toast.LENGTH_LONG).show();

                        }
                    }

                }
            }
        });
        log= findViewById(R.id.log);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j= new Intent(Register.this,MainActivity.class);
                startActivity(j);
            }
        });

    }
}