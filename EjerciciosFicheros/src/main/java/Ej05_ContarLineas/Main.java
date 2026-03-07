package Ej05_ContarLineas;

public class Main { // Clase principal que sirve como punto de arranque del proyecto
    public static void main(String[] args) { // Método main, el primero que ejecuta la Máquina Virtual de Java
        ContadorModel model = new ContadorModel(); // Creamos el objeto que contiene la lógica de conteo
        ContadorView view = new ContadorView(); // Creamos el objeto que maneja la consola

        // Creamos el controlador pasándole el modelo y la vista (Inyección de dependencias)
        ContadorController controller = new ContadorController(model, view);

        controller.ejecutar(); // Iniciamos la ejecución del programa
    } // Cerramos el método main
} // Cerramos la clase Main