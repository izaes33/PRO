package Ej03;

public class Persona {
    protected String nombre;
    protected int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Método para presentarse
    public void presentarse() {
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años");
    }
}
