package Ej01;

public class Gato extends Animal {

    public Gato(String nombre, int edad) {
        super(nombre, edad);
    }

    // Sobrescribir método hacerSonido
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " hace: Miau miau");
    }
}
