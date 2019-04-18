package com.example.finalproject;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class StartActivity extends AppCompatActivity {

    private Switch aSwitch1, aSwitch2, aSwitch3;

    private int NOTIF_ID;
    private int NOTIF_ID1;
    private int NOTIF_ID2;

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

        final PendingIntent notifyPendingIntent20 = PendingIntent.getBroadcast(this, NOTIF_ID, notifyIntent20, PendingIntent.FLAG_UPDATE_CURRENT);

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

        final PendingIntent notifyPendingIntentD = PendingIntent.getBroadcast(this, NOTIF_ID1, notifyIntentD, PendingIntent.FLAG_UPDATE_CURRENT);

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

        final PendingIntent notifyPendingIntentE = PendingIntent.getBroadcast(this, NOTIF_ID2, notifyIntentE, PendingIntent.FLAG_UPDATE_CURRENT);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.other_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.night_mode:
                if(item.getItemId()==R.id.night_mode){
                    int nightMode = AppCompatDelegate.getDefaultNightMode();

                    if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    } else {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    }

                    recreate();

                    return true;
                }
            default:

        }
        return super.onOptionsItemSelected(item);
    }
}
