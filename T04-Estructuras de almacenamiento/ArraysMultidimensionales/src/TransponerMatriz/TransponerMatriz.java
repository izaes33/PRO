/*Crea un programa que defina una matriz de 3x4. Usa bucles for anidados para crear una nueva
matriz transpuesta (4x3) donde las filas se convierten en columnas. Muestra ambas matrices.

Ejemplo de salida por consola:
Matriz original (3x4):
1 2 3 4
5 6 7 8
9 10 11 12
Matriz transpuesta (4x3):
1 5 9
2 6 10
3 7 11
4 8 12 */


package TransponerMatriz;

public class TransponerMatriz {
    public void transponerMatriz(){

        int matriz[][] = new int[3][4];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * 50);
            }
        }

        // Crear matriz transpuesta 4x3
        int[][] transpuesta = new int[4][3];

        // Rellenar la matriz transpuesta
        // i → fila de matriz original
        // j → columna de matriz original
        for (int i = 0; i < matriz.length; i++) {              // 3 filas
            for (int j = 0; j < matriz[i].length; j++) {       // 4 columnas
                transpuesta[j][i] = matriz[i][j];              // intercambio posiciones
            }
        }

        // Mostrar matriz original
        System.out.println("Matriz original (3x4):");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%3d", matriz[i][j]); // Cada número ocupa 3 espacios
            }
            System.out.println();
        }

        // Mostrar matriz transpuesta
        System.out.println("Matriz transpuesta (4x3):");
        for (int i = 0; i < transpuesta.length; i++) {         // ahora 4 filas
            for (int j = 0; j < transpuesta[i].length; j++) {  // y 3 columnas
                System.out.printf("%3d", transpuesta[i][j]); // Cada número ocupa 3 espacios
            }
            System.out.println();
        }
    }
}
