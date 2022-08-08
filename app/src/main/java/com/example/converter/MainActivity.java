package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView temperature=(CardView) findViewById(R.id.Temperature);
        CardView length=(CardView) findViewById(R.id.Length);
        CardView weight=(CardView) findViewById(R.id.Weight);
        CardView speed=(CardView) findViewById(R.id.Speed);

        temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,temp.class);
                startActivity(i);
            }
        });
        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,length.class);
                startActivity(i);
            }
        });
        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,weight.class);
                startActivity(i);
            }
        });
        speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,speed.class);
                startActivity(i);
            }
        });
    }
}