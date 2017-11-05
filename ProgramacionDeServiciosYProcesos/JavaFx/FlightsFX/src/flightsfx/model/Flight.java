package flightsfx.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author Miguel
 */
public class Flight {
    protected String number;
    protected String destination;
    protected LocalDateTime localDate;
    protected LocalTime duration;
    
    public Flight(String number) {
        this.number = number;
    }

    public Flight(String number, String destination, LocalDateTime localDate, LocalTime duration) {
        this.number = number;
        this.destination = destination;
        this.localDate = localDate;
        this.duration = duration;
    }

    public String getNumber() {
        return number;
    }

    public Flight setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getDestination() {
        return destination;
    }

    public Flight setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public LocalDateTime getLocalDate() {
        return localDate;
    }

    public Flight setLocalDate(LocalDateTime localDate) {
        this.localDate = localDate;
        return this;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public Flight setDuration(LocalTime duration) {
        this.duration = duration;
        return this;
    }
    
    @Override
    public String toString() {
        return number + ";" + destination + ";" + localDate + ";" + duration;
    }
}
