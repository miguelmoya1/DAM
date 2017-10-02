/**
 * Miguel Moya Ortega
 */
package csvtoxml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvToXml {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    new File("algo.csv")));

            PrintWriter writer = new PrintWriter(new BufferedWriter(
                    new FileWriter(String.format("algo.xml"), true)));

            System.out.println("Escribiendo...");

            String line = reader.readLine();
            writer.println("<datos>");

            while (line != null) {
                writer.println("    <dato>");

                String[] datos = line.split(",");

                writer.println("        <mes>" + datos[0] + "</mes>");
                writer.println("        <ventas>" + datos[1] + "</ventas>");
                writer.println("        <acumulado>" + datos[2]
                        + "</acumulado>");

                writer.println("    </dato>");

                line = reader.readLine();
            }
            writer.println("</datos>");

            System.out.println("finalizado");

            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println(
                    "No se ha podido abrir o leer el fichero.");
        } catch (IOException e) {
            System.err.println("Error con el fichero.");
        }
    }
}
