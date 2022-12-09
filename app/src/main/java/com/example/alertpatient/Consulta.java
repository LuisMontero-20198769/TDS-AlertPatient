package com.example.alertpatient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.alertpatient.DBSQLite.BD_Consulta;
import com.example.alertpatient.DBSQLite.daoConsulta;


public class Consulta extends AppCompatActivity {

    daoConsulta dao;

    protected EditText edit_nombreC, edit_telC, edit_enfermedadC, edit_AlergiaMedC, edit_PadecimientoC;
    RadioGroup rg_enfermedad, rg_alergia;
    RadioButton opc_enf, opc_aler;

    //Botones....
    protected Button btn_procesarC, btn_cancelarC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_consulta);

        //Referencias...
        edit_nombreC = (EditText) findViewById(R.id.edit_nombreC);
        edit_telC = (EditText) findViewById(R.id.edit_telefonoC);
        edit_enfermedadC = (EditText) findViewById(R.id.edit_enfermedadC);
        edit_AlergiaMedC = (EditText) findViewById(R.id.edit_alergiaM);
        edit_PadecimientoC = (EditText) findViewById(R.id.edit_descripcion_padecimiento);;
        rg_enfermedad = (RadioGroup) findViewById(R.id.Group_Enfermerdad);
        rg_alergia = (RadioGroup) findViewById(R.id.Group_Alergia);
        btn_procesarC = (Button) findViewById(R.id.btn_procesarC);
        btn_cancelarC = (Button) findViewById(R.id.btn_cancelarC);
        dao = new daoConsulta(this);
        //------


        //Acciones...
        btn_cancelarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Consulta.this, Principal.class);
                startActivity(i);
                Toast.makeText(Consulta.this, "Haz cancelada la Consulta", Toast.LENGTH_SHORT).show();
                finish();//cierra esta actividad
            }
        });




        btn_procesarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int enfer_ID = rg_enfermedad.getCheckedRadioButtonId();
                opc_enf = findViewById(enfer_ID);

                int aler_ID = rg_alergia.getCheckedRadioButtonId();
                opc_aler = findViewById(aler_ID);

                BD_Consulta C = new BD_Consulta();
                C.setNombre(edit_nombreC.getText().toString());
                C.setTel(edit_telC.getText().toString());
                C.setOpcion_enf(opc_enf.getText().toString());
                C.setEnfermedad(edit_enfermedadC.getText().toString());
                C.setOpcion_alergia(opc_aler.getText().toString());
                C.setAlergia(edit_AlergiaMedC.getText().toString());
                C.setPadecimiento(edit_PadecimientoC.getText().toString());


                //Validamos los datos
                if(!C.isNull()){
                    Toast.makeText(Consulta.this, "Alert! Campos Vacios!!", Toast.LENGTH_SHORT).show();
                } else if(dao.insertConsulta(C)){
                    Toast.makeText(Consulta.this, "Registro de Consulta Exitoso!!", Toast.LENGTH_SHORT).show();
                    Intent i2 = new Intent(Consulta.this, Principal.class);
                    startActivity(i2);//Para cuando se registre el user me lleve inmediatamente al login...
                    finish();//cierra esta actividad
                }else{
                    Toast.makeText(Consulta.this, "Consulta Existente!", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }


}
