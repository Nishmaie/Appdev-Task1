package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class lenTest extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        EditText input = (EditText) findViewById(R.id.input);
        EditText output = (EditText) findViewById(R.id.output);
        Spinner s1 = findViewById(R.id.spinner1);
        Spinner s2= findViewById(R.id.spinner2);
        TextView t= findViewById(R.id.property);
        View v= findViewById(R.id.view);
        t.setText(R.string.length);
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        String[] items = new String[]{"meter","centimeter","kilometer","foot"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        s1.setAdapter(adapter);
        s2.setAdapter(adapter);
        Button verify= findViewById(R.id.verify);
        Button reset= findViewById(R.id.reset);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String d1 = s1.getSelectedItem().toString();
                String d2 = s2.getSelectedItem().toString();


                if(input.getText().toString().matches(".*[a-zA-Z]+.*")||output.getText().toString().matches(".*[a-zA-Z]+.*")){
                    Toast.makeText(lenTest.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    vibe.vibrate(100);
                }
                else{
                    double i= Double.parseDouble(input.getText().toString());
                    double o= Double.parseDouble(output.getText().toString());
                    double ans = 0;
                    if(d1==d2 ){
                        if(i==o){
                            Toast.makeText(lenTest.this,"Correct",Toast.LENGTH_SHORT).show();
                            v.setBackgroundColor(Color.GREEN);
                        }else{
                            Toast.makeText(lenTest.this,"Wrong, Right answer is: "+i,Toast.LENGTH_LONG).show();
                            v.setBackgroundColor(Color.RED);
                            vibe.vibrate(1000);
                        }
                    }else{
                        if(d1.equals("meter") && d2.equals("kilometer")){
                            ans=i*0.001;
                        }
                        else if(d1.equals("meter") && d2.equals("centimeter")){
                            ans=i*100;
                        }
                        else if(d1.equals("meter") && d2.equals("foot")){
                            ans=i*3.28;
                        }
                        else if(d1.equals("centimeter") && d2.equals("meter")){
                            ans=i*0.01;
                        }
                        else if(d1.equals("centimeter") && d2.equals("kilometer")){
                            ans=i*0.00001;
                        }
                        else if(d1.equals("centimeter") && d2.equals("foot")){
                            ans=i*0.0328;
                        }
                        else if(d1.equals("kilometer") && d2.equals("centimeter")){
                            ans= i*100000;
                        }
                        else if(d1.equals("kilometer") && d2.equals("meter")){
                            ans=i*1000;
                        }
                        else if(d1.equals("kilometer") && d2.equals("foot")){
                            ans=i*3280.84;
                        }
                        else if(d1.equals("foot") && d2.equals("centimeter")){
                            ans=i*30.48;
                        }
                        else if(d1.equals("foot") && d2.equals("meter")){
                            ans=i*0.3048;
                        }
                        else {
                            ans=i*0.0003048;
                        }
                        if(ans ==o){
                            Toast.makeText(lenTest.this,"Correct",Toast.LENGTH_SHORT).show();
                            v.setBackgroundColor(Color.GREEN);
                        }
                        else{
                            Toast.makeText(lenTest.this,"Wrong,Right answer is: "+ans,Toast.LENGTH_LONG).show();
                            v.setBackgroundColor(Color.RED);
                            vibe.vibrate(1000);
                        }
                    }
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v.setBackground(null);
                input.getText().clear();
                output.getText().clear();
            }
        });
    }
}