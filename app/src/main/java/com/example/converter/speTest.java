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

public class speTest extends AppCompatActivity {

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
        t.setText(R.string.speed);
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        String[] items = new String[]{"mps","kmph","mph","ft/s"};
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
                    Toast.makeText(speTest.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    vibe.vibrate(100);
                }
                else{
                    double i= Double.parseDouble(input.getText().toString());
                    double o= Double.parseDouble(output.getText().toString());
                    double ans = 0;
                    if(d1==d2 ){
                        if(i==o){
                            Toast.makeText(speTest.this,"Correct",Toast.LENGTH_SHORT).show();
                            v.setBackgroundColor(Color.GREEN);
                        }else{
                            Toast.makeText(speTest.this,"Wrong, Right answer is: "+i,Toast.LENGTH_LONG).show();
                            v.setBackgroundColor(Color.RED);
                            vibe.vibrate(1000);
                        }
                    }else{
                        if(d1.equals("mps") && d2.equals("kmph")){
                            ans=i*3.6;
                        }
                        else if(d1.equals("mps") && d2.equals("mph")){
                            ans=i*2.23694;
                        }
                        else if(d1.equals("mps") && d2.equals("ft/s")){
                            ans=i*3.28084;
                        }
                        else if(d1.equals("kmph") && d2.equals("mps")){
                            ans=i*0.2778;
                        }
                        else if(d1.equals("kmph") && d2.equals("mph")){
                            ans=i*0.621371;
                        }
                        else if(d1.equals("kmph") && d2.equals("ft/s")){
                            ans=i*0.911344;
                        }
                        else if(d1.equals("mph") && d2.equals("mps")){
                            ans= i*0.44704;
                        }
                        else if(d1.equals("mph") && d2.equals("kmph")){
                            ans=i*0.60934;
                        }
                        else if(d1.equals("mph") && d2.equals("ft/s")){
                            ans=i*1.46667;
                        }
                        else if(d1.equals("ft/s") && d2.equals("mps")){
                            ans=i*0.3048;
                        }
                        else if(d1.equals("ft/s") && d2.equals("kmph")){
                            ans=i*1.09728;
                        }
                        else {
                            ans=i*0.6818;
                        }
                        if(ans ==o){
                            Toast.makeText(speTest.this,"Correct",Toast.LENGTH_SHORT).show();
                            v.setBackgroundColor(Color.GREEN);
                        }
                        else{
                            Toast.makeText(speTest.this,"Wrong,Right answer is: "+ans,Toast.LENGTH_LONG).show();
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