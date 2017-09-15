package com.example.enrique.nicaherolayout;

/**
 * Created by enrique on 09/07/2017.
 */

public class FuenteArtistas {
    String titulo;
    int imagen;
    int estado;

    public FuenteArtistas(String titulo, int imagen, int estado) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
