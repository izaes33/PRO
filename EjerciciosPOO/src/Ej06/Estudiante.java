package Ej06;

public class Estudiante {

    private String nombre;
    private int edad;
    private double nota;

    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.nota = 0.0;
    }

    public void setNota(double nota) {
        System.out.print("Asignando nota " + nota + ": ");
        if (nota >= 0 && nota <= 10) {
            this.nota = nota;
            System.out.println("Correcto");
        } else {
            System.out.println("Error - La nota debe estar entre 0 y 10");
        }
    }

    public double getNota() {
        return nota;
    }

    public String getNombre() {
        return nombre;
    }
}
