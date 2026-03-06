package Ej04_ValidacDeEdad;

// Creamos una clase de excepción personalizada que hereda de Exception
public class EdadInvalidaException extends Exception { // Al heredar de Exception creamos una excepción comprobada (checked exception)

    public EdadInvalidaException(String mensaje) { // Constructor que recibe un mensaje de error
        super(mensaje); // Llamamos al constructor de la clase padre (Exception) para guardar el mensaje
    }
}