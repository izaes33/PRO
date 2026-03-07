package Ej01LeerArchivoDeTexto;

import java.io.IOException; // Importa la excepción para poder capturarla aquí (donde se gestiona el flujo)
import java.util.List; // Importa la interfaz List para manejar los datos que vienen del Modelo

public class ArchivoController { // Definimos la clase ArchivoController, el cerebro que coordina la app
    private ArchivoModel model; // Referencia al componente de datos
    private ArchivoView view; // Referencia al componente de interfaz

    public ArchivoController(ArchivoModel model, ArchivoView view) { // Constructor que inyecta ambos componentes
        this.model = model; // Asignamos el modelo recibido a nuestra variable interna
        this.view = view; // Asignamos la vista recibida a nuestra variable interna
    } // Fin del constructor

    public void ejecutar() { // Método principal que arranca la lógica del programa
        String ruta = view.pedirRuta(); // Paso 1: Pedimos a la Vista que solicite la ruta al usuario

        try { // Intentamos realizar la operación lógica
            List<String> datos = model.leerArchivo(ruta); // Paso 2: Pedimos al Modelo que procese el archivo
            view.mostrarLineas(datos); // Paso 3: Enviamos los datos obtenidos a la Vista para que los muestre
        } catch (IOException e) { // Si el Modelo lanza una excepción, la capturamos aquí
            view.imprimirError("No se pudo acceder al archivo. Verifique la ruta."); // Informamos al usuario a través de la Vista
        } // Fin del bloque try-catch
    } // Fin del método ejecutar
} // Fin de la clase ArchivoController