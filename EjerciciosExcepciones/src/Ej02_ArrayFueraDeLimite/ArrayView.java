package Ej02_ArrayFueraDeLimite;

import java.util.Scanner; // Importamos Scanner para leer datos del teclado.
import java.util.Arrays; // Importamos Arrays para poder mostrar el array fácilmente.

public class ArrayView { // Definimos la clase vista.

    private Scanner scanner; // Declaramos un objeto Scanner para capturar la entrada del usuario.

    public ArrayView() { // Constructor de la clase.
        scanner = new Scanner(System.in); // Inicializamos el Scanner para leer desde el teclado.
    }

    public void mostrarArray(int[] array) { // Método que recibe un array y lo muestra por pantalla
        System.out.println("Array: " + Arrays.toString(array)); // Arrays.toString convierte el array en texto legible.
    }

    public int pedirPosicion() { // Método que pide al usuario la posición del array
        System.out.print("Introduce la posición (0-4): "); // Mostramos el mensaje al usuario.
        return scanner.nextInt(); // Leemos el número introducido y lo devolvemos.
    }

    public void mostrarElemento(int posicion, int valor) { // Método que muestra el valor encontrado.
        System.out.println("Elemento en posición " + posicion + ": " + valor); // Mostramos la posición y el valor.
    }

    public void mostrarError(String mensaje) { // Método que muestra un mensaje de error.
        System.out.println("Error: " + mensaje); // Imprimimos el mensaje de error.
    }
}