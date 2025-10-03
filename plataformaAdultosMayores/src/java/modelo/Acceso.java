/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package modelo;

/**
 *
 * @author barro
 */
public class Acceso {

    private int idUsuario;
    private String correo;
    private String contrasena;

    // Constructor vacío
    public Acceso() {
    }

    // Constructor con parámetros
    public Acceso(int idUsuario, String correo, String contrasena) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // toString()
    @Override
    public String toString() {
        return "Acceso{" +
                "idUsuario=" + idUsuario +
                ", correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
