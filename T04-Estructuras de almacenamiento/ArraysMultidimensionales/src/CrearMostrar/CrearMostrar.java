/* Crea un programa que defina una matriz de 3x3 con números del 1 al 9.
Usa bucles for anidados para mostrar la matriz en formato de tabla.

Ejemplo de salida por consola:
Matriz 3x3:
1 2 3
4 5 6
7 8 9 */

package CrearMostrar;
import java.util.Random;

public class CrearMostrar {

    public void ejecutarPrograma() {

        int matriz[][] = new int[3][3];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * 50);
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            // Recorrer columnas de la fila actual
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%3d", matriz[i][j]); // Cada número ocupa 3 espacios
            }
            System.out.println(); // Salto de línea al terminar cada fila
        }
    }
}
