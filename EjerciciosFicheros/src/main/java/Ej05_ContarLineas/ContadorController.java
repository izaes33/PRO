package Ej05_ContarLineas;

import java.io.IOException; // Importamos la excepción para capturar posibles fallos de lectura en este nivel

public class ContadorController { // Definimos la clase ContadorController que coordina el flujo de la app
    private ContadorModel model; // Declaramos una referencia privada al objeto de lógica (Modelo)
    private ContadorView view; // Declaramos una referencia privada al objeto de interfaz (Vista)

    public ContadorController(ContadorModel model, ContadorView view) { // Constructor que recibe e inyecta las dependencias
        this.model = model; // Guardamos la instancia del modelo recibida en nuestra variable interna
        this.view = view; // Guardamos la instancia de la vista recibida en nuestra variable interna
    } // Cerramos el constructor

    public void ejecutar() { // Método principal que arranca el proceso de la aplicación
        String ruta = view.solicitarRuta(); // Llamamos a la vista para obtener la ruta que el usuario quiere analizar

        try { // Iniciamos un bloque de protección para capturar errores durante la ejecución lógica
            int lineas = model.contarLineas(ruta); // Pedimos al modelo que procese el archivo y nos dé el número de líneas
            view.mostrarResultado(lineas); // Le pasamos ese número a la vista para que se lo muestre al usuario
        } catch (IOException e) { // Si el modelo lanza un error (archivo no encontrado, por ejemplo), cae aquí
            view.mostrarError("No se pudo leer el archivo. Verifique la ruta."); // Avisamos al usuario mediante la vista
        } // Cerramos el bloque try-catch
    } // Cerramos el método ejecutar
} // Cerramos la clase ContadorController