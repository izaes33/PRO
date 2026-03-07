package Ej01LeerArchivoDeTexto;

import java.util.Scanner; // Importa la utilidad para leer la entrada del usuario por consola
import java.util.List; // Importa List para poder iterar sobre el contenido que queremos mostrar

public class ArchivoView { // Definimos la clase ArchivoView, responsable de la representación visual
    private Scanner entrada; // Declaramos un objeto Scanner para capturar datos del teclado

    public ArchivoView() { // Constructor de la vista
        entrada = new Scanner(System.in); // Inicializamos el Scanner apuntando al flujo de entrada estándar (teclado)
    } // Fin del constructor

    public String pedirRuta() { // Método para interactuar con el usuario y pedirle un dato
        System.out.print("Introduce la ruta del archivo: "); // Imprime la instrucción en la consola
        return entrada.nextLine(); // Captura la cadena de texto escrita por el usuario hasta que pulsa Enter
    } // Fin del método pedirRuta

    public void mostrarLineas(List<String> lineas) { // Método que recibe los datos procesados y los imprime
        System.out.println("\nContenido del archivo:"); // Imprime un encabezado decorativo
        for (String l : lineas) { // Bucle "for-each" que recorre cada String dentro de la lista recibida
            System.out.println(l); // Imprime la línea actual en una nueva línea de consola
        } // Fin del bucle
    } // Fin del método mostrarLineas

    public void imprimirError(String msg) { // Método para centralizar cómo se muestran los mensajes de error
        System.err.println("ERROR: " + msg); // Imprime el mensaje usando el flujo de error (suele salir en rojo en el IDE)
    } // Fin del método imprimirError
} // Fin de la clase ArchivoView