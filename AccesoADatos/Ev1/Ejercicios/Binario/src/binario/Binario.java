
package binario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Binario {

    public static void main(String[] args) {
        try {
            InputStream file = new FileInputStream(new File("fichero.bin"));
            byte[] buf = new byte[999];
        } catch (FileNotFoundException ex) {
            System.out.println("no se ha podido encontrar el fichero");
        } 
    }
    
}
