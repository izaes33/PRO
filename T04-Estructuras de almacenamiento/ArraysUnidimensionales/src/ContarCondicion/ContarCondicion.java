package ContarCondicion;
import java.util.Random;

public class ContarCondicion {
    public void contarCondicion(){

        int[] numeros = new int[10];
        Random random = new Random();

        // Rellenar el array con números aleatorios del 0 al 99
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(100);
        }

        // Mostrar el array
        System.out.print("Array: [");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        // Contar cuántos son mayores de 50
        int contador = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > 50) {
                contador++;
            }
        }

        System.out.println("Cantidad de números mayores que 50: " + contador);
    }
}
