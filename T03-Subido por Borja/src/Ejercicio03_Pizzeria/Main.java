package Ejercicio03_Pizzeria;
import java.util.Scanner;
/*Crea un programa que permita al usuario crear una pizza personalizada
eligiendo ingredientes desde un menú.
Reglas:
• El programa muestra al usuario un menú con al menos cinco ingredientes
posibles y su precio individual. Ejemplo: queso (10), jamón (15), piña
(8), tomate (6), pepperoni (12).
• El usuario puede agregar hasta 5 ingredientes diferentes a su pizza,
eligiendo uno por uno. El programa debe evitar la cantidad máxima no
se supere.
• Por cada ingrediente elegido, el programa suma el precio
correspondiente.
• Después de cada selección, muestra al usuario la lista actual de
ingredientes y el subtotal acumulado.
• Cuando el usuario termina, muestra la pizza final detallada (con todos
los ingredientes seleccionados) y el total a pagar. */

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String ingredientes ="";
        int numeroIngredientes = 0;
        int totalPizza = 0;
        int opcionIngrediente;
        do {
            System.out.println("1. Queso");
            System.out.println("2. Jamón");
            System.out.println("3. Piña");
            System.out.println("4. Tomate");
            System.out.println("5. Pepperoni");
            System.out.println("0. Finalizar pedido");

            System.out.print("¿Qué ingrediente quieres? ");

            opcionIngrediente = scanner.nextInt();

            switch (opcionIngrediente) {
                case 1 -> {
                    totalPizza += Ingrediente.Queso.precio; ingredientes+= Ingrediente.Queso;
                }
                case 2 -> {
                    totalPizza += Ingrediente.Jamon.precio; ingredientes+=Ingrediente.Jamon;
                }
                case 3 -> {
                    totalPizza += Ingrediente.Piña.precio; ingredientes+=Ingrediente.Piña;
                }
                case 4 -> {
                    totalPizza += Ingrediente.Tomate.precio; ingredientes+=Ingrediente.Tomate;
                }
                case 5 -> {
                    totalPizza += Ingrediente.Pepperoni.precio; ingredientes+=Ingrediente.Pepperoni;
                }
                default -> System.out.println("Opción no válida.");
            }

            numeroIngredientes++;
            System.out.println("El total de lo que has pedido es: " + totalPizza+ "€");
            System.out.println("Los ingredientes de tu pizza son " +ingredientes);

        } while (numeroIngredientes<5 && opcionIngrediente!=0);

        scanner.close();
    }
}