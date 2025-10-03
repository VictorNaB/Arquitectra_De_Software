/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package persistencia;

import modelo.Acceso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author barro
 */
public class AccesoRepositorio {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/plataformaAdultoMayor";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "salchipapa123";
    
    public AccesoRepositorio() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void saveAcceso(Acceso acceso) {
        String sql = "INSERT INTO accesos (id_usuario, correo, contraseña) VALUES (?, ?, ?)";

        try {
            Bd x = new Bd(DB_URL, DB_USER, DB_PASSWORD);
            Connection conn = x.getConn();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, acceso.getIdUsuario());
            stmt.setString(2, acceso.getCorreo());
            stmt.setString(3, acceso.getContrasena());

            int filasInsertadas = stmt.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Acceso guardado exitosamente.");
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al guardar el acceso: " + e.getMessage());
        }
    }   
    
    public Acceso obtenerAcceso(String correo, String contrasena) {
    String sql = "SELECT id_usuario, correo, contraseña FROM accesos WHERE correo = ? AND contraseña = ?";
    Acceso acceso = null;

    try {
        Bd x = new Bd(DB_URL, DB_USER, DB_PASSWORD);
        Connection conn = x.getConn();

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, correo);
        stmt.setString(2, contrasena);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            acceso = new Acceso();
            acceso.setIdUsuario(rs.getInt("id_usuario"));
            acceso.setCorreo(rs.getString("correo"));
            acceso.setContrasena(rs.getString("contraseña"));
        }

        rs.close();
        stmt.close();
        conn.close();

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al obtener el acceso: " + e.getMessage());
    }

    return acceso;
}
}
