
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class ReadXml extends DefaultHandler {

    public void procesarXml() {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            DefaultHandler manejadorEventos = new DefaultHandler() {

                String etiquetaActual = "";
                String contenido = "";

                // Método que se llama al encontrar inicio de etiqueta: '<'
                public void startElement(String uri, String localName,
                        String qName, Attributes attributes)
                        throws SAXException {

                    // Si el nombre es "asignatura",
                    // empieza una nueva y mostramos su id
                    // Si no, memorizamos el nombre para mostrar después
                    etiquetaActual = qName;
                    if (etiquetaActual == "videojuego") {
                        System.out.println("videojuego: ");
                    }
                }

                // Obtiene los datos entre '<' y '>'
                public void characters(char ch[], int start, int length)
                        throws SAXException {

                    contenido = new String(ch, start, length);
                }

                // Llamado al encontrar un fin de etiqueta: '>'
                public void endElement(String uri, String localName, String qName)
                        throws SAXException {

                    if (etiquetaActual.equals("titulo")) {
                        System.out.print("  " + etiquetaActual
                                + ": " + contenido);
                        etiquetaActual = "";
                    } else if (etiquetaActual.equals("anyo")) {
                        System.out.println("  " + etiquetaActual
                                + ": " + contenido);
                    }
                }
            };

            // Cuerpo de la función: trata de analizar el fichero deseado
            // Llamará a startElement(), endElement() y character() 
            saxParser.parse("videojuegos.xml", manejadorEventos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Sax1 {

    public static void main(String args[]) {
        ReadXml ficheroXml = new ReadXml();
        ficheroXml.procesarXml();
    }
}
