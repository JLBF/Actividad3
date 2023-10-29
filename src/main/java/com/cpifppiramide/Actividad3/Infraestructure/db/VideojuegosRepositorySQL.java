package com.cpifppiramide.Actividad3.Infraestructure.db;

import com.cpifppiramide.Actividad3.Domain.Videojuego;
import com.cpifppiramide.Actividad3.Domain.VideojuegosRepository;
import context.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideojuegosRepositorySQL implements VideojuegosRepository {

    Connection con = ConnectionManager.getConnection();
    @Override
    public List<Videojuego> getAll() {
        List<Videojuego> videojuegos = new ArrayList<>();
        try {
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM  videojuegos");

            while(rs.next()){
                 Videojuego videojuego = new Videojuego(
                     rs.getString("nombre"),
                     rs.getString("categoría"),
                     rs.getDouble("precio")
                 );
                videojuegos.add(videojuego);
            }

            stmnt.close();
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return videojuegos;
    }

    @Override
    public Videojuego getVideojuego(String nombre) {
        Videojuego videojuego = null;

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM videojuegos WHERE nombre LIKE ?");
            ps.setString(1, "%" + nombre + "%");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                videojuego = new Videojuego(
                        rs.getString("nombre"),
                        rs.getString("categoría"),
                        rs.getDouble("precio")
                );
            }

            ps.close();
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return videojuego;
    }

    @Override
    public Videojuego save(Videojuego videojuegoGuardar) {
        Videojuego videojuegoGuardado = null;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO videojuegos (nombre, categoría, precio) VALUES (?, ?, ?)");

            ps.setString(1, videojuegoGuardar.getNombre());
            ps.setString(2, videojuegoGuardar.getCategoria());
            ps.setDouble(3, videojuegoGuardar.getPrecio());

            int rowAfeccted = ps.executeUpdate();

            if(rowAfeccted > 0){
                videojuegoGuardado = videojuegoGuardar;
            }

            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return videojuegoGuardado;
    }

    @Override
    public Videojuego update(String nombre, Videojuego actualizado) {

        Videojuego actualizar = null;

        try {
            PreparedStatement ps1 = con.prepareStatement("SELECT * FROM videojuegos WHERE nombre LIKE ?");
            ps1.setString(1, "%" + nombre + "%");

            ResultSet rs = ps1.executeQuery();

            while(rs.next()){
                actualizar = new Videojuego(
                        rs.getString("nombre"),
                        rs.getString("categoría"),
                        rs.getDouble("precio")
                );
            }

            if(actualizado.getNombre() == null){
                actualizado.setNombre(actualizar.getNombre());
            }
            if(actualizado.getCategoria() == null){
                actualizado.setCategoria(actualizar.getCategoria());
            }
            if(actualizado.getPrecio() == null){
                actualizado.setPrecio(actualizar.getPrecio());
            }

            PreparedStatement ps2 = con.prepareStatement("UPDATE videojuegos SET nombre = ?, categoría = ?, precio = ? WHERE nombre = ?");
            ps2.setString(1, actualizado.getNombre());
            ps2.setString(2, actualizado.getCategoria());
            ps2.setDouble(3, actualizado.getPrecio());
            ps2.setString(4, nombre);

            ps2.executeUpdate();

            ps1.close();
            ps2.close();
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return actualizado;
    }

    @Override
    public String delete(String nombre) {

        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM videojuegos WHERE nombre = ?");
            ps.setString(1, nombre);

            int rowAffected = ps.executeUpdate();
            if(rowAffected <= 0){
                return "El videojuego no se ha encontrado en la base de datos";
            }

            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return "Videojuego borrado";
    }
}
