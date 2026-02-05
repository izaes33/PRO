import controller.CampeonatoController; // Importa la clase CampeonatoController del paquete controller.
public class Main { // Declara la clase pública Main, punto de entrada del programa.
    public static void main(String[] args) { // Método main estático, ejecutado al iniciar el programa.
// Creamos el controlador del campeonato
        CampeonatoController campeonatoController = new CampeonatoController(); // Crea una nueva instancia de CampeonatoController.
// Iniciamos todo el flujo del programa
        campeonatoController.iniciarCampeonato(); // Llama al método iniciarCampeonato para comenzar el proceso completo.
    }
}

/* Explicación general de la clase Main y flujo del código:
Esta clase es el punto de entrada del programa Java. Al ejecutarse, el método main crea una instancia de CampeonatoController
y llama a su método iniciarCampeonato(). Esto inicia el flujo: */