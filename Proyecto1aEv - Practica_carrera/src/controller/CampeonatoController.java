package controller; // Define el paquete donde se encuentra esta clase.
import model.*; // Importa todas las clases del paquete model, como Campeonato, Carrera, Coche, Piloto, etc.
import java.util.Comparator; // Importa la clase Comparator de java.util para ordenar colecciones.
import java.util.Scanner; // Importa la clase Scanner de java.util para leer entrada del usuario.


public class CampeonatoController { // Declara la clase pública CampeonatoController, que maneja la lógica de todo el campeonato.
    private Campeonato campeonato; // Declara una variable privada de tipo Campeonato para almacenar el campeonato actual.
    private CarreraController carreraController; // Declara una variable privada de tipo CarreraController para manejar carreras individuales.
    private Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario desde la consola.


    public CampeonatoController() { // Constructor público de la clase CampeonatoController.
        carreraController = new CarreraController(); // Inicializa el controlador de carreras creando una nueva instancia de CarreraController.
    }


    public void iniciarCampeonato() { // Método público para iniciar todo el campeonato.
        System.out.print("Cuantas carreras tendrá el campeonato?:  "); // Imprime un mensaje pidiendo el número de carreras.
        int numCarreras = scanner.nextInt(); // Lee un entero de la entrada y lo asigna a numCarreras.
        campeonato = new Campeonato(numCarreras); // Crea un nuevo objeto Campeonato con el número de carreras especificado.
// Crear coches SOLO UNA VEZ
        carreraController.numeroCoches(); // Llama al método numeroCoches del CarreraController para crear los coches una sola vez.
// Guardamos los pilotos en el campeonato
        for (Coche coche : carreraController.getCoches()) { // Bucle for-each que itera sobre los coches creados.
            campeonato.addPiloto(coche.getPiloto()); // Añade el piloto de cada coche al campeonato.
        }
// Ejecutar las carreras
        for (int i = 0; i < numCarreras; i++) { // Bucle for que se ejecuta por cada carrera en el campeonato.
            System.out.println("\n=== CARRERA " + (i + 1) + " ==="); // Imprime un encabezado para la carrera actual.
            carreraController.kmCarrera(); // Llama al método kmCarrera para establecer los kilómetros de esta carrera.
            boolean ultimaCarrera = (i == numCarreras - 1);
            carreraController.simularCarrera(ultimaCarrera); // Llama al método simularCarrera para ejecutar la simulación de esta carrera.
        }
        mostrarResultadosFinales(); // Llama al método privado para mostrar los resultados finales del campeonato.
    }


    private void mostrarResultadosFinales() { // Método privado para mostrar la clasificación final del campeonato.
// Ordenamos pilotos por puntos (DESC)
        campeonato.getPilotos() // Obtiene la lista de pilotos del campeonato.
                .sort(Comparator.comparingInt(Piloto::getPuntosAcumulados).reversed()); // Ordena la lista por puntos en orden descendente.
        System.out.println("\n=== CLASIFICACIÓN FINAL DEL CAMPEONATO ==="); // Imprime un encabezado para la clasificación final.
        System.out.println("Pos | Piloto | Dorsal | Puntos "); // Imprime los encabezados de la tabla.
        for (int i = 0; i < campeonato.getPilotos().size(); i++) { // Bucle for que itera sobre los pilotos ordenados.
            Piloto p = campeonato.getPilotos().get(i); // Obtiene el piloto en la posición actual.
            System.out.println( // Imprime la posición, nombre, dorsal y puntos del piloto.
                    (i + 1) + "\t" +
                            p.getNombre() + "\t" +
                            p.getDorsal() + "\t" +
                            p.getPuntosAcumulados()
            );
        }
    }
}
/*

Explicación general de la clase CampeonatoController:
Esta clase orquesta todo el campeonato, que consiste en múltiples carreras. Solicita al usuario el número de carreras, crea el campeonato,
utiliza CarreraController para crear los coches y pilotos una vez (compartidos en todas las carreras), añade los pilotos al campeonato,
ejecuta cada carrera individualmente, y finalmente ordena e imprime la clasificación general basada
en los puntos acumulados de todas las carreras. Los puntos se acumulan en los objetos Piloto a lo largo de las carreras, ya que no se resetean.
*/