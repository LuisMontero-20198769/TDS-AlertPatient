package com.example.alertpatient;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity {

    String[] t_user = {"Doctor", "Paciente"};
    AutoCompleteTextView completeTextView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_registro);

        completeTextView = (AutoCompleteTextView) findViewById(R.id.Auto_Comp_TipoUsuario);
        adapter = new ArrayAdapter<String>(this, R.layout.list_user, t_user);
        completeTextView.setAdapter(adapter);

        //Accion...
        completeTextView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String user = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Registro.this, "Debe seleccionar un tipo de Usuario", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
