package RecorrerConFor;

public class Main {
    public static void main(String[] args) {

        int[][] tablaValores = new int[][]{{3,8,2},{6,7,1},{2,8,1}};

        for (int i = 0; i < tablaValores.length; i++) {  // Recorre las filas
            int[] fila = tablaValores[i];

            System.out.print("nº fila: " + i + " | Valores: ");

            for (int j = 0; j < fila.length; j++) {      // Recorre las columnas de cada fila
                System.out.print(fila[j] + " ");         // Imprime sólo el número
            }

            System.out.println(); // Salto de línea al final de cada fila
        }
    }
}

/*
// Declaración y creación de un array bidimensional de 3 filas y 3 columnas.
// Cada par de llaves internas representa una fila.
// tablaValores.length = 3 → porque hay 3 filas.
int[][] tablaValores = new int[][] { {3, 8, 2}, {6, 7, 1}, {2, 8, 1} };

// PRIMER BUCLE: recorre las filas de la matriz.
for (int i = 0; i < tablaValores.length; i++) {
// tablaValores.length devuelve el número de filas (3 en este caso).
// i empieza en 0 → recorre las filas: 0, 1, 2.


int[] fila = tablaValores[i];
// 'fila' apunta al array interno que representa la fila actual.
/*tablaValores[i] es ya un objeto array (por ejemplo {3, 8, 2}).
La variable fila solo guarda la dirección de ese array en memoria.
Java no duplica ni clona el array —solo apunta al mismo sitio. */
// Cuando i=0 → fila = {3, 8, 2}
// Cuando i=1 → fila = {6, 7, 1}
// Cuando i=2 → fila = {2, 8, 1}

/*  SEGUNDO BUCLE: recorre las columnas de la fila actual.
    for (int j = 0; j < fila.length; j++) {
        // fila.length devuelve el nº de columnas de esa fila.
        // Cada fila tiene 3 elementos → se recorre j = 0, 1, 2.

        // Imprime el elemento de la fila en la columna j.
        // No hace salto de línea, por eso los valores quedan en la misma línea.
        System.out.print(fila[j] + " ");
    }

            // Al acabar cada fila, imprime un salto de línea.
            // Así cada fila aparece en una línea distinta.
            System.out.println();
} */