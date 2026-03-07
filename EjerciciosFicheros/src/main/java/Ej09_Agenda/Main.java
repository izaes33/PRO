package Ej09_Agenda;

public class Main { // Punto de entrada al sistema
    public static void main(String[] args) { // Método principal de Java
        UsuarioView vista = new UsuarioView(); // Creamos la interfaz
        UsuarioController controlador = new UsuarioController(vista); // Creamos el controlador con su vista

        controlador.iniciar(); // Arrancamos la aplicación
    } // Cerramos el main
} // Cerramos la clase Main