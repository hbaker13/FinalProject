package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FunFact extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funfact);
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
