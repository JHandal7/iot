package com.example.iot;

public class dispositivos {
    String id_usuario,nombre;

    public dispositivos() {
    }

    public dispositivos(String id_usuario, String nombre) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
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
}
