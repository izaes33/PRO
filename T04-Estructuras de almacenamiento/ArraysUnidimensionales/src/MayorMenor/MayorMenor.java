package MayorMenor;
import java.util.Random;

public class MayorMenor {
    public void mayorMenor(){

        int[] numeros = new int[6];
        Random random = new Random();

        // Rellenar el array con números aleatorios entre 1 y 50
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(50) + 1; // 1 a 50
        }

        // Mostrar el array
        System.out.print("Array: [");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        // Encontrar mayor y menor
        int mayor = numeros[0];
        int menor = numeros[0];

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > mayor) mayor = numeros[i];
            if (numeros[i] < menor) menor = numeros[i];
        }

        System.out.println("El número mayor es: " + mayor);
        System.out.println("El número menor es: " + menor);
    }
}
