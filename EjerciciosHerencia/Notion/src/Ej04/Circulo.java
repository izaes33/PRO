package Ej04;

public class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() { return radio; }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public String toString() {
        return "Círculo con radio " + radio;
    }
}
