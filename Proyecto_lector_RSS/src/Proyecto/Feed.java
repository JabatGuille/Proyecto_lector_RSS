package Proyecto;

public class Feed {
    private String titulo;
    private String url;

    public Feed(String titulo, String url) {
        this.titulo = titulo;
        this.url = url;
    }

    public Feed() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "titulo='" + titulo + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
