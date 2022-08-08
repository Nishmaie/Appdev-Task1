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

public class length extends AppCompatActivity {

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
        t.setText("Length");
        String[] items = new String[]{"meter","centimeter","kilometer","foot"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        s1.setAdapter(adapter);
        s2.setAdapter(adapter);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String d1 = s1.getSelectedItem().toString();
                String d2 = s2.getSelectedItem().toString();

                if(input.getText().toString().matches(".*[a-zA-Z]+.*")){
                    Toast.makeText(length.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    vibe.vibrate(100);
                }
                else {
                    double i= Double.parseDouble(input.getText().toString());
                    if (d1 == d2) {
                        answer.setText(String.valueOf(i));
                    } else if (d1.equals("meter") && d2.equals("kilometer")) {
                        answer.setText(String.valueOf(i*0.001));
                    } else if (d1.equals("meter") && d2.equals("centimeter")) {
                        answer.setText(String.valueOf(i*100));
                    } else if (d1.equals("meter") && d2.equals("foot")) {
                        answer.setText(String.valueOf(i*3.28));
                    } else if (d1.equals("centimeter") && d2.equals("meter")) {
                        answer.setText(String.valueOf(i*0.01));
                    } else if (d1.equals("centimeter") && d2.equals("kilometer")) {
                        answer.setText(String.valueOf(i*0.00001));
                    } else if (d1.equals("centimeter") && d2.equals("foot")) {
                        answer.setText(String.valueOf(i*0.0328));
                    }else if (d1.equals("kilometer") && d2.equals("centimeter")) {
                        answer.setText(String.valueOf(i*100000));
                    } else if (d1.equals("kilometer") && d2.equals("meter")) {
                        answer.setText(String.valueOf(i*1000));
                    }else if (d1.equals("kilometer") && d2.equals("foot")) {
                        answer.setText(String.valueOf(i*3280.84));
                    }else if (d1.equals("foot") && d2.equals("centimeter")) {
                        answer.setText(String.valueOf(i*30.48));
                    }else if (d1.equals("foot") && d2.equals("meter")) {
                        answer.setText(String.valueOf(i*0.3048));
                    }else if (d1.equals("foot") && d2.equals("kilometer")) {
                        answer.setText(String.valueOf(i*0.0003048));
                    }
                    Toast.makeText(length.this, "Valid input", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void test(View view) {
        Intent i1 = new Intent(this,lenTest.class);
        startActivity(i1);
    }
}