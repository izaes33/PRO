public class Main {
    public static void main(String[] args) {
        // 1. Inicializar la variable 'puntuacion' con valor 0
        int puntuacion = 0;
        System.out.println("Puntuación inicial: " + puntuacion);

        // --- Modificaciones ---

        // 2. Primera modificación: Sumar 10 puntos
        // Uso del operador de asignación compuesta (puntuacion = puntuacion + 10)
        puntuacion += 10;
        System.out.println("Puntuación después de sumar 10: " + puntuacion);

        // 3. Segunda modificación: Restar 3 puntos (por un error)
        puntuacion -= 3;
        System.out.println("Puntuación después de restar 3: " + puntuacion);

        // 4. Tercera modificación: Multiplicar la puntuación actual por 2 (bonificación)
        puntuacion *= 2;
        System.out.println("Puntuación después de multiplicar por 2: " + puntuacion);

        // --- Resultado Final ---

        System.out.println("\n--------------------------");
        System.out.println("Puntuación FINAL del juego: " + puntuacion);
    }
}
