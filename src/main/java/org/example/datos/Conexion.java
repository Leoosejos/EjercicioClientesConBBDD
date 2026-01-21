package org.example.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Conexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/estudiantes?serverTimezone=UTC";
        String user = "root";
        String pass = "";
        conn = DriverManager.getConnection(url, user, pass);
    }
}
