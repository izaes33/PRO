package Ej01_DivisionPorCero;

public class DivisionModel { // Definimos la clase DivisionModel que será el modelo encargado de realizar la división

    public double dividir(int numero1, int numero2) { // Método público que recibe dos números enteros y devuelve un double
        return (double) numero1 / numero2; // Convertimos numero1 a double para que el resultado tenga decimales.
        // En Java, si numero2 es 0 y los dos son enteros, se lanzará automáticamente una ArithmeticException

    }
}