/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author barro
 */
public class Bd {

    private Connection conn = null;

    public Bd() {
    }

    public Bd(String DB_URL, String DB_USER, String DB_PASSWORD) throws SQLException {
       conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public Connection getConn() {
        return conn;
    }
}
