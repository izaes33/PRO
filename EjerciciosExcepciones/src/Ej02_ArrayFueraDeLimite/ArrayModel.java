package Ej02_ArrayFueraDeLimite;

public class ArrayModel { // Definimos la clase del modelo.

    // Declaramos un array de enteros con 5 posiciones y lo inicializamos con los valores indicados.
    private int[] numeros = {10, 20, 30, 40, 50}; // Este array será la fuente de datos del programa.

    public int obtenerElemento(int posicion) { // Método que recibe una posición y devuelve el valor del array.
        // Si la posición no existe en el array Java lanzará automáticamente ArrayIndexOutOfBoundsException.
        return numeros[posicion]; // Devolvemos el valor almacenado en la posición indicada.
    }

    public int[] getNumeros() { // Método getter que permite acceder al array desde otras capas.
        return numeros; // Devolvemos el array completo.
    }
}