/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author TheJunior
 */
public class Main {
    
    
        public static BufferedReader cadena = new BufferedReader(new InputStreamReader(System.in));
        private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
        menu();

    }

    static void menu() throws IOException, SQLException {
        
        int opcMenu = 0;

        do {
            System.out.println("---Menu---");
            System.out.println("1.Crear Cliente");
            System.out.println("2.Eliminar Cliente");
            System.out.println("3.Crear Articulo");
            System.out.println("4.Eliminar Articulo");
            System.out.println("5.Update stock del Articulo");
            System.out.println("6.Crear Pedido");/*Restar stock artiuculo, comprobar que articulo existe*/
            System.out.println("7.Eliminar Pedido");/*devolver stock a articulo*/
            System.out.println("8.Ver Todos los Pedidos");
            System.out.println("9.Ver todos los clientes");
            System.out.println("10.Ver todos los articulos");     
            System.out.println("11.Salir");
            opcMenu = Integer.parseInt(cadena.readLine());

        switch (opcMenu) {
            case 1:
                System.out.println("---Crear Cliente---");
                Crearcliente();

                break;
            case 2:
                System.out.println("---Eliminar Cliente---");

                break;
            case 3:
                System.out.println("---Crear Articulo---");

                break;
            case 4:
                System.out.println("---Eliminar Articulo---");

                break;
            case 5:
                System.out.println("---Update stock del Articulo---");

                break;
            case 6:
                System.out.println("---Crear Pedido---");

                break;
            case 7:
                System.out.println("---Eliminar Pedido---");

                break;
            case 8:
                System.out.println("---Ver Todos los Pedidos---");

                break;
            case 9:
                System.out.println("---Ver todos los clientes---");

                break;
            case 10:
                System.out.println("---Ver todos los articulos---");

                break;
            default:
                System.out.println("¡Selecciona una opcion del menu!");
                break;
                

        }
        } while (opcMenu != 11);

    }
    
     private static void Crearcliente() throws SQLException {
        connection = conexionbasedatos.Obtenerinstancia();
        statement = connection.createStatement();
        
        statement.executeUpdate("INSERT INTO departamentos (`nombre`)" + "VALUES('" + "Recursos Humanos" + "')");


    }

}
