/* Crea una clase Vehiculo con atributos marca y modelo.
Crea una clase Coche que herede de Vehiculo y añada el atributo
numeroPuertas. Implementa constructores en ambas clases usando super().
Crea varios objetos y muestra su información. */

package Ej02;

public class MainEj02 {
    public static void main(String[] args) {

        // Crear vehículos
        Vehiculo v1 = new Vehiculo("Toyota", "Corolla");

        // Crear coches
        Coche c1 = new Coche("Ford", "Focus", 5);
        Coche c2 = new Coche("Seat", "Ibiza", 3);

        // Mostrar información
        System.out.println(v1);
        System.out.println(c1);
        System.out.println(c2);

        // Si quieres, también puedes usar un array de Vehiculo para polimorfismo
        Vehiculo[] listaVehiculos = {v1, c1, c2};

        System.out.println("\n--- Lista de vehículos ---");
        for (Vehiculo v : listaVehiculos) {
            System.out.println(v);
        }
    }
}
