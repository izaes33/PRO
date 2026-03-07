package Ej07_ExploracConFile;

import java.io.File; // Importamos la clase File para poder iterar sobre los elementos devueltos por el modelo

public class DirectorioController { // Definimos el Controlador, que actúa como puente entre el Modelo y la Vista
    private DirectorioModel model; // Referencia privada al objeto de lógica de negocio
    private DirectorioView view; // Referencia privada al objeto de interfaz de usuario

    public DirectorioController(DirectorioModel model, DirectorioView view) { // Constructor para inyectar el modelo y la vista
        this.model = model; // Asignamos el modelo recibido a nuestra variable interna
        this.view = view; // Asignamos la vista recibida a nuestra variable interna
    } // Cerramos el constructor

    public void ejecutar() { // Método principal que inicia la ejecución de la aplicación
        String ruta = view.solicitarRuta(); // Llamamos a la vista para obtener la ruta del directorio
        File[] contenido = model.obtenerContenido(ruta); // Pedimos al modelo que nos dé la lista de archivos de esa ruta

        if (contenido != null) { // Si el modelo encontró el directorio y pudo leerlo...
            view.mostrarCabecera(ruta); // Pedimos a la vista que imprima el encabezado con la ruta

            for (File f : contenido) { // Recorremos cada elemento (archivo o subdirectorio) encontrado
                String tipo = f.isDirectory() ? "DIRECTORIO" : "ARCHIVO"; // Determinamos el tipo usando un operador ternario
                String fecha = model.formatearFecha(f.lastModified()); // Pedimos al modelo que convierta la fecha de modificación
                String tamano = f.isFile() ? " (" + f.length() + " bytes)" : ""; // Si es archivo, preparamos el texto del tamaño

                view.mostrarElemento(tipo, f.getName(), tamano, fecha); // Enviamos todos los datos listos a la vista para su impresión
            } // Cerramos el bucle de recorrido
        } else { // Si el contenido es nulo (la ruta no existe o no es un directorio)...
            view.mostrarError("La ruta especificada no existe o no es un directorio válido."); // Informamos del error
        } // Cerramos el condicional
    } // Cerramos el método ejecutar
} // Cerramos la clase DirectorioController