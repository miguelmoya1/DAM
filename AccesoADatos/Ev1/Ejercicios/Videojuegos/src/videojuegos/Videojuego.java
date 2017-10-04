//Alejandro Gascón y Miguel Moya
package videojuegos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Videojuego implements Serializable {

    private String titulo;
    private String genero;
    private int anyo;
    private String plataforma;
    private String resumen;

    public Videojuego(String titulo, String genero, int anyo, String plataforma, String resumen) {
        this.titulo = titulo;
        this.genero = genero;
        this.anyo = anyo;
        this.plataforma = plataforma;
        this.resumen = resumen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getAnyo() {
        return anyo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public String getResumen() {
        return resumen;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Videojuego anyadir() {
        this.serialice();
        return this;
    }

    public boolean serialice() {
        try {
            FileOutputStream file = new FileOutputStream(new File("juego.abc"));
            ObjectOutputStream fileO = new ObjectOutputStream(file);
            fileO.writeInt(1);
            fileO.writeObject(this);
            return true;
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el fichero.");
            return false;
        } catch (IOException e) {
            System.err.println("Error en el fichero.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "- Titulo: " + this.getTitulo()
                + " Genero: " + this.getGenero()
                + " Año: " + this.getAnyo()
                + " Plataforma: " + this.getPlataforma()
                + " Resumen: " + this.getResumen();
    }

    public static boolean writeObjects() {
        try {
            File fichero = new File("juego.abc");
            FileInputStream ficheroSalida
                    = new FileInputStream(fichero);
            ObjectInputStream obj
                    = new ObjectInputStream(ficheroSalida);
            
           int number = obj.readInt();
           Videojuego game = (Videojuego) obj.readObject();
                      
           while (number != -1) {
               System.out.println(game.toString());
               number = obj.readInt();
               game = (Videojuego) obj.readObject();
           }

            obj.close();

            return true;
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el fichero.");
        } catch (IOException e) {
            System.err.println("Error en el fichero.");
        } catch (ClassNotFoundException ex) {
            System.out.println("No he encontrado la clase :(");
        }
        return false;
    }
}
