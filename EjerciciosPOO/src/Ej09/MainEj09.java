/* Crea una clase Calculadora con métodos estáticos para sumar, restar,
multiplicar y dividir dos números. Añade también un método estático
potencia(base, exponente). Usa estos métodos sin crear objetos de la clase. */

package Ej09;

public class MainEj09 {
    public static void main(String[] args) {
        double num1 = 10;
        double num2 = 5;

        System.out.println("Suma: " + num1 + " + " + num2 + " = " + Calculadora.sumar(num1, num2));
        System.out.println("Resta: " + num1 + " - " + num2 + " = " + Calculadora.restar(num1, num2));
        System.out.println("Multiplicación: " + num1 + " * " + num2 + " = " + Calculadora.multiplicar(num1, num2));
        System.out.println("División: " + num1 + " / " + num2 + " = " + Calculadora.dividir(num1, num2));

        double base = 2;
        double exponente = 3;
        System.out.println("Potencia: " + (int)base + "^" + (int)exponente + " = " + Calculadora.potencia(base, exponente));
    }
}
