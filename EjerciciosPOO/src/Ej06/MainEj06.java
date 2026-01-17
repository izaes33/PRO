/* Crea una clase Estudiante con atributos privados nombre,
edad y nota. La nota debe estar entre 0 y 10. Implementa el
setter de nota validando que esté en el rango correcto
(si no lo está, muestra un mensaje de error).
Crea un objeto y prueba con diferentes valores. */

package Ej06;

public class MainEj06 {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Laura Fernández", 20);

        System.out.println("Estudiante: " + estudiante.getNombre());

        estudiante.setNota(8.5);
        System.out.println("Nota actual: " + estudiante.getNota());
        System.out.println();

        estudiante.setNota(12);
        System.out.println("Nota actual: " + estudiante.getNota());
        System.out.println();

        estudiante.setNota(-3);
        System.out.println("Nota actual: " + estudiante.getNota());
    }
}
