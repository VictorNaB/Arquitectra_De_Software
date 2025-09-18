/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

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


public class Usuarios extends HttpServlet {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/Plataforma_Sueños";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "2324";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        int id_tipo_documento = Integer.parseInt(request.getParameter("tipodocumento"));
        String documento = request.getParameter("documento");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String genero = request.getParameter("genero");
        String fecha_nacimiento_str = request.getParameter("fecha_nacimiento");
        java.sql.Date fecha_nacimiento = java.sql.Date.valueOf(fecha_nacimiento_str);
        int id_tipo_telefono = Integer.parseInt(request.getParameter("idtipotelefono"));
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String contraseña = request.getParameter("contraseña");

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            conn.setAutoCommit(false); // iniciar transacción

            // 1. Insertar usuario
            String sqlUser = "INSERT INTO usuarios (id_tipo_documento, documento_usuario, nombre_usuario, apellidos_usuario, genero_usuario, fecha_nacimiento_usuario,id_tipo_telefono,telefono) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING cod_usuario";
            PreparedStatement stmtUser = conn.prepareStatement(sqlUser);
            stmtUser.setInt(1, id_tipo_documento);
            stmtUser.setString(2, documento);
            stmtUser.setString(3, nombre);
            stmtUser.setString(4, apellidos);
            stmtUser.setString(5, genero);
            stmtUser.setDate(6, fecha_nacimiento);
            stmtUser.setInt(7, id_tipo_telefono);
            stmtUser.setString(8, telefono);

            ResultSet rsUser = stmtUser.executeQuery();
            int codUsuario = 0;
            if (rsUser.next()) {
                codUsuario = rsUser.getInt("cod_usuario");
            }
            rsUser.close();
            stmtUser.close();

            String sqlCred = "INSERT INTO correos (id_usuario, correo, contraseña) VALUES (?, ?, ?)";
            PreparedStatement stmtCred = conn.prepareStatement(sqlCred);
            stmtCred.setInt(1, codUsuario);
            stmtCred.setString(2, correo);
            stmtCred.setString(3, contraseña);
            stmtCred.executeUpdate();
            stmtCred.close();

            conn.commit(); 
            conn.close();

            request.setAttribute("mensaje", "✅ Usuario registrado con éxito.");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error al registrar el usuario: " + e.getMessage());
        }

        request.getRequestDispatcher("FormUsuario.jsp").forward(request, response);
    }

}