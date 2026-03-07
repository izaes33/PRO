package Ej08_ContadorPalabras;

public class Main { // Clase principal encargada de arrancar el sistema
    public static void main(String[] args) { // Método main: punto de inicio de la ejecución en la JVM
        WordModel model = new WordModel(); // Creamos la instancia de la lógica de procesamiento
        WordView view = new WordView(); // Creamos la instancia de la interfaz de consola

        // Ensamblamos el Controlador inyectando los componentes de Modelo y Vista
        WordController controller = new WordController(model, view);

        controller.ejecutar(); // Ponemos en marcha la aplicación
    } // Cerramos el método main
} // Cerramos la clase Main