import controller.Operaciones;

public class Main {

    public static void main(String[] args) {

        // Se crea un objeto de la clase Operaciones que contiene
        // todos los métodos para trabajar con ficheros
        Operaciones operaciones = new Operaciones();

        // ====== MÉTODOS DE LECTURA ======

        // Lee recursivamente todos los archivos y carpetas dentro de una ruta
        // operaciones.leerFichero("src/main/java/resources");

        // Lee el contenido de un fichero carácter por carácter
        // operaciones.leerContenidoFichero("src/main/java/resources/analisis.txt");

        // Lee el contenido de un fichero línea por línea
        // operaciones.leerContenidoFicheroLineas("src/main/java/resources/analisis.txt");

        // Descifra el contenido de un fichero previamente cifrado
        // operaciones.descifrarContenido("src/main/java/resources/escritura.txt");


        // ====== MÉTODOS DE ESCRITURA ======

        // Escribe un mensaje cifrado dentro de un fichero
        // operaciones.escrituraFichero("src/main/java/resources/escritura.txt");

        // Escribe varias líneas dentro de un fichero usando saltos de línea
        // operaciones.escrituraSalto("src/main/java/resources/ejemplo_salto.txt");


        // ====== EJEMPLO DE LECTURA DE OBJETOS (si existe el fichero) ======

        // operaciones.lecturaObjeto("src/main/java/resources/objetos.dat");
    }
}