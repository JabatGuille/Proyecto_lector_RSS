package LecturaSAX;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class SAXparse {

//Con esto se hace toda la lectura usando las clases de la carpeta en la que esta

    public static void lectura(String RSS) {
        System.out.println("Lectura del archivo XML");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            GestorEventos handler = new GestorEventos();
            InputSource datos = new InputSource(new StringReader(DescargarRSS.descargar(RSS)));

            saxParser.parse(datos, handler);

            List<LectorEtiquetas> lec = handler.getLectorEtiquetas();

            for(LectorEtiquetas t : lec){
                System.out.println(t);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
