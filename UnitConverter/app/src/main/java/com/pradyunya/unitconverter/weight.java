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

public class weight extends AppCompatActivity {
    EditText in;
    TextView res;
    Button calcu;
    float inputNumber;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        in=findViewById(R.id.inp);
        res=findViewById(R.id.res);
        ArrayList<String> weight = new ArrayList<>();
        weight.add("Select");
        weight.add("Kilogram");
        weight.add("Gram");
        weight.add("Milligram");
        weight.add("Pound");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, weight);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner option = findViewById(R.id.option);
        option.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, weight);
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

                    if (selectedItem1.equals("Kilogram") && selectedItem2.equals("Gram"))
                    {


                        res.setText(inputNumber+" kg is equal to "+inputNumber*1000+"g");

                    }

                    else if (selectedItem1.equals("Gram") && selectedItem2.equals("Kilogram"))
                    {

                        res.setText(inputNumber+"g is equal to "+inputNumber/1000+" kg");

                    }
                    else if (selectedItem1.equals("Kilogram") && selectedItem2.equals("Milligram"))
                    {

                        res.setText(inputNumber+"kg is equal to "+inputNumber*1000000+" milligram");

                    }
                    else if (selectedItem1.equals("Milligram") && selectedItem2.equals("Kilogram"))
                    {

                        res.setText(inputNumber+" milligram is equal to "+inputNumber/1000000+"km");

                    }
                    else if (selectedItem1.equals("Kilogram") && selectedItem2.equals("Pound"))
                    {

                        res.setText(inputNumber+"km is equal to "+inputNumber*2.20462+" pounds");

                    }

                    else if (selectedItem1.equals("Pound") && selectedItem2.equals("Kilogram"))
                    {


                        res.setText(inputNumber+" pounds is equal to "+inputNumber/2.20462+"kg");

                    }

                    else if (selectedItem1.equals("Gram") && selectedItem2.equals("Milligram"))
                    {

                        res.setText(inputNumber+"g is equal to "+inputNumber*1000+" milligram");

                    }

                    else if (selectedItem1.equals("Milligram") && selectedItem2.equals("Gram"))
                    {


                        res.setText(inputNumber+" milligram is equal to "+inputNumber/1000+"g");

                    }

                    else if (selectedItem1.equals("Gram") && selectedItem2.equals("Pound"))
                    {


                        res.setText(inputNumber+"g is equal to "+inputNumber*0.00220462+" pounds");

                    }

                    else if (selectedItem1.equals("Pound") && selectedItem2.equals("Gram"))
                    {


                        res.setText(inputNumber+" pounds is equal to "+inputNumber*453.592 +"g");

                    }
                    else if (selectedItem1.equals("Milligram") && selectedItem2.equals("Pound"))
                    {


                        res.setText(inputNumber+" milligram is equal to "+inputNumber/453592.37+" pounds");

                    }
                    else if (selectedItem1.equals("Pound") && selectedItem2.equals("Milligram"))
                    {


                        res.setText(inputNumber+"pounds is equal to "+inputNumber*453592.37+" milligram");

                    }

                    res.setTextColor(ContextCompat.getColor(weight.this, R.color.colorAccent));
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