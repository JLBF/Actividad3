package com.cpifppiramide.Actividad3.Infraestructure;

import com.cpifppiramide.Actividad3.Application.VideojuegosUseCases;
import com.cpifppiramide.Actividad3.Domain.Videojuego;
import com.cpifppiramide.Actividad3.Infraestructure.db.VideojuegosRepositorySQL;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideojuegosRestController {

    private VideojuegosUseCases videojuegosUseCases;

    public VideojuegosRestController(){
        this.videojuegosUseCases = new VideojuegosUseCases(new VideojuegosRepositorySQL());
    }

    @GetMapping("/videojuegos")
    List<Videojuego> getAll(){
        return this.videojuegosUseCases.getAll();
    }

    @GetMapping("/videojuegos/{nombre}")
    Videojuego getVideojuego(@PathVariable String nombre){
        return this.videojuegosUseCases.getVideojuego(nombre);
    }

    @PostMapping(path = "videojuegos", consumes = MediaType.APPLICATION_JSON_VALUE)
    Videojuego save(@RequestBody Videojuego videojuego){
        return this.videojuegosUseCases.save(videojuego);
    }
    @DeleteMapping("/videojuegos/{nombre}")
    String delete(@PathVariable String nombre){
        return this.videojuegosUseCases.delete(nombre);
    }


}
