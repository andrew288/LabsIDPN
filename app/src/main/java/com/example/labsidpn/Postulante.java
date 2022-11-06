package com.example.labsidpn;

import java.io.Serializable;

public class Postulante implements Serializable {
    private String dni;
    private String aPaterno;
    private String aMaterno;
    private String nombres;
    private String fNacimiento;
    private String colegio;
    private String carrera;

    public Postulante(
            String dni,
            String aPaterno,
          String aMaterno,
          String nombres,
          String fNacimiento,
          String colegio,
          String carrera){
        this.dni = dni;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.nombres = nombres;
        this.fNacimiento = fNacimiento;
        this.colegio = colegio;
        this.carrera = carrera;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getColegio() {
        return colegio;
    }

    public String getfNacimiento() {
        return fNacimiento;
    }

    public String getNombres() {
        return nombres;
    }

    public String getDni(){
        return dni;
    }

    @Override
    public String toString(){
        return
                "DNI: " + dni+ "\n"+
                "Apellido paterno: "+aPaterno+"\n"+
                "Apellido materno: "+aMaterno+"\n"+
                "Nombres: "+nombres+"\n"+
                "Fecha de Nacimiento: "+fNacimiento+"\n"+
                "Colegio de procedencia: "+colegio+"\n"+
                "Carrera postulante: "+carrera+"\n";
    }
}
