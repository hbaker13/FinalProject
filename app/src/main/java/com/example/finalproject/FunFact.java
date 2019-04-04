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

    public void showFF(View view) {
        Intent Iff = new Intent(this, FFActivity.class);
        startActivity(Iff);
    }

    public void showFF1(View view) {
        Intent Iff1 = new Intent(this, FFActivity1.class);
        startActivity(Iff1);
    }

    public void showFF2(View view) {
        Intent Iff2 = new Intent(this, FFActivity2.class);
        startActivity(Iff2);
    }
}
