package examentema1;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 * @author Miguel Moya Ortega
 */
public class LectorXML {

    public List<Persona> getPersonas(String file) {
        List<Persona> lista = new ArrayList<>();

        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("persona");

            String nombre, apellidos;
            int codigo;
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    codigo = Integer.parseInt(
                            eElement.getAttribute("codigo"));

                    nombre = eElement.getElementsByTagName("nombre")
                            .item(0).getTextContent();
                    apellidos = eElement.getElementsByTagName("apellidos")
                            .item(0).getTextContent();
                    lista.add(new Persona(codigo, nombre, apellidos));
                }
            }
        } catch (Exception e) {
            System.out.println("No se ha podido leer el xml");
        }
        return lista;
    }
}
