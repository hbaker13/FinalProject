package com.example.finalproject;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class ReceiverD extends BroadcastReceiver {

    private int NOTIF_ID;

    public ReceiverD() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent contentIntent = new Intent(context, Vid1.class);
        PendingIntent contentPendingIntent = PendingIntent.getActivity(context, NOTIF_ID, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_notif)
                .setContentTitle(context.getString(R.string.drink_title))
                .setContentText(context.getString(R.string.drink_text))
                .setContentIntent(contentPendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        notificationManager.notify(NOTIF_ID, builder.build());
    }
}
