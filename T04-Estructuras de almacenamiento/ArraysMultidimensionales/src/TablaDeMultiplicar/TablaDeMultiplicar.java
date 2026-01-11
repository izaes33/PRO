package TablaDeMultiplicar;

/*Escribe un programa que genere una matriz de 10x10 que represente las tablas de multiplicar del 1 al 10. Usa bucles for anidados para llenar la matriz donde cada elemento [i][j] contenga el resultado de (i+1) * (j+1). Muestra la matriz completa.

Ejemplo de salida por consola:
Tabla de multiplicar (10x10):
1   2   3   4   5   6   7   8   9   10
2   4   6   8   10  12  14  16  18  20
3   6   9   12  15  18  21  24  27  30
4   8   12  16  20  24  28  32  36  40
5   10  15  20  25  30  35  40  45  50
6   12  18  24  30  36  42  48  54  60
7   14  21  28  35  42  49  56  63  70
8   16  24  32  40  48  56  64  72  80
9   18  27  36  45  54  63  72  81  90
10  20  30  40  50  60  70  80  90  100
``` */

public class TablaDeMultiplicar {

    public void ejecutar(){

        int[][] tabla = new int[10][10];

        // Llenar la matriz
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tabla[i][j] = (i + 1) * (j + 1);
            }
        }

        // Mostrar la matriz
        System.out.println("Tabla de multiplicar (10x10):");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tabla[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

