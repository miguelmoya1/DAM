/***
 * @Author: Miguel Moya Ortega
 */
package java8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Java8 {

    public static void main(String[] args) {
        Instant i = Instant.EPOCH;
        System.out.println(i.toString());
        
        System.out.println(LocalDate.MAX);
        
        LocalDate date = LocalDate.parse("9999-05-02");
        LocalDate now = LocalDate.now();
        System.out.println("Total days: " + now.until(date, ChronoUnit.DAYS));
    }
    
}
