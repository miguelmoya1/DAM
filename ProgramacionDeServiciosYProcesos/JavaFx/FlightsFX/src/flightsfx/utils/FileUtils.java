package flightsfx.utils;

import java.util.List;
import flightsfx.model.Flight;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Miguel
 */
public class FileUtils {

    static List<Flight> loadFlights() {
        List<Flight> flight = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new FileReader("flights.txt"))) {
            reader.lines()
                    .forEach(line -> {
                        String[] arrayLine = line.split(line);
                        flight.add(new Flight(
                                arrayLine[0],
                                arrayLine[1],
                                LocalDateTime.parse(arrayLine[2]),
                                LocalTime.parse(arrayLine[3])));
                    });
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return flight;
    }

    static void saveFlights(List<Flight> flights) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(
                new FileWriter("algo.xml")))) {
            flights.forEach(flight -> writer.println(flight));
        } catch (IOException ex) {
        }
    }
}
