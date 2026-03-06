package Ej01_DivisionPorCero;

import java.util.Scanner; // Importamos Scanner

public class DivisionView { // Definimos la clase
    private Scanner scanner; // Declaramos un objeto Scanner para PODER leer lo que el usuario escribe

    public DivisionView() { // Constructor de la clase
        scanner = new Scanner(System.in); // Inicializamos el Scanner para leer desde la entrada estándar (teclado)
    }
    /*El constructor es necesario para inicializar los recursos que la vista necesita para funcionar, en este caso el objeto
    Scanner que lee datos del teclado, y el constructor se ejecuta una sola vez cuando se crea el objeto.
    Así: Main crea DivisionView -> se ejecuta el constructor -> se crea Scanner(System.in)
    Y después todos los métodos de la vista pueden usar ese mismo Scanner.*/

    public int pedirNumero(String mensaje) { // Método que pide un número al usuario y recibe el mensaje a mostrar
        System.out.print(mensaje); // Mostramos el mensaje en consola sin salto de línea
        return scanner.nextInt(); // Leemos el número entero que introduce el usuario y lo devolvemos
    }

    public void mostrarResultado(double resultado) { // Método que muestra el resultado de la división
        System.out.println("Resultado: " + resultado); // Imprimimos el resultado concatenado con el texto
    }

    public void mostrarError(String mensaje) { // Método para mostrar mensajes de error
        System.out.println("Error: " + mensaje); // Mostramos el mensaje de error en consola
    }
}