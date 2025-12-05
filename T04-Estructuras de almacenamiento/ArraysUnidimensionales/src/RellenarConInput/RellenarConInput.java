package RellenarConInput;
import java.util.Scanner;

public class RellenarConInput {
    public void rellenarConInput (){
        Scanner teclado = new Scanner(System.in);

        String[] nombres = new String[5];

        // Pedir los nombres
        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Introduce el nombre " + (i + 1) + ": ");
            nombres[i] = teclado.nextLine();
        }

        // Mostrar los nombres
        System.out.println("\nNombres introducidos:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i]);
        }

        teclado.close();
    }
}
