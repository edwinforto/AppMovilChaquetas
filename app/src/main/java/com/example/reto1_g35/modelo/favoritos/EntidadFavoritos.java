package com.example.reto1_g35.modelo.favoritos;

import android.graphics.Bitmap;

public class EntidadFavoritos {

    Bitmap imagen;
     String titulo;
     String descripcion;
     String valor;
     String favoritos;

    public EntidadFavoritos(Bitmap imagen, String titulo, String descripcion, String valor, String favoritos) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.valor = valor;
        this.favoritos = favoritos;

    }

    public Bitmap getImagen() {

        return imagen;
    }

    public void setImagen(Bitmap imagen) {

        this.imagen = imagen;
    }

    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {

        this.titulo = titulo;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;
    }

    public String getValor() {

        return valor;
    }

    public void setValor(String valor) {

        this.valor = valor;
    }


    public int getFavoritos() {

        return Integer.parseInt(favoritos);
    }

    public void setFavoritos(int favoritos) {

        this.favoritos = Integer.toString(favoritos);
    }
}
