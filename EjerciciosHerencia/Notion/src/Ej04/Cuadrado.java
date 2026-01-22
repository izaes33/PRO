package Ej04;

public class Cuadrado extends Figura {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double getLado() { return lado; }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public String toString() {
        return "Cuadrado con lado " + lado;
    }
}
