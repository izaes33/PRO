package Ej04;



public class MainEj04 {
    public static void main(String[] args) {

        Libro libro1 = new Libro();
        Libro libro2 = new Libro("El Topo", "John le Carré");
        Libro libro3 = new Libro("El Caso Bourne", "Robert Ludlum", 576);

        System.out.println("Libro 1: " + libro1.imprimir());
        System.out.println("Libro 2: " + libro2.imprimir());
        System.out.println("Libro 3: " + libro3.imprimir());
    }
}
