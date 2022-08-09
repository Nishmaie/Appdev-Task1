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

public class weiTest extends AppCompatActivity {

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
        t.setText(R.string.weight);
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        String[] items = new String[]{"kilogram","gram","pound"};
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
                    Toast.makeText(weiTest.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    vibe.vibrate(100);
                }
                else{
                    double i= Double.parseDouble(input.getText().toString());
                    double o= Double.parseDouble(output.getText().toString());
                    double ans =0;
                    if(d1==d2 ){
                        if(i==o){
                            Toast.makeText(weiTest.this,"Correct",Toast.LENGTH_SHORT).show();
                            v.setBackgroundColor(Color.GREEN);
                        }else{
                            Toast.makeText(weiTest.this,"Wrong, Right answer is: "+i,Toast.LENGTH_LONG).show();
                            v.setBackgroundColor(Color.RED);
                            vibe.vibrate(1000);
                        }
                    }else{
                        if(d1.equals("kilogram") && d2.equals("gram")){
                            ans=i*1000;
                        }
                        else if(d1.equals("kilogram") && d2.equals("pound")){
                            ans=i*2.205;
                        }
                        else if(d1.equals("gram") && d2.equals("kilogram")){
                            ans=i*0.001;
                        }
                        else if(d1.equals("gram") && d2.equals("pound")){
                            ans=i*0.00220462;
                        }
                        else if(d1.equals("pound") && d2.equals("kilogram")){
                            ans=i*0.453592;
                        }
                        else {
                            ans=i*453.592;
                        }
                        if(ans==o){
                            Toast.makeText(weiTest.this,"Correct",Toast.LENGTH_SHORT).show();
                            v.setBackgroundColor(Color.GREEN);
                        }
                        else{
                            Toast.makeText(weiTest.this,"Wrong,Right answer is: "+ans,Toast.LENGTH_LONG).show();
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
