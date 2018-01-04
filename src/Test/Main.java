/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author TheJunior
 */
public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String cadena;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

    static void menu() {
        
        int opcMenu = 0;

        do {
            System.out.println("---Menu---");
            System.out.println("1.Crear Cliente");
            System.out.println("2.Eliminar Cliente");
            System.out.println("3.Crear Articulo");
            System.out.println("4.Eliminar Articulo");
            System.out.println("5.Update stock del Articulo");
            System.out.println("6.Crear Pedido");
            System.out.println("7.Eliminar Pedido");
            System.out.println("8.Ver Todos los Pedidos");
            System.out.println("9.Ver todos los clientes");
            System.out.println("10.Ver todos los articulos");
            System.out.println("11.Salir");
        } while (opcMenu != 11);

        switch (opcMenu) {
            case 1:
                System.out.println("---Crear Cliente---");

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

                break;

        }

    }

}
