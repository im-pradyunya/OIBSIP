package com.pradyunya.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class length extends AppCompatActivity {
EditText in;
TextView res;
Button calcu;
float inputNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        in=findViewById(R.id.inp);
        res=findViewById(R.id.res);
        ArrayList<String> length = new ArrayList<>();
        length.add("Select");
        length.add("Kilometers");
        length.add("Meter");
        length.add("Centimeter");
        length.add("millimeter");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, length);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner option = findViewById(R.id.option);
        option.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, length);
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

                  if (selectedItem1.equals("Kilometers") && selectedItem2.equals("Meter"))
                  {


                      res.setText(inputNumber+" km is equal to "+inputNumber*1000+"m");

                  }

                  else if (selectedItem1.equals("Meter") && selectedItem2.equals("Kilometers"))
                  {

                      res.setText(inputNumber+"m is equal to "+inputNumber/1000+" km");

                  }
                  else if (selectedItem1.equals("Kilometers") && selectedItem2.equals("Centimeter"))
                  {

                      res.setText(inputNumber+"km is equal to "+inputNumber*100000+"cm");

                  }
                  else if (selectedItem1.equals("Centimeter") && selectedItem2.equals("Kilometers"))
                  {

                      res.setText(inputNumber+"cm is equal to "+inputNumber/100000+"km");

                  }
                  else if (selectedItem1.equals("Kilometers") && selectedItem2.equals("millimeter"))
                  {

                      res.setText(inputNumber+"km is equal to "+inputNumber*1000000+"mm");

                  }

                  else if (selectedItem1.equals("millimeter") && selectedItem2.equals("Kilometers"))
                  {


                      res.setText(inputNumber+"mm is equal to "+inputNumber/1000000+"km");

                  }

                  else if (selectedItem1.equals("Meter") && selectedItem2.equals("Centimeter"))
                  {

                      res.setText(inputNumber+"m is equal to "+inputNumber*100+"cm");

                  }

                  else if (selectedItem1.equals("Centimeter") && selectedItem2.equals("Meter"))
                  {


                      res.setText(inputNumber+"cm is equal to "+inputNumber/100+"m");

                  }

                  else if (selectedItem1.equals("Meter") && selectedItem2.equals("millimeter"))
                  {


                      res.setText(inputNumber+"m is equal to "+inputNumber*1000+"mm");

                  }

                  else if (selectedItem1.equals("millimeter") && selectedItem2.equals("Meter"))
                  {


                      res.setText(inputNumber+"mm is equal to "+inputNumber/1000+"m");

                  }
                  else if (selectedItem1.equals("Centimeter") && selectedItem2.equals("millimeter"))
                  {


                      res.setText(inputNumber+"cm is equal to "+inputNumber*10+"mm");

                  }
                  else if (selectedItem1.equals("millimeter") && selectedItem2.equals("Centimeter"))
                  {


                      res.setText(inputNumber+"mm is equal to "+inputNumber/10+"cm");

                  }

                  res.setTextColor(ContextCompat.getColor(com.pradyunya.unitconverter.length.this, R.color.colorAccent));
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