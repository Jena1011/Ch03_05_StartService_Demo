package com.demo.android.ch03_05_startservice_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt_start_service, bt_stop_service;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_start_service = findViewById(R.id.bt_start_service);
        bt_stop_service = findViewById(R.id.bt_stop_service);

        bt_start_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,MyService.class);
                intent.putExtra("counter",Math.random()*9+1);
                startService(intent);
            }
        });

        bt_stop_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });

    }
}