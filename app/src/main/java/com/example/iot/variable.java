package com.example.iot;

public class variable {
    String dispositivo,id_usuario,nombre,unidad_med;

    public variable() {
    }
    public variable(String dispositivo, String id_usuario, String nombre, String unidad_med) {
        this.dispositivo = dispositivo;
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.unidad_med = unidad_med;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
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

    public String getUnidad_med() {
        return unidad_med;
    }

    public void setUnidad_med(String unidad_med) {
        this.unidad_med = unidad_med;
    }


}
