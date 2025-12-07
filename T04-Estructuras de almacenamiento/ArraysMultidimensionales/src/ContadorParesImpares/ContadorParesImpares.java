/*Desarrolla un programa que cree una matriz de 4x5 con números enteros.
Usa bucles for anidados para contar cuántos números pares e impares hay en toda la matriz.
Muestra ambos contadores.

Ejemplo de salida por consola:
Matriz:
12 15 8 23 34
17 20 9 14 27
6 11 18 25 30
13 22 7 16 19

Números pares: 11
Números impares: 9 */


package ContadorParesImpares;

public class ContadorParesImpares {
    public void ejecutarMetodo(){

        int[][] matriz = new int[4][5];

        // Llenar la matriz con números aleatorios de 0 a 49
        for (int i = 0; i < matriz.length; i++) {               // i → fila
            for (int j = 0; j < matriz[i].length; j++) {        // j → columna
                matriz[i][j] = (int) (Math.random() * 50);
            }
        }

        // Mostrar la matriz
        System.out.println("Matriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%3d", matriz[i][j]);
            }
            System.out.println();
        }

        int pares = 0;
        int impares = 0;

        // Contar pares e impares
        for (int i = 0; i < matriz.length; i++) {               // recorrer filas
            for (int j = 0; j < matriz[i].length; j++) {        // recorrer columnas

                if (matriz[i][j] % 2 == 0) {                    // número par
                    pares++;
                } else {                                        // número impar
                    impares++;
                }
            }
        }

        // Mostrar resultados
        System.out.println("\nNúmeros pares: " + pares);
        System.out.println("Números impares: " + impares);
    }
}
