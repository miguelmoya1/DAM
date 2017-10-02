package bmpporconsola;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Escribir por consola una imagen
 *
 * @author Miguel Moya Ortega
 */
public class BmpPorConsola {

    public static void main(String[] args) {
        try {
            File file = new File("file.bmp");
            InputStream read = new FileInputStream(file);

            int sizeFile = (int) file.length();
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.err.println("Error desconocido en el fichero");
        }
    }

}
