/**
 * Miguel Moya Ortega
 * base de datos de polos
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultaBD1 {

    public static void main(String[] args) {
        try {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/polos";
        String usuario = "postgres";
        String password = "mi1995guel";
        Connection con = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("No se ha podido encontrar la clase");
        } catch (SQLException ex) {
            System.out.println("Error en la sql.");
        }

        boolean finish = false;
        Scanner scanner = new Scanner(System.in);
        byte opcion;

        while (!finish) {
            System.out.println("¿Qué operación desea realizar?");
            System.out.println("    1) Añadir polo.");
            System.out.println("    2) Ver polos.");
            System.out.println("    0) Salir.");
            opcion = scanner.nextByte();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Introduce la marca:");
                    String marca = scanner.nextLine();
                    System.out.println("Introduce el sabor:");
                    String sabor = scanner.nextLine();
                    System.out.println("Introduce el precio:");
                    double price = scanner.nextDouble();
                    try {
                    addPolo(con, marca, sabor, price);
                    } catch (ClassNotFoundException ex) {
                        System.out.println("No se ha encontrado la clase.");
                    } catch (SQLException ex) {
                        System.out.println("Error en la sql.");
                    }
                    break;
                case 2:
                    try {
                        showPolos(con);
                    } catch (ClassNotFoundException ex) {
                        System.out.println("No se ha encontrado la clase.");
                    } catch (SQLException ex) {
                        System.out.println("Error en la sql.");
                    }
                    break;
                case 0:
                    finish = !finish;
                    break;
                default:
                    System.out.println("Opción no reconocida.");
            }
        }
        con.close();
    }

    /**
     *
     * @param con
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void showPolos(Connection con) throws ClassNotFoundException, SQLException {

        Statement statement = con.createStatement();

        String sentenciaSQL = "SELECT * FROM polos";
        ResultSet rs = statement.executeQuery(sentenciaSQL);

        System.out.println(String.format("%-20s", "id")
                + String.format("%-20s", "marca")
                + String.format("%-20s", "sabor")
                + String.format("%-20s", "precio"));
        System.out.println("-------------------------------------"
                + "-------------------------------");
        while (rs.next()) {
            System.out.println(String.format("%-20s", rs.getString(1))
                    + String.format("%-20s", rs.getString(2))
                    + String.format("%-20s", rs.getString(3))
                    + String.format("%-20s", rs.getString(4)));
        }
        rs.close();
    }

    /**
     *
     * @param con
     * @param marca
     * @param sabor
     * @param precio
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void addPolo(Connection con, String marca, String sabor, double precio)
            throws ClassNotFoundException, SQLException {

        Statement statement = con.createStatement();

        String sql = " INSERT INTO polos (marca, sabor, precio) VALUES ('" + marca + "', '"
                + sabor + "', '" + precio + "');";

        int cantidad = statement.executeUpdate(sql);
        if (cantidad < 0) System.out.println("Se ha guardado correctamente.");
        else System.err.println("No se ha podido guardar.");
        statement.close();
    }
}
