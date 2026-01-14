package org.example.datos;
import java.sql.SQLException;
import java.util.ArrayList;

public class FachadaBBDD {
    DAOClientes f = new DAOClientes();
    public void altaClientes(Cliente c) throws SQLException {

        f.altaCliente(c);
    }

    public ArrayList<Cliente> getAll() throws SQLException {
        return f.getall();
    }

    public ArrayList<Cliente> getOne(String dni) throws SQLException {
        return f.getOne(dni);
    }

}
