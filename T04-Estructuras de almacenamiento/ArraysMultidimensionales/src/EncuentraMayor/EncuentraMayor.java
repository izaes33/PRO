/*Escribe un programa que cree una matriz de 3x4 con números.
Usa bucles for para encontrar el número mayor de cada columna y muestra los resultados.

Ejemplo de salida por consola:
Matriz:
15 23 8 19
42 17 31 25
28 35 12 40
Mayor de columna 0: 42
Mayor de columna 1: 35
Mayor de columna 2: 31
Mayor de columna 3: 40 */
package EncuentraMayor;

public class EncuentraMayor {
    public void encuentraMayor() {

        int matriz[][] = new int[3][3];

        // Llenar matriz con valores aleatorios de 0 a 49
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * 50);
            }
        }

        // Mostrar la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%3d", matriz[i][j]);
            }
            System.out.println();
        }

        // Buscar el mayor de cada columna:
        for (int j = 0; j < matriz[0].length; j++) {
/*matriz[0].length es el número de columnas de la matriz (asumiendo que hay al menos una fila).
El bucle externo recorre cada columna una por una, y escogemos columnas como iteración externa
porque queremos producir un resultado por columna. */

            // Tomamos el primer valor de la columna como referencia
            int mayor = matriz[0][j];
/* Inicializamos mayor con el primer elemento de la columna (fila 0, columna j).
Al usar el primer elemento como referencia, ya hemos "procesado" la fila 0 para
esa columna, por eso el siguiente bucle empieza en 1.*/

            // Recorremos las filas
            for (int i = 1; i < matriz.length; i++) {
/*matriz.length es el número de filas.
El bucle interior recorre todas las filas restantes (desde la fila 1 hasta la última) en la columna j.*/

                // Si el valor de esta fila y columna es mayor, sustituimos
                if (matriz[j][i] > mayor) {
                    mayor = matriz[j][i];
// Una vez revisadas todas las filas de la columna j, mayor contiene el máximo. Lo imprimes.
                }
            }

            // Mostrar el mayor encontrado en esa columna
            System.out.println("Mayor de columna " + j + ": " + mayor);
        }
    }

}
