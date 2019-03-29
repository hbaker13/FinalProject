package com.example.finalproject;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.DrawableRes;

class FunFact {

    private final String title;
    private final String info;
    private final int imageResource;

    static final String TITLE_KEY = "Title";
    static final String IMAGE_KEY = "Image Resource";

    FunFact(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    String getTitle() {
        return title;
    }

    String getInfo() {
        return info;
    }

    int getImageResource() {
        return imageResource;
    }

    static Intent starter(Context context, String title, @DrawableRes int imageResId) {
        Intent detailIntent = new Intent(context, FFActivity.class);
        detailIntent.putExtra(TITLE_KEY, title);
        detailIntent.putExtra(IMAGE_KEY, imageResId);
        return detailIntent;
    }
}