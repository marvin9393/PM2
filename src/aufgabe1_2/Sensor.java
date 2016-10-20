/**
*
*
*
*/
package aufgabe1_2;


import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 1, Aufgabe 1.2
* Verwendete Quellen: */
public class Sensor {
	
	/**
	 * Objekt Variable die den Ort oder Namen des Sensors speichert
	 */
	private String id;
	
	/**
	 * Objektvariable die die Messungen in einer Liste speichert.
	 */
	private List<Messung> messungen;
	
	/**
	 * Lesender-Konstruktor
	 * Leerer String id wird beim Auslesen einer XML-Datei überschrieben
	 * @param id
	 */
	public Sensor(){
		id="";
		messungen=new ArrayList<Messung>();
	}
	
	/**
	 * Schreibender-Konstruktor
	 * @param id
	 */
	public Sensor(String id){
		this.id=id;
		messungen=new ArrayList<Messung>();
	}
	
	/**
	 * Methode liest eine XML datei, erzeugt die Messungen und speichert diese
	 * in unsere Liste.
	 */
	public void ausXmlLesen(){
		try {
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document document=builder.parse("src/aufgabe1_2/Sensor.xml");
			
			NodeList nList=document.getElementsByTagName("Sensor");
			//um Id zu setzten
			id=(nList.item(0).getAttributes().item(0).getNodeValue());
			
			nList = document.getElementsByTagName("Messung");
			for (int i = 0; i < nList.getLength(); i++) {
				Messung messung=new Messung(nList.item(i).getAttributes().getNamedItem("wert").getNodeValue()
						, nList.item(i).getAttributes().getNamedItem("zeitstempel").getNodeValue());
				messungen.add(messung);
			}
			

		} catch (ParserConfigurationException|SAXException|IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Methode liest aus einer Liste von Messungen die einzelnen Messungen aus und
	 * speichert diese in einer XML Datei.
	 */
	public void xmlDateiSchreiben(){
			try {
				DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document document=builder.newDocument();
				DOMImplementation domImpl = document.getImplementation();
			      DocumentType docType = domImpl.createDocumentType("Sensor", "", "Sensor.dtd");
			      document.appendChild(docType);

				
				Element rootElement=document.createElement("Sensor");
				document.appendChild(rootElement);
				
				Attr attrId=document.createAttribute("id");
				attrId.setValue(id);
				rootElement.setAttributeNode(attrId);
				
				for(int i=0;i<messungen.size();i++){
					Element messung =document.createElement("Messung");
					rootElement.appendChild(messung);
					
					Attr attrWert=document.createAttribute("wert");
					attrWert.setValue(messungen.get(i).getWertString());
					messung.setAttributeNode(attrWert);
					
					Attr attrZeit=document.createAttribute("zeitstempel");
					attrZeit.setValue(messungen.get(i).getZeitstempelString());
					messung.setAttributeNode(attrZeit);
				}
				
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
			      Transformer transformer;
			      transformer = transformerFactory.newTransformer();
			      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			      transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			      transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			      transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,
			          docType.getSystemId());
			      DOMSource source = new DOMSource(document);
			      StreamResult result = new StreamResult(
			          new File("src/aufgabe1_2/Sensor_Out1.xml"));
			      transformer.transform(source, result);
				
			} catch (ParserConfigurationException|TransformerException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Ergaenzt die messung-Liste um eine Messung
	 * @param messung
	 */
	public void hinzufuegen(Messung messung){
		messungen.add(messung);
	}
	
	/**
	 * Anwendung
	 * @param args
	 */
	public static void main(String[] args){
		Sensor sensor=new Sensor();
		sensor.ausXmlLesen();
		Messung messung1=new Messung(100);
		Messung messung2=new Messung(23.1234);
		
		Sensor sensor2=new Sensor("Schlafzimmmer");
		sensor2.hinzufuegen(messung1);
		sensor2.hinzufuegen(messung2);
		sensor2.xmlDateiSchreiben();
	}
	
	
	
	
}
