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

import com.example.alertpatient.DBSQLite.daoUsuario;

public class Login extends AppCompatActivity {

    //Declaracion de los botones....
    Button btn_salir, btn_ingresar, btn_crearUser;
    //--------------

    daoUsuario dao;

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

        dao = new daoUsuario(this);

        //Llamado de boton ingresar....
        btn_ingresar.setOnClickListener(view -> {
             String u = user.getText().toString();
             String p = pass.getText().toString();

             //Validar campos vacios
            if(u.equals("") && p.equals("")){
                Toast.makeText(this, "Error: Campos Vacios!", Toast.LENGTH_SHORT).show();
            } else if(dao.login(u, p) == 1){
                Toast.makeText(this, "Bienvenido: "+dao.getUser(u, p).getNombre().toString(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Login.this, Principal.class);
                startActivity(i);
                finish();
            }else {
                Toast.makeText(this, "Usuario Inexistente!", Toast.LENGTH_SHORT).show();
            }

        });

        btn_crearUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent crear = new Intent(Login.this, Registro.class);
                startActivity(crear);
                finish();
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
                        finishAffinity (); //cerrara esta actividad...
                    }
                }).show();
    }
}