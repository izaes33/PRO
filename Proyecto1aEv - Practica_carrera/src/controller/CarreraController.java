package controller; // Define el paquete donde se encuentra esta clase.
import model.Carrera; // Importa la clase Carrera del paquete model.
import model.Coche; // Importa la clase Coche del paquete model.
import model.Piloto; // Importa la clase Piloto del paquete model.
import java.util.*; // Importa todas las clases del paquete java.util, como Scanner, ArrayList y Comparator.


public class CarreraController { // Declara la clase pública CarreraController, que maneja la lógica de una carrera individual.
    Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario desde la consola.
    private Carrera carrera; // Declara una variable privada de tipo Carrera para almacenar la carrera actual (incluyendo kilómetros y puntuaciones).
    private ArrayList<Coche> coches; // Declara una lista dinámica privada de objetos Coche para almacenar los coches participantes.


    public CarreraController() { // Constructor público de la clase CarreraController.
        this.coches = new ArrayList<>(); // Inicializa la lista de coches como un nuevo ArrayList vacío.
    }


    public ArrayList<Coche> getCoches() { // Método getter público para obtener la lista de coches.
        return this.coches; // Retorna la lista de coches.
    }


    public void numeroCoches() { // Método público para determinar y crear el número de coches.
        System.out.print("¿Cuantos coches quieres crear?:  "); // Imprime un mensaje pidiendo el número de coches.
        int numeroCoches = scanner.nextInt(); // Lee un entero de la entrada del usuario y lo asigna a numeroCoches.
        for (int i = 0; i < numeroCoches; i++) { // Bucle for que se ejecuta tantas veces como coches se deseen crear.
            System.out.println("Vamos a crear el coche numero " + (i + 1)); // Imprime un mensaje indicando el número de coche que se está creando.
            crearCoche(); // Llama al método crearCoche para crear un nuevo coche.
        }
    }

    public void crearCoche() { // Método público para crear un nuevo coche solicitando datos al usuario.
        System.out.print("Introduce la marca del coche:  "); // Imprime un mensaje pidiendo la marca del coche.
        String marca = scanner.next(); // Lee una cadena de la entrada y la asigna a marca.
        System.out.print("Introduce el modelo del coche:  "); // Imprime un mensaje pidiendo el modelo del coche.
        String modelo = scanner.next(); // Lee una cadena de la entrada y la asigna a modelo.
        System.out.print("Introduce el nombre del piloto:  "); // Imprime un mensaje pidiendo el nombre del piloto.
        String nombre = scanner.next(); // Lee una cadena de la entrada y la asigna a nombre.
        System.out.print("Introduce el dorsal del piloto:  "); // Imprime un mensaje pidiendo el dorsal del piloto.
        int dorsal = scanner.nextInt(); // Lee un entero de la entrada y lo asigna a dorsal.
        Piloto piloto = new Piloto(nombre, dorsal); // Crea un nuevo objeto Piloto con el nombre y dorsal proporcionados.
        Coche coche = new Coche(marca, modelo, piloto); // Crea un nuevo objeto Coche con la marca, modelo y piloto.
        coches.add(coche); // Añade el nuevo coche a la lista de coches.
        System.out.println("Coche creado correctamente"); // Imprime un mensaje confirmando la creación del coche.
    }


    public void kmCarrera() { // Método público para establecer la longitud de la carrera.
        System.out.print("Cuantos km quieres que tenga la carrera?"); // Imprime un mensaje pidiendo los kilómetros de la carrera.
        int kmCarrera = scanner.nextInt(); // Lee un entero de la entrada y lo asigna a kmCarrera.
        carrera = new Carrera(kmCarrera); // Crea un nuevo objeto Carrera con los kilómetros especificados y lo asigna a la variable carrera.
    }


    public void simularCarrera(boolean ultimaCarrera) { // Método público para simular la carrera.
        for (Coche coche : coches) { // Bucle for-each que itera sobre cada coche en la lista.
            coche.resetearKm();// Llama al método resetearKm del coche para poner sus kilómetros a cero.
        }
        boolean carreraEnCurso = true; // Inicializa una bandera booleana en true para indicar que la carrera está en curso.
        while (carreraEnCurso) { // Bucle while que continúa mientras la carrera esté en curso.
            for (Coche coche : coches) { // Bucle for-each que itera sobre cada coche.
                int kmAleatorio = 20 + (int) (Math.random() * 31); // Genera un número aleatorio de kilómetros entre 20 y 50 (inclusive).
                coche.setKm(coche.getKm() + kmAleatorio); // Añade los kilómetros aleatorios al total del coche.
                if (coche.getKm() >= carrera.getKilometros()) { // Si el coche ha alcanzado los kilómetros de la carrera,
                    carreraEnCurso = false; // Marca que la carrera ha finalizado
                    break;
                }
            }
        }
// Ordenar por km DESC
        coches.sort(Comparator.comparingInt(Coche::getKm).reversed()); // Ordena la lista de coches por kilómetros en orden descendente usando un Comparator.
// Asignar puntos
        for (int i = 0; i < coches.size(); i++) { // Bucle for que itera sobre los coches ordenados.
            int puntosCarrera; // Declara una variable para los puntos.
            int puntosAcumulados;
            coches.get(i).getPiloto().resetearPuntosCarrera();
            if (i == 0) puntosCarrera = carrera.getPuntuacion1(); // Asigna 10 puntos al primer lugar.
            else if (i == 1) puntosCarrera = carrera.getPuntuacion2(); // Asigna 8 puntos al segundo lugar.
            else if (i == 2) puntosCarrera = carrera.getPuntuacion3(); // Asigna 6 puntos al tercer lugar.
            else puntosCarrera = 0; // Asigna 0 puntos a los demás.
            puntosAcumulados = puntosCarrera + coches.get(i).getPiloto().getPuntosAcumulados();
            coches.get(i).getPiloto().setPuntosCarrera(puntosCarrera);
            coches.get(i).getPiloto().setPuntosAcumulados(puntosAcumulados);
        }
// Resultados
        System.out.println("=== CARRERA ==="); // Imprime un encabezado para los resultados de la carrera.
        for (int i = 0; i < coches.size(); i++) { // Bucle for que itera sobre los coches ordenados.
            System.out.println( // Imprime la posición, marca, modelo y puntos del piloto.
                    (i + 1) + "º - " +
                            coches.get(i).getPiloto().getNombre() + " - " +
                            coches.get(i).getMarca() + " " +
                            coches.get(i).getModelo() +
                            " [" + coches.get(i).getPiloto().getPuntosCarrera() + "]"
            );
        }
        if (!ultimaCarrera) {
            System.out.println("=== CLASIFICACION GENERAL ==="); // Imprime un encabezado para la clasificación general.
            System.out.println("Posicion | Piloto | Dorsal | Marca | Modelo | Puntos"); // Imprime los encabezados de la tabla.
            for (int i = 0; i < coches.size(); i++) { // Bucle for que itera sobre los coches.
                System.out.println( // Imprime la posición, nombre del piloto, dorsal y puntos.
                        (i + 1) + "\t" +
                                coches.get(i).getPiloto().getNombre() + "\t" +
                                coches.get(i).getPiloto().getDorsal() + "\t" +
                                coches.get(i).getMarca() + "\t" +
                                coches.get(i).getModelo() + "\t" +
                                coches.get(i).getPiloto().getPuntosAcumulados()
                );
            }
        }
    }
}

/* Esta clase maneja la lógica de una sola carrera en el campeonato. Incluye métodos para crear coches y pilotos basados en la entrada del usuario,
establecer la longitud de la carrera, simular la carrera generando avances aleatorios para cada coche hasta uno alcance o supere
la distancia requerida, ordenar los resultados, asignar puntos a los pilotos (10, 8, 6 para los tres primeros, 0 para el resto) e imprimir
los resultados de la carrera y la clasificación. */