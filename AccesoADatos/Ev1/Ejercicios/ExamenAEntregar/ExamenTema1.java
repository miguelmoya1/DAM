package examentema1;

import java.util.List;

/**
 *
 * @author Miguel Moya Ortega
 */
public class ExamenTema1 {

    public static void main(String[] args) {
        List<Persona> lista;
        
        LectorXML lector = new LectorXML();
        
        lista = lector.getPersonas("alumnos.xml");
        
        Compactador compactador = new Compactador();
        
        compactador.escribirXMLSinCompactar(lista);
        
        compactador.escribirXMLConflictos(lista);
        
        compactador.escribirXMLCompactado("alumnos2.xml");
        
        compactador.serializa(compactador);
        
        
        // lista.forEach(System.out::println);
    }
}
