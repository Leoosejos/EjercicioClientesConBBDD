package org.example.datos;

import java.sql.*;

public class pruebaConexion {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/estudiantes?serverTimezone=UTC";
            String user = "root";
            String pass = "";
            // TODO code application logic here
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM clientes");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("nombre") + " - " + rs.getString("apellido")+ " - " + rs.getString("dni"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("No se ha podido conectar con la base de datos");
        }
    }
}
