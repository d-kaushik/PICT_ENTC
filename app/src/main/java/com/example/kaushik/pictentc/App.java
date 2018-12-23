package com.example.kaushik.pictentc;


import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

/**
 * Created by hp on 21-12-2018.
 */

public class App extends Application {
    public static final String Channel_file_id="channel1";
    public static final String Channel_notice_id="channel2";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotifcationChannels();
    }

    private void createNotifcationChannels() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel1 =new NotificationChannel(
                    Channel_file_id,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("New File added");
            channel1.enableVibration(true);
            channel1.shouldShowLights();
            NotificationChannel channel2 =new NotificationChannel(
                    Channel_notice_id,
                    "Channel 2",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel2.setDescription("New Notice added");
            channel2.enableVibration(true);
            channel2.shouldShowLights();
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);

        }
    }
}
