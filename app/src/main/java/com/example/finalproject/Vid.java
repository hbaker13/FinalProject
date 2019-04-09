package com.example.finalproject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class Vid extends Activity {

    final MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vid);

        VideoView vid =(VideoView)findViewById(R.id.videoview);

        MediaController vidCon = new MediaController(this);
            vidCon.setAnchorView(vid);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.greateyesight);

        vid.setMediaController(vidCon);
        vid.setVideoURI(video);
        vid.requestFocus();
        vid.start();
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.layout.activity_vid, menu);
        return true;
    }
}
