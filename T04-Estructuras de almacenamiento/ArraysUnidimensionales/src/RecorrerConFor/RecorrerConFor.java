package RecorrerConFor;
import java.util.Random;

public class RecorrerConFor {
    public void recorrerConFor(){
        int[] numeros = new int[6];
        Random random = new Random();

        // Rellenar el array con números aleatorios
            for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(100); // Números entre 0 y 99
        }

        // Mostrar el contenido del array
            System.out.println("Recorriendo el array:");
            for (int i = 0; i < numeros.length; i++) {
                System.out.println("Posición " + i + ": " + numeros[i]);
        }
    }
}
