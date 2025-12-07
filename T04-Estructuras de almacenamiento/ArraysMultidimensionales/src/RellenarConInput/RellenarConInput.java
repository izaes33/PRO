/* Desarrolla un programa que cree una matriz de 2x4. Usa bucles for anidados para
pedir al usuario que introduzca 8 números y los almacene en la matriz.
Al final, muestra la matriz completa.

Ejemplo de salida por consola:
Introduce el valor para posición [0][0]: 5
Introduce el valor para posición [0][1]: 10
Introduce el valor para posición [0][2]: 15
Introduce el valor para posición [0][3]: 20
Introduce el valor para posición [1][0]: 25
Introduce el valor para posición [1][1]: 30
Introduce el valor para posición [1][2]: 35
Introduce el valor para posición [1][3]: 40

Matriz resultante:
5 10 15 20
25 30 35 40 */

package RellenarConInput;
import java.util.Scanner;

public class RellenarConInput {

    public void ejecutarPrograma(){

        Scanner sc = new Scanner(System.in);

        int matriz[][] = new int[2][4];

        // Rellenar la matriz con valores del usuario
        for (int i = 0; i < matriz.length; i++) {          // filas
            for (int j = 0; j < matriz[i].length; j++) {   // columnas
                System.out.print("Introduce el valor para posición [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }

        // Mostrar la matriz
        System.out.println("\nMatriz resultante:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(); // salto de línea al final de cada fila
        }

        sc.close();
    }
}
