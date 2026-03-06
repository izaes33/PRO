package Ej03_TextoANumero;

public class NumeroController { // Definimos la clase controlador

    private NumeroModel model; // Declaramos una variable para almacenar el modelo
    private NumeroView view; // Declaramos una variable para almacenar la vista

    public NumeroController(NumeroModel model, NumeroView view) { // Constructor que recibe modelo y vista
        this.model = model; // Guardamos el modelo recibido
        this.view = view; // Guardamos la vista recibida
    }

    public void iniciar() { // Método que inicia el flujo del programa
        boolean numeroValido = false; // Variable booleana que controlará si el usuario ha introducido un número válido

        while (!numeroValido) { // Bucle que se ejecuta mientras el número no sea válido
            try { // Bloque try donde se ejecuta el código que puede generar una excepción

                String texto = view.pedirNumero(); // Pedimos al usuario que introduzca un número como texto
                int numero = model.convertirANumero(texto); // Intentamos convertir el texto a número usando el modelo
                view.mostrarNumero(numero); // Si la conversión es correcta mostramos el número
                numeroValido = true; // Cambiamos la variable a true para salir del bucle

            } catch (NumberFormatException e) { // Capturamos la excepción si el texto no representa un número válido
                view.mostrarError(); // Mostramos el mensaje de error al usuario
            }
        }
    }
}