/* Crea una clase Animal con atributos nombre y edad, y un método
hacerSonido(). Luego crea dos clases hijas: Perro y Gato que hereden
de Animal. Sobrescribe el método hacerSonido() en cada clase hija
para que muestre el sonido correspondiente.
Crea objetos de cada tipo y prueba los métodos. */

package Ej01;

public class MainEj01 {
    public static void main(String[] args) {

        // Crear objetos
        Perro perro = new Perro("Rex", 5);
        Gato gato = new Gato("Mishi", 3);

        // Probar métodos
        System.out.println(perro);
        perro.hacerSonido();

        System.out.println();

        System.out.println(gato);
        gato.hacerSonido();
    }
}
