package Ej03_CopiarArchivo;

public class Main { // Clase principal donde reside el punto de entrada de la aplicación
    public static void main(String[] args) { // Método main que busca la máquina virtual para empezar a trabajar
        CopiaModel model = new CopiaModel(); // Creamos la instancia del Modelo (lógica)
        CopiaView view = new CopiaView(); // Creamos la instancia de la Vista (interfaz)

        // Creamos el Controlador y le pasamos el Modelo y la Vista que acabamos de crear
        CopiaController controller = new CopiaController(model, view);

        controller.iniciarCopia(); // Llamamos al método que pone en marcha todo el proceso
    } // Fin del método main
} // Fin de la clase Main