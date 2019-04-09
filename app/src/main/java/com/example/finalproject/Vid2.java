package com.example.finalproject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class Vid2 extends Activity {

    final MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vid2);

        VideoView vid2 =(VideoView)findViewById(R.id.videoview2);

        MediaController vidCon2 = new MediaController(this);
        vidCon2.setAnchorView(vid2);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.deskexe);

        vid2.setMediaController(vidCon2);
        vid2.setVideoURI(video);
        vid2.requestFocus();
        vid2.start();
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.layout.activity_vid2, menu);
        return true;
    }
}
