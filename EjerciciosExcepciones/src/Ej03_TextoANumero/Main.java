package Ej03_TextoANumero; // Indicamos que esta clase pertenece al paquete del ejercicio 3

public class Main { // Clase principal del ejercicio
    public static void main(String[] args) { // Punto de entrada del programa
        NumeroModel model = new NumeroModel();
        // Creamos el modelo encargado de convertir texto a número
        NumeroView view = new NumeroView();
        // Creamos la vista que pedirá el número al usuario

        NumeroController controller = new NumeroController(model, view);
        // Creamos el controlador que gestionará el flujo entre modelo y vista
        controller.iniciar();
        // Ejecutamos el método que inicia la lógica del programa
    }
}