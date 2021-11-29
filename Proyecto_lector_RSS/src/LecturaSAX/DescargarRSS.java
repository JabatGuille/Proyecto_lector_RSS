package LecturaSAX;

import okhttp3.*;

import java.io.IOException;
import java.util.Objects;

public class DescargarRSS {
// Esto descagar los RSS
    public static String descargar(String RSS) {
        String respuesta = null;
        //El constructor para poder descargar los RSS de un enlace
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        Request request = new Request.Builder()
                .url(RSS)
                .get()
                .addHeader("cache-control", "no-cache")
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.body() != null) {
                respuesta = Objects.requireNonNull(response.body()).string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
return respuesta;
    }
}
