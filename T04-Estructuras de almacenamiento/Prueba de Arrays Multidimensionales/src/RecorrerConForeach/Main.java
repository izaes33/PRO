package RecorrerConForeach;

public class Main {
    public static void main(String[] args) {

        int[][] tablaValores = new int[][]{{3,8,2},{6,7,1},{2,8,1}};

        for (int[] fila : tablaValores) { //En cada iteración, toma una fila completa del array tablaValores.
            for (int numero : fila) { //En cada iteración, toma un elemento del array fila. numero contiene el valor entero de esa posición.
                System.out.print(numero + " ");
            }
            System.out.println();
        }
    }
}

/*// Bucle foreach externo: recorre cada "fila" del array bidimensional.
// "fila" será un array de enteros (int[]) en cada iteración.
// Equivale a: for (int i = 0; i < tablaValores.length; i++) { int[] fila = tablaValores[i]; }
for (int[] fila : tablaValores) {

    // Bucle foreach interno: recorre cada número dentro de la fila actual.
    // "numero" será cada elemento de la fila, uno por uno.
    // Equivale a: for (int j = 0; j < fila.length; j++) { int numero = fila[j]; }
    for (int numero : fila) {

        // Imprime el valor actual seguido de un espacio.
        // Se imprimen uno detrás de otro en la misma línea.
        System.out.print(numero + " ");
    }

    // Al terminar la fila, imprime un salto de línea para pasar a la siguiente.
    System.out.println();
}*/

/*
Un foreach en Java es un tipo de bucle que recorre todos los elementos de un array o colección sin usar índices,
tomando cada elemento uno a uno, en orden, hasta que no queda ninguno.
El foreach recorre automáticamente todos los elementos de una estructura, entregándotelos uno por uno,
sin que tengas que preocuparte por índices o límites.

1. La forma general del foreach:

for (Tipo elemento : estructura) {
    // usar elemento
}

Significa:

“Saca el siguiente elemento de estructura
y mételo en elemento”.
 */