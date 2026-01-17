/* Crea una clase Producto con atributos nombre, precio y cantidad.
Sobrescribe el método toString() para mostrar la información del producto
de forma legible. Crea varios productos y muéstralos usando
System.out.println(). */


package Ej07;

public class MainEj07 {
    // Método principal para probar la clase
    public static void main(String[] args) {

        // Crear objetos Producto
        Producto p1 = new Producto("Teclado", 45.99, 10);
        Producto p2 = new Producto("Ratón", 25.50, 25);
        Producto p3 = new Producto("Monitor", 299.99, 5);

        // Mostrar productos en consola
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
