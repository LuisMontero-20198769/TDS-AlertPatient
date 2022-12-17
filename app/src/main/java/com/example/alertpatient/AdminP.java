package com.example.alertpatient;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AdminP extends AppCompatActivity {

    ImageButton imageButtonVer, imageButtonAgregarMedic;

    Button btn_atras, btn_salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_admin);

        //-------
        btn_atras = (Button) findViewById(R.id.btn_atrasAdmin);
        btn_salir = (Button) findViewById(R.id.btn_salirAdmin);

        //-----
        imageButtonVer = (ImageButton) findViewById(R.id.Ibtn_consultaVer);
        imageButtonAgregarMedic = (ImageButton) findViewById(R.id.Ibtn_agregarMedicamentos);

        btn_atras.setOnClickListener(view -> {
            Intent principal = new Intent(AdminP.this, Login.class);
            startActivity(principal);//ponemos a correr el intent...
        });

        btn_salir.setOnClickListener(view -> {
            cerrarAplicacion();
        });

    }

    private void cerrarAplicacion() {
        new AlertDialog.Builder(AdminP.this)
                .setTitle("Estas por salir de la app ¿estas seguro?")
                .setCancelable(false)
                .setNegativeButton(android.R.string.cancel, null)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {// un listener que al pulsar, cierre la aplicacion
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        android.os.Process.killProcess(android.os.Process.myPid()); //Su funcion es algo similar a lo que se llama cuando se presiona el botón "Forzar Detención" o "Administrar aplicaciones", lo cuál mata la aplicación
                        finish(); //cerrara esta actividad...
                    }
                }).show();
    }
}
