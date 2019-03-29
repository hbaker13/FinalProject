package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FunFact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funfact);

    }

    public void toFFActivity(View view) {
        Intent i = new Intent(FunFact.this, FFActivity.class);
        startActivity(i);
    }

    public void toFFActivity1(View view) {
        Intent i1 = new Intent(FunFact.this, FFActivity1.class);
        startActivity(i1);
    }

    public void toFFActivity2 (View view) {
        Intent i2 = new Intent(FunFact.this, FFActivity2.class);
        startActivity(i2);    }

}