/* Crea una clase Persona con atributos nombre y edad, y un método
presentarse(). Crea una clase Estudiante que herede de Persona y añada
el atributo curso. Añade un método estudiar() en la clase Estudiante.
Crea objetos y prueba todos los métodos. */


package Ej03;

public class MainEj03 {
    public static void main(String[] args) {

        Estudiante e1 = new Estudiante("Laura", 20, "2º de DAM");
        Estudiante e2 = new Estudiante("Carlos", 19, "1º de DAM");

        // Probar métodos
        e1.presentarse();
        e1.estudiar();

        System.out.println();

        e2.presentarse();
        e2.estudiar();
    }
}
