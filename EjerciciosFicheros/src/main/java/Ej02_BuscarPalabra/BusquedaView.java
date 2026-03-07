package Ej02_BuscarPalabra;

import java.util.Scanner; // Importa Scanner para leer datos del usuario

public class BusquedaView { // Clase encargada de la interfaz de usuario (Vista)
    private Scanner teclado; // Declaramos el objeto Scanner como atributo de la clase

    public BusquedaView() { // Constructor de la Vista
        teclado = new Scanner(System.in); // Inicializamos el Scanner para leer desde la consola estándar
    } // Fin del constructor

    public String pedirDato(String mensaje) { // Método genérico para solicitar información al usuario
        System.out.print(mensaje + ": "); // Imprime el mensaje descriptivo (ej: "Ruta del archivo")
        return teclado.nextLine(); // Lee y devuelve la cadena de texto introducida por el usuario
    } // Fin del método pedirDato

    public void mostrarResultado(String palabra, int cantidad) { // Método para imprimir el éxito de la operación
        System.out.println("\nLa palabra \"" + palabra + "\" aparece " + cantidad + " veces en el archivo."); // Muestra el conteo final
    } // Fin del método mostrarResultado

    public void mostrarError(String error) { // Método para centralizar los mensajes de error
        System.out.println("Error: " + error); // Imprime el mensaje de fallo para el usuario
    } // Fin del método mostrarError
} // Fin de la clase BusquedaView