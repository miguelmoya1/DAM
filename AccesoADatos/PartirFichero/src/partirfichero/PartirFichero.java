/*
    Miguel Moya Ortega
    Partir ficheros
 */
package partirfichero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PartirFichero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileToRead;
        int sizeOfFile;
        if (args.length == 0) {
            System.out.println("Escribe el nombre del fichero: ");
            fileToRead = scanner.nextLine();
            System.out.println("Escribe el tamaño del fichero: ");
            sizeOfFile = scanner.nextInt() * 8;
        } else {
            fileToRead = args[0];
            sizeOfFile = Integer.parseInt(args[1]) * 8;
        }

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(
                            new File(fileToRead)));
            String line = "", lineToAdd = "";
            while (line != null) {
                line = reader.readLine();
                if (line != null) lineToAdd += line;
            }
            
            int totalToCreate = (int)Math.ceil(lineToAdd.length() / sizeOfFile), 
                    count = 0;
            PrintWriter writer = null;
            
            for (int i = 0; i < totalToCreate; i++) {
                System.out.println("Part " + (i + 1) + "/" + totalToCreate);
                writer = new PrintWriter(new BufferedWriter(
                    new FileWriter(String.format("%03d", i), true)));
                writer.println(lineToAdd.substring(count, count + sizeOfFile));
                count += sizeOfFile;
            }
            
            writer.close();
            reader.close();
            
        } catch (IOException e) {
            System.out.println("No se ha podido leer el fichero.");
        }
    }
}
