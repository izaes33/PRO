/* Escribe un programa que defina una matriz de 4x4 con números. Usa bucles for
anidados para recorrer la matriz y calcular la suma de todos sus elementos. Muestra el resultado.

Ejemplo de salida por consola:
Matriz:
        2 4 6 8
        1 3 5 7
        9 11 13 15
        10 12 14 16
Suma total de elementos: 136 */


package SumarElementos;

public class SumarElementos {

    public void sumar(){

        int matriz[][] = {
                {2, 4, 6, 8},
                {1, 3, 5, 7},
                {9, 11, 13, 15},
                {10, 12, 14, 16}
        };

        int suma = 0;

        System.out.println("Matriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%3d", matriz[i][j]); // Cada número ocupa 4 espacios
                suma += matriz[i][j];
            }
            System.out.println();
        }

        System.out.println("\nSuma total de elementos: " + suma);
    }
}
