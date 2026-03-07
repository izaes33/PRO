package Ej01LeerArchivoDeTexto;

public class Main { // Clase principal que contiene el método de arranque
    public static void main(String[] args) { // Punto de inicio de la ejecución de Java
        ArchivoModel model = new ArchivoModel(); // Instanciamos el Modelo
        ArchivoView view = new ArchivoView(); // Instanciamos la Vista

        // Creamos el Controlador pasándole las piezas que necesita (Inyección de dependencias)
        ArchivoController controller = new ArchivoController(model, view);

        controller.ejecutar(); // Iniciamos la aplicación
    } // Fin del main
} // Fin de la clase Main