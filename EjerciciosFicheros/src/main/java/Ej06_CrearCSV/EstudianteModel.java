package Ej06_CrearCSV;

import java.io.*; // Importamos todas las clases de entrada y salida de datos (File, Writers, Readers, etc.)
import java.util.ArrayList; // Importamos ArrayList para manejar listas dinámicas de texto
import java.util.List; // Importamos la interfaz List para definir nuestras colecciones de datos

public class EstudianteModel { // Definimos la clase EstudianteModel, el motor de datos de nuestra app

    public void crearCSV(String ruta, List<String> datos) throws IOException { // Método que recibe la ruta y las líneas a escribir
        // Usamos BufferedWriter para escribir de forma eficiente (acumula datos antes de volcarlos al disco)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (String linea : datos) { // Recorremos cada cadena de texto que representa a un estudiante
                bw.write(linea); // Escribimos la línea de texto en el flujo del archivo
                bw.newLine(); // Insertamos el carácter de salto de línea específico del sistema operativo
            } // Cerramos el bucle for
        } // El try-with-resources cierra automáticamente el BufferedWriter y el archivo al terminar
    } // Cerramos el método crearCSV

    public List<String> leerCSV(String ruta) throws IOException { // Método para recuperar los datos guardados
        List<String> contenido = new ArrayList<>(); // Creamos una lista vacía para almacenar lo que leamos
        // Usamos BufferedReader para leer líneas completas de texto del archivo de forma fluida
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea; // Variable temporal para guardar el texto de la línea actual
            while ((linea = br.readLine()) != null) { // Leemos línea por línea hasta que el archivo se acabe (null)
                contenido.add(linea); // Guardamos la línea leída en nuestra lista de resultados
            } // Cerramos el bucle while
        } // El bloque try cierra el lector automáticamente, liberando los recursos
        return contenido; // Devolvemos la lista llena con la información del archivo al Controlador
    } // Cerramos el método leerCSV
} // Cerramos la clase EstudianteModel