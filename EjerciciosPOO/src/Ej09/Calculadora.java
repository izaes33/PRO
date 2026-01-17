package Ej09;

public class Calculadora {

    // Método estático para sumar
    public static double sumar(double a, double b) {
        return a + b;
    }

    // Método estático para restar
    public static double restar(double a, double b) {
        return a - b;
    }

    // Método estático para multiplicar
    public static double multiplicar(double a, double b) {
        return a * b;
    }

    // Método estático para dividir
    public static double dividir(double a, double b) {
        if (b == 0) {
            System.out.println("Error: División entre cero");
            return 0;
        }
        return a / b;
    }

    // Método estático para potencia
    public static double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }
}
