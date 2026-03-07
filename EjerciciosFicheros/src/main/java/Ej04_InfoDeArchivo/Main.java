package Ej04_InfoDeArchivo;

public class Main { // Clase de arranque
    public static void main(String[] args) { // Punto de entrada oficial de Java
        FileModel model = new FileModel(); // Instanciamos la lógica
        FileView view = new FileView(); // Instanciamos la interfaz
        FileController controller = new FileController(model, view); // Conectamos todo en el controlador

        controller.ejecutar(); // Iniciamos el programa
    } // Cerramos el main
} // Cerramos la clase Main