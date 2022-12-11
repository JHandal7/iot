package com.example.iot;

public class widget {
    String id_usuario,estancia,funcion,id_estancia,id_variable,msj_off,msj_on,nombre,tipo,variable;

    public widget() {
    }

    public widget(String id_usuario, String estancia, String funcion, String id_estancia, String id_variable, String msj_off, String msj_on, String nombre, String tipo, String variable) {
        this.id_usuario = id_usuario;
        this.estancia = estancia;
        this.funcion = funcion;
        this.id_estancia = id_estancia;
        this.id_variable = id_variable;
        this.msj_off = msj_off;
        this.msj_on = msj_on;
        this.nombre = nombre;
        this.tipo = tipo;
        this.variable = variable;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEstancia() {
        return estancia;
    }

    public void setEstancia(String estancia) {
        this.estancia = estancia;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getId_estancia() {
        return id_estancia;
    }

    public void setId_estancia(String id_estancia) {
        this.id_estancia = id_estancia;
    }

    public String getId_variable() {
        return id_variable;
    }

    public void setId_variable(String id_variable) {
        this.id_variable = id_variable;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }
}
