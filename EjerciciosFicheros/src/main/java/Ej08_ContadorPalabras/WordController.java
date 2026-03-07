package Ej08_ContadorPalabras;

import java.io.IOException; // Importamos para gestionar posibles excepciones de lectura
import java.util.*; // Importamos utilidades de colecciones (Map, List)

public class WordController { // Clase Controlador: actúa como mediador entre la lógica y la interfaz
    private WordModel model; // Referencia privada al componente de lógica (Modelo)
    private WordView view; // Referencia privada al componente de interfaz (Vista)

    public WordController(WordModel model, WordView view) { // Constructor que inyecta las dependencias necesarias
        this.model = model; // Guardamos el objeto modelo recibido
        this.view = view; // Guardamos el objeto vista recibido
    } // Cerramos el constructor

    public void ejecutar() { // Método principal que dirige el flujo de la aplicación
        String ruta = view.pedirRuta(); // Paso 1: Obtenemos la ruta del archivo a través de la vista

        try { // Iniciamos bloque de control para capturar errores de entrada/salida
            Map<String, Integer> frecuencias = model.obtenerFrecuencias(ruta); // Paso 2: El modelo procesa el archivo y cuenta palabras

            // Calculamos el total de palabras sumando todos los valores (conteo) contenidos en el mapa
            int total = frecuencias.values().stream().mapToInt(Integer::intValue).sum();

            // Paso 3: Solicitamos al modelo que extraiga el ranking de las 5 más usadas a partir del mapa
            List<Map.Entry<String, Integer>> top5 = model.obtenerTop5(frecuencias);

            view.mostrarResultados(total, top5); // Paso 4: Enviamos los datos calculados a la vista para su visualización

        } catch (IOException e) { // Si el archivo no existe o ocurre un fallo de lectura...
            view.mostrarError("No se pudo procesar el archivo. Verifique que la ruta sea correcta."); // Informamos al usuario
        } // Cerramos el bloque catch
    } // Cerramos el método ejecutar
} // Cerramos la clase WordController