package Ej03_CopiarArchivo;

import java.io.BufferedReader; // Importa BufferedReader para leer texto de forma eficiente mediante un búfer
import java.io.BufferedWriter; // Importa BufferedWriter para escribir texto de forma eficiente en el destino
import java.io.FileReader; // Importa FileReader para abrir el flujo de lectura del archivo físico de origen
import java.io.FileWriter; // Importa FileWriter para abrir el flujo de escritura del archivo físico de destino
import java.io.IOException; // Importa la clase para gestionar errores de entrada/salida durante el proceso

public class CopiaModel { // Definimos la clase CopiaModel, encargada de la lógica de manipulación de archivos

    public void copiarArchivo(String rutaOrigen, String rutaDestino) throws IOException { // Método que realiza la copia y avisa que puede lanzar excepciones

        // El 'try-with-resources' gestiona la apertura y el cierre automático de ambos archivos (lectura y escritura)
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaOrigen)); // Creamos el lector para el archivo de origen
             BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaDestino))) { // Creamos el escritor para el archivo de destino

            String linea; // Declaramos una variable temporal para almacenar cada línea que vayamos leyendo

            while ((linea = lector.readLine()) != null) { // Mientras el lector encuentre una línea (no sea nula)...
                escritor.write(linea); // Escribimos el contenido de la línea actual en el archivo de destino
                escritor.newLine(); // Insertamos un salto de línea en el destino, ya que readLine() lo omite al leer
            } // Cerramos el bucle de lectura/escritura
        } // Fin del bloque try; aquí los archivos se cierran automáticamente liberando los recursos del sistema
    } // Fin del método copiarArchivo
} // Fin de la clase CopiaModel