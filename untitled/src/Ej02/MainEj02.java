/*Crea una clase llamada Persona con dos atributos: nombre y edad.
Define un constructor que inicialice estos atributos.
En el método main, crea un objeto de tipo Persona y muestra sus datos. */

package Ej02;


import java.util.Scanner;

public class MainEj02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona persona = new Persona("Juan", 25);

        System.out.println("Datos iniciales: ");
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Edad: " + persona.getEdad());
        System.out.print("\nIntroduce un nuevo nombre: ");
        persona.setNombre(sc.nextLine());
        System.out.print("Introduce una nueva edad: ");
        persona.setEdad(sc.nextInt());
        System.out.print("\nDatos modificados: \n");
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Edad: " + persona.getEdad());


    }
}
