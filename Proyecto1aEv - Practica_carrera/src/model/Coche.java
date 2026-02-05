package model; // Define el paquete donde se encuentra esta clase.


public class Coche { // Declara la clase pública Coche, que representa un coche con sus atributos y piloto.
    private String marca; // Declara una variable privada para la marca del coche.
    private String modelo; // Declara una variable privada para el modelo del coche.
    private int km; // Declara una variable privada para los kilómetros recorridos.
    private Piloto piloto; // Declara una variable privada para el piloto asociado al coche.


    //Constructores
    public Coche(){ // Constructor público por defecto, sin parámetros.
    }

    public Coche(String marca, String modelo, Piloto piloto){ // Constructor público con marca, modelo y piloto.
        this.marca = marca; // Asigna la marca.
        this.modelo = modelo; // Asigna el modelo.
        this.piloto = piloto; // Asigna el piloto.
    }


    //Getters
    public Piloto getPiloto() { // Getter público para obtener el piloto.
        return piloto; // Retorna el piloto.
    }
    public String getMarca(){ // Getter público para la marca.
        return marca; // Retorna la marca.
    }
    public String getModelo(){ // Getter público para el modelo.
        return modelo; // Retorna el modelo.
    }
    public int getKm(){ // Getter público para los km.
        return km; // Retorna los km.
    }


    //Setters
    public void setKm(int km){ // Setter público para los km.
        this.km = km; // Asigna los km.
    }


    public void resetearKm(){ // Método público para resetear los kilómetros.
        this.km = 0; // Pone los km a 0.
    }
}


/* Esta clase modela un coche con atributos como marca, modelo, kilómetros recorridos y un piloto asociado.
Proporciona un constructor vacío por defecto y otro para la inicialización, getters y setters para acceder y modificar atributos,
y un métodos específico para resetear kilómetros. El coche está ligado a un piloto,
y los kilómetros se usan en la simulación de carreras para rastrear el progreso. */