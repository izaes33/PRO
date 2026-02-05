package model; // Define el paquete donde se encuentra esta clase.


public class Piloto { // Declara la clase pública Piloto, que representa un piloto con sus atributos.
    private String nombre; // Declara una variable privada para el nombre del piloto.
    private int dorsal; // Declara una variable privada para el dorsal del piloto.
    private int puntosCarrera;
    private int puntosAcumulados; // Declara una variable privada para los puntos acumulados.


    public Piloto(){ // Constructor público por defecto, sin parámetros.
    }

    public Piloto(String nombre, int dorsal){ // Constructor público con nombre y dorsal.
        this.nombre = nombre; // Asigna el nombre.
        this.dorsal = dorsal; // Asigna el dorsal.
        this.puntosAcumulados = 0; // Inicializa los puntos a 0.
    }

    public String getNombre() { // Getter público para el nombre.
        return nombre; // Retorna el nombre.
    }
    public int getDorsal() { // Getter público para el dorsal.
        return dorsal; // Retorna el dorsal.
    }
    public int getPuntosAcumulados() { // Getter público para los puntos.
        return puntosAcumulados; // Retorna los puntos.
    }
    public int getPuntosCarrera() { // Getter público para los puntos.
        return puntosCarrera; // Retorna los puntos.
    }

    public void setPuntosAcumulados(int puntosAcumulados) { // Setter público para los puntos.
        this.puntosAcumulados = puntosAcumulados; // Asigna los puntos (nota: en el programa, esto sobrescribe puntos previos, no los acumula).
    }
    public void setPuntosCarrera(int puntosCarrera) {
        this.puntosCarrera = puntosCarrera; //
    }
    public void resetearPuntosCarrera(){ this.puntosCarrera=0;}

}


/* Esta clase modela un piloto con nombre, dorsal y puntos. Proporciona un constructor vacío y otro para inicializarla con nombre y dorsal, y
getters/setters para acceder y modificar los atributos. Los puntos se usan para la clasificación, */