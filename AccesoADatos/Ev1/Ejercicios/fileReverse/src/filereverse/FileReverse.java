/*
 * Miguel Moya Ortega
 */
package filereverse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class FileReverse {

    public static void main(String[] args) {
        try {
            File file = 
                    new File("fichero.jpg");
            InputStream reader = new FileInputStream(file);
            OutputStream writer = new FileOutputStream(
                    new File("fichero2.gpj"));
            byte[] buf = new byte[(int) file.length()];
            int cantidadLeida;
            while ((cantidadLeida = reader.read(buf, 0,
                    (int) file.length())) > 0) {
                byte[] buf2 = new byte [(int) file.length()];
                
                for (int i = 0, last = buf2.length; i < file.length(); i++, last--) 
                    buf2[i] = buf[last];
                
                writer.write(Arrays.asList(buf), 0, cantidadLeida);
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("Ha habido problemas: "
                    + e.getMessage());
        }

    }

}
