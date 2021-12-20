package com.example.reto1_g35.modelo.producto;

import android.graphics.Bitmap;

public class EntidadProducto {

    private Bitmap imagen;
    private String titulo;
    private String descripcion;
    private String valor;
    private int favoritos;

    public EntidadProducto(Bitmap imagen, String titulo, String descripcion, String valor, String favoritos) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.valor = valor;
        this.favoritos = Integer.parseInt(favoritos);

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

        return favoritos;
    }

    public void setFavoritos(int favoritos) {

        this.favoritos = favoritos;
    }
}
