package com.example.finalproject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class Vid1 extends Activity {

    final MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vid1);

        VideoView vid1 =(VideoView)findViewById(R.id.videoview1);

        MediaController vidCon = new MediaController(this);
        vidCon.setAnchorView(vid1);

        Uri video1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.drink);

        vid1.setMediaController(vidCon);
        vid1.setVideoURI(video1);
        vid1.requestFocus();
        vid1.start();
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.layout.activity_vid1, menu);
        return true;
    }
}
