package LecturaSAX;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class GestorEventos extends DefaultHandler {
    private final List<LectorEtiquetas> lectorEtiquetas = new ArrayList<>();
    private LectorEtiquetas lec = null;
    private final StringBuilder builder = new StringBuilder();
    private boolean item = false;

    //Indica que esta al princio del elemento <>

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if ("item".equals(qName)) {
            if (!item) {
                lec = new LectorEtiquetas();
                item = true;
            }
        }
        builder.setLength(0);
    }

    //Guarda los caracteres que estan entre el princio y final de elemento
    @Override
    public void characters(char[] ch, int start, int length) {
        builder.append(new String(ch, start, length));
    }

    //Indica que esta al final del elemento </>
    @Override
    public void endElement(String uri, String localName, String qName) {

        String texto = builder.toString();

        if (item){
            switch (qName){
                case "title":{
                    lec.setTitulo(texto);
                    break;
                } case "description":{
                    lec.setDescripcion(texto);
                    break;
                } case "pubDate":{
                    lec.setFecha(texto);
                    item = false;
                    lectorEtiquetas.add(lec);
                }
            }

        }
    }

    public List<LectorEtiquetas> getLectorEtiquetas() {
        return lectorEtiquetas;
    }
}
