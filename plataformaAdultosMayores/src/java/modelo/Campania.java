/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author barro
 */
public class Campania {
    
    private int idCampania;
    private int idUsuario;
    private Date fechaPublicacion;
    private String titulo;
    private String descripcion;

    // Constructor vacío
    public Campania() {
    }

    // Constructor con parámetros
    public Campania(int idCampania, int idUsuario, Date fechaPublicacion, String titulo, String descripcion) {
        this.idCampania = idCampania;
        this.idUsuario = idUsuario;
        this.fechaPublicacion = fechaPublicacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getIdCampania() {
        return idCampania;
    }

    public void setIdCampania(int idCampania) {
        this.idCampania = idCampania;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
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

    // toString()
    @Override
    public String toString() {
        return "Campania{" +
                "idCampania=" + idCampania +
                ", idUsuario=" + idUsuario +
                ", fechaPublicacion=" + fechaPublicacion +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
