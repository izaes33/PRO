/* Crea una clase Rectangulo con atributos base y altura.
Añade métodos calcularArea() y calcularPerimetro() que devuelvan el área
y el perímetro respectivamente. Crea un objeto y muestra los resultados.

Ejemplo de salida por consola:
Rectángulo con base 5.0 y altura 3.0
Área: 15.0
Perímetro: 16.0 */

package Ej03;

public class MainEj03 {

    public static void main(String[] args) {
        Rectangulo r = new Rectangulo(5.0, 3.0);

        System.out.println("Rectángulo con base " + r.getBase() + " y altura " + r.getAltura());
        System.out.println("Área: " + r.calcularArea());
        System.out.println("Perímetro: " + r.calcularPerimetro());
    }

}
