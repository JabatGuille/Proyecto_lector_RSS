import CrearXMLDOM.GeneradorDOM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    public static void main(String[] args) {
        boolean bucle = true;
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        do {
            System.out.println("RSS\n" +
                    "---\n" +
                    "1. Nuevo feed\n" +
                    "2. Borrar feed\n" +
                    "3. Mostrar titulares de un feed\n" +
                    "4. Salir");
            try {
                int menu = Integer.parseInt(br.readLine());
                switch (menu) {
                    case 1: {
                        System.out.println("Introduce el titulo para el nuevo feed");
                        String titulo = br.readLine();
                        System.out.println("Introduce el url para guardarlo en el nuevo feed");
                        String url = br.readLine();
                        GeneradorDOM generador = new GeneradorDOM();
                        generador.generador(titulo,url);

                        //SAXparse.lectura(RSS);
                        break;
                    }
                    case 2: {
                        System.out.println("Que feed quieres borrar");
                        break;
                    }
                    case 3: {
                        break;
                    }
                    case 4: {
                        System.out.println("Adios");
                        bucle = false;
                        break;
                    }
                    default: {
                        System.out.println("Numero equivocado");
                        break;
                    }

                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Tienes que elegir un numero");
            }


        } while (bucle);
    }

}
