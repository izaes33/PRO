/* Desarrolla un programa que defina una matriz de 4x3 con números decimales.
Usa bucles for anidados para calcular y mostrar el promedio de cada fila de la matriz.

Ejemplo de salida por consola:
Matriz:
5.5 7.2 6.8
8.1 9.3 7.5
4.2 5.6 6.1
7.8 8.9 9.2
Promedio de fila 0: 6.50
Promedio de fila 1: 8.30
Promedio de fila 2: 5.30
Promedio de fila 3: 8.63  */


package PromedioFila;

public class PromedioFila {
    public void ejecutaMetodo(){
        double matriz[][] = new double[4][3];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = Math.random() * 10.0;
                matriz[i][j] = Math.round(matriz[i][j] * 10) / 10.0;
/* Math.round:
Math.round() REDONDEA AL ENTERO más cercano:
Si el número original es, por ejemplo:
7.26
Lo multiplicamos por 10:
7.26 * 10 = 72.6
Esto mueve el decimal una posición a la derecha, para poder redondearlo correctamente.
Ahora devolvemos el decimal a su posición original (/ 10.0):
73 / 10.0 = 7.3
Esto garantiza:
Resultado double. Siempre con 1 decimal, aunque el número completo tenga más precisión */
            }
        }

        System.out.println("Matriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println();
        }

        for (int i = 0; i < matriz.length; i++) {
            double suma = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }
            double promedio = suma / matriz[i].length;
            System.out.printf("Promedio de fila %d: %.2f%n", i, promedio);
        }
    }
}
