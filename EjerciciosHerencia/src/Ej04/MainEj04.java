/* Crea una clase Figura con un método calcularArea(). Crea dos clases
hijas: Circulo (con atributo radio) y Cuadrado (con atributo lado).
Implementa el método calcularArea() en cada clase hija con la fórmula correspondiente.
Crea objetos de cada tipo y muestra sus áreas. */

package Ej04;

public class MainEj04 {
    public static void main(String[] args) {

        Circulo c = new Circulo(5.0);
        Cuadrado q = new Cuadrado(4.0);

        System.out.println(c);
        System.out.println("Área: " + String.format("%.2f", c.calcularArea()));

        System.out.println();

        System.out.println(q);
        System.out.println("Área: " + String.format("%.2f", q.calcularArea()));
    }
}
