package Ej02_BuscarPalabra;

public class Main { // Clase que contiene el método de arranque de la aplicación
    public static void main(String[] args) { // Método main, obligatorio para ejecutar programas Java
        BusquedaModel model = new BusquedaModel(); // Creamos la instancia del Modelo
        BusquedaView view = new BusquedaView(); // Creamos la instancia de la Vista

        // Creamos el Controlador y le inyectamos sus dependencias (Modelo y Vista)
        BusquedaController controller = new BusquedaController(model, view);

        controller.ejecutar(); // Llamamos al método que inicia el flujo de trabajo
    } // Fin del método main
} // Fin de la clase Main