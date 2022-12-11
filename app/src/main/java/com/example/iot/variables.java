package com.example.iot;

public class variables {
    String nombre, dispositivo,id_usuario,id_variable;

    public variables() {
    }

    public variables(String nombre, String dispositivo, String id_usuario, String id_variable) {
        this.nombre = nombre;
        this.dispositivo = dispositivo;
        this.id_usuario = id_usuario;
        this.id_variable = id_variable;
    }

    public String getId_variable() {
        return id_variable;
    }

    public void setId_variable(String id_variable) {
        this.id_variable = id_variable;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }
}


