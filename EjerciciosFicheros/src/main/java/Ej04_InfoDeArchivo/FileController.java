package Ej04_InfoDeArchivo;

import java.io.File; // Importamos la clase File para manejar el objeto que viaja entre modelo y vista

public class FileController { // Definimos el Controlador, el cerebro de la operación
    private FileModel model; // Referencia al modelo
    private FileView view; // Referencia a la vista

    public FileController(FileModel model, FileView view) { // Constructor que inyecta las dependencias
        this.model = model; // Guardamos el modelo
        this.view = view; // Guardamos la vista
    } // Cerramos el constructor

    public void ejecutar() { // Método que arranca el flujo de la aplicación
        String ruta = view.pedirRuta(); // Paso 1: Pedimos la ruta a la vista
        File archivo = model.obtenerArchivo(ruta); // Paso 2: Pedimos al modelo que localice el archivo

        if (archivo != null) { // Si el archivo existe y es válido...
            String fecha = model.formatearFecha(archivo.lastModified()); // Pedimos al modelo que formatee la fecha de modificación
            double megas = model.calcularMB(archivo.length()); // Pedimos al modelo que calcule el tamaño en MB
            view.mostrarDetalles(archivo, fecha, megas); // Paso 3: Mandamos todos los datos listos a la vista
        } else { // Si el modelo devolvió null (el archivo no existe)...
            view.mostrarError("El archivo no existe o la ruta es incorrecta."); // Informamos del fallo
        } // Cerramos el condicional
    } // Cerramos el método ejecutar
} // Cerramos la clase FileController