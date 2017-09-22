package javaToCs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class JavaToCs {

    public static void main(String[] args) {
        String fileName;
        if (args.length == 0) {
            System.out.println("Escribe el nombre del fichero ");
            Scanner scanner = new Scanner(System.in);
            fileName = scanner.nextLine();
        } else {
            fileName = args[0];
        }
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    new File(fileName)));
            
            if (fileName.endsWith(".java")) {
                fileName = fileName.substring(0, fileName.length() - 5);
            }
            
            fileName = fileName + ".cs";
            PrintWriter writer = new PrintWriter(new BufferedWriter(
                    new FileWriter(fileName, true)));
            String line = reader.readLine();
            
            
            writer.println();
            
            while (line != null) {
                if (true) {
                    if (line.contains("import")) {
                        line = line.replace("import", "using");
                    }
                    if (line.contains(" main")) {
                        line = line.replace("main", "Main");
                    }
                    if (line.contains("String")) {
                        line = line.replace("String", "string");
                    }
                    if (line.contains("boolean")) {
                        line = line.replace("boolean", "bool");
                    }
                    if(line.contains("System.out.println")) {
                        line = line.replace("System.out.println",
                                "System.Console.WriteLine");
                    }
                    if(line.contains("out.println")) {
                        line = line.replace("out.println",
                                "Console.WriteLine");
                    }
                    if(line.contains("System.out.print")) {
                        line = line.replace("System.out.print",
                                "System.Console.Write");
                    }
                    if(line.contains("out.print")) {
                        line = line.replace("out.print",
                                "Console.Write");
                    }
                    if(line.contains("package")) {
                        line = "";
                    }
                    if (line.contains(".")) {
                        // line = line.replace(line, fileName)
                    }
                }
                writer.println(line);
                line = reader.readLine();
            }
            
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
