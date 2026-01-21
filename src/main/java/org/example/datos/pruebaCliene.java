package org.example.datos;

import java.sql.SQLException;
import java.util.Scanner;

public class pruebaCliene {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
    try {
        FachadaBBDD f = new FachadaBBDD();

        //Alta de un cliente
//        Cliente c = new Cliente("Z5485793F", "Leonardo", "Osejos");
//        f.altaClientes(c);

        //Consulta de todos los clientes
        for (Cliente cliente : f.getAll()){
            System.out.println(cliente.toString());
        }

        //Consulta de un cliente
//        for (Cliente cliente : f.getOne("Z5485793F")){
//            System.out.println(cliente.toString());
//        }

        //Prueba eliminar
//        for (Cliente cliente : f.getAll()){
//            System.out.println(cliente.toString());
//        }
//        System.out.println("Dime el cliente que quieres eliminar(id): ");
//        int opcion = sc.nextInt();
//        f.eliminar(opcion);

        //Prueba de modificar
        for (Cliente cliente : f.getAll()){
            System.out.println(cliente.toString());
        }
        System.out.println("Dime el cliente que quieres modificar(id): ");
        int opcion1 = sc.nextInt();
        System.out.println("Introduce el nombre del cliente: ");
        String nombre = sc.next();
        System.out.println("Introduce el apellido del cliente: ");
        String apellido = sc.next();
        System.out.println("Introduce el DNI del cliente: ");
        String DNI = sc.next();
        f.modificar(new Cliente(opcion1, nombre,apellido,DNI));

    }catch (SQLException e){
        System.out.println("Hay un error");
    }

    }
}
