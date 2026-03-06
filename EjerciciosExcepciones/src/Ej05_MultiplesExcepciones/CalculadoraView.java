package Ej05_MultiplesExcepciones;

import java.util.Scanner; // Importamos Scanner para leer datos desde el teclado

public class CalculadoraView { // Definimos la clase vista
    private Scanner scanner; // Declaramos un objeto Scanner para leer datos del usuario

    public CalculadoraView() { // Constructor de la clase
        scanner = new Scanner(System.in); // Inicializamos el Scanner para leer desde el teclado
    }

    public String pedirNumero(String mensaje) { // Método que pide un número pero lo devuelve como texto
        System.out.print(mensaje); // Mostramos el mensaje en consola
        return scanner.nextLine(); // Leemos lo que el usuario escribe como texto
    }

    public char pedirOperacion() { // Método que pide la operación matemática
        System.out.print("Introduce la operación (+, -, *, /): "); // Mostramos el mensaje al usuario
        return scanner.nextLine().charAt(0); // Leemos la línea y tomamos el primer carácter
    }

    public void mostrarResultado(int num1, int num2, char operacion, int resultado) { // Método para mostrar el resultado
        System.out.println("Resultado: " + num1 + " " + operacion + " " + num2 + " = " + resultado); // Mostramos la operación completa
    }

    public void mostrarError(String mensaje) { // Método para mostrar mensajes de error
        System.out.println("Error: " + mensaje); // Mostramos el mensaje de error
    }
}