package Ej07_ExploracConFile;

public class Main { // Clase principal que contiene el punto de entrada de la aplicación
    public static void main(String[] args) { // Método main obligatorio para ejecutar cualquier programa en Java
        DirectorioModel model = new DirectorioModel(); // Instanciamos el objeto del Modelo
        DirectorioView view = new DirectorioView(); // Instanciamos el objeto de la Vista

        // Creamos el Controlador pasando el Modelo y la Vista (Inyección de dependencias)
        DirectorioController controller = new DirectorioController(model, view);

        controller.ejecutar(); // Iniciamos el proceso de la aplicación llamando al controlador
    } // Cerramos el método main
} // Cerramos la clase Main