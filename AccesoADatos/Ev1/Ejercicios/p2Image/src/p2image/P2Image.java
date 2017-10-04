package p2image;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class P2Image {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileToRead;
        if (args.length == 0) {
            System.out.println("Escribe el nombre del fichero: ");
            fileToRead = scanner.nextLine();
        } else fileToRead = args[0];

        try {
            File file = new File(fileToRead);
            BufferedReader reader = new BufferedReader(new FileReader(file));

            OutputStream out = new FileOutputStream(
                    new File("file.out.pgm"));

            String type = reader.readLine();

            if (!type.equals("P2")) {
                System.out.println("Tipo de fichero no valido.");
            } else {
                out.write(type.getBytes());

                String line2 = reader.readLine();
                int width, height;
                if (!line2.startsWith("#")) {
                    width = Integer.parseInt(line2.split(" ")[0]);
                    height = Integer.parseInt(line2.split(" ")[1]);
                } else {
                    line2 = reader.readLine();
                    width = Integer.parseInt(line2.split(" ")[0]);
                    height = Integer.parseInt(line2.split(" ")[1]);
                }
                out.write(width);
                out.write(height);

                String colors = reader.readLine();
                out.write(colors.getBytes());

                for (int i = 0; i < height; i++) {
                    String line = reader.readLine();

                    String[] array = line.split(" ");
                    
                    if (array.length >= width * height)
                        i = height;
                    

                    for (String item : array) out.write(Byte.parseByte(item));
                }

                reader.close();
                out.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero.");
        } catch (IOException e) {
            System.out.println("Error desconocido.");
        }
    }

}
