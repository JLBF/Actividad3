package com.cpifppiramide.Actividad3.Application;

import com.cpifppiramide.Actividad3.Domain.Videojuego;
import com.cpifppiramide.Actividad3.Infraestructure.db.VideojuegosRepositorySQL;
import context.ConnectionManagerTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VideojuegosUseCasesTest {

    Connection con = ConnectionManagerTest.getConnection();
    private VideojuegosUseCases videojuegosUseCases;

    public VideojuegosUseCasesTest(){
        this.videojuegosUseCases = new VideojuegosUseCases(new VideojuegosRepositorySQL());
    }

    @AfterEach
    public void limpiarBD(){
        try {
            Statement stmnt = con.createStatement();
            stmnt.execute("DELETE FROM videojuegos");
            stmnt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void getAll() {
        List<Videojuego> videojuegos = this.videojuegosUseCases.getAll();
        assertEquals(0, videojuegos.size());
    }

    @Test
    public void getVideojuego() {

        String nombre = "Minecraft";
        Videojuego videojuego = videojuegosUseCases.getVideojuego(nombre);
        assertNull(videojuego);

    }

    @Test
    public void save() {

        Videojuego videojuego = new Videojuego("Diablo IV", "RPG", 55.55);
        Videojuego saved = this.videojuegosUseCases.save(videojuego);

        assertEquals("Diablo IV", saved.getNombre());
        assertNotNull(saved.getPrecio());
    }

    @Test
    public void update() {

        Videojuego videojuego = new Videojuego("Diablo IV", "RPG", 55.55);
        videojuegosUseCases.save(videojuego);

        Double precio = 45.64;
        Videojuego actualizar = videojuegosUseCases.getVideojuego("Diablo IV");
        actualizar.setPrecio(precio);
        Videojuego actualizado = videojuegosUseCases.update("Diablo IV", actualizar);

        assertEquals(precio, actualizado.getPrecio());
    }

    @Test
    public void delete() {

    }
}