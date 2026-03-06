package Ej02_ArrayFueraDeLimite; // Indicamos que esta clase pertenece al paquete del ejercicio 2.

public class Main { // Definimos la clase principal.
    public static void main(String[] args) { // Método principal desde donde comienza el programa.

        ArrayModel model = new ArrayModel();
        // Creamos el modelo que contiene el array y la lógica para acceder a sus elementos.
        ArrayView view = new ArrayView();
        // Creamos la vista que se encargará de pedir datos al usuario y mostrar resultados.

        ArrayController controller = new ArrayController(model, view);
        // Creamos el controlador que conecta el modelo y la vista.

        controller.iniciar();
        // Ejecutamos el método iniciar del controlador para comenzar el flujo del programa.
    }
}