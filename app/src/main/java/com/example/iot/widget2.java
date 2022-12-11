package com.example.iot;

public class widget2 {
    String estancia,nombre,variable,max,min;

    public widget2() {
    }

    public widget2(String estancia, String nombre, String variable, String max, String min) {
        this.estancia = estancia;
        this.nombre = nombre;
        this.variable = variable;
        this.max = max;
        this.min = min;
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

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }
}
