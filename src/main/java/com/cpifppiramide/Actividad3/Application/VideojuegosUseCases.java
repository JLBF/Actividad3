package com.cpifppiramide.Actividad3.Application;

import com.cpifppiramide.Actividad3.Domain.Videojuego;
import com.cpifppiramide.Actividad3.Domain.VideojuegosRepository;

import java.util.List;

public class VideojuegosUseCases {

    private VideojuegosRepository videojuegosRepository;

    public VideojuegosUseCases(VideojuegosRepository videojuegosRepository){
        this.videojuegosRepository = videojuegosRepository;
    }

    public List<Videojuego> getAll(){
        return this.videojuegosRepository.getAll();
    }

    public Videojuego getVideojuego(String nombre){
        return this.videojuegosRepository.getVideojuego(nombre);
    }

    public Videojuego save(Videojuego videojuego){
        return this.videojuegosRepository.save(videojuego);
    }

    public Videojuego update(String nombre, Videojuego videojuego){
        return this.videojuegosRepository.update(nombre, videojuego);
    }

    public String delete(String id){
        return this.videojuegosRepository.delete(id);
    }

}
