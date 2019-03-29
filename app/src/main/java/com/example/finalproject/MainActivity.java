package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.us:
                Intent intent = new Intent(this, UsActivity.class);
                startActivity(intent);
                return true;
            case R.id.night_mode:
                if(item.getItemId()==R.id.night_mode){
                    int nightMode = AppCompatDelegate.getDefaultNightMode();

                    if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    } else {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    }

                    recreate();

                    return true;
                }
            default:

        }
        return super.onOptionsItemSelected(item);
    }

    public void showWhat(View view) {
        Intent iw = new Intent(this, WhatActivity.class);
        startActivity(iw);
    }

    public void showStart(View view) {
        Intent is = new Intent(this, StartActivity.class);
        startActivity(is);
    }

    public void showFunFact(View view) {
        Intent iff = new Intent(this, FunFact.class);
        startActivity(iff);
    }
}
