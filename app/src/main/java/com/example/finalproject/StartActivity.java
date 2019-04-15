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

public class StartActivity extends AppCompatActivity {

    private Switch aSwitch1, aSwitch2, aSwitch3;

    private int NOTIF_ID[] = {1, 2, 3};

    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        final AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        aSwitch1 = (Switch) findViewById(R.id.switch20);

        Intent notifyIntent20 = new Intent(this, Receiver20.class);

        boolean alarmUp20 = (PendingIntent.getBroadcast(this, 0, notifyIntent20, PendingIntent.FLAG_NO_CREATE) != null);

        aSwitch1.setChecked(alarmUp20);

        final PendingIntent notifyPendingIntent20 = PendingIntent.getBroadcast(this, NOTIF_ID[1], notifyIntent20, PendingIntent.FLAG_UPDATE_CURRENT);

        aSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String toastMessage;

                if (isChecked) {
                    long triggerTime = SystemClock.elapsedRealtime() + 1200000;

                    long repeatInterval = 1200000;

                    alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime, repeatInterval, notifyPendingIntent20);

                    toastMessage = "ON";
                } else {
                    alarmManager.cancel(notifyPendingIntent20);
                    notificationManager.cancelAll();

                    toastMessage = "OFF";
                }

                Toast.makeText(StartActivity.this, toastMessage, Toast.LENGTH_LONG).show();
            }
        });

        aSwitch2 = (Switch) findViewById(R.id.switchD);

        Intent notifyIntentD = new Intent(this, ReceiverD.class);

        boolean alarmUpD = (PendingIntent.getBroadcast(this, 0, notifyIntentD, PendingIntent.FLAG_NO_CREATE) != null);

        aSwitch2.setChecked(alarmUpD);

        final PendingIntent notifyPendingIntentD = PendingIntent.getBroadcast(this, NOTIF_ID[2], notifyIntentD, PendingIntent.FLAG_UPDATE_CURRENT);

        aSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String toastMessage;

                if (isChecked) {
                    long triggerTime = SystemClock.elapsedRealtime() + 7200000;

                    long repeatInterval = 7200000;

                    alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime, repeatInterval, notifyPendingIntentD);

                    toastMessage = "ON";
                } else {
                    alarmManager.cancel(notifyPendingIntentD);
                    notificationManager.cancelAll();

                    toastMessage = "OFF";
                }

                Toast.makeText(StartActivity.this, toastMessage, Toast.LENGTH_LONG).show();
            }
        });

        aSwitch3 = (Switch) findViewById(R.id.switchE);

        Intent notifyIntentE = new Intent(this, ReceiverE.class);

        boolean alarmUpE = (PendingIntent.getBroadcast(this, 0, notifyIntentE, PendingIntent.FLAG_NO_CREATE) != null);

        aSwitch3.setChecked(alarmUpE);

        final PendingIntent notifyPendingIntentE = PendingIntent.getBroadcast(this, NOTIF_ID[3], notifyIntentE, PendingIntent.FLAG_UPDATE_CURRENT);

        aSwitch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String toastMessage;

                if (isChecked) {
                    long triggerTime = SystemClock.elapsedRealtime() + 14400000;

                    long repeatInterval = 14400000;

                    alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime, repeatInterval, notifyPendingIntentE);

                    toastMessage = "ON";
                } else {
                    alarmManager.cancel(notifyPendingIntentE);
                    notificationManager.cancelAll();

                    toastMessage = "OFF";
                }

                Toast.makeText(StartActivity.this, toastMessage, Toast.LENGTH_LONG).show();
            }
        });
    }
}
