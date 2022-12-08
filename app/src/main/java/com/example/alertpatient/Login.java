package com.example.alertpatient;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    //Declaracion de los botones....
    Button btn_salir, btn_ingresar, btn_crearUser;
    //--------------

    //Las cajas de textos..........
    EditText user;
    EditText pass;
    //-----------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        //Inicialiazando los botones....
        btn_salir = findViewById(R.id.btn_salirLogin);
        btn_ingresar = findViewById(R.id.btn_ingresar);
        btn_crearUser = findViewById(R.id.btn_crearUser);
        //----------------

        //Inicialiazando las cajas de textos
        user = findViewById(R.id.text_user);
        pass = findViewById(R.id.text_pass);
        //---------------------

        //Llamado de boton ingresar....
        btn_ingresar.setOnClickListener(view -> {
             if(user.getText().toString().equals("Luis") && pass.getText().toString().equals("12345")){
                 Intent ingresar = new Intent(Login.this, Principal.class);
                 startActivity(ingresar);
             }else{
                 //Mensaje de alert de fallo
                 Toast.makeText(Login.this, "Login failed!", Toast.LENGTH_SHORT).show();
             }
        });

        btn_crearUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent crear = new Intent(Login.this, Registro.class);
                startActivity(crear);
            }
        });

        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 cerrarAplicacion();
            }
        });

    }

    private void cerrarAplicacion() {
        new AlertDialog.Builder(Login.this)
                .setTitle("¿Realmente desea cerrar la aplicación?")
                .setCancelable(false)
                .setNegativeButton(android.R.string.cancel, null)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {// un listener que al pulsar, cierre la aplicacion
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        android.os.Process.killProcess(android.os.Process.myPid()); //Su funcion es algo similar a lo que se llama cuando se presiona el botón "Forzar Detención" o "Administrar aplicaciones", lo cuál mata la aplicación
                        //finish(); Si solo quiere mandar la aplicación a segundo plano
                    }
                }).show();
    }
}