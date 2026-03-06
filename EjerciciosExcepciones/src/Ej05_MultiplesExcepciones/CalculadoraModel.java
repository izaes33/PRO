package Ej05_MultiplesExcepciones;

public class CalculadoraModel { // Definimos la clase del modelo que realizará las operaciones

    public int calcular(int num1, int num2, char operacion) { // Método que recibe dos números y una operación

        switch (operacion) { // Usamos un switch para decidir qué operación realizar

            case '+': // Si la operación es suma
                return num1 + num2; // Devolvemos la suma
            case '-': // Si la operación es resta
                return num1 - num2; // Devolvemos la resta
            case '*': // Si la operación es multiplicación
                return num1 * num2; // Devolvemos la multiplicación
            case '/': // Si la operación es división
                // Si num2 es 0 Java lanzará automáticamente ArithmeticException
                return num1 / num2; // Devolvemos la división

            default: // Si la operación no es válida
                throw new IllegalArgumentException("Operación no válida"); // Lanzamos una excepción indicando error
        }
    }
}