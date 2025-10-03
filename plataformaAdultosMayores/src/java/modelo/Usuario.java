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
public class Usuario {

    private int codUsuario;
    private int idTipoDocumento;
    private String documentoUsuario;
    private String nombreUsuario;
    private String apellidosUsuario;
    private String generoUsuario;
    private int idRol;
    private Date fechaNacimientoUsuario;
    private int idTipoTelefono;
    private String telefono;

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(int codUsuario, int idTipoDocumento, String documentoUsuario, String nombreUsuario, 
                   String apellidosUsuario, String generoUsuario, int idRol, 
                   Date fechaNacimientoUsuario, int idTipoTelefono, String telefono) {
        this.codUsuario = codUsuario;
        this.idTipoDocumento = idTipoDocumento;
        this.documentoUsuario = documentoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidosUsuario = apellidosUsuario;
        this.generoUsuario = generoUsuario;
        this.idRol = idRol;
        this.fechaNacimientoUsuario = fechaNacimientoUsuario;
        this.idTipoTelefono = idTipoTelefono;
        this.telefono = telefono;
    }

    // Getters y Setters
    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(String documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
    }

    public String getGeneroUsuario() {
        return generoUsuario;
    }

    public void setGeneroUsuario(String generoUsuario) {
        this.generoUsuario = generoUsuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public Date getFechaNacimientoUsuario() {
        return fechaNacimientoUsuario;
    }

    public void setFechaNacimientoUsuario(Date fechaNacimientoUsuario) {
        this.fechaNacimientoUsuario = fechaNacimientoUsuario;
    }

    public int getIdTipoTelefono() {
        return idTipoTelefono;
    }

    public void setIdTipoTelefono(int idTipoTelefono) {
        this.idTipoTelefono = idTipoTelefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // toString()
    @Override
    public String toString() {
        return "Usuario{" +
                "codUsuario=" + codUsuario +
                ", idTipoDocumento=" + idTipoDocumento +
                ", documentoUsuario='" + documentoUsuario + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", apellidosUsuario='" + apellidosUsuario + '\'' +
                ", generoUsuario='" + generoUsuario + '\'' +
                ", idRol=" + idRol +
                ", fechaNacimientoUsuario=" + fechaNacimientoUsuario +
                ", idTipoTelefono=" + idTipoTelefono +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
