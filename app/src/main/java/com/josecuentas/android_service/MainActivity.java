package com.josecuentas.android_service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MainView{

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.butStartService).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Log.i(TAG, "onClick");
                Intent intent = new Intent(MainActivity.this, MessageService.class);
                startService(intent);
            }
        });

        findViewById(R.id.butStopService).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Log.i(TAG, "onClick");
                Intent intent = new Intent(MainActivity.this, MessageService.class);
                stopService(intent);
            }
        });


    }

    @Override protected void onPause() {
        super.onPause();
    }

    @Override public void showMessage(int number) {

    }
}
