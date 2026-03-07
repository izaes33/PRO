package Ej07_ExploracConFile;

import java.util.Scanner; // Importamos Scanner para capturar la entrada de texto desde el teclado

public class DirectorioView { // Definimos la clase Vista, encargada de la representación visual por consola
    private Scanner scanner; // Declaramos un objeto Scanner como atributo privado de la clase

    public DirectorioView() { // Definimos el constructor de la Vista
        this.scanner = new Scanner(System.in); // Inicializamos el Scanner para leer la entrada estándar del sistema
    } // Cerramos el constructor

    public String solicitarRuta() { // Método para pedir al usuario la ruta del directorio
        System.out.print("Ruta: "); // Imprimimos el texto de solicitud en la consola
        return scanner.nextLine(); // Leemos y devolvemos la línea completa introducida por el usuario
    } // Cerramos el método solicitarRuta

    public void mostrarCabecera(String ruta) { // Método para imprimir la ruta que se está listando
        System.out.println("\nDirectorio: " + ruta); // Imprimimos la ruta precedida por un salto de línea
    } // Cerramos el método mostrarCabecera

    public void mostrarElemento(String tipo, String nombre, String tamano, String fecha) { // Método para imprimir una línea de archivo/carpeta
        // Imprimimos los datos con el formato solicitado: [TIPO] Nombre (tamaño si es archivo) - Fecha
        System.out.println("- [" + tipo + "] " + nombre + tamano + " - Última modificación: " + fecha);
    } // Cerramos el método mostrarElemento

    public void mostrarError(String mensaje) { // Método para mostrar mensajes de error al usuario
        System.out.println("Error: " + mensaje); // Imprimimos el mensaje de fallo descriptivo
    } // Cerramos el método mostrarError
} // Cerramos la clase DirectorioView