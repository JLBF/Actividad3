package com.cpifppiramide.Actividad3.Domain;

import java.util.List;

public interface VideojuegosRepository {

    public List<Videojuego> getAll();
    public Videojuego getVideojuego(String nombre);

    public Videojuego save(Videojuego videojuego);

    public Videojuego update(String nombre, Videojuego actualizado);
    public String  delete(String id);

}
