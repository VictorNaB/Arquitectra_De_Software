/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import static Persistencia.Usuarios.DB_URL;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Vector
 */
public class Campañas extends HttpServlet {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/Prueba";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "2324";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fechaPublicacion = request.getParameter("Fechapublicacion");
        String titulo = request.getParameter("Titulo");
        String descripcion = request.getParameter("Descripcion");

        //Integer codUsuario = (int) request.getSession().getAttribute("cod_usuario");
        int codUsuario = 4;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            conn.setAutoCommit(false); // iniciar transacción

           String sqlGetAdulto = "SELECT cod_usuario FROM usuarios WHERE cod_usuario = ?";
            PreparedStatement stmtGetAdulto = conn.prepareStatement(sqlGetAdulto);
            stmtGetAdulto.setInt(1, codUsuario);
            ResultSet rs = stmtGetAdulto.executeQuery();

            int idAdultoMayor = 0;
            if (rs.next()) {
                idAdultoMayor = rs.getInt("cod_usuario");
            } else {
                throw new Exception("No se encontró adulto mayor para el usuario");
            }
            rs.close();
            stmtGetAdulto.close();

            String sqlInsertCampaña = "INSERT INTO campañas (id_usuario, fecha_publicacion, titulo, descripcion) VALUES (?, ?, ?, ?)";
            PreparedStatement stmtInsert = conn.prepareStatement(sqlInsertCampaña);
            stmtInsert.setInt(1, idAdultoMayor);
            stmtInsert.setDate(2, java.sql.Date.valueOf(fechaPublicacion));
            stmtInsert.setString(3, titulo);
            stmtInsert.setString(4, descripcion);

            stmtInsert.executeUpdate();
            stmtInsert.close();

            conn.commit();
            conn.close();

            request.setAttribute("mensaje", "Campaña registrada con éxito");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensaje", "Error: " + e.getMessage());
        }
        request.getRequestDispatcher("FormCampañas.jsp").forward(request, response);

    }

}
