package Ej04_InfoDeArchivo;

import java.io.File; // Importamos la clase File para representar rutas de archivos y directorios
import java.text.SimpleDateFormat; // Importamos para dar un formato legible a la fecha de modificación
import java.util.Date; // Importamos para convertir el tiempo en milisegundos a un objeto fecha

public class FileModel { // Definimos la clase Modelo que gestionará la lógica de metadatos

    public File obtenerArchivo(String ruta) { // Método que intenta crear un objeto File a partir de una ruta
        File archivo = new File(ruta); // Instanciamos el objeto File (no crea un archivo real, solo apunta a la ruta)
        if (archivo.exists()) { // Comprobamos si el archivo o carpeta realmente existe en el disco
            return archivo; // Si existe, devolvemos el objeto con toda su información
        } // Cerramos el condicional
        return null; // Si no existe, devolvemos nulo para que el controlador sepa que hay un error
    } // Cerramos el método obtenerArchivo

    public String formatearFecha(long milisegundos) { // Método para convertir un número largo en una fecha bonita
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // Definimos el patrón de día/mes/año hora:min:seg
        return sdf.format(new Date(milisegundos)); // Creamos la fecha, la formateamos y la devolvemos como String
    } // Cerramos el método formatearFecha

    public double calcularMB(long bytes) { // Método para convertir el tamaño de bytes a Megabytes
        return bytes / (1024.0 * 1024.0); // Dividimos entre 1024 dos veces (KB y MB) usando decimales para precisión
    } // Cerramos el método calcularMB
} // Cerramos la clase FileModel