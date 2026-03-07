package Ej08_ContadorPalabras;

import java.util.*; // Importamos utilidades para manejar listas y entradas de mapas

public class WordView { // Clase Vista: gestiona la entrada y salida de información por consola
    private Scanner sc = new Scanner(System.in); // Instanciamos Scanner para capturar datos del teclado

    public String pedirRuta() { // Método para solicitar la ubicación del archivo al usuario
        System.out.print("Introduce la ruta del archivo: "); // Imprimimos la instrucción en pantalla
        return sc.nextLine(); // Capturamos la línea escrita y la retornamos al controlador
    } // Cerramos el método pedirRuta

    public void mostrarResultados(int total, List<Map.Entry<String, Integer>> top5) { // Método para imprimir el informe final
        System.out.println("\n--- ESTADÍSTICAS DEL ARCHIVO ---"); // Imprimimos un título decorativo
        System.out.println("Total de palabras encontradas: " + total); // Mostramos el conteo global de palabras
        System.out.println("\nLas 5 palabras más frecuentes:"); // Título para el ranking de repeticiones

        for (Map.Entry<String, Integer> entrada : top5) { // Recorremos la lista de las 5 palabras más frecuentes
            // Imprimimos la palabra (key) y su frecuencia (value) con un formato de lista
            System.out.println("- " + entrada.getKey() + ": " + entrada.getValue() + " veces");
        } // Cerramos el bucle de impresión del ranking
    } // Cerramos el método mostrarResultados

    public void mostrarError(String msg) { // Método para notificar errores de forma clara
        System.err.println("Error: " + msg); // Imprimimos el mensaje en el canal de error estándar (usualmente texto rojo)
    } // Cerramos el método mostrarError
} // Cerramos la clase WordView