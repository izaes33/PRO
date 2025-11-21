/*Crea un programa para jugar una partida virtual de dardos entre dos
jugadores. El objetivo es que uno de los jugadores llegue exactamente a 0 puntos
partiendo desde 301.
Reglas:
• Nada más empezar pide el nombre de cada jugador
• Cada jugador comienza con 301 puntos.
• En cada turno, un jugador lanza 3 dardos. Cada dardo genera un número
aleatorio entre 0 y 60 (simulando puntuación en dardos).
• La puntuación del turno es la suma de los 3 dardos.
• Resta la puntuación del turno al total de puntos del jugador.
• Si la puntuación restante es menor que 0, se considera que el jugador "se
pasa" y su total no cambia ese turno.
• El primer jugador que llegue exactamente a 0 gana la partida.
• Después de cada turno, muestra las puntuaciones actuales y quién va
ganando (el que tiene menos puntos).
• Al finalizar, muestra el ganador y cuántos turnos tomó la partida. */

package Ejercicio04_PartidaDeDardos;

import java.util.Random;
import java.util.Scanner;

public class Main {
/*1. Inicio del programa (main)
El main arranca y hace tres cosas: */

    public static void main(String[] args) {
        // Crea los objetos necesarios
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        // b) Pide los nombres
        System.out.print("Nombre del jugador 1: ");
        String jugador1 = sc.nextLine();
        System.out.print("Nombre del jugador 2: ");
        String jugador2 = sc.nextLine();
        // c) Inicializa los puntos y el contador de turnos
        int puntos1 = 301;
        int puntos2 = 301;
        int turnos = 0;

/* Este bucle representa toda la partida.
Cada vuelta del bucle equivale a un turno
completo (jugador 1 + jugador 2). */
        while (true) {
            turnos++;

            // Turno jugador 1
            puntos1 = jugarTurno(jugador1, puntos1, random); //random se envía como argumento a la función.
            mostrarEstado(jugador1, puntos1, jugador2, puntos2);
/*Se llama a la función jugarTurno. La función calcula la puntuación del turno.
Devuelve los puntos actualizados del jugador. Ese valor se asigna a puntos1. */
            if (puntos1 == 0) {
                System.out.println("\n¡" + jugador1 + " gana la partida en " + turnos + " turnos!");
                break;
            }

            // Turno jugador 2
            puntos2 = jugarTurno(jugador2, puntos2, random); //random se envía como argumento a la función.
            mostrarEstado(jugador1, puntos1, jugador2, puntos2);

            if (puntos2 == 0) {
                System.out.println("\n¡" + jugador2 + " gana la partida en " + turnos + " turnos!");
                break;
            }
        }

        sc.close();
    }

    // Lanza 3 dardos y resta la puntuación si no se pasa
    public static int jugarTurno(String nombre, int puntos, Random random) { /* Este Random random es el mismo
        objeto que se creó en el main, solo que ahora está disponible dentro
        de esta función. */
        System.out.println("\nTurno de " + nombre + " (Puntos actuales: " + puntos + ")");

        int d1 = random.nextInt(61);
        int d2 = random.nextInt(61);
        int d3 = random.nextInt(61);

        int total = d1 + d2 + d3;

        System.out.println("Dardos: [" + d1 + ", " + d2 + ", " + d3 + "]  -> Total del turno: " + total);

        if (puntos - total < 0) {
            System.out.println("¡Se pasó! Los puntos no cambian.");
            return puntos;
        }

        return puntos - total;
/* La función NO altera el valor por sí misma. Solo devuelve un número.
Luego el main recibe ese número y lo guarda en puntos1. */
    }

    // Muestra el marcador actual
    public static void mostrarEstado(String j1, int p1, String j2, int p2) {
        System.out.println("\n--- Marcador Actual ---");
        System.out.println(j1 + ": " + p1 + " puntos");
        System.out.println(j2 + ": " + p2 + " puntos");
        System.out.println("Va ganando: " + (p1 < p2 ? j1 : j2));
        System.out.println("------------------------");
    }
}
