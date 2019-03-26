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

    public void showRulesOf20(View view) {
        Intent in = new Intent(this, RulesOf20Activity.class);
        startActivity(in);
    }

    public void showDrink(View view) {
        Intent ist = new Intent(this, DrinkActivity.class);
        startActivity(ist);
    }

    public void showExercise(View view) {
        Intent ibs = new Intent(this, ExerciseActivity.class);
        startActivity(ibs);
    }
}
