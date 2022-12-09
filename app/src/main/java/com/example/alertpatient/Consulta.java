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


public class Consulta extends AppCompatActivity {



    protected EditText edit_nombreP, edit_tel, edit_enfermedad, edit_AlergiaMed, edit_Padecimiento;
    RadioGroup rg_enfermedad, rg_alergia;
    RadioButton opc_enf_yes, opc_enf_no, opc_aler_yes, opc_aler_no;

    //Botones....
    protected Button btn_procesarC, btn_cancelarC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_consulta);

        //Referencias...
        edit_nombreP = (EditText) findViewById(R.id.edit_nombreC);
        edit_tel = (EditText) findViewById(R.id.edit_telefonoC);
        edit_enfermedad = (EditText) findViewById(R.id.edit_enfermedadC);
        edit_AlergiaMed = (EditText) findViewById(R.id.edit_alergiaM);
        edit_Padecimiento = (EditText) findViewById(R.id.edit_descripcion_padecimiento);
        opc_enf_yes = (RadioButton) findViewById(R.id.RbOpcion_Yes_E);
        opc_enf_no = (RadioButton) findViewById(R.id.RbOpcion_No_E);
        opc_aler_yes = (RadioButton) findViewById(R.id.RbOpcion_Yes_A);
        opc_aler_no = (RadioButton) findViewById(R.id.RbOpcion_No_A);
        rg_enfermedad = (RadioGroup) findViewById(R.id.Group_Enfermerdad);
        rg_alergia = (RadioGroup) findViewById(R.id.Group_Alergia);
        btn_procesarC = (Button) findViewById(R.id.btn_procesarC);
        btn_cancelarC = (Button) findViewById(R.id.btn_cancelarC);
        //------

        //Acciones...
        btn_cancelarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Consulta.this, Principal.class);
                startActivity(i);
                String u, p;
                Toast.makeText(Consulta.this, "Haz cancelada la Consulta", Toast.LENGTH_SHORT).show();
                finish();//cierra esta actividad
            }
        });

        rg_enfermedad.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                String opcion = "";
                switch(checkedId) {
                    case R.id.RbOpcion_Yes_E:
                        opcion = "Yes";
                        break;
                    case R.id.RbOpcion_No_E:
                        opcion = "No";
                        break;
                }
            }
        });

        rg_alergia.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                String opcion = "";
                switch(checkedId) {
                    case R.id.RbOpcion_Yes_A:
                        opcion = "Yes";
                        break;
                    case R.id.RbOpcion_No_A:
                        opcion = "No";
                        break;
                }
            }
        });


        //-----

    }


}
