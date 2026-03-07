package Ej07_ExploracConFile;

import java.io.File; // Importamos la clase File para representar y manejar rutas de archivos y carpetas
import java.text.SimpleDateFormat; // Importamos para convertir fechas de milisegundos a un formato legible
import java.util.Date; // Importamos para trabajar con objetos de fecha de Java

public class DirectorioModel { // Definimos la clase Modelo, responsable de la lógica de acceso al sistema de archivos

    public File[] obtenerContenido(String ruta) { // Método que recibe una ruta y devuelve un array de objetos File
        File directorio = new File(ruta); // Creamos un objeto File que apunta a la ruta proporcionada por el usuario

        if (directorio.exists() && directorio.isDirectory()) { // Comprobamos que la ruta existe y que efectivamente es una carpeta
            return directorio.listFiles(); // Retornamos un array con todos los archivos y carpetas que contiene el directorio
        } // Cerramos la validación

        return null; // Si no existe o no es un directorio, devolvemos null para que el controlador gestione el error
    } // Cerramos el método obtenerContenido

    public String formatearFecha(long milisegundos) { // Método para convertir el tiempo Unix en una fecha comprensible
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // Definimos el formato: día/mes/año hora:minuto
        return sdf.format(new Date(milisegundos)); // Convertimos los milisegundos a Date, los formateamos y devolvemos el String
    } // Cerramos el método formatearFecha
} // Cerramos la clase DirectorioModel