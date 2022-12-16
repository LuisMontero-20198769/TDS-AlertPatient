package com.example.alertpatient.DBSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoUsuario {

    Context c;
    Usuario u;
    ArrayList<Usuario> list;
    SQLiteDatabase sql;
    String bd = "BDUsuario";
    String tabla = "create table if not exists usuario(id integer primary key autoincrement, correo text, nombre text, edad text, ocupacion text, tipoUser text, pass text)";

    //Metodo Constructor...
    public daoUsuario(Context c){
        this.c = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u = new Usuario();
    }

    //Insertar Usuario
    public boolean insertUsuario(Usuario u){
        if (buscar(u.getCorreo()) == 0) {
            ContentValues values = new ContentValues();
            values.put("correo", u.getCorreo());
            values.put("nombre", u.getNombre());
            values.put("edad", u.getEdad());
            values.put("ocupacion", u.getOcupacion());
            values.put("tipoUser", u.getT_user());
            values.put("pass", u.getPass());
            return (sql.insert("usuario", null, values)>0);
        }else{
            return false; //no pudo insertar los datos
        }
    }

    //Metodo Login
    public int login(String u, String p, String t_user){
        int i = 0;
        Cursor cr = sql.rawQuery("select * from usuario", null);
        if (cr != null && cr.moveToFirst()) {
            do{
                if(cr.getString(1).equals(u) && cr.getString(6).equals(p)
                        && cr.getString(7).equals(t_user)) {
                    i++;
                }
            }while(cr.moveToNext());

        }
        return i;
    }

    public Usuario getUser(String u, String p, String t_user){
        list = selectUsuarios();
        for (Usuario us: list) {
            if(us.getCorreo().equals(u) && us.getPass().equals(p)  && us.getT_user().equals(t_user)){
                return us;
            }

        } return null;
    }

    public Usuario getUserByID(int id){
        list = selectUsuarios();
        for (Usuario us: list) {
            if(us.getId() == id ){
                return us;
            }

        } return null;
    }

    //---------

    //Metodo Buscar...
    public  int buscar(String u){
         int x = 0;
         list = selectUsuarios();
        for (Usuario us: list) {
            if (u.equals(us.getCorreo())) {
                 x++;
            }
        } return x;
    }

    public ArrayList<Usuario> selectUsuarios(){
        ArrayList<Usuario> list = new ArrayList<Usuario>();
        list.clear();
        Cursor cr = sql.rawQuery("select * from usuario", null);
        if (cr != null && cr.moveToFirst()) {
            do{
                Usuario u = new Usuario();
                u.setId(cr.getInt(0));
                u.setCorreo(cr.getString(1));
                u.setNombre(cr.getString(2));
                u.setEdad(cr.getString(3));
                u.setOcupacion(cr.getString(4));
                u.setT_user(cr.getString(5));
                u.setPass(cr.getString(6));
                list.add(u);
            }while(cr.moveToNext());
            
        }
        return list;
    }
}
