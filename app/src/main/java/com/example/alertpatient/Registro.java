package com.example.alertpatient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.alertpatient.DBSQLite.Usuario;
import com.example.alertpatient.DBSQLite.daoUsuario;

public class Registro extends AppCompatActivity {

    /*
    String[] t_user = {"Doctor", "Paciente"};
    String user;
    AutoCompleteTextView completeTextView;
    ArrayAdapter<String> adapter;
    */
    daoUsuario dao;

    //----Declaramos los los atributos
    protected EditText edit_correo, edit_nombre, edit_edad, edit_ocupacion, edit_tUser, edit_pass;

    //---Declaramos los botones
    protected Button btn_registrar, btn_cancelar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_registro);

        /*

        completeTextView = (AutoCompleteTextView) findViewById(R.id.Auto_Comp_TipoUsuario);
        adapter = new ArrayAdapter<String>(this, R.layout.list_user, t_user);
        completeTextView.setAdapter(adapter);


         */

        //---Referencias...
        edit_correo = (EditText) findViewById(R.id.edit_correo);
        edit_nombre = (EditText) findViewById(R.id.edit_nombre);
        edit_edad = (EditText) findViewById(R.id.edit_edad);
        edit_ocupacion = (EditText) findViewById(R.id.edit_profesion);
        edit_tUser = (EditText) findViewById(R.id.edit_T_user);
        edit_pass = (EditText) findViewById(R.id.edit_pass);
        btn_registrar = (Button) findViewById(R.id.btn_registrar);
        btn_cancelar = (Button) findViewById(R.id.btn_cancelar_registro);
        dao = new daoUsuario(this);
        //-----


        /*
        //Acciones...
        completeTextView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                user = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Registro.this, "Debe seleccionar un tipo de Usuario", Toast.LENGTH_SHORT).show();
            }
        });
         */

        //----Acciones de los botones...
        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario u = new Usuario();
                u.setCorreo(edit_correo.getText().toString());
                u.setNombre(edit_nombre.getText().toString());
                u.setEdad(edit_edad.getText().toString());
                u.setOcupacion(edit_ocupacion.getText().toString());
                u.setT_user(edit_tUser.getText().toString());
                u.setPass(edit_pass.getText().toString());

                //Validamos los datos
                if(!u.isNull()){
                    Toast.makeText(Registro.this, "Alert! Campos Vacios!!", Toast.LENGTH_SHORT).show();
                } else if(dao.insertUsuario(u)){
                    Toast.makeText(Registro.this, "Registro Exitoso!!", Toast.LENGTH_SHORT).show();
                    Intent i2 = new Intent(Registro.this, Login.class);
                    startActivity(i2);//Para cuando se registre el user me lleve inmediatamente al login...
                    finish();//cierra esta actividad
                }else{
                    Toast.makeText(Registro.this, "Usuario Existente!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Registro.this, Login.class);
                startActivity(i);
                finish();//cierra esta actividad
            }
        });

    }


}
