import org.w3c.dom.Document;
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
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.w3c.dom.Element;

public class ApplicationModel {

    public  Currency extractData(int index) throws ParserConfigurationException, IOException, SAXException {

        URL url=new URL("https://www.nbp.pl/kursy/xml/lasta.xml");
        HttpURLConnection connection=(HttpURLConnection)url.openConnection();
        InputStream inputStream=connection.getInputStream();


        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputStream);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("pozycja");
        Node node=nList.item(index);
        Element element=(Element)node;
        Currency currency=new Currency();
        String tempString=element.getElementsByTagName("kurs_sredni").item(0).getTextContent();
        String newString=tempString.replace(",",".");
        currency.setAverageRate(Double.parseDouble(newString));
        currency.setConversionRate(Integer.parseInt(element.getElementsByTagName("przelicznik").item(0).getTextContent()));
        inputStream.close();
        return currency;
    }
}
