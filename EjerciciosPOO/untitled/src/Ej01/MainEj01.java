/*Crea una clase llamada Persona con dos atributos: nombre y edad.
Define un constructor que inicialice estos atributos.
En el método main, crea un objeto de tipo Persona y muestra sus datos. */

package Ej01;

public class MainEj01 {

    public static void main(String[] args) {
        Persona persona = new Persona("Juan", 25);

        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Edad: " + persona.getEdad());
    }
}
