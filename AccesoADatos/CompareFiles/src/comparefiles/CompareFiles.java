/*
    Miguel Moya Ortega
    Partir ficheros
 */
package comparefiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CompareFiles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileToRead;
        if (args.length == 0) {
            System.out.println("Escribe el nombre del fichero: ");
            fileToRead = scanner.nextLine();
        } else {
            fileToRead = args[0];
        }
        
        List<Byte> list = new ArrayList<>();
        List<Byte> list1 = new ArrayList<>();
        
        try {
            InputStream read = new FileInputStream(
                    new File(fileToRead));
            
        int sizeFile = (int) new File(fileToRead).length();

            byte[] buf = new byte[10];
            
            read.read(buf);
            if ((buf[0] != 'I') || (buf[1] != 'D') || (buf[2] != '3')) {
                System.out.println("No es un fichero mp3 v2");
            } else {
                
            }

            read.close();

        } catch (IOException e) {
            System.out.println("No se ha podido leer el fichero.");
        }
    }
}
