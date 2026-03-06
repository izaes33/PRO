package Ej04_ValidacDeEdad;

public class EdadModel { // Definimos la clase del modelo

    public void validarEdad(int edad) throws EdadInvalidaException { // Método que valida la edad y declara que puede lanzar la excepción personalizada

        // Comprobamos si la edad es menor que 0
        if (edad < 0) { // Si la edad es negativa no es válida
            throw new EdadInvalidaException("La edad no puede ser negativa"); // Lanzamos la excepción con el mensaje correspondiente
        }

        // Comprobamos si la edad es mayor que 120
        if (edad > 120) { // Si la edad supera 120 se considera inválida
            throw new EdadInvalidaException("La edad no puede ser mayor que 120"); // Lanzamos la excepción con el mensaje correspondiente
        }

        // Si no se cumple ninguna condición significa que la edad es válida
    }
}