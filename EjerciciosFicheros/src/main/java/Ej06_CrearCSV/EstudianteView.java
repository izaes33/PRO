package Ej06_CrearCSV;

import java.util.List; // Importamos List para poder recibir y mostrar la información procesada

public class EstudianteView { // Definimos la clase EstudianteView, encargada de la salida por consola

    public void mostrarMensaje(String mensaje) { // Método simple para dar feedback al usuario
        System.out.println(mensaje); // Imprimimos el texto recibido seguido de un salto de línea
    } // Cerramos el método mostrarMensaje

    public void mostrarContenido(List<String> lineas) { // Método para imprimir los datos del CSV formateados
        System.out.println("\nContenido del archivo:"); // Imprimimos un título para la sección
        for (String l : lineas) { // Recorremos cada línea de la lista que nos pasó el Controlador
            System.out.println(l); // Imprimimos la línea del estudiante (Nombre, Edad, Nota) por pantalla
        } // Cerramos el bucle for
    } // Cerramos el método mostrarContenido

    public void mostrarError(String error) { // Método para centralizar los avisos de fallos técnicos
        System.err.println("Ha ocurrido un error: " + error); // Imprimimos el error en el flujo de errores (sale en rojo)
    } // Cerramos el método mostrarError
} // Cerramos la clase EstudianteView