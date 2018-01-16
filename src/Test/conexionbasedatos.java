/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author Jordi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jordi
 */
public class conexionbasedatos {

    private static Connection instance;
    public static final String url = "jdbc:mysql://localhost:3306/javapractica";
    public static final String username = "root";
    public static final String password = "";
    
    private conexionbasedatos() {
    }

    public static Connection Obtenerinstancia() throws SQLException {
        if (instance == null) {
            System.out.println("Iniciando base de datos");
            instance = DriverManager.getConnection(url, username, password);
        }

        return instance;
    }

    public static void Cerrarinstancia() throws SQLException {
        if (instance != null) {
            System.out.println("Cerrando instancia");
            instance.close();
            instance = null;
        }
    }
    
}
