/* Crea un sistema de biblioteca con las clases: Libro (titulo, autor,
ISBN, disponible), Usuario (nombre, numeroSocio) y Prestamo (libro,
usuario, fechaPrestamo). Implementa métodos para prestar un libro
(si está disponible) y devolverlo. Crea varios libros y usuarios,
realiza algunos préstamos y devoluciones. */

package Ej10;


import Ej10.Controller.BibliotecaController;

public class MainEj10 {
    public static void main(String[] args) {
        BibliotecaController biblioteca = new BibliotecaController();

        Libro libro1 = new Libro("Don Quijote", "Miguel de Cervantes", "001");
        Usuario usuario1 = new Usuario("Juan Pérez", 101);

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarUsuario(usuario1);

        boolean exito = biblioteca.prestarLibro(libro1, usuario1, "20/12/2025");
        if (exito) System.out.println("Préstamo realizado");
        else System.out.println("El libro no está disponible");

    }
}
