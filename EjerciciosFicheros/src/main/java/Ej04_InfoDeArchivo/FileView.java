package Ej04_InfoDeArchivo;

import java.io.File; // Importamos File para poder recibir el objeto y extraer sus datos en los prints
import java.util.Scanner; // Importamos Scanner para leer la ruta del teclado

public class FileView { // Definimos la clase Vista para la interacción con el usuario
    private Scanner teclado; // Declaramos el scanner como atributo de clase

    public FileView() { // Constructor de la vista
        teclado = new Scanner(System.in); // Inicializamos el scanner para la entrada estándar
    } // Cerramos el constructor

    public String pedirRuta() { // Método para solicitar la ruta al usuario
        System.out.print("Introduce la ruta del archivo: "); // Imprimimos la instrucción
        return teclado.nextLine(); // Retornamos lo que el usuario escriba
    } // Cerramos el método pedirRuta

    public void mostrarDetalles(File f, String fechaFormateada, double tamanoMB) { // Método que imprime el informe final
        System.out.println("\nInformación del archivo " + f.getName() + ":"); // Imprimimos el nombre del archivo
        System.out.println("- Tamaño: " + f.length() + " bytes (" + String.format("%.2f", tamanoMB) + " MB)"); // Mostramos bytes y MB con 2 decimales
        System.out.println("- Última modificación: " + fechaFormateada); // Imprimimos la fecha ya procesada
        System.out.println("- Permisos: Lectura (" + (f.canRead() ? "sí" : "no") + // Usamos operador ternario para mostrar sí/no
                "), Escritura (" + (f.canWrite() ? "sí" : "no") +
                "), Ejecución (" + (f.canExecute() ? "sí" : "no") + ")");
        System.out.println("- Archivo oculto: " + (f.isHidden() ? "sí" : "no")); // Comprobamos el atributo de visibilidad
        System.out.println("- Ruta absoluta: " + f.getAbsolutePath()); // Mostramos la ruta completa desde la raíz
    } // Cerramos el método mostrarDetalles

    public void mostrarError(String mensaje) { // Método para errores
        System.out.println("Error: " + mensaje); // Imprimimos el mensaje de fallo
    } // Cerramos el método mostrarError
} // Cerramos la clase FileView