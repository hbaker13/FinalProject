package com.example.finalproject;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Vid extends Activity {
    ImageButton start,pause,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vid);

        start=(ImageButton)findViewById(R.id.button1);
        pause=(ImageButton) findViewById(R.id.button2);
        stop=(ImageButton) findViewById(R.id.button3);
        final MediaPlayer mp=new MediaPlayer();
        try{
            mp.setDataSource("android.resource://" + getPackageName() + "/" + R.raw.greateyesight);

            mp.prepare();
        }catch(Exception e){e.printStackTrace();}

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
            }
        });
    }
}
