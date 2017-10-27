package examentema1;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Miguel Moya Ortega
 */
public class Compactador implements Serializable {

    final String SPACES = "    ";

    public void escribirXMLCompactado(String file) {
        if (!(new File(file)).exists()) {
            System.out.println("No he encontrado " + file);
            return;
        }
        try {
            PrintWriter print = new PrintWriter("alumnos3.xml");
            BufferedReader ficheroEntrada = new BufferedReader(
                    new FileReader(new File(file)));
            String linea = ficheroEntrada.readLine();
            while (linea != null) {
                print.println(linea
                        .trim()
                        .replaceAll("duplicado=\"si\"", "")
                        .replaceAll("conflicto=\"si\"", "")
                );
                linea = ficheroEntrada.readLine();
            }
            ficheroEntrada.close();
            print.close();
        } catch (IOException ex) {
            System.out.println("Ha habido problemas");
        }

    }

    public void escribirXMLSinCompactar(List<Persona> lista) {
        List<Persona> lista2 = new ArrayList<>();
        lista2.addAll(lista);
        try {
            PrintWriter print = new PrintWriter("alumnos2.xml");

            print.println("<personas>");

            for (int i = 0; i < lista2.size(); i++) {
                Persona p = lista2.get(i);

                boolean contains = false;
                for (int j = i + 1; j < lista2.size(); j++) {
                    if (p.codigo == lista2.get(j).codigo) {
                        contains = true;
                        lista2.remove(j);
                    }
                }

                if (contains) {
                    print.println(SPACES + "<persona codigo=\"" + p.codigo
                            + "\" duplicado=\"si\">");
                } else {
                    print.println(SPACES + "<persona codigo=\"" + p.codigo + "\">");
                }

                print.println(SPACES + SPACES + "<nombre>"
                        + p.nombre + "</nombre>");
                print.println(SPACES + SPACES + "<apellidos>"
                        + p.apellidos + "</apellidos>");
                print.println(SPACES + "</persona>");
            }

            print.println("</personas>");

            print.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        }
    }

    public void escribirXMLConflictos(List<Persona> lista) {
        List<Persona> lista2 = new ArrayList<>();
        lista2.addAll(lista);
        try {
            PrintWriter print = new PrintWriter("conflictos.xml");

            print.println("<personas>");

            for (int i = 0; i < lista2.size(); i++) {
                Persona p = lista2.get(i);

                boolean contains = false;
                Persona p2 = null;
                for (int j = i + 1; j < lista2.size(); j++) {
                    p2 = lista2.get(j);
                    if (p.codigo == p2.codigo && (!p.nombre.equals(p2.nombre)
                            || !p.apellidos.equals(p2.apellidos))) {
                        contains = true;
                        lista2.remove(j);
                    }
                }

                if (contains) {
                    print.println(SPACES + "<persona codigo=\"" + p2.codigo
                            + "\" conflicto=\"si\">");
                    print.println(SPACES + SPACES + "<nombre>"
                            + p2.nombre + "</nombre>");
                    print.println(SPACES + SPACES + "<apellidos>"
                            + p2.apellidos + "</apellidos>");
                    print.println(SPACES + "</persona>");
                }

            }

            print.println("</personas>");

            print.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        }
    }

    public static void serializa(Compactador c) {
        try {
            File fichero = new File("compactador.dat");
            FileOutputStream ficheroSalida
                    = new FileOutputStream(fichero);
            ObjectOutputStream ficheroObjetos
                    = new ObjectOutputStream(ficheroSalida);
            ficheroObjetos.writeObject(c);
            ficheroObjetos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException ex) {
            System.out.println("Error desconocido");
        }
    }
}
