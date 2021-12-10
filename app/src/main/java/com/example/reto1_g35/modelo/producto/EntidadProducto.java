package com.example.reto1_g35.modelo.producto;

public class EntidadProducto {

    private int imagen;
    private String titulo;
    private String descripcion;
    private String valor;
    private Boolean favoritos;

    public EntidadProducto(int imagen, String titulo, String descripcion, String valor, Boolean favoritos ) {
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


    public Boolean getFavoritos() {

        return favoritos;
    }

    public void setFavoritos(Boolean favoritos) {

        this.favoritos = favoritos;
    }




}
