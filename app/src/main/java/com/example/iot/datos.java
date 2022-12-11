package com.example.iot;

public class datos {
    String id_widgets,mensaje;

    public datos() {
    }

    public datos(String id_widgets, String mensaje) {
        this.id_widgets = id_widgets;
        this.mensaje = mensaje;

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
