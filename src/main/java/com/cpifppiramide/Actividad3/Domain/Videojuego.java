package com.cpifppiramide.Actividad3.Domain;
//Dcoumentacion
//http://localhost:8080/swagger-ui/index.html
public class Videojuego {

    private String nombre;
    private String categoria;
    private Double precio;

    public Videojuego(String nombre, String categoria, Double precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
