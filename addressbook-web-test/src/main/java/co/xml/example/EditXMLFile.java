package co.xml.example;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by natan.radostin on 3/19/2018.
 */
public class EditXMLFile {
private String file_EndPointClassifierStaticConfig_location="C:\\testTemp\\EndPointClassifierStaticConfig.xml";


  public void changeEndPointClassifierStaticConfig (String file_EndPointClassifierStaticConfig_location)  {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(new FileInputStream(file_EndPointClassifierStaticConfig_location));
      chnageNodeValue(document, "UseDuplicateIncidentFilter", "true");
      saveFromDOMToXMLFile(document);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    }
  }



  public void saveFromDOMToXMLFile(Document document) {
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = null;
    try {
      transformer = transformerFactory.newTransformer();
    } catch (TransformerConfigurationException e) {
      e.printStackTrace();
    }
    DOMSource source = new DOMSource(document);
    StreamResult result = null;
    try {
      result = new StreamResult(new FileOutputStream(file_EndPointClassifierStaticConfig_location));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    try {
      transformer.transform(source, result);
    } catch (TransformerException e) {
      e.printStackTrace();
    }
  }

  public void chnageNodeValue(Document document, String nameOfNode, String newValue) {
    for (int i = 0; i < document.getElementsByTagName("Name").getLength(); i++) {
      Node parameter = document.getElementsByTagName("Name").item(i);

      if (nameOfNode.equals(parameter.getTextContent())) {
        document.getElementsByTagName("Name").item(i).getNextSibling().getNextSibling().setTextContent(newValue);
      }
      System.out.println(parameter.getTextContent());
      System.out.println(document.getElementsByTagName("Name").item(i).getNextSibling().getNextSibling().getTextContent());
    }
  }


  public void setXMLPath(String file_EndPointClassifierStaticConfig_location) {
    this.file_EndPointClassifierStaticConfig_location = file_EndPointClassifierStaticConfig_location;
  }
}











