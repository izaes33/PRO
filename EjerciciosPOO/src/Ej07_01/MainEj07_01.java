/* Crea una clase Direccion con atributos calle, ciudad y codigoPostal.
Luego crea una clase Cliente que tenga como atributos nombre, email
y un objeto Direccion. Implementa un método para mostrar todos los datos
del cliente incluyendo su dirección. */

package Ej07_01;

public class MainEj07_01 {
    public static void main(String[] args) {
        Direccion dir = new Direccion("Calle Mayor 15", "Madrid", "28001");
        Cliente cliente = new Cliente("Carlos Ruiz", "carlos.ruiz@email.com", dir);

        cliente.mostrarDatos();
    }
}
