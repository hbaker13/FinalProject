package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void showNotification(View view) {
        Intent in = new Intent(this, NotificationActivity.class);
        startActivity(in);
    }

    public void showSetTime(View view) {
        Intent ist = new Intent(this, SetTimeActivity.class);
        startActivity(ist);
    }

    public void showBacksound(View view) {
        Intent ibs = new Intent(this, BacksoundActivity.class);
        startActivity(ibs);
    }
}
