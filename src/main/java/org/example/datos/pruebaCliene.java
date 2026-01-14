package org.example.datos;

import java.sql.SQLException;

public class pruebaCliene {
    public static void main(String[] args){

    try {
        FachadaBBDD f = new FachadaBBDD();

        //Alta de un cliente
//        Cliente c = new Cliente("Z5485793F", "Leonardo", "Osejos");
//        f.altaClientes(c);

        //Consulta de todos los clientes
//        for (Cliente cliente : f.getAll()){
//            System.out.println(cliente.toString());
//        }

        //Consulta de un cliente
        for (Cliente cliente : f.getOne("Z5485793F")){
            System.out.println(cliente.toString());
        }

    }catch (SQLException e){
        System.out.println("Hay un error");
    }

    }
}
