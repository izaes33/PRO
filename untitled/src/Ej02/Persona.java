/*Amplía la clase Persona del ejercicio anterior añadiendo métodos
getter y setter para los atributos nombre y edad. Crea un objeto,
modifica sus valores usando los setters y muestra los datos usando los getters. */

package Ej02;

public class Persona {
    private String nombre;
    private int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
