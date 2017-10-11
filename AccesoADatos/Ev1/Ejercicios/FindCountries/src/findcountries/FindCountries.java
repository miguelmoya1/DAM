package findcountries;

import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 *
 * @author Miguel Moya Ortega
 */
public class FindCountries {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String toFind;
        System.out.println("Escribe el nombre: ");
        toFind = scanner.nextLine();
        while (!toFind.equals("")) {
            try {
                File inputFile = new File("countries.xml");
                DocumentBuilderFactory dbFactory
                        = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();

                NodeList nList = doc.getElementsByTagName("country");

                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        if (eElement.getAttribute("translations").toLowerCase()
                                .contains(toFind.toLowerCase())) {
                            
                            System.out.println(eElement.getAttribute("name"));
                        }
                    }
                }
                toFind = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("No va");
            }

        }

    }

}
