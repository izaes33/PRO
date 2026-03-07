package Ej06_CrearCSV;

public class Main { // Clase principal que arranca todo el ecosistema MVC
    public static void main(String[] args) { // Método estático de inicio de Java
        EstudianteModel model = new EstudianteModel(); // Instanciamos la lógica de archivos
        EstudianteView view = new EstudianteView(); // Instanciamos la interfaz de consola

        // Creamos el controlador inyectando el modelo y la vista (Inyección de dependencias)
        EstudianteController controller = new EstudianteController(model, view);

        controller.ejecutar(); // Damos la orden de salida al controlador
    } // Cerramos el método main
} // Cerramos la clase Main