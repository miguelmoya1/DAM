package ejemplovelocidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EjemploVelocidad {

    public static void main(String[] args) {
        long time_start, time_end, trys = 1000;
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < trys; i++) lista.add("hola");
        time_start = System.currentTimeMillis();
            for (int i = 0; i < trys; i++) lista.get(i).toUpperCase();
        time_end = System.currentTimeMillis();
        System.out.println((time_end - time_start) + " milliseconds");
            for (String en : lista) en.toLowerCase();

        time_start = System.currentTimeMillis();
            lista.forEach(li -> li.toUpperCase());
        time_end = System.currentTimeMillis();
        System.out.println((time_end - time_start) + " milliseconds");
    }

}
