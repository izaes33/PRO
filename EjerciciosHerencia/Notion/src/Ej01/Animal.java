package Ej01;

public class Animal {
    protected String nombre;
    protected int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Método que se sobrescribirá en las clases hijas
    public void hacerSonido() {
        System.out.println(nombre + " hace un sonido genérico");
    }

    @Override
    public String toString() {
        return "Animal: " + nombre + ", " + edad + " años";
    }
}
