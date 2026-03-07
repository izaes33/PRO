package Ej08_ContadorPalabras;

import java.io.*; // Importamos clases para lectura de archivos (BufferedReader, FileReader)
import java.util.*; // Importamos utilidades como Map, HashMap y List
import java.util.stream.Collectors; // Importamos para transformar flujos de datos en listas

public class WordModel { // Clase Modelo: gestiona los datos y la lógica de conteo de palabras

    public Map<String, Integer> obtenerFrecuencias(String ruta) throws IOException { // Método que devuelve un mapa con palabra -> cantidad
        Map<String, Integer> mapaFrecuencia = new HashMap<>(); // Creamos un HashMap para almacenar palabras como clave y su conteo como valor

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) { // Abrimos el archivo de forma segura con un búfer de lectura
            String linea; // Variable auxiliar para almacenar cada línea leída del archivo
            while ((linea = br.readLine()) != null) { // Leemos el archivo línea por línea hasta llegar al final (null)
                // Limpiamos la línea: pasamos a minúsculas y quitamos puntuación usando una expresión regular (p{Punct})
                String lineaLimpia = linea.toLowerCase().replaceAll("[\\p{Punct}]", "");
                String[] palabras = lineaLimpia.split("\\s+"); // Dividimos la línea en un array de palabras usando espacios como separador

                for (String p : palabras) { // Recorremos cada palabra obtenida de la línea actual
                    if (!p.isEmpty()) { // Comprobamos que la palabra no sea una cadena vacía (evita errores con espacios extra)
                        // Actualizamos el mapa: si existe sumamos 1, si no existe (default 0) sumamos 1
                        mapaFrecuencia.put(p, mapaFrecuencia.getOrDefault(p, 0) + 1);
                    } // Cerramos la validación de palabra válida
                } // Cerramos el bucle que recorre las palabras de la línea
            } // Cerramos el bucle de lectura de todas las líneas
        } // El flujo de lectura se cierra automáticamente aquí gracias al try-with-resources
        return mapaFrecuencia; // Devolvemos el mapa con todas las frecuencias acumuladas
    } // Cerramos el método obtenerFrecuencias

    public List<Map.Entry<String, Integer>> obtenerTop5(Map<String, Integer> mapa) { // Método para extraer las 5 palabras más repetidas
        return mapa.entrySet() // Obtenemos el conjunto de pares (palabra-cantidad) del mapa
                .stream() // Convertimos el conjunto en un flujo de datos (Stream) para procesarlo
                // Ordenamos comparando los valores (frecuencia) de mayor a menor (reversed)
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5) // Nos quedamos únicamente con los primeros 5 elementos del flujo ya ordenado
                .collect(Collectors.toList()); // Transformamos el flujo de vuelta a una lista de entradas
    } // Cerramos el método obtenerTop5
} // Cerramos la clase WordModel