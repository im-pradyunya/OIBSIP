package com.pradyunya.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class temperature extends AppCompatActivity {
    EditText in;
    TextView res;
    Button calcu;
    float inputNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        in=findViewById(R.id.inp);
        res=findViewById(R.id.res);
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Select");
        temp.add("Celsius");
        temp.add("Fahrenheit");
        temp.add("Kelvin");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, temp);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner option = findViewById(R.id.option);
        option.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, temp);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner convo = findViewById(R.id.Convert);
        convo.setAdapter(adapter2);

        calcu= findViewById(R.id.b1);
        calcu.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String selectedItem1 = option.getSelectedItem().toString();
                String selectedItem2 = convo.getSelectedItem().toString();
                String inputString = in.getText().toString().trim();
                if (!inputString.equals("") && inputString.matches("^-?\\d+(\\.\\d+)?$"))
                {
                    inputNumber = Float.parseFloat(inputString);

                    if (selectedItem1.equals("Celsius") && selectedItem2.equals("Fahrenheit"))
                    {


                        res.setText(inputNumber+"°C is equal to "+((inputNumber*9/5)+32) +"°F");

                    }

                    else if (selectedItem1.equals("Fahrenheit") && selectedItem2.equals("Celsius"))
                    {

                        res.setText(inputNumber+"°F is equal to "+((inputNumber-32)*5/9) +"°C");

                    }
                    else if (selectedItem1.equals("Celsius") && selectedItem2.equals("Kelvin"))
                    {

                        res.setText(inputNumber+"°C is equal to "+(inputNumber+273.15)+"K");

                    }
                    else if (selectedItem1.equals("Kelvin") && selectedItem2.equals("Celsius"))
                    {

                        res.setText(inputNumber+"K is equal to "+(inputNumber-273.15)+"°C");

                    }
                    else if (selectedItem1.equals("Fahrenheit") && selectedItem2.equals("Kelvin"))
                    {

                        res.setText(inputNumber+"°F is equal to "+(((inputNumber-32)*5/9)+273.15)+"K");

                    }

                    else if (selectedItem1.equals("Kelvin") && selectedItem2.equals("Fahrenheit"))
                    {


                        res.setText(inputNumber+"K is equal to "+(((inputNumber-273.15)*9/5)+32)+"°F");

                    }



                    res.setTextColor(ContextCompat.getColor(temperature.this, R.color.colorAccent));
                }
                else
                {
                    if(inputString.equals(""))
                    {
                        res.setText("Please Enter Number");

                    }
                    else
                    {
                        res.setText("Please Enter Valid number");

                    }

                    res.setTextColor(Color.RED);
                }





            }
        });
    }
}