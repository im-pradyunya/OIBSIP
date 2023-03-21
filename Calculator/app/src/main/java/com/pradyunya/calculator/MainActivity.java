package com.pradyunya.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    String data="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        TextView inp=findViewById(R.id.inp);
        TextView res=findViewById(R.id.res);
        MaterialButton b0=findViewById(R.id.b0);
        MaterialButton b1=findViewById(R.id.b1);
        MaterialButton b2=findViewById(R.id.b2);
        MaterialButton b3=findViewById(R.id.b3);
        MaterialButton b4=findViewById(R.id.b4);
        MaterialButton b5=findViewById(R.id.b5);
        MaterialButton b6=findViewById(R.id.b6);
        MaterialButton b7=findViewById(R.id.b7);
        MaterialButton b8=findViewById(R.id.b8);
        MaterialButton b9=findViewById(R.id.b9);
        MaterialButton dot=findViewById(R.id.point);

        MaterialButton add=findViewById(R.id.add);
        MaterialButton sub=findViewById(R.id.sub);
        MaterialButton mul=findViewById(R.id.mul);
        MaterialButton div=findViewById(R.id.div);
        MaterialButton mod=findViewById(R.id.modulo);

        MaterialButton c =findViewById(R.id.clear);
        MaterialButton back=findViewById(R.id.back);
        MaterialButton ac=findViewById(R.id.all_clear);
        MaterialButton equal=findViewById(R.id.equal);
        b0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                data=inp.getText().toString();
                inp.setText(data+"0");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inp.getText().toString();
                inp.setText(data+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inp.getText().toString();
                inp.setText(data+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inp.getText().toString();
                inp.setText(data+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inp.getText().toString();
                inp.setText(data+"4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inp.getText().toString();
                inp.setText(data+"5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inp.getText().toString();
                inp.setText(data+"6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inp.getText().toString();
                inp.setText(data+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inp.getText().toString();
                inp.setText(data+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inp.getText().toString();
                inp.setText(data+"9");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inp.getText().toString();
                inp.setText(data+"0.");
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inp.setText("");
                res.setText("");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inp.getText().toString();
                if (data.matches(".*[+\\-*/%]$"))
                {
                    data = data+null;
                }
                else
                {
                    inp.setText(data+"+");
                }

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inp.getText().toString();
                if (data.matches(".*[+\\-*/%]$"))
                {
                    data = data+null;
                }
                else
                {
                    inp.setText(data+"-");
                }

            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inp.getText().toString();
                if (data.matches(".*[+\\-*/%]$"))
                {
                    data = data+null;
                }
                else
                {
                    inp.setText(data+"*");
                }


            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inp.getText().toString();
                if (data.matches(".*[+\\-*/%]$"))
                {
                    data = data+null;
                }
                else
                {
                    inp.setText(data+"/");
                }


            }
        });
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inp.getText().toString();
                if (data.matches(".*[+\\-*/%]$"))
                {
                    data = data+null;
                }
                else
                {
                    inp.setText(data+"%");
                }

            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                data=inp.getText().toString();
                if (data.matches(".*[+\\-*/%]$")) {

                    data = data.substring(0, data.length() - 1);
                    if(data.equals(""))
                    {
                        inp.setText("0");
                        data="0";
                    }
                }

            if(data.equals(""))
            {
                inp.setText("0");
                data="0";
            }
            if(data.matches("^[-+*/%].*"))
            {
                data="0"+data;
                inp.setText(data);
            }

            data=data.replaceAll("×","*");
                data=data.replaceAll("%","/100");
                data=data.replaceAll("÷","/");

                Context rhino=Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult;

                Scriptable sb=rhino.initStandardObjects();
                finalResult=rhino.evaluateString(sb,data,"Javascript",1,null).toString();


           res.setText(finalResult);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inp.getText().toString();
                if (data.length() > 0) {
                   data = data.substring(0, data.length() - 1);
                    inp.setText(data);
                }
            }
        });
       c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inp.setText("");

            }
        });

    }



}