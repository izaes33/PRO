public class Main {
    public static void main(String[] args) {

        // Variables con nombres descriptivos para la información del libro

        // Título del libro (String)
        String tituloLibro = "Cien años de soledad";

        // Autor principal (String)
        String autorPrincipal = "Gabriel García Márquez";

        // Año de publicación (int)
        int anioPublicacion = 1967;

        // Número de páginas (int)
        int numeroPaginas = 410;

        // Precio de venta con decimales (double)
        double precioVenta = 19.95;

        // Indicador si es una edición de tapa dura (boolean)
        boolean esTapaDura = true;

        // ISBN (String, ya que puede contener guiones o letras)
        String isbn = "978-3-16-148410-0";


        // Mostrar toda la información del libro en la consola
        System.out.println("=========================================");
        System.out.println("           Ficha Técnica del Libro       ");
        System.out.println("=========================================");

        System.out.println("Título: " + tituloLibro);
        System.out.println("Autor: " + autorPrincipal);
        System.out.println("Año de Publicación: " + anioPublicacion);
        System.out.println("Páginas: " + numeroPaginas);
        System.out.println("ISBN: " + isbn);
        System.out.println("Precio: $" + precioVenta);

        // Usamos una estructura simple de control para mostrar si es tapa dura
        if (esTapaDura) {
            System.out.println("Formato: Tapa Dura ✅");
        } else {
            System.out.println("Formato: Tapa Blanda 🗐");
        }

        System.out.println("=========================================");
    }
}
