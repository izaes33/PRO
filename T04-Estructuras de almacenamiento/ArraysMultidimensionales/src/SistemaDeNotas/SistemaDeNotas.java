package SistemaDeNotas;

/* Desarrolla un programa que pida al usuario cuántos estudiantes y cuántas asignaturas hay.
Crea una matriz para almacenar las notas (estudiantes x asignaturas).
Usa bucles for anidados para rellenar la matriz con las notas. Luego:
1. Muestra todas las notas en formato de tabla
2. Calcula y muestra el promedio de cada estudiante
3. Calcula y muestra el promedio de cada asignatura
4. Encuentra la nota más alta de toda la clase y su posición

Ejemplo de salida por consola:

¿Cuántos estudiantes hay?: 3
¿Cuántas asignaturas hay?: 4

Introduce nota de estudiante 1, asignatura 1: 7.5
Introduce nota de estudiante 1, asignatura 2: 8.0
Introduce nota de estudiante 1, asignatura 3: 6.5
Introduce nota de estudiante 1, asignatura 4: 9.0
Introduce nota de estudiante 2, asignatura 1: 5.0
Introduce nota de estudiante 2, asignatura 2: 7.0
Introduce nota de estudiante 2, asignatura 3: 6.0
Introduce nota de estudiante 2, asignatura 4: 8.0
Introduce nota de estudiante 3, asignatura 1: 9.5
Introduce nota de estudiante 3, asignatura 2: 8.5
Introduce nota de estudiante 3, asignatura 3: 9.0
Introduce nota de estudiante 3, asignatura 4: 10.0
--- TABLA DE NOTAS ---
        Asig1  Asig2  Asig3  Asig4
Est 1:  7.5    8.0    6.5    9.0
Est 2:  5.0    7.0    6.0    8.0
Est 3:  9.5    8.5    9.0    10.0
--- PROMEDIOS POR ESTUDIANTE ---
Estudiante 1: 7.75
Estudiante 2: 6.50
Estudiante 3: 9.25
--- PROMEDIOS POR ASIGNATURA ---
Asignatura 1: 7.33
Asignatura 2: 7.83
Asignatura 3: 7.17
Asignatura 4: 9.00
--- NOTA MÁS ALTA ---
La nota más alta es 10.0 (Estudiante 3, Asignatura 4) */
import java.util.Scanner;

public class SistemaDeNotas {

    public void ejecutar() {

        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos estudiantes hay?: ");
        int estudiantes = sc.nextInt();

        System.out.print("¿Cuántas asignaturas hay?: ");
        int asignaturas = sc.nextInt();

        double[][] notas = new double[estudiantes][asignaturas];

        // Rellenar la matriz
        for (int i = 0; i < estudiantes; i++) {
            for (int j = 0; j < asignaturas; j++) {
                System.out.print("Introduce nota de estudiante " + (i + 1) +
                        ", asignatura " + (j + 1) + ": ");
                notas[i][j] = sc.nextDouble();
            }
        }

        // Mostrar tabla de notas
        System.out.println("\n--- TABLA DE NOTAS ---");
        System.out.print("        ");
        for (int j = 0; j < asignaturas; j++) {
            System.out.print("Asig" + (j + 1) + "  ");
        }
        System.out.println();

        for (int i = 0; i < estudiantes; i++) {
            System.out.print("Est " + (i + 1) + ":  ");
            for (int j = 0; j < asignaturas; j++) {
                System.out.print(notas[i][j] + "    ");
            }
            System.out.println();
        }

        // Promedio por estudiante
        System.out.println("\n--- PROMEDIOS POR ESTUDIANTE ---");
        for (int i = 0; i < estudiantes; i++) {
            double suma = 0;
            for (int j = 0; j < asignaturas; j++) {
                suma += notas[i][j];
            }
            System.out.printf("Estudiante %d: %.2f%n", i + 1, suma / asignaturas);
        }

        // Promedio por asignatura
        System.out.println("\n--- PROMEDIOS POR ASIGNATURA ---");
        for (int j = 0; j < asignaturas; j++) {
            double suma = 0;
            for (int i = 0; i < estudiantes; i++) {
                suma += notas[i][j];
            }
            System.out.printf("Asignatura %d: %.2f%n", j + 1, suma / estudiantes);
        }

        // Nota más alta y posición
        double maxNota = notas[0][0];
        int estMax = 0;
        int asigMax = 0;

        for (int i = 0; i < estudiantes; i++) {
            for (int j = 0; j < asignaturas; j++) {
                if (notas[i][j] > maxNota) {
                    maxNota = notas[i][j];
                    estMax = i;
                    asigMax = j;
                }
            }
        }

        System.out.println("\n--- NOTA MÁS ALTA ---");
        System.out.println("La nota más alta es " + maxNota +
                " (Estudiante " + (estMax + 1) +
                ", Asignatura " + (asigMax + 1) + ")");

        sc.close();
    }
}
