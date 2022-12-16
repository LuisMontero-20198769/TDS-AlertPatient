package com.example.alertpatient;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Emergencia extends AppCompatActivity {

    ImageButton btn_emergencias;
    Button btn_cancelarLlmada;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_emergencia);

        //Referencias...
        btn_emergencias = (ImageButton) findViewById(R.id.btn_llmada_emergencia);
        btn_cancelarLlmada = (Button) findViewById(R.id.btn_cancelarLlamada);

        //Acciones....
        btn_emergencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:911"));
                startActivity(intent);
            }
        });

        btn_cancelarLlmada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Emergencia.this, Principal.class);
                startActivity(intent2);
                finish();//Cierra de esta actividad
            }
        });

    }
}
