package orderedComments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Miguel Moya Ortega
 */
public class OrderedComments {

    public static void main(String[] args) {
        List<Comment> comments = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(
                new File("comments.txt")));
                PrintWriter writer = new PrintWriter(new FileWriter("ordered_comments.txt"))) {
            String line = reader.readLine();
            System.out.println("Reading...");
            while (line != null) {
                String[] lineArray = line.split(";");
                String[] date = lineArray[2].split("/");
                comments.add(new Comment(
                        lineArray[0],
                        lineArray[1],
                        ZonedDateTime.parse((date[2] + "-" + date[1] + "-" + date[0]
                                + "T" + lineArray[3]
                                + "+01:00[" + lineArray[4]) + "]")
                ));

                line = reader.readLine();
            }
            System.out.println("Formatting...");
            comments.stream().map(c -> c.setDate(c.getDate().withZoneSameInstant(ZoneId.of("Europe/Madrid"))));

            comments.add(new Comment("usuario1", "hola comentario", ZonedDateTime.now()));
            comments.add(new Comment("usuario2", "adios", ZonedDateTime.now()));

            comments.sort((c1, c2) -> c1.getDate().compareTo(c2.getDate()));

            DateTimeFormatter formatter
                    = DateTimeFormatter.ofPattern("dd/MM/yyy;HH:mm:ss;VV");

            System.out.println("Writing...");
            comments.forEach(c -> writer.println(c.getUsername() + ";"
                    + c.getComment()
                    + c.getDate()
                            .withZoneSameInstant(ZoneId.of("Europe/Madrid"))
                            .format(formatter)
            ));
            System.out.println("Done!");
        } catch (FileNotFoundException ex) {
            System.err.println("No se ha podido encontrar el fichero.");
        } catch (IOException ex) {
            System.err.println("No se sabe por qué.");
        }
    }
}
