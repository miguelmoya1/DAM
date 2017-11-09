/**
 * CREATE DATABASE "Logs";
 *
 * CREATE TABLE log(
 * id SERIAL PRIMARY KEY,
 * message varchar(255),
 * time TIMESTAMP DEFAULT current_timestamp
 * );
 */
package logs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel Moya Ortega
 */
public class Logs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/Logs";
            String usuario = "postgres";
            String password = "mi1995guel";
            Connection con = DriverManager.getConnection(url, usuario, password);
            Scanner scanner = new Scanner(System.in);
            boolean finish = false;

            while (!finish) {
                System.out.println("Introduce el texto a guardar (vacio para salir): ");
                String message = scanner.nextLine();

                System.out.println(message);
                if (message == "") {
                    finish = true;
                } else {
                    Statement statement = con.createStatement();

                    String sql = " INSERT INTO log (message) VALUES ('" + message + "');";

                    int cantidad = statement.executeUpdate(sql);
                    if (cantidad == 0) {
                        System.out.println("Se ha guardado correctamente.");
                    } else {
                        System.err.println("No se ha podido guardar.");
                    }
                    statement.close();
                }
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Logs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Logs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
