package H0SRE6_1110;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class XpathQueryH0SRE6 {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("H0SRE6_1110\\studentH0SRE6.xml"));
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        String expression = "/class/student[@rollno='593']";
        NodeList nodes = (NodeList) xpath.compile(expression).evaluate(doc, XPathConstants.NODESET);

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            Element element = (Element) node;

            System.out.println("\ncurrent element: " + node.getNodeName());
            System.out.println("student roll no: " + element.getAttribute("rollno"));

            NodeList childNodes = element.getChildNodes();

            for (int j = 0; j < childNodes.getLength(); j++) {
                Node childNode = childNodes.item(j);

                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println(childNode.getNodeName() + ": " + childNode.getTextContent());
                }
            }
        }
    }
}
