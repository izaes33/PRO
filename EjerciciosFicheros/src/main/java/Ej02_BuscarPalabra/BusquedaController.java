package Ej02_BuscarPalabra;

import java.io.IOException; // Importa la excepción de entrada/salida para gestionarla aquí

public class BusquedaController { // Clase que coordina el flujo entre Vista y Modelo (Controlador)
    private BusquedaModel model; // Referencia al componente de datos
    private BusquedaView view; // Referencia al componente de interfaz

    public BusquedaController(BusquedaModel model, BusquedaView view) { // Constructor que recibe las instancias
        this.model = model; // Asigna el modelo recibido
        this.view = view; // Asigna la vista recibida
    } // Fin del constructor

    public void ejecutar() { // Método principal para iniciar la lógica del programa
        String ruta = view.pedirDato("Ruta del archivo"); // Solicita la ruta a través de la vista
        String palabra = view.pedirDato("Palabra a buscar"); // Solicita la palabra a través de la vista

        try { // Bloque para intentar la operación de lectura, que es sensible a fallos
            int total = model.contarPalabraEnArchivo(ruta, palabra); // Llama al modelo para procesar el archivo
            view.mostrarResultado(palabra, total); // Envía el resultado numérico a la vista para mostrarlo
        } catch (IOException e) { // Captura el error si el archivo no existe o no se puede leer
            view.mostrarError("No se pudo leer el archivo. Comprueba la ruta y los permisos."); // Muestra el error mediante la vista
        } // Fin del bloque catch
    } // Fin del método ejecutar
} // Fin de la clase BusquedaController