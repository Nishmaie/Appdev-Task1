package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class temp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common);
        Spinner s1 = findViewById(R.id.spinner1);
        Spinner s2= findViewById(R.id.spinner2);
        Button b = findViewById(R.id.convert);
        EditText input= findViewById(R.id.input);
        TextView answer= findViewById(R.id.answer);
        TextView t= findViewById(R.id.property);
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        t.setText("Temperature");
        String[] items = new String[]{"celsius","fahrenheit","kelvin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        s1.setAdapter(adapter);
        s2.setAdapter(adapter);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String d1 = s1.getSelectedItem().toString();
                String d2 = s2.getSelectedItem().toString();

                if(input.getText().toString().matches(".*[a-zA-Z]+.*")){
                    Toast.makeText(temp.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    vibe.vibrate(100);
                }
                else {
                    double i= Double.parseDouble(input.getText().toString());
                    if (d1 == d2) {
                        answer.setText(String.valueOf(i));
                    } else if (d1.equals("celsius") && d2.equals("fahrenheit")) {
                        answer.setText(String.valueOf((1.8 * i) + 32));
                    } else if (d1.equals("celsius") && d2.equals("kelvin")) {
                        answer.setText(String.valueOf((i + 273)));
                    } else if (d1.equals("fahrenheit") && d2.equals("celsius")) {
                        answer.setText(String.valueOf((i - 32) * 0.56));
                    } else if (d1.equals("fahrenheit") && d2.equals("kelvin")) {
                        answer.setText(String.valueOf(((i - 32) / 1.8) + 273));
                    } else if (d1.equals("kelvin") && d2.equals("fahrenheit")) {
                        answer.setText(String.valueOf(((1.8 * (i - 273)) + 32)));
                    } else if (d1.equals("kelvin") && d2.equals("celsius")) {
                        answer.setText(String.valueOf((i - 273)));
                    }
                    Toast.makeText(temp.this, "Valid input", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void test(View view) {
        Intent i1 = new Intent(this,Test.class);
        startActivity(i1);
    }

}