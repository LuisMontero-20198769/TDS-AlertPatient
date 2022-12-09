package com.example.alertpatient;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;

public class AlarmReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        String fetch_string = intent.getExtras().getString("extra");
        int get_sound_choice = intent.getExtras().getInt("sound_choice");
        Intent service_intent = new Intent(context, RingtoneManager.class);

        service_intent.putExtra("extra", fetch_string);

        service_intent.putExtra("sound_choice", get_sound_choice);

        context.startService(service_intent);



    }
}
