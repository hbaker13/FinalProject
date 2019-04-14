package com.example.finalproject;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Test extends AppCompatActivity {

    private NotificationManager notificationManager;

    private static final int NOTIF_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        final AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Switch switch20 = (Switch) findViewById(R.id.switch1);

        Intent notifyIntent = new Intent(this, TestReceiver.class);

        boolean alarmUp = (PendingIntent.getBroadcast(this, 0, notifyIntent, PendingIntent.FLAG_NO_CREATE) != null);

        switch20.setChecked(alarmUp);

        final PendingIntent notifyPendingIntent = PendingIntent.getBroadcast(this, NOTIF_ID, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        switch20.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                String toastMessage;

                if (isChecked) {
                    long triggerTime = SystemClock.elapsedRealtime() + 3000;
                    long repeatInterval = 3000;

                    alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime, repeatInterval, notifyPendingIntent);

                    toastMessage = "ON";
                } else {
                    alarmManager.cancel(notifyPendingIntent);
                    notificationManager.cancelAll();

                    toastMessage = "OFF";
                }

                Toast.makeText(Test.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
