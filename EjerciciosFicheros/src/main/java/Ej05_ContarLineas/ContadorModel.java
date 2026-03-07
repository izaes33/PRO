package Ej05_ContarLineas;

import java.io.BufferedReader; // Importamos BufferedReader para leer el archivo de forma eficiente línea a línea
import java.io.FileReader; // Importamos FileReader para abrir una conexión de lectura con el archivo físico
import java.io.IOException; // Importamos IOException para gestionar errores (ej: el archivo no existe o está bloqueado)

public class ContadorModel { // Definimos la clase ContadorModel que contiene la lógica de negocio

    public int contarLineas(String ruta) throws IOException { // Método que recibe la ruta, devuelve un entero y avisa de posibles errores
        int totalLineas = 0; // Inicializamos un acumulador entero en cero para ir sumando cada línea encontrada

        // El bloque try-with-resources asegura el cierre automático de los flujos de datos al terminar
        try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {

            // Usamos el método readLine() dentro de un bucle; cada vez que lee algo que no es nulo, hay una línea
            while (lector.readLine() != null) { // Mientras el resultado de leer una línea no sea 'null' (fin del archivo)...
                totalLineas++; // Incrementamos en uno nuestro contador de líneas
            } // Cerramos el bucle while

        } // El lector y el archivo se cierran automáticamente aquí por el cierre del bloque try

        return totalLineas; // Devolvemos el número total acumulado al Controlador
    } // Cerramos el método contarLineas
} // Cerramos la clase ContadorModel