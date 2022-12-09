package com.example.alertpatient;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Alarmas extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    AlarmManager alarmManager;
    TimePicker alarm_timePicker;
    TextView alarm_state;
    Context context;
    PendingIntent pending_Intent;
    int sound_select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_alarma);

        final AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        final TimePicker alam_TimePicker = (TimePicker) findViewById(R.id.timePicker);
        final TextView alarm_state = (TextView) findViewById(R.id.alarm_state);

        final Calendar calendar = Calendar.getInstance();

        final Intent my_intent = new Intent( Alarmas.this, AlarmReceiver.class);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.stepbrothers_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button alarm_on = (Button) findViewById(R.id.alarm_on);
        alarm_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.set(Calendar.HOUR_OF_DAY, alarm_timePicker.getHour());
                calendar.set(Calendar.MINUTE, alarm_timePicker.getMinute());

                int hour = alam_TimePicker.getHour();
                int minute = alam_TimePicker.getMinute();

                String hour_string = String.valueOf(hour);
                String minute_string = String.valueOf(minute);

                if(hour > 12) hour_string = String.valueOf(hour - 12);
                if(minute < 10) minute_string = "0" + String.valueOf(minute);

                alarm_state.setText("Alarma establecida en: " + hour_string + ":" + minute_string);

                my_intent.putExtra("extra", "alarma encendida");

                my_intent.putExtra("sound_choice", sound_select);

                pending_Intent = PendingIntent.getBroadcast
                        (Alarmas.this, 0, my_intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pending_Intent);

            }
        });

        Button alarm_off = (Button) findViewById(R.id.alarm_off);
        alarm_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarm_state.setText("Alarm Apadada");

                alarmManager.cancel(pending_Intent);

                my_intent.putExtra("extra", "alarma apagada");

                my_intent.putExtra("sound_choice", sound_select);

                sendBroadcast(my_intent);
            }
        });




    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
