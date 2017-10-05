/*
 * Miguel Moya Ortega
 * Leer un fichero xml con DOM :(
 */
package domxml;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class DOMXml {

    public static void main(String[] args) {
        
        try {
            File inputFile = new File("videojuegos.xml");
            DocumentBuilderFactory dbFactory 
                = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            
            NodeList nList = doc.getElementsByTagName("videojuego");
            System.out.println();
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("Videojuego:");
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Titulo: " 
                        + eElement.getElementsByTagName("titulo")
                        .item(0).getTextContent());
                    System.out.println("Año: " 
                        + eElement.getElementsByTagName("anyo")
                        .item(0).getTextContent());
                    System.out.println(); 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
