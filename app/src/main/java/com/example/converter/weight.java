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

public class weight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common);
        Spinner s1 = findViewById(R.id.spinner1);
        Spinner s2= findViewById(R.id.spinner2);
        Button b = findViewById(R.id.convert);
        EditText input= findViewById(R.id.input);
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        TextView answer= findViewById(R.id.answer);
        TextView t= findViewById(R.id.property);
        t.setText("Weight");
        String[] items = new String[]{"kilogram","gram","pound"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        s1.setAdapter(adapter);
        s2.setAdapter(adapter);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String d1 = s1.getSelectedItem().toString();
                String d2 = s2.getSelectedItem().toString();

                if(input.getText().toString().matches(".*[a-zA-Z]+.*")){
                    Toast.makeText(weight.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    vibe.vibrate(100);
                }
                else {
                    double i= Double.parseDouble(input.getText().toString());
                    if (d1 == d2) {
                        answer.setText(String.valueOf(i));
                    } else if (d1.equals("kilogram") && d2.equals("gram")) {
                        answer.setText(String.valueOf(i*1000));
                    } else if (d1.equals("kilogram") && d2.equals("pound")) {
                        answer.setText(String.valueOf(i*2.205));
                    } else if (d1.equals("gram") && d2.equals("kilogram")) {
                        answer.setText(String.valueOf(i*0.001));
                    } else if (d1.equals("gram") && d2.equals("pound")) {
                        answer.setText(String.valueOf(i*0.00220462));
                    } else if (d1.equals("pound") && d2.equals("kilogram")) {
                        answer.setText(String.valueOf(i*0.453592));
                    } else if (d1.equals("pound") && d2.equals("gram")) {
                        answer.setText(String.valueOf(i*453.592));
                    }
                    Toast.makeText(weight.this, "Valid input", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void test(View view) {
        Intent i1 = new Intent(this,weiTest.class);
        startActivity(i1);
    }
}