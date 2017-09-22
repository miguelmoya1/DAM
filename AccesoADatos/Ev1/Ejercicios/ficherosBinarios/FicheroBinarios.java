/**
 * FicheroBinarios
 */

import java.io.FileInputStream;
import java.io.File;

public class FicheroBinarios {

   public static void main(String[] args) {
       try {
           FileInputStream ficheroEntrada = new FileInputStream(new File("fichero.bin"));
    
           int dato = ficheroEntrada.read();
           if (dato != -1) {
               int dato2 = ficheroEntrada.read();     
           } if (dato2 != -1) {
               System.out.println(dato1 == 'B' && dato2 == 'M' ? "Si es tipo BMP" : "No es tipo BMP");
           }
           System.out.println("No es fichero BMP");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
       }
   }
}