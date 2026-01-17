package Ej08;

public class Empleado {

    private String nombre;
    private String puesto;
    private double salario;

    // Constructor
    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }

    // Sobrescribir toString para mostrar empleado
    @Override
    public String toString() {
        return nombre + " - " + puesto + " - " + salario + "€";
    }
}

