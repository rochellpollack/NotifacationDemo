package com.example.rachel.notifacationdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notifyMe(View view){
        Intent intent = new Intent(this,NotifacationReceiverActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);

        //building the notification.
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext()).setTicker("Ready for the challenge?")
                .setSmallIcon(android.R.drawable.stat_sys_warning).setAutoCancel(true).setContentTitle("Challenge Reminder")
                .setContentText("This is a reminder about upcoming challenge.").setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0,notificationBuilder.build());
    }

}
