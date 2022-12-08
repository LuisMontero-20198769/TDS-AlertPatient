package com.example.alertpatient;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

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
}
