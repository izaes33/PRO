package model; // Define el paquete donde se encuentra esta clase.


public class Carrera { // Declara la clase pública Carrera, que representa una carrera con sus atributos.
    private int kilometros; // Declara una variable privada para los kilómetros de la carrera.
    public static final int PUNTUACION1 = 10; // Constante pública estática para los puntos del primer lugar.
    public static final int PUNTUACION2 = 8; // Constante pública estática para los puntos del segundo lugar.
    public static final int PUNTUACION3 = 6; // Constante pública estática para los puntos del tercer lugar.


    //Constructores
    public Carrera(){ // Constructor público por defecto, sin parámetros (inicializa atributos a valores predeterminados).
    }

    public Carrera(int kilometros){ // Constructor público que recibe los kilómetros y los asigna.
        this.kilometros = kilometros; // Asigna el parámetro a la variable de instancia.
    }


    //Getters
    public int getKilometros(){ // Getter público para obtener los kilómetros de la carrera.
        return kilometros; // Retorna el valor de kilometros.
    }
    public int getPuntuacion1(){ // Getter público para obtener la puntuación del primer lugar.
        return PUNTUACION1; // Retorna la constante PUNTUACION1.
    }
    public int getPuntuacion2(){ // Getter público para obtener la puntuación del segundo lugar.
        return PUNTUACION2; // Retorna la constante PUNTUACION2.
    }
    public int getPuntuacion3(){ // Getter público para obtener la puntuación del tercer lugar.
        return PUNTUACION3; // Retorna la constante PUNTUACION3.
    }

}


/* Esta clase modela una carrera con una longitud en kilómetros y constantes para las puntuaciones de los tres primeros lugares.
Proporciona un constructor vacío y otro para inicializarla con kilómetros, getters para acceder a los atributos y setters para modificarlos.
Sirve principalmente como un contenedor de datos para la configuración de una carrera. */