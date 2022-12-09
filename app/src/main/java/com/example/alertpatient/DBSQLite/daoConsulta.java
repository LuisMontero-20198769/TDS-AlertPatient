package com.example.alertpatient.DBSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoConsulta {
    Context c;
    BD_Consulta cons;
    ArrayList<BD_Consulta> list;
    SQLiteDatabase sql;
    String bd = "BDUsuario";
    String tabla = "create table if not exists consulta(id integer primary key autoincrement, nombre text, " +
            "tel text, opcion_enf text, enfermedad text, opcion_alergia text, alergia text, padecimiento text)";

    //Metodo Constructor...
    public daoConsulta(Context c){
        this.c = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        cons = new BD_Consulta();
    }

    //Insertar Consulta
    public boolean insertConsulta(BD_Consulta cons){
        if (buscar(cons.getNombre()) == 0) {
            ContentValues values = new ContentValues();
            values.put("nombre", cons.getNombre());
            values.put("tel", cons.getTel());
            values.put("opcion_enf", cons.getOpcion_enf());
            values.put("enfermedad", cons.getEnfermedad());
            values.put("opcion_alergia", cons.getOpcion_alergia());
            values.put("alergia", cons.getOpcion_alergia());
            values.put("padecimiento", cons.getPadecimiento());
            return (sql.insert("consulta", null, values)>0);
        }else{
            return false; //no pudo insertar los datos
        }
    }


    //Metodo Buscar...
    public  int buscar(String C){
        int x = 0;
        list = selectConsulta();
        for (BD_Consulta CONS: list) {
            if (C.equals(CONS.getPadecimiento())) {
                x++;
            }
        } return x;
    }

    public ArrayList<BD_Consulta> selectConsulta(){
        ArrayList<BD_Consulta> list = new ArrayList<BD_Consulta>();
        list.clear();
        Cursor cr = sql.rawQuery("select * from consulta", null);
        if (cr != null && cr.moveToFirst()) {
            do{
                BD_Consulta C = new BD_Consulta();
                C.setId_consulta(cr.getInt(0));
                C.setNombre(cr.getString(1));
                C.setTel(cr.getString(2));
                C.setOpcion_enf(cr.getString(3));
                C.setEnfermedad(cr.getString(4));
                C.setOpcion_alergia(cr.getString(5));
                C.setAlergia(cr.getString(6));
                C.setPadecimiento(cr.getString(7));
                list.add(C);
            }while(cr.moveToNext());

        }
        return list;
    }
}
