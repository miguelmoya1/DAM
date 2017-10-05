package orderedComments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Miguel Moya Ortega
 */
public class OrderedComments {

    public static void main(String[] args) {
        try ( BufferedReader reader = new BufferedReader(new FileReader(
                    new File("comments.txt")));) {
             
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha podido encontrar el fichero.");
        } catch (IOException ex) {
            System.out.println("No se sabe por qué.");
        } 
    }

    /**
     * In the main method, read the file and create a Comment object for every
     * comment (you can use the String's split method to divide fields), change
     * the timezone of each comment's date to “Europe/Madrid” (use
     * withZoneSameInstant method), and add comments to a List. After that,
     * order the list by date of comments using a Comparator. To compare a date
     * to another (in seconds), you can use: date1.until(date2,
     * ChronoUnit.SECONDS) → “date2 - date1” in seconds Service and Process
     * Programming – Java reinforcement 4. Finally, create a new file called
     * ordered_comments.txt and save all comments in the same format as before
     * but they will be ordered by date and in the same timezone (Madrid). To
     * convert the ZonedDateTime to the date format in the file use the method
     * explained in subsection 2.3, with this pattern: DateTimeFormatter
     * formatter = DateTimeFormatter.ofPattern("dd/MM/yyy;HH:mm:ss;VV");*
     */
}
