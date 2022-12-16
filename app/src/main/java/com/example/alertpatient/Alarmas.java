package com.example.alertpatient;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class Alarmas extends AppCompatActivity  {

    //EditText
    EditText text_nombre, text_hora, text_minutos, text_dia;

    //Botones
    Button btn_establecer, btn_cancelar, btn_salirApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_alarma);

        //Referencias
        text_nombre = (EditText) findViewById(R.id.text_recordar);
        text_hora = (EditText) findViewById(R.id.text_hora);
        text_minutos = (EditText) findViewById(R.id.text_minutos);
        text_dia = (EditText) findViewById(R.id.text_dia);

        btn_establecer = (Button) findViewById(R.id.btn_establecer);
        btn_cancelar = (Button) findViewById(R.id.btn_cancelarAlarm);
        btn_salirApp = (Button) findViewById(R.id.btn_salirApp);

        //-------


        //Acciones....
        btn_establecer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = text_nombre.getText().toString();
                int hora = Integer.parseInt(text_hora.getText().toString());
                int minutos = Integer.parseInt(text_minutos.getText().toString());
                String dia = text_dia.getText().toString();
                establecerAlarma(nombre, hora, minutos, dia);
            }
        });

        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent principal = new Intent(Alarmas.this, Principal.class);
                startActivity(principal);
                finish();
            }
        });
        btn_salirApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarAplicacion();
            }
        });



    }


    private void cerrarAplicacion() {
        new AlertDialog.Builder(Alarmas.this)
                .setTitle("¿Realmente desea cerrar la aplicación?")
                .setCancelable(false)
                .setNegativeButton(android.R.string.cancel, null)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {// un listener que al pulsar, cierre la aplicacion
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        android.os.Process.killProcess(android.os.Process.myPid()); //Su funcion es algo
                        // similar a lo que se llama cuando se presiona el botón "Forzar Detención" o "Administrar aplicaciones", lo cuál mata la aplicación
                        finishAffinity ();//cerrara esta actividad...
                    }
                }).show();
    }

    public void establecerAlarma(String mensaje, int hora, int minutos, String dia){
         Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                 .putExtra(AlarmClock.EXTRA_MESSAGE, mensaje)
                 .putExtra(AlarmClock.EXTRA_HOUR, hora)
                 .putExtra(AlarmClock.EXTRA_MINUTES, minutos)
                 .putExtra(AlarmClock.EXTRA_DAYS, dia);


         if(intent.resolveActivity(getPackageManager()) != null){
             startActivity(intent);
         }
    }

}
