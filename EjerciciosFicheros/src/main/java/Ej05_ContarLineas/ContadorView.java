package Ej05_ContarLineas;

import java.util.Scanner; // Importamos la clase Scanner para capturar la entrada de texto del usuario

public class ContadorView { // Definimos la clase ContadorView para manejar la interfaz de usuario
    private Scanner scanner; // Declaramos un objeto Scanner como atributo privado para usarlo en toda la clase

    public ContadorView() { // Constructor de la clase Vista
        this.scanner = new Scanner(System.in); // Inicializamos el Scanner configurado para la entrada estándar (teclado)
    } // Cerramos el constructor

    public String solicitarRuta() { // Método para pedir la ubicación del archivo
        System.out.print("Introduce la ruta del archivo: "); // Imprimimos la instrucción en pantalla sin salto de línea
        return scanner.nextLine(); // Capturamos la cadena completa que el usuario escriba y la devolvemos
    } // Cerramos el método solicitarRuta

    public void mostrarResultado(int numLineas) { // Método para presentar el dato final procesado
        System.out.println("\nEl archivo contiene " + numLineas + " líneas."); // Imprimimos el resultado con un salto de línea previo
    } // Cerramos el método mostrarResultado

    public void mostrarError(String mensaje) { // Método de utilidad para informar de fallos de forma clara
        System.out.println("Ocurrió un error: " + mensaje); // Imprimimos el prefijo de error junto con el detalle técnico
    } // Cerramos el método mostrarError
} // Cerramos la clase ContadorView