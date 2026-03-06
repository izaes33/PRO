package Ej05_MultiplesExcepciones;

import java.util.InputMismatchException; // Importamos la excepción InputMismatchException

public class CalculadoraController { // Definimos la clase controlador

    private CalculadoraModel model; // Variable para almacenar el modelo
    private CalculadoraView view; // Variable para almacenar la vista

    public CalculadoraController(CalculadoraModel model, CalculadoraView view) { // Constructor que recibe modelo y vista
        this.model = model; // Guardamos el modelo
        this.view = view; // Guardamos la vista
    }

    public void iniciar() { // Método que inicia el flujo del programa

        try { // Bloque try donde colocamos el código que puede generar excepciones
            String texto1 = view.pedirNumero("Introduce el primer número: "); // Pedimos el primer número como texto
            int num1 = Integer.parseInt(texto1); // Convertimos el texto a número (puede lanzar NumberFormatException)
            String texto2 = view.pedirNumero("Introduce el segundo número: "); // Pedimos el segundo número como texto
            int num2 = Integer.parseInt(texto2); // Convertimos el texto a número (puede lanzar NumberFormatException)

            char operacion = view.pedirOperacion(); // Pedimos la operación matemática
            int resultado = model.calcular(num1, num2, operacion); // Llamamos al modelo para realizar el cálculo
            view.mostrarResultado(num1, num2, operacion, resultado); // Mostramos el resultado

        } catch (NumberFormatException e) { // Capturamos la excepción si el texto no se puede convertir a número
            view.mostrarError("Debes introducir números válidos"); // Mostramos mensaje de error

        } catch (ArithmeticException e) { // Capturamos la excepción si ocurre división por cero
            view.mostrarError("No se puede dividir por cero"); // Mostramos mensaje de error

        } catch (InputMismatchException e) { // Capturamos error si Scanner recibe un tipo incorrecto
            view.mostrarError("Entrada no válida"); // Mostramos mensaje de error
        /*La excepción InputMismatchException en Java ocurre principalmente cuando un objeto (en este caso Scanner)
        * recibe un tipo de dato que no coincide con el esperado (por ejemplo, introducir texto cuando se esperaba un
        * número entero con nextInt()). También surge si el valor introducido supera el rango del tipo de dato
        * (desbordamiento) o si hay problemas con el formato regional del número (coma en lugar de punto). */

        } finally { // El bloque finally siempre se ejecuta haya o no error
            System.out.println("Fin del programa"); // Mostramos el mensaje final
        }
    }
}