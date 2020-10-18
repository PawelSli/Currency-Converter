import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class CurrencyList {
    private  Map<String,Integer> currencyMap;

    public Map<String,Integer> getCurrencyMap(){
        return currencyMap;
    }

    public  CurrencyList() throws ParserConfigurationException, IOException, SAXException {

        currencyMap= new LinkedHashMap<>();

        URL url=new URL("https://www.nbp.pl/kursy/xml/lasta.xml");
        HttpURLConnection connection=(HttpURLConnection)url.openConnection();
        InputStream inputStream=connection.getInputStream();

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputStream);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("pozycja");

        for(int i=0;i<nList.getLength();i++){
            Node nNode = nList.item(i);
            Element eElement = (Element) nNode;
            currencyMap.put((String) eElement.getElementsByTagName("nazwa_waluty").item(0).getTextContent(),i);
        }
    }
}
