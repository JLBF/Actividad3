package com.cpifppiramide.Actividad3.Infraestructure.db;

import com.cpifppiramide.Actividad3.Domain.Videojuego;
import com.cpifppiramide.Actividad3.Domain.VideojuegosRepository;

import java.util.List;

public class VideojuegosRepositorySQL implements VideojuegosRepository {
    @Override
    public List<Videojuego> getAll() {
        return null;
    }

    @Override
    public Videojuego getVideojuego(String id) {
        return null;
    }

    @Override
    public Videojuego save(Videojuego videojuego) {
        return null;
    }

    @Override
    public Videojuego update(String id, Videojuego actualizado) {
        return null;
    }

    @Override
    public String delete(String id) {
        return null;
    }
}
