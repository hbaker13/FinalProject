package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class FunFact extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funfact);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.other_menu, menu);
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

    public void showFF (View view){
        Intent sf = new Intent(this, FFActivity.class);
        startActivity(sf);
    }

    public void showFF1 (View view){
        Intent sff = new Intent(this, FFActivity1.class);
        startActivity(sff);
    }

    public void showFF2 (View view){
        Intent sfff = new Intent(this, FFActivity2.class);
        startActivity(sfff);
    }
}
