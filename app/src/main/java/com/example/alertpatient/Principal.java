package com.example.alertpatient;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Principal extends AppCompatActivity {

    Button btn_atras, btn_salir;
    ImageButton IBtn_consulta, IBtn_alarma, IBtn_emergencia, IBtn_medicamentos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_principal);

        //-------
        btn_atras = (Button) findViewById(R.id.btn_atrasP);
        btn_salir = (Button) findViewById(R.id.btn_salirP);

        //-----
        IBtn_consulta = (ImageButton) findViewById(R.id.Ibtn_consulta);
        IBtn_alarma= (ImageButton) findViewById(R.id.Ibtn_alarma);
        IBtn_emergencia = (ImageButton) findViewById(R.id.Ibtn_emergencia);
        IBtn_medicamentos = (ImageButton) findViewById(R.id.Ibtn_medicamento);

        //Acciones......
        btn_atras.setOnClickListener(view -> {
            Intent principal = new Intent(Principal.this, Login.class);
            startActivity(principal);//ponemos a correr el intent...
        });

        btn_salir.setOnClickListener(view -> {
             cerrarAplicacion();
        });



        IBtn_alarma.setOnClickListener(view -> {
            Intent alarma = new Intent(Principal.this, Alarmas.class);
            startActivity(alarma);//ponemos a correr el intent...
        });

        IBtn_consulta.setOnClickListener(v -> {
            Intent consulta = new Intent(Principal.this, Consulta.class);
            startActivity(consulta);
        });

        IBtn_emergencia.setOnClickListener(v -> {
            Intent emergencia = new Intent(Principal.this, Emergencia.class);
            startActivity(emergencia);
        });

        IBtn_medicamentos.setOnClickListener(view -> {
            Intent medicamentos = new Intent(Principal.this, Medicamentos.class);
            startActivity(medicamentos);
        });


    }

    private void cerrarAplicacion() {
        new AlertDialog.Builder(Principal.this)
                .setTitle("Estas por salir de la app ¿estas seguro?")
                .setCancelable(false)
                .setNegativeButton(android.R.string.cancel, null)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {// un listener que al pulsar, cierre la aplicacion
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        android.os.Process.killProcess(android.os.Process.myPid()); //Su funcion es algo similar a lo que se llama cuando se presiona el botón "Forzar Detención" o "Administrar aplicaciones", lo cuál mata la aplicación
                        finishAffinity (); //cerrara esta actividad...
                    }
                }).show();
    }
}
