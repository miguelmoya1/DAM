/**
 *
 * Creación de tablas
 *
 * CREATE TABLE IF NOT EXISTS programadores (
 * id serial primary key,
 * nombre varchar(20)
 * );
 *
 * CREATE TABLE IF NOT EXISTS lenguajes (
 * id serial primary key,
 * nombre varchar(20)
 * );
 *
 * CREATE TABLE IF NOT EXISTS conocer (
 * fk_programadores integer references programadores(id),
 * fk_lenguajes integer references lenguajes(id),
 * nivel integer
 * );
 *
 */
package personal;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel Moya Ortega
 */
public class Personal {

    public static void limpiar(int lineas) {
        for (int i = 0; i < lineas; i++) {
            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.println("fkfrj");
        try {
            Runtime.getRuntime().exec("clear");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("hola");
        }
        // TODO code application logic here
    }

}
