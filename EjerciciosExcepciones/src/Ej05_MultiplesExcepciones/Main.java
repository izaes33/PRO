package Ej05_MultiplesExcepciones; // Indicamos que esta clase pertenece al paquete del ejercicio 5

public class Main { // Clase principal del ejercicio

    public static void main(String[] args) { // Método main donde empieza el programa

        CalculadoraModel model = new CalculadoraModel();
        // Creamos el modelo que contiene la lógica de las operaciones matemáticas
        CalculadoraView view = new CalculadoraView();
        // Creamos la vista que interactúa con el usuario

        CalculadoraController controller = new CalculadoraController(model, view);
        // Creamos el controlador que conecta el modelo y la vista
        controller.iniciar();
        // Llamamos al método iniciar para ejecutar el programa
    }
}