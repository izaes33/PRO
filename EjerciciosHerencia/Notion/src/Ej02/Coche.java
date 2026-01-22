package Ej02;

public class Coche extends Vehiculo {
    private int numeroPuertas;

    public Coche(String marca, String modelo, int numeroPuertas) {
        super(marca, modelo); // Llamada al constructor de Vehiculo
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public String toString() {
        return "Coche: " + marca + " " + modelo + ", " + numeroPuertas + " puertas";
    }
}
