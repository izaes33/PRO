package Ej02_BuscarPalabra;

import java.io.BufferedReader; // Importa BufferedReader para leer el texto de forma eficiente
import java.io.FileReader; // Importa FileReader para conectar con el archivo físico en el disco
import java.io.IOException; // Importa la clase para manejar errores de entrada/salida

public class BusquedaModel { // Clase que representa la lógica de negocio (Modelo)

    public int contarPalabraEnArchivo(String ruta, String palabraObjetivo) throws IOException { // Método que devuelve el número de apariciones
        int contador = 0; // Variable entera para acumular el número de veces que aparece la palabra

        // Abrimos el archivo usando try-with-resources para asegurar que se cierre solo al terminar
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea; // Variable temporal para almacenar cada línea leída del archivo

            while ((linea = br.readLine()) != null) { // Bucle que recorre el archivo hasta que no queden más líneas (null)
                // Dividimos la línea en palabras usando expresiones regulares (espacios, puntos, comas, etc.)
                String[] palabrasEnLinea = linea.split("\\W+");

                for (String p : palabrasEnLinea) { // Recorremos cada palabra obtenida de la línea actual
                    if (p.equalsIgnoreCase(palabraObjetivo)) { // Comparamos ignorando mayúsculas/minúsculas para ser más precisos
                        contador++; // Si coinciden, incrementamos el contador en 1
                    } // Fin del if de comparación
                } // Fin del bucle for que recorre las palabras de la línea
            } // Fin del bucle while que recorre las líneas del archivo
        } // Fin del bloque try; el archivo se cierra automáticamente aquí

        return contador; // Devolvemos el total de coincidencias halladas al Controlador
    } // Fin del método contarPalabraEnArchivo
} // Fin de la clase BusquedaModel