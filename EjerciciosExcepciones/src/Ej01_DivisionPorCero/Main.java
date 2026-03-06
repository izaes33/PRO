package Ej01_DivisionPorCero;

public class Main { // Definimos la clase principal que arrancará el programa

    public static void main(String[] args) { // Método main: punto de entrada del programa Java

        DivisionModel model = new DivisionModel();
        // Creamos un objeto del modelo
        DivisionView view = new DivisionView();
        // Creamos un objeto de la vista
        // (NECESARIOS PARA PODER PASARLOS COMO ARGUMENTOS DEL CONSTRUCTOR DE CONTROLLER)

        DivisionController controller = new DivisionController(model, view);
        // Creamos el controlador pasándole el modelo y la vista para que pueda conectarlos

        controller.iniciar();
        // Llamamos al método iniciar del controlador para ejecutar la lógica del programa
    }
}