package com.example.iot;

public class cambio1 {
    int notificacion;
    String id_widgets,mensaje,titulo;

    public cambio1() {
    }

    public cambio1(int notificacion, String id_widgets, String mensaje, String titulo) {
        this.notificacion = notificacion;
        this.id_widgets = id_widgets;
        this.mensaje = mensaje;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(int notificacion) {
        this.notificacion = notificacion;
    }

    public String getId_widgets() {
        return id_widgets;
    }

    public void setId_widgets(String id_widgets) {
        this.id_widgets = id_widgets;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
