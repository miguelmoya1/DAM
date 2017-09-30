/*
    Miguel Moya Ortega
    Partir ficheros
 */
package comparefiles;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Id3 {

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
                System.err.println("No es un fichero mp3 v2");
            } else {
                int num = (buf[6] + buf[7] + buf[8] + buf[9]);
                System.out.println(num);

                byte[] head = new byte[50000];
                read.read(head);
                for (byte a : head) {
                    System.out.print((char) a);
                }
            }

            read.close();

        } catch (IOException e) {
            System.err.println("No se ha podido leer el fichero.");
        }
    }
}
