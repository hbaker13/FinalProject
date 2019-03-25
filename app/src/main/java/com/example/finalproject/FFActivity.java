package com.example.finalproject;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class FFActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_funfact);

        TextView sportsTitle = (TextView)findViewById(R.id.titleDetail);
        ImageView sportsImage = (ImageView)findViewById(R.id.funfactImage);

        Drawable drawable = ContextCompat.getDrawable
                (this,getIntent().getIntExtra(FunFact.IMAGE_KEY, 0));

        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        if(drawable!=null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

        sportsTitle.setText(getIntent().getStringExtra(FunFact.TITLE_KEY));

        Glide.with(this).load(getIntent().getIntExtra(FunFact.IMAGE_KEY,0))
                .placeholder(gradientDrawable).into(sportsImage);
    }
}