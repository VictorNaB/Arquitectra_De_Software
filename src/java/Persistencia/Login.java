/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import static Persistencia.Usuarios.DB_URL;
import com.sun.jdi.connect.spi.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Vector
 */
public class Login extends HttpServlet {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/Prueba";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "2324";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recibir parámetros del formulario
        String correo = request.getParameter("correo");
        String contraseña = request.getParameter("contraseña");

        try (PrintWriter out = response.getWriter()) {
            Class.forName("org.postgresql.Driver");
            java.sql.Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "SELECT * FROM accesos WHERE correo = ? AND contraseña = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, correo);
            stmt.setString(2, contraseña);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Usuario válido → guardar sesión
                HttpSession session = request.getSession();
                session.setAttribute("correo", correo);

            } else {
                // Usuario inválido
                request.setAttribute("mensaje", "Correo o contraseña incorrectos.");
                request.getRequestDispatcher("FormLogin.jsp").forward(request, response);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error en el login: " + e.getMessage());
        }
    }

}
