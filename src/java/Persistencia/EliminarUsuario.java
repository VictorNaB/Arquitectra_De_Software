/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EliminarUsuario extends HttpServlet {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/Plataforma_Sueños";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "2324";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("id_usuario") == null) {
            request.setAttribute("mensaje", "⚠️ Debes iniciar sesión primero.");
            request.getRequestDispatcher("FormLogin.jsp").forward(request, response);
            return;
        }

        int idUsuario = (int) session.getAttribute("id_usuario");

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            conn.setAutoCommit(false);

            // Primero eliminar de correos
            String sqlCorreo = "DELETE FROM correos WHERE id_usuario = ?";
            PreparedStatement stmtCorreo = conn.prepareStatement(sqlCorreo);
            stmtCorreo.setInt(1, idUsuario);
            stmtCorreo.executeUpdate();
            stmtCorreo.close();

            // Luego eliminar de usuarios
            String sqlUser = "DELETE FROM usuarios WHERE cod_usuario = ?";
            PreparedStatement stmtUser = conn.prepareStatement(sqlUser);
            stmtUser.setInt(1, idUsuario);
            stmtUser.executeUpdate();
            stmtUser.close();

            conn.commit();
            conn.close();

            // Cerrar sesión
            session.invalidate();

            request.setAttribute("mensaje", "✅ Tu cuenta ha sido eliminada correctamente.");
            request.getRequestDispatcher("FormLogin.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensaje", "❌ Error al eliminar la cuenta: " + e.getMessage());
            
        }
    }
}