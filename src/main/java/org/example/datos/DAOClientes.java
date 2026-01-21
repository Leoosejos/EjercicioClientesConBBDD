package org.example.datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOClientes {
    ArrayList<Cliente> listaClientes = new ArrayList<>();

    public static void altaCliente(Cliente c) throws SQLException {
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO clientes (nombre, apellido, dni) VALUES (?, ?, ?)";
        PreparedStatement ps = conexion.getConn().prepareStatement(sql);
        ps.setString(1, c.getNombre());
        ps.setString(2, c.getApellido());
        ps.setString(3, c.getDni());
        ps.executeUpdate();
    }

    public ArrayList<Cliente> getall() throws SQLException {

        Conexion conexion = new Conexion();
        Statement stml = conexion.getConn().createStatement();
        String sql = "SELECT * FROM clientes";
        ResultSet rs = stml.executeQuery(sql);

        while (rs.next()){
            listaClientes.add(new Cliente(
                    rs.getInt("id"),
                    rs.getString("dni"),
                    rs.getString("nombre"),
                    rs.getString("apellido")));
        }
        rs.close();
        stml.close();
        conexion.getConn().close();
        return listaClientes;
    }

    public ArrayList<Cliente> getOne(String dni) throws SQLException {
        Conexion conexion = new Conexion();
        Statement stml = conexion.getConn().createStatement();
        String sql = "SELECT * FROM clientes where dni = '" + dni + "'";
        ResultSet rs = stml.executeQuery(sql);

        while (rs.next()){
            listaClientes.add(new Cliente(
                    rs.getInt("id"),
                    rs.getString("dni"),
                    rs.getString("nombre"),
                    rs.getString("apellido")));
        }
        rs.close();
        stml.close();
        conexion.getConn().close();
        return listaClientes;
    }

    public void eliminar (int opcion) throws SQLException {
        Conexion conexion = new Conexion();
        String sql = "DELETE FROM clientes WHERE id = ?";
        PreparedStatement ps = conexion.getConn().prepareStatement(sql);
        ps.setInt(1, opcion);
        ps.executeUpdate();
    }

    public void modificar(Cliente a) throws SQLException {
        Conexion conexion = new Conexion();
        String sql = "UPDATE clientes SET dni = ?, nombre = ?, apellido = ? WHERE id = ?";
        PreparedStatement ps = conexion.getConn().prepareStatement(sql);
        ps.setString(1, a.getDni());
        ps.setString(2, a.getNombre());
        ps.setString(3, a.getApellido());
        ps.setInt(4, a.getId());
        ps.executeUpdate();
    }

}
