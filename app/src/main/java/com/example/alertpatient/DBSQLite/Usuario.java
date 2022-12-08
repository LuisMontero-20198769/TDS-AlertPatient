package com.example.alertpatient.DBSQLite;

public class Usuario {

    //Variable....
    int id, edad;
    String correo, nombre, ocupacion, t_user, pass;

    //Constructor sin parametros
    public Usuario(){}

    //Constrcutor con parametros....
    public Usuario(int id, int edad, String correo, String nombre, String ocupacion, String t_user, String pass) {
        this.id = id;
        this.edad = edad;
        this.correo = correo;
        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.t_user = t_user;
        this.pass = pass;
    }


    //Metodos Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getT_user() {
        return t_user;
    }

    public void setT_user(String t_user) {
        this.t_user = t_user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
