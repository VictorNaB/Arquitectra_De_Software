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
public class Donacion {

    private int idDonacion;
    private int idUsuario;
    private int idCampania;
    private int idTipoDonacion;
    private Date fechaDonacion;
    private String descripcion;
    private int valor;

    // Constructor vacío
    public Donacion() {
    }

    // Constructor con parámetros
    public Donacion(int idDonacion, int idUsuario, int idCampania, int idTipoDonacion,
                    Date fechaDonacion, String descripcion, int valor) {
        this.idDonacion = idDonacion;
        this.idUsuario = idUsuario;
        this.idCampania = idCampania;
        this.idTipoDonacion = idTipoDonacion;
        this.fechaDonacion = fechaDonacion;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    // Getters y Setters
    public int getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(int idDonacion) {
        this.idDonacion = idDonacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCampania() {
        return idCampania;
    }

    public void setIdCampania(int idCampania) {
        this.idCampania = idCampania;
    }

    public int getIdTipoDonacion() {
        return idTipoDonacion;
    }

    public void setIdTipoDonacion(int idTipoDonacion) {
        this.idTipoDonacion = idTipoDonacion;
    }

    public Date getFechaDonacion() {
        return fechaDonacion;
    }

    public void setFechaDonacion(Date fechaDonacion) {
        this.fechaDonacion = fechaDonacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    // toString()
    @Override
    public String toString() {
        return "Donacion{" +
                "idDonacion=" + idDonacion +
                ", idUsuario=" + idUsuario +
                ", idCampania=" + idCampania +
                ", idTipoDonacion=" + idTipoDonacion +
                ", fechaDonacion=" + fechaDonacion +
                ", descripcion='" + descripcion + '\'' +
                ", valor=" + valor +
                '}';
    }
}
