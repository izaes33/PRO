package Ej01LeerArchivoDeTexto;

import java.io.BufferedReader; // Importa la clase para leer texto de un flujo de entrada de forma eficiente (con buffer)
import java.io.FileReader; // Importa la clase necesaria para leer archivos de caracteres desde el disco
import java.io.IOException; // Importa la excepción que maneja errores de entrada/salida (archivo no encontrado, sin permisos, etc.)
import java.util.ArrayList; // Importa la implementación de lista dinámica basada en un array
import java.util.List; // Importa la interfaz List para definir el tipo de retorno de forma genérica

public class ArchivoModel { // Definimos la clase ArchivoModel, que representa los datos y la lógica de negocio

    public List<String> leerArchivo(String ruta) throws IOException { // Método que recibe la ruta y devuelve una lista de líneas, avisando que puede lanzar excepciones
        List<String> contenido = new ArrayList<>(); // Instanciamos la lista donde guardaremos cada línea leída del archivo

        // El bloque try-with-resources asegura que el BufferedReader y el FileReader se cierren solos al terminar
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea; // Variable auxiliar para almacenar temporalmente cada línea leída

            while ((linea = br.readLine()) != null) { // Bucle que lee el archivo línea a línea hasta que llega al final (null)
                contenido.add(linea); // Añadimos la línea actual a nuestra lista de contenido
            } // Fin del bucle while
        } // Fin del try; aquí se cierran los flujos de datos automáticamente

        return contenido; // Devolvemos la lista con todas las líneas al Controlador
    } // Fin del método leerArchivo
} // Fin de la clase ArchivoModel