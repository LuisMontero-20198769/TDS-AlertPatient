package com.example.alertpatient.DBSQLite;

public class BD_Consulta {

    //Variable....
    int id_consulta;
    String nombre;
    String tel;
    String opcion_enf;
    String enfermedad;
    String opcion_alergia;
    String alergia;
    String padecimiento;
    //----


    public BD_Consulta() {}

    public BD_Consulta(String nombre, String tel, String opcion_enf, String enfermedad, String opcion_alergia, String alergia, String padecimiento) {
        this.nombre = nombre;
        this.tel = tel;
        this.opcion_enf = opcion_enf;
        this.enfermedad = enfermedad;
        this.opcion_alergia = opcion_alergia;
        this.alergia = alergia;
        this.padecimiento = padecimiento;
    }

    public boolean isNull(){
        if (nombre.equals("") && tel.equals("") && opcion_enf.equals("") && enfermedad.equals("") &&
                opcion_alergia.equals("") && alergia.equals("") && padecimiento.equals("")) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "BD_Consulta{" +
                "id_consulta=" + id_consulta +
                ", nombre='" + nombre + '\'' +
                ", tel='" + tel + '\'' +
                ", opcion_enf='" + opcion_enf + '\'' +
                ", enfermedad='" + enfermedad + '\'' +
                ", getOpcion_alergia='" + opcion_alergia + '\'' +
                ", alergia='" + alergia + '\'' +
                ", padecimiento='" + padecimiento + '\'' +
                '}';
    }

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getOpcion_enf() {
        return opcion_enf;
    }

    public void setOpcion_enf(String opcion_enf) {
        this.opcion_enf = opcion_enf;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getOpcion_alergia() {
        return opcion_alergia;
    }

    public void setOpcion_alergia(String getOpcion_alergia) {
        this.opcion_alergia = getOpcion_alergia;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public String getPadecimiento() {
        return padecimiento;
    }

    public void setPadecimiento(String padecimiento) {
        this.padecimiento = padecimiento;
    }
}