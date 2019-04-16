package com.example.finalproject;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

public class Timer20 extends AppCompatActivity {

    private TextView cDownText;
    private Button cDownButton, cDownButton1;

    private CountDownTimer countDownTimer;
    private static final long START_TIME_IN_MILLIS = 20000;
    private boolean timerRunning;
    private long timeLeftInMillis = START_TIME_IN_MILLIS;

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer20);

        mp= MediaPlayer.create(this, R.raw.softpiano);

        cDownText = (TextView) findViewById(R.id.cDown_text);
        cDownButton = (Button) findViewById(R.id.buttonStartPause);
        cDownButton1 = (Button) findViewById(R.id.buttonReset);

        cDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        cDownButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        updateCountdownText();
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountdownText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(300);
                cDownButton.setText("START");
                cDownButton.setVisibility(View.INVISIBLE);
                cDownButton1.setVisibility(View.VISIBLE);
            }
        }.start();

        timerRunning = true;
        cDownButton.setText("PAUSE");
        cDownButton1.setVisibility(View.INVISIBLE);
        mp.start();
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        cDownButton.setText("START");
        cDownButton1.setVisibility(View.VISIBLE);
        mp.pause();
    }

    private void resetTimer() {
        timeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountdownText();

        cDownButton1.setVisibility(View.INVISIBLE);
        cDownButton.setVisibility(View.VISIBLE);
        mp=MediaPlayer.create(this, R.raw.softpiano);
    }

    private void updateCountdownText() {
        int mins = (int) (timeLeftInMillis / 1000) / 60;
        int secs = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", mins, secs);

        cDownText.setText(timeLeftFormatted);
    }
}
