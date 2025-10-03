/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package persistencia;

import modelo.Usuario;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author barro
 */
public class UsuarioRepositorio {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/plataformaAdultoMayor";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "salchipapa123";
    
    public UsuarioRepositorio() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public int saveUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (id_tipo_documento, documento_usuario, nombre_usuario, " +
                 "apellidos_usuario, genero_usuario, idrol, fecha_nacimiento_usuario, id_tipo_telefono, telefono) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING cod_usuario";
        
        int cod_usuario = -1;
        
        try {
            Bd x = new Bd(DB_URL, DB_USER, DB_PASSWORD);
            Connection conn = x.getConn();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuario.getIdTipoDocumento());
            stmt.setString(2, usuario.getDocumentoUsuario());
            stmt.setString(3, usuario.getNombreUsuario());
            stmt.setString(4, usuario.getApellidosUsuario());
            stmt.setString(5, usuario.getGeneroUsuario());
            stmt.setInt(6, usuario.getIdRol());

            // si usas java.sql.Date
            stmt.setDate(7, new java.sql.Date(usuario.getFechaNacimientoUsuario().getTime()));

            stmt.setInt(8, usuario.getIdTipoTelefono());
            stmt.setString(9, usuario.getTelefono());

            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("Usuario guardado exitosamente.");
                cod_usuario = rs.getInt("cod_usuario");
            }
            
            
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al guardar el usuario: " + e.getMessage());
        }
        
        return cod_usuario;
    }   
}
