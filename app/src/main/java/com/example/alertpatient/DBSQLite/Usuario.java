package com.example.alertpatient.DBSQLite;

public class Usuario {

    //Variable....
    int id;
    String correo;
    String nombre;
    String ocupacion;
    String t_user;
    String pass;
    String edad;
    //----


    //Constructor sin parametros
    public Usuario(){}

    public boolean isNull(){
        if (correo.equals("") && nombre.equals("") && edad.equals("") && ocupacion.equals("") &&
            t_user.equals("") && pass.equals("")) {
             return false;
        }else {
            return true;
        }
    }

    //Constrcutor con parametros....
    public Usuario(String edad, String correo, String nombre, String ocupacion, String t_user, String pass) {
        this.edad = edad;
        this.correo = correo;
        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.t_user = t_user;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", edad=" + edad +
                ", correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                ", t_user='" + t_user + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    //Metodos Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEdad() {return edad;}

    public void setEdad(String edad) {this.edad = edad;}

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
