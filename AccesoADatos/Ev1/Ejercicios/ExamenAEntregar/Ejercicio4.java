package ejercicio4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 *
 * @author Miguel Moya Ortega
 */
public class Ejercicio4 {

    public static void main(String[] args) {
        final int BUFFER_SIZE = 512 * 1024;
        try {
            InputStream ficheroEntrada3 = new FileInputStream(
                    new File("alumnos3.xml"));
            PrintWriter print = new PrintWriter("alumnos3.txt");
            byte[] buf = new byte[BUFFER_SIZE];
            int cantidadLeida;
            while ((cantidadLeida = ficheroEntrada3.read(buf, 0,
                    BUFFER_SIZE)) > 0) {
                boolean write = true;
                for (int i = 0; i < buf.length; i++) {
                    if (buf[i] != -1) {
                        if (buf[i] == '<') write = false;
                        else if (buf[i] == '>') write = true;
                        else if (write) print.write(buf[i]);
                    }
                }
            }
            ficheroEntrada3.close();
            print.close();
        } catch (Exception errorDeFichero) {
            System.out.println("Ha habido problemas: "
                    + errorDeFichero.getMessage());
        }

    }

}
