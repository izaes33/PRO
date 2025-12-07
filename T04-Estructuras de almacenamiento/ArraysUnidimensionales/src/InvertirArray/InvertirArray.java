/* Escribe un programa que cree un array de 7 números. Usa un bucle for para crear un nuevo array
con los elementos en orden inverso. Muestra ambos arrays: el original y el invertido.

Ejemplo de salida por consola:
Array original: [2, 4, 6, 8, 10, 12, 14]
Array invertido: [14, 12, 10, 8, 6, 4, 2] */

package InvertirArray;
import java.util.Random;
import java.util.Arrays;

public class InvertirArray {
    public void invertir(){

        int[] numeros = new int[12];
        Random random = new Random();

        // Rellenar el array con números aleatorios
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(50);
        }
        System.out.println("Array original: " + Arrays.toString(numeros));

        for (int i = 0; i < numeros.length / 2; i++) {
            int tempo = numeros[i];
            numeros[i] = numeros[numeros.length -1 - i];
            numeros[numeros.length -1 - i] = tempo;
        }

        System.out.println("Array invertido: " + Arrays.toString(numeros));

    }
}
