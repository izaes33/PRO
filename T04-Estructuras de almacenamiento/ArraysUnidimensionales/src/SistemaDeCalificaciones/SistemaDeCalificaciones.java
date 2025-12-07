/* Desarrolla un programa que pida al usuario cuántos estudiantes hay en una clase.
Crea un array para almacenar sus calificaciones (0-10). Usa un bucle while para rellenar el array con las notas.
Luego, usa un bucle for para:
1. Mostrar todas las calificaciones
2. Calcular el promedio de la clase
3. Contar cuántos estudiantes aprobaron (nota ≥ 5)
4. Encontrar la nota más alta y la más baja

Ejemplo de salida por consola:

¿Cuántos estudiantes hay?: 5
Introduce la nota del estudiante 1: 7.5
Introduce la nota del estudiante 2: 4.0
Introduce la nota del estudiante 3: 8.5
Introduce la nota del estudiante 4: 6.0
Introduce la nota del estudiante 5: 9.0
--- REPORTE DE CALIFICACIONES ---
Calificaciones: [7.5, 4.0, 8.5, 6.0, 9.0]
Promedio de la clase: 7.0
Estudiantes aprobados: 4
Nota más alta: 9.0
Nota más baja: 4.0 */


package SistemaDeCalificaciones;
import java.util.Scanner;
import java.util.Arrays;

public class SistemaDeCalificaciones {
    public void sistemaDeCalificaciones() {

        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos estudiantes hay?: ");
        int cantidad = sc.nextInt();

        double[] notas = new double[cantidad];

        int i = 0;

        // Rellenar el array con notas usando while
        while (i < notas.length) {
            System.out.print("Introduce la nota del estudiante " + (i + 1) + ": ");
            notas[i] = sc.nextDouble();
            i++;
        }

        // Mostrar reporte
        System.out.println("--- REPORTE DE CALIFICACIONES ---");

        // 1. Mostrar todas las calificaciones
        System.out.println("Calificaciones: " + Arrays.toString(notas));

        // Variables para el procesamiento
        double suma = 0;
        int aprobados = 0;
        double max = notas[0];
        double min = notas[0];

        // 2, 3, 4 usando un solo bucle for
        for (int j = 0; j < notas.length; j++) {

            suma += notas[j];

            if (notas[j] >= 5) {
                aprobados++;
            }

            if (notas[j] > max) {
                max = notas[j];
            }

            if (notas[j] < min) {
                min = notas[j];
            }
        }

        double promedio = suma / notas.length;

        // Mostrar resultados
        System.out.println("Promedio de la clase: " + promedio);
        System.out.println("Estudiantes aprobados: " + aprobados);
        System.out.println("Nota más alta: " + max);
        System.out.println("Nota más baja: " + min);

        sc.close();
    }
}
