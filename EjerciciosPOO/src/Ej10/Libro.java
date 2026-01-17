package Ej10;

public class Libro {
    private String titulo;
    private String autor;
    private String ISBN;
    private boolean disponible;

    public Libro(String titulo, String autor, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.disponible = true;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getISBN() { return ISBN; }
    public boolean isDisponible() { return disponible; }

    public void prestar() { disponible = false; }
    public void devolver() { disponible = true; }

    @Override
    public String toString() {
        return titulo + " (" + autor + ") ISBN: " + ISBN;
    }
}
