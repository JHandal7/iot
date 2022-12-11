package com.example.iot;

public class widget1 {
    String estancia,nombre,variable,msj_off,msj_on;

    public widget1() {
    }

    public widget1(String estancia, String nombre, String variable, String msj_off, String msj_on) {
        this.estancia = estancia;
        this.nombre = nombre;
        this.variable = variable;
        this.msj_off = msj_off;
        this.msj_on = msj_on;
    }

    public String getEstancia() {
        return estancia;
    }

    public void setEstancia(String estancia) {
        this.estancia = estancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getMsj_off() {
        return msj_off;
    }

    public void setMsj_off(String msj_off) {
        this.msj_off = msj_off;
    }

    public String getMsj_on() {
        return msj_on;
    }

    public void setMsj_on(String msj_on) {
        this.msj_on = msj_on;
    }
}
