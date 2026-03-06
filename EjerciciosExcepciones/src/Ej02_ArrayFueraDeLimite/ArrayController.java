package Ej02_ArrayFueraDeLimite;

public class ArrayController { // Definimos la clase controlador.

    private ArrayModel model; // Declaramos una variable que almacenará el modelo.
    private ArrayView view; // Declaramos una variable que almacenará la vista.

    public ArrayController(ArrayModel model, ArrayView view) { // Constructor que recibe el modelo y la vista.
        this.model = model; // Guardamos el modelo en el atributo de la clase.
        this.view = view; // Guardamos la vista en el atributo de la clase.
    }

    public void iniciar() { // Método que inicia la lógica del programa
        try { // Bloque try donde colocamos el código que podría generar una excepción.
            view.mostrarArray(model.getNumeros()); // Mostramos el array usando la vista.
            int posicion = view.pedirPosicion(); // Pedimos al usuario la posición que quiere consultar.
            int valor = model.obtenerElemento(posicion); // Pedimos al modelo el valor en esa posición.
            view.mostrarElemento(posicion, valor); // Mostramos el valor encontrado al usuario.

        } catch (ArrayIndexOutOfBoundsException e) { // Capturamos la excepción si el usuario introduce un índice inválido.
            view.mostrarError("Posición fuera de los límites del array"); // Mostramos el mensaje de error.
        }
    }
}