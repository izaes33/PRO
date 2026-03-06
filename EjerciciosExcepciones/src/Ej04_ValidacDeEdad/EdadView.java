package Ej04_ValidacDeEdad;

import java.util.Scanner; // Importamos Scanner para leer datos del teclado

public class EdadView { // Definimos la clase vista
    private Scanner scanner; // Declaramos un objeto Scanner para capturar la entrada del usuario

    public EdadView() { // Constructor de la clase
        scanner = new Scanner(System.in); // Inicializamos el Scanner para leer desde el teclado
    }

    public int pedirEdad() { // Método que solicita al usuario su edad
        System.out.print("Introduce tu edad: "); // Mostramos el mensaje en consola
        return scanner.nextInt(); // Leemos el número entero introducido por el usuario y lo devolvemos
    }

    public void mostrarEdadValida(int edad) { // Método para mostrar la edad cuando es válida
        System.out.println("Edad válida: " + edad + " años"); // Mostramos la edad válida
    }

    public void mostrarError(String mensaje) { // Método que muestra mensajes de error
        System.out.println("Error: " + mensaje); // Imprimimos el mensaje recibido
    }
}