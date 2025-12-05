package BuscarElemento;
import java.util.Scanner;

public class BuscarElemento {
    public void buscarElemento(){
        Scanner teclado = new Scanner(System.in);

        int[] numeros = {5, 12, 8, 3, 15, 9, 6};

        // Mostrar el array
        System.out.print("Array: [");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        // Pedir número al usuario
        System.out.print("Introduce el número a buscar: ");
        int buscado = teclado.nextInt();

        boolean encontrado = false;
        int posicion = -1;

        // Buscar el número
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                encontrado = true;
                posicion = i;
                break;
            }
        }

        // Resultado
        if (encontrado) {
            System.out.println("El número " + buscado + " se encuentra en la posición " + posicion);
        } else {
            System.out.println("El número " + buscado + " no se encuentra en el array");
        }

        teclado.close();
    }
}
