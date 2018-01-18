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
                    crearcliente();

                    break;
                case 2:
                    System.out.println("---Eliminar Cliente---");
                    borrarcliente();
                    break;
                case 3:
                    System.out.println("---Crear Articulo---");
                    creararticulo();

                    break;
                case 4:
                    System.out.println("---Eliminar Articulo---");
                    borrararticulo();
                    break;
                case 5:
                    System.out.println("---Update stock del Articulo---");
                    cambiarstock();
                    break;
                case 6:
                    System.out.println("---Crear Pedido---");
                    crearPedido();
                    break;
                case 7:
                    System.out.println("---Eliminar Pedido---");
                    borrarPedido();
                    break;
                case 8:
                    System.out.println("---Ver Todos los Pedidos---");
                    verTodosPedidos();
                    break;
                case 9:
                    System.out.println("---Ver todos los clientes---");
                    verTodosClientes();
                    break;
                case 10:
                    System.out.println("---Ver todos los articulos---");
                    verTodosArticulos();
                    break;
                default:
                    System.out.println("¡Selecciona una opcion del menu!");
                    break;

            }
        } while (opcMenu != 11);

    }

    private static void crearcliente() throws SQLException, IOException {
        connection = conexionbasedatos.Obtenerinstancia();
        statement = connection.createStatement();
        String dni, nombre;

        System.out.println("Inserta el dni ");
        dni = cadena.readLine();
        System.out.println("Inserta el nombre");
        nombre = cadena.readLine();

        statement.executeUpdate("INSERT INTO cliente VALUES('" + dni + "','" + nombre + "')");

    }

    private static void creararticulo() throws SQLException, IOException {
        connection = conexionbasedatos.Obtenerinstancia();
        statement = connection.createStatement();
        String nombre;
        int numeroserie, stock;

        System.out.println("Inserta el numero de serie ");
        numeroserie = Integer.parseInt(cadena.readLine());
        System.out.println("Inserta el nombre");
        nombre = cadena.readLine();
        System.out.println("Inserta el stock");
        stock = Integer.parseInt(cadena.readLine());

        statement.executeUpdate("INSERT INTO articulo VALUES('" + numeroserie + "','" + nombre + "','" + stock + "')");
        System.out.println("Articulo creado correctamente");

    }

    private static void borrararticulo() throws SQLException, IOException {
        connection = conexionbasedatos.Obtenerinstancia();
        statement = connection.createStatement();
        int numeroserie;
        System.out.println("Inserta el numero de serie del articulo a borrar");
        numeroserie = Integer.parseInt(cadena.readLine());

        statement.executeUpdate("DELETE FROM `articulo` WHERE(numSerie =" + numeroserie + ")");
        System.out.println("Articulo borrado correctamente");

    }

    private static void borrarcliente() throws SQLException, IOException {
        connection = conexionbasedatos.Obtenerinstancia();
        statement = connection.createStatement();
        String dni;
        System.out.println("Inserta el dni del usuario a borrar");
        dni = cadena.readLine();

        statement.executeUpdate("DELETE FROM `cliente` WHERE(dni =" + dni + ")");
        System.out.println("Cliente borrado correctamente");

    }

    private static void cambiarstock() throws SQLException, IOException {
        connection = conexionbasedatos.Obtenerinstancia();
        statement = connection.createStatement();
        int numeroserie, stock;

        System.out.println("Inserta el numero de articulo a modificar stock");
        numeroserie = Integer.parseInt(cadena.readLine());
        System.out.println("Inserte stock deseado");
        stock = Integer.parseInt(cadena.readLine());

        statement.executeUpdate("UPDATE `articulo` SET `stock`=" + stock + " WHERE `numSerie` =" + numeroserie);
        System.out.println("Cliente borrado correctamente");

    }

    private static void verTodosArticulos() throws SQLException {
        connection = conexionbasedatos.Obtenerinstancia();
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("Select * from Articulo");
        while (rs.next()) {
            int numSerie = rs.getInt("numSerie");
            String name = rs.getString("nombre");
            int stock = rs.getInt("stock");

            System.out.println("El Articulo con numero de serie " + numSerie + " con nombre " + name + " i con un stock de " + stock);
        }

    }

    private static void verTodosClientes() throws SQLException {
        connection = conexionbasedatos.Obtenerinstancia();
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("Select * from cliente");
        while (rs.next()) {
            String dni = rs.getString("dni");
            String name = rs.getString("nombre");
            System.out.println("El cliente con nombre " + name + " y Dni: " + dni);
        }

    }

    private static void verTodosPedidos() throws SQLException {
        connection = conexionbasedatos.Obtenerinstancia();
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("Select * from pedido");
        while (rs.next()) {
            String dni = rs.getString("dni");
            String name = rs.getString("numSerie");
            System.out.println("El pedido con nombre " + name + " y Dni: " + dni);
        }

    }

    private static void crearPedido() throws SQLException, IOException {
        int numserie, stockdisp = 0, stockpedido, stockfinal;
        System.out.println("Inserta el numero de serie del articulo deseado");
        numserie = Integer.parseInt(cadena.readLine());
        connection = conexionbasedatos.Obtenerinstancia();
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT `stock` FROM `articulo` WHERE `numSerie` = " + numserie);
        while (rs.next()) {
            stockdisp = rs.getInt("stock");
            System.out.println("Stock disponible " + stockdisp);
        }
        rs.close();
        System.out.println("Inserta stock deseado adquirir");
        stockpedido = Integer.parseInt(cadena.readLine());
        if (stockpedido <= stockdisp) {
            System.out.println("Compra aceptada");
            stockfinal = stockdisp - stockpedido;
            
                    
            rs.close();
            System.out.println("Inserta el dni del cliente");
            String dni = cadena.readLine();
           statement.executeUpdate("INSERT INTO `pedido`(`dni`, `numSerie`, `cantidad`) VALUES('" + dni + "','" + numserie + "','" + stockpedido + "')");
           statement.executeUpdate("UPDATE `articulo` SET `stock`=" + stockfinal + " WHERE `numSerie` =" + numserie);
            System.out.println("Pedido creado correctamente");
        }else{
            System.out.println("El producto solicitado tiene un stock inferior al que requiere");
        }

    }
    private static void borrarPedido() throws SQLException, IOException {
        connection = conexionbasedatos.Obtenerinstancia();
        statement = connection.createStatement();
        int numpedido;
        System.out.println("Inserta el numero del pedido a borrar");
        numpedido = Integer.parseInt(cadena.readLine());

        statement.executeUpdate("DELETE FROM `pedido` WHERE(idPedido =" + numpedido + ")");
        System.out.println("Pedido borrado correctamente");

    }

}
