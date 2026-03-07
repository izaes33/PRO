package Ej03_CopiarArchivo;

import java.io.IOException; // Importamos la excepción para poder capturarla en el bloque catch

public class CopiaController { // Definimos la clase CopiaController, el mediador del patrón MVC
    private CopiaModel model; // Declaramos la referencia al Modelo
    private CopiaView view; // Declaramos la referencia a la Vista

    public CopiaController(CopiaModel model, CopiaView view) { // Constructor que recibe e inyecta ambos componentes
        this.model = model; // Asignamos el objeto modelo a la variable de clase
        this.view = view; // Asignamos el objeto vista a la variable de clase
    } // Fin del constructor

    public void iniciarCopia() { // Método principal que gestiona el orden de ejecución del programa
        String origen = view.solicitarRuta("Archivo de origen"); // Paso 1: Pedimos la ruta de origen a través de la vista
        String destino = view.solicitarRuta("Archivo de destino"); // Paso 2: Pedimos la ruta de destino a través de la vista

        try { // Iniciamos bloque de seguridad para realizar la operación de archivos
            model.copiarArchivo(origen, destino); // Paso 3: Ordenamos al modelo que ejecute la lógica de copia con las rutas obtenidas
            view.mostrarExito(); // Paso 4: Si no hubo errores, ordenamos a la vista mostrar el mensaje de éxito
        } catch (IOException e) { // Si ocurre un error (archivo no existe, disco lleno, etc.), se captura aquí
            view.mostrarError(e.getMessage()); // Paso 5: Enviamos el mensaje del error a la vista para informar al usuario
        } // Fin del bloque try-catch
    } // Fin del método iniciarCopia
} // Fin de la clase CopiaController