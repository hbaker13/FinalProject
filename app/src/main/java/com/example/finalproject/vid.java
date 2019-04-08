package com.example.finalproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class vid extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vid);

        Uri u = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.greateyesight);

        Intent intent = new Intent(Intent.ACTION_VIEW, u);
        intent.setDataAndType(u, "video/mp4");
        startActivity(intent);
    }
}
