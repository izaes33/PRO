package Ej04_ValidacDeEdad;

public class EdadController { // Definimos la clase controlador

    private EdadModel model; // Declaramos una variable que almacenará el modelo
    private EdadView view; // Declaramos una variable que almacenará la vista

    public EdadController(EdadModel model, EdadView view) { // Constructor que recibe el modelo y la vista
        this.model = model; // Guardamos el modelo recibido
        this.view = view; // Guardamos la vista recibida
    }

    public void iniciar() { // Método que inicia la lógica del programa

        try { // Bloque try donde colocamos el código que puede lanzar la excepción
            int edad = view.pedirEdad(); // Pedimos la edad al usuario usando la vista
            model.validarEdad(edad); // Llamamos al modelo para validar la edad (puede lanzar la excepción)
            view.mostrarEdadValida(edad); // Si no ocurre ninguna excepción mostramos que la edad es válida

        } catch (EdadInvalidaException e) { // Capturamos la excepción personalizada
            view.mostrarError(e.getMessage()); // Mostramos el mensaje de error contenido en la excepción
        }
    }
}