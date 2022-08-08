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

public class speed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common);
        Spinner s1 = findViewById(R.id.spinner1);
        Spinner s2= findViewById(R.id.spinner2);
        Button b = findViewById(R.id.convert);
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        EditText input= findViewById(R.id.input);
        TextView answer= findViewById(R.id.answer);
        TextView t= findViewById(R.id.property);
        t.setText("Speed");
        String[] items = new String[]{"mps","kmph","mph","ft/s"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        s1.setAdapter(adapter);
        s2.setAdapter(adapter);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String d1 = s1.getSelectedItem().toString();
                String d2 = s2.getSelectedItem().toString();

                if(input.getText().toString().matches(".*[a-zA-Z]+.*")){
                    Toast.makeText(speed.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    vibe.vibrate(100);
                }
                else {
                    double i= Double.parseDouble(input.getText().toString());
                    if (d1 == d2) {
                        answer.setText(String.valueOf(i));
                    } else if (d1.equals("mps") && d2.equals("kmph")) {
                        answer.setText(String.valueOf(i*3.6));
                    } else if (d1.equals("mps") && d2.equals("mph")) {
                        answer.setText(String.valueOf(i*2.23694));
                    } else if (d1.equals("mps") && d2.equals("ft/s")) {
                        answer.setText(String.valueOf(i*3.28084));
                    } else if (d1.equals("kmph") && d2.equals("mps")) {
                        answer.setText(String.valueOf(i*0.2778));
                    } else if (d1.equals("kmph") && d2.equals("mph")) {
                        answer.setText(String.valueOf(i*0.621371));
                    }else if (d1.equals("kmph") && d2.equals("ft/s")) {
                        answer.setText(String.valueOf(i*0.911344));
                    } else if (d1.equals("mph") && d2.equals("mps")) {
                        answer.setText(String.valueOf(i*0.44704));
                    }else if (d1.equals("mph") && d2.equals("kmph")) {
                        answer.setText(String.valueOf(i*1.60934));
                    }else if (d1.equals("mph") && d2.equals("ft/s")) {
                        answer.setText(String.valueOf(i*1.46667));
                    }else if (d1.equals("ft/s") && d2.equals("kmph")) {
                        answer.setText(String.valueOf(i*1.09728));
                    }else if (d1.equals("ft/s") && d2.equals("mph")) {
                        answer.setText(String.valueOf(i*0.6818));
                    }else if (d1.equals("ft/s") && d2.equals("mps")) {
                        answer.setText(String.valueOf(i*0.3048));
                    }
                    Toast.makeText(speed.this, "Valid input", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void test(View view) {
        Intent i1 = new Intent(this,speTest.class);
        startActivity(i1);
    }
}