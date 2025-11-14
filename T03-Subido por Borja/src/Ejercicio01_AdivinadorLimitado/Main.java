/*  Crea un programa de adivinación de números El programa genera de manera
aleatoria un número entre 1 y 50. El usuario debe adivinar el número en un
máximo de 7 intentos. Después de cada intento, indica si el número es mayor
o menor que el elegido. Si el usuario acierta, mostrar un aviso con el número
de intentos utilizado; si no, mostrar un aviso de que debe introducir
nuevamente un número. */

package Ejercicio01_AdivinadorLimitado;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Genera un número secreto entre 1 y 50 (50 - 1 + 1 = 50)
        final int NUMERO_SECRETO = random.nextInt(50) + 1;

        // Variables de control del juego
        int intento = 0;
        int intentosRestantes = 7;
        int numeroIntentos = 0;
        boolean adivinado = false;

        System.out.println("--- ¡BIENVENIDO AL JUEGO DE ADIVINACIÓN! ---");
        System.out.println("Tienes que adivinar un número entre 1 y 50.");
        System.out.println("Tienes un máximo de 7 intentos.");
        System.out.println("----------------------------------------------");

        // Bucle WHILE que se ejecuta mientras no se adivine Y queden intentos
        while (intentosRestantes > 0 && !adivinado) {
            numeroIntentos++;
            System.out.println("Intento #" + numeroIntentos + " (Te quedan " + intentosRestantes + "):");
            System.out.print("Introduce tu número: ");

            // Validación de entrada (con lo visto hasta ahora)
            if (scanner.hasNextInt()) {
                intento = scanner.nextInt();

                // 1. Verificar si adivinó
                if (intento == NUMERO_SECRETO) {
                    adivinado = true;
                }
                // 2. Dar pistas si no adivinó
                else if (intento < NUMERO_SECRETO) {
                    System.out.println("El número secreto es MAYOR. ¡Sigue intentando!");
                } else { // intento > NUMERO_SECRETO
                    System.out.println("El número secreto es MENOR. ¡Sigue intentando!");
                }

                // Decrementar el contador de intentos restantes SOLO si la entrada es válida
                intentosRestantes--;
            } else {
                // Aviso de entrada inválida
                System.out.println("AVISO: Debes introducir un número entero válido.");
                scanner.next(); // Limpia la entrada no válida
            }
        }

        System.out.println("\n==============================================");

        // 3. Mostrar el resultado final
        if (adivinado) {
            System.out.println("¡🎉 CORRECTO! 🎉");
            System.out.println("Has adivinado el número " + NUMERO_SECRETO + " en " + numeroIntentos + " intentos.");
        } else {
            System.out.println("¡OH NO! 😭 Te has quedado sin intentos.");
            System.out.println("El número secreto era: " + NUMERO_SECRETO);
        }

        System.out.println("==============================================");
        scanner.close();
    }
}
