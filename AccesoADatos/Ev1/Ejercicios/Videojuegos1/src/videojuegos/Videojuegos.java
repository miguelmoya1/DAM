//Alejandro Gascón y Miguel Moya
package videojuegos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Videojuegos {

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {

        }
    }

    public static void main(String[] args) {
        boolean finish = false;
        Scanner scanner = new Scanner(System.in);
        byte opcion;

        while (!finish) {
            System.out.println("¿Qué operación desea realizar?");
            System.out.println("    1) Añadir.");
            // System.out.println("    2) Buscar.");
            // System.out.println("    3) Modificar.");
            System.out.println("    4) Mostrar.");
            System.out.println("    0) Salir.");
            opcion = scanner.nextByte();
            switch (opcion) {
                case 1:
                    String titulo,
                     genero,
                     plataforma,
                     resumen;
                    titulo = genero = plataforma = resumen = "";
                    int anyo = -1;
                    do {
                        scanner.nextLine();
                        System.out.println("Escribe el titulo:");
                        titulo = scanner.nextLine();
                    } while ("".equals(titulo));
                    do {
                        System.out.println("Escribe el genero:");
                        genero = scanner.nextLine();
                    } while ("".equals(genero));
                    do {
                        System.out.println("Escribe el año:");
                        anyo = scanner.nextInt();
                    } while (anyo == -1);
                    do {
                        scanner.nextLine();
                        System.out.println("Escribe la plataforma:");
                        plataforma = scanner.nextLine();
                    } while ("".equals(plataforma));
                    do {
                        System.out.println("Escribe el resumen:");
                        resumen = scanner.nextLine();
                    } while ("".equals(resumen));
                    Videojuego juego = new Videojuego(titulo, genero,
                            anyo, plataforma, resumen);

                    juego.anyadir();
                    break;
                /*case 2:
                    System.out.println("Introduce que buscar: ");
                    String buscar = scanner.nextLine();
                    
                    for(Videojuego game : juegos) {
                        if (game.getTitulo().contains(buscar) ||
                                game.getGenero().contains(buscar) ||
                                game.getPlataforma().contains(buscar) ||
                                game.getResumen().contains(buscar) ||
                                game.getAnyo() == Integer.parseInt(buscar)) {
                            System.out.println("- Titulo: " + game.getTitulo() +
                                    " Genero: " + game.getGenero() +
                                    " Año: " + game.getAnyo() + 
                                    " Plataforma: " + game.getPlataforma() + 
                                    " Resumen: " + game.getResumen());
                        }   
                    }                    
                    break;
                 */
 /*case 3:
                    System.out.println("No implementado.");
                    break;
                 */
                case 4:
                    Videojuego.writeObjects();
                    break;
                case 0:
                    finish = true;
                    break;
                default:
                    System.out.println("No se reconoce la opción");
                    break;
            }
            clearConsole();
        }
    }

}
