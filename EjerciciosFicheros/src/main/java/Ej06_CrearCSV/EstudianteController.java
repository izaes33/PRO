package Ej06_CrearCSV;

import java.io.IOException; // Importamos la excepción para capturarla si algo falla en el disco
import java.util.ArrayList; // Importamos ArrayList para preparar los datos iniciales
import java.util.List; // Importamos List para estructurar la colección de estudiantes

public class EstudianteController { // Definimos el Controlador, el cerebro que une Modelo y Vista
    private EstudianteModel model; // Referencia al componente de lógica y datos
    private EstudianteView view; // Referencia al componente de interfaz de usuario

    public EstudianteController(EstudianteModel model, EstudianteView view) { // Constructor que conecta las piezas
        this.model = model; // Asignamos el modelo inyectado a nuestra variable privada
        this.view = view; // Asignamos la vista inyectada a nuestra variable privada
    } // Cerramos el constructor

    public void ejecutar() { // Método principal que dirige el flujo de la aplicación
        String nombreArchivo = "estudiantes.csv"; // Definimos el nombre del archivo que vamos a manipular
        List<String> estudiantes = new ArrayList<>(); // Creamos la lista de datos que queremos guardar

        // Preparamos los datos siguiendo el formato CSV (Cabecera + Filas separadas por comas)
        estudiantes.add("Nombre,Edad,Calificación"); // Añadimos la cabecera del archivo
        estudiantes.add("Ana García,20,8.5"); // Añadimos el primer registro
        estudiantes.add("Carlos Martín,19,7.2"); // Añadimos el segundo registro
        estudiantes.add("Laura Pérez,21,9.3"); // Añadimos el tercer registro

        try { // Iniciamos bloque de seguridad para operaciones de entrada/salida
            model.crearCSV(nombreArchivo, estudiantes); // Pedimos al modelo que escriba los datos en el disco
            view.mostrarMensaje("Archivo CSV creado correctamente."); // Avisamos a la vista que informe del éxito

            List<String> datosLeidos = model.leerCSV(nombreArchivo); // Pedimos al modelo que lea el archivo recién creado
            view.mostrarContenido(datosLeidos); // Pasamos los datos leídos a la vista para que los imprima

        } catch (IOException e) { // Si algo falla (archivo bloqueado, disco lleno, etc.), capturamos la excepción
            view.mostrarError(e.getMessage()); // Pedimos a la vista que muestre el detalle del fallo al usuario
        } // Cerramos el bloque try-catch
    } // Cerramos el método ejecutar
} // Cerramos la clase EstudianteController