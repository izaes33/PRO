package Ej01;

public class Perro extends Animal {

    public Perro(String nombre, int edad) {
        super(nombre, edad);
    }

    // Sobrescribir método hacerSonido
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " hace: Guau guau");
    }
}
