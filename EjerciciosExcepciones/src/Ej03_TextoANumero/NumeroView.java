package Ej03_TextoANumero;

import java.util.Scanner; // Importamos Scanner para leer datos desde el teclado

public class NumeroView { // Definimos la clase vista
    private Scanner scanner; // Declaramos un objeto Scanner para capturar la entrada del usuario

    public NumeroView() { // Constructor de la clase
        scanner = new Scanner(System.in); // Inicializamos el Scanner para leer desde la entrada estándar (teclado)
    }

    public String pedirNumero() { // Método que pide al usuario que introduzca un número
        System.out.print("Introduce un número: "); // Mostramos el mensaje al usuario
        return scanner.nextLine(); // Leemos lo que el usuario escribe como texto y lo devolvemos
    }

    public void mostrarNumero(int numero) { // Método para mostrar el número válido introducido
        System.out.println("Has introducido el número: " + numero); // Mostramos el número final al usuario
    }

    public void mostrarError() { // Método que muestra el mensaje de error cuando el valor no es válido
        System.out.println("Error: Eso no es un número válido. Inténtalo de nuevo."); // Mostramos el mensaje de error
    }
}