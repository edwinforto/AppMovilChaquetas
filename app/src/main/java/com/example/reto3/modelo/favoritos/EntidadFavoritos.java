package com.example.reto3.modelo.favoritos;

public class EntidadFavoritos {
    private int imagen;
    private String titulo;
    private String descripcion;
    private String valor;
    private String favoritos;

    public EntidadFavoritos(int imagen, String titulo, String descripcion, String valor, String favoritos ) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.valor=valor;
        this.favoritos=favoritos;

    }

    public int getImagen() {

        return imagen;
    }

    public void setImagen(int imagen) {

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


    public String getFavoritos() {

        return favoritos;
    }

    public void setFavoritos(String favoritos) {

        this.favoritos = favoritos;
    }
}

