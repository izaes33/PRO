/* Crea un programa con una matriz de 3x5 con números. Pide al usuario un número
a buscar y usa bucles for anidados para encontrarlo. Si existe, muestra su posición
(fila y columna). Si no existe, indica que no se encontró.

Ejemplo de salida por consola:
Matriz:
12 45 23 67 89
34 56 78 90 11
22 33 44 55 66

Introduce el número a buscar: 78
El número 78 se encuentra en la posición [1][2]  */

package BuscarElemento;
import java.util.Scanner;

public class BuscarElemento {
    public void buscar(){

        Scanner sc = new Scanner(System.in);

        int matriz[][] = {
                {12, 45, 23, 67, 89},
                {34, 56, 78, 90, 11},
                {22, 33, 44, 55, 66}
        };

        System.out.print("\nIntroduce el número a buscar: ");
        int numero = sc.nextInt();

        System.out.println("\nMatriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        boolean encontrado = false;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == numero) {
                    System.out.println("\nEl número " + numero + " se encuentra en la posición [" + i + "][" + j + "]");
                    encontrado = true;
                    break; // Sale del bucle interno al encontrarlo
                }
            }
            if (encontrado) break; // Sale del bucle externo si ya se encontró
        }

        if (!encontrado) {
            System.out.println("\nEl número " + numero + " no se encontró en la matriz.");
        }

        sc.close();
    }
}
