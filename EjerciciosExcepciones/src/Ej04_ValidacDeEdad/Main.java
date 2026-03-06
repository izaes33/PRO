package Ej04_ValidacDeEdad; // Indicamos que esta clase pertenece al paquete del ejercicio 4

public class Main { // Clase principal del ejercicio
    public static void main(String[] args) { // Método principal donde comienza la ejecución

        EdadModel model = new EdadModel();
        // Creamos el modelo que contiene la lógica para validar la edad
        EdadView view = new EdadView();
        // Creamos la vista que se encargará de pedir la edad al usuario

        EdadController controller = new EdadController(model, view);
        // Creamos el controlador que conecta la vista con el modelo
        controller.iniciar();
        // Ejecutamos el método que inicia el flujo del programa
    }
}