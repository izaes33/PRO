package model;
import java.util.ArrayList;


public class Campeonato {
    private int numeroCarreras;
    private ArrayList<Piloto> pilotos; // Puede ser null si no se inicializa


    public Campeonato() {
        this.numeroCarreras = 0; // Valor por defecto
        this.pilotos = new ArrayList<>(); // ¡SIEMPRE inicializar!
    }

    public Campeonato(int numeroCarreras) {  //En este constructor se pasa como parámetro el número de carreras, que será introducido al instarciar el objeto
        this.numeroCarreras = numeroCarreras;     //Campeonato desde iniciarCampeonato en CampeonatoController, y se inicializa el arrayList sin valores, para poder
        this.pilotos = new ArrayList<>(); // añadirle los valores a posterior, que se crean desde el método crearCoche de CarreraController,
                                    // vienen desde la clase Coche, asociados a cada coche, y se insertan mediante el setter addPiloto a través de CampeonatoController
    }


    public ArrayList<Piloto> getPilotos() {
        if (pilotos == null) {
            pilotos = new ArrayList<>(); // Nunca devolver null
        }
        return pilotos;
    }


    public void addPiloto(Piloto piloto) {
        if (pilotos == null) {
            pilotos = new ArrayList<>(); // Protección extra por si acaso
        }
        pilotos.add(piloto);
    }
}


/* Explicación general de la clase Campeonato:
Esta clase modela un campeonato definiendo el número de carreras y manteniendo una lista de pilotos participantes.
Proporciona constructores para inicializarlo, un método para añadir pilotos y getters para acceder al número de carreras y la lista de pilotos,
sirve como contenedor de datos para el campeonato entero. */
