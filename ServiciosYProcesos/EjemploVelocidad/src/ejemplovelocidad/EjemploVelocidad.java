package ejemplovelocidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EjemploVelocidad {

    public static void main(String[] args) {
        long time_start, time_end, trys = 100;
        time_start = System.currentTimeMillis();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        for (int i = 0; i < trys; i++) try { br.readLine(); } catch (IOException e) {}
        
        time_end = System.currentTimeMillis();
        System.out.println((time_end - time_start) + " milliseconds");

        time_start = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < trys; i++) scanner.nextLine();
        
        time_end = System.currentTimeMillis();
        System.out.println((time_end - time_start) + " milliseconds");
    }

}
