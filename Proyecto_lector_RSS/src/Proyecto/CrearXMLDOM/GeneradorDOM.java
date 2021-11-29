package Proyecto.CrearXMLDOM;

import Proyecto.Feed;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneradorDOM {

    //Esta clase escribe en disco el docuemento XML

    private Document dom;

    private List<String> datos;

    public void generador(Feed feed){

        datos = new ArrayList<>();
//Carga datos (si quieres añadir datos)
        cargarDatos();
// Crea el documento
        crearDocumento();
//Inicia el sistema para poder rellenarlo
        run(feed);
    }

    public void run(Feed feed) {
        System.out.println("Iniciando..");
        datos.add(feed.getTitulo());
        datos.add(feed.getUrl());
        crearArbolDOM();
        exportarFichero();
        System.out.println("Fichero generado.");
    }

    private void crearArbolDOM() {
        //Crea <feeds>
        Element raiz = dom.createElement("feeds");
        //Añade el documento xmls para poder leer el feeds.xsd
        raiz.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance",
        "xsi:noNamespaceSchemaLocation","feeds.xsd");
        //cierra </feeds>
        dom.appendChild(raiz);
        //Añade todos los elementos en el feed
        Element elemento = crearElementoFeed(datos);
        //cierra </feeds>
        raiz.appendChild(elemento);


    }

    public Element crearElementoFeed(List<String> dato) {
//<feed>
        Element elementofeed = dom.createElement("feed");
//<titulo>
        Element elementotitulo = dom.createElement("titulo");
//texto del titulo
        Text textotitulo = dom.createTextNode(dato.get(0));
//</titulo>
        elementotitulo.appendChild(textotitulo);
//</feed>
        elementofeed.appendChild(elementotitulo);
//<url>
        Element elementourl = dom.createElement("url");
//texto del url
        Text textourl = dom.createTextNode(dato.get(1));
//</url>
        elementourl.appendChild(textourl);
//</feed>
        elementofeed.appendChild(elementourl);

        return elementofeed;
    }

    public void exportarFichero(){

        try {

            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT,"yes");

            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            transformer.setOutputProperty(OutputKeys.STANDALONE,"yes");

            //Dice el lugar donde se va a guardar
            Result output = new StreamResult(new File("Proyecto_lector_RSS/XML/feeds.xml"));

            Source input = new DOMSource(dom);

            transformer.transform(input,output);

        }catch (TransformerException e) {
            e.printStackTrace();
        }
    }
    private void crearDocumento(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.newDocument();
            dom.setXmlStandalone(true);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
    public void cargarDatos(){

    }
}
