package com.example.iot;

public class estancias {
    String id_usuario,nombre,ubicacion;

    public estancias() {
    }

    public estancias(String id_usuario, String nombre, String ubicacion) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
