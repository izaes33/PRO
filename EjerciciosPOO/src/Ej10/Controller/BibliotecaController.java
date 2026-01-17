package Ej10.Controller;

import Ej10.Libro;
import Ej10.Prestamo;
import Ej10.Usuario;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaController {

    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

    public BibliotecaController() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    // Agregar libro o usuario
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Obtener libros disponibles
    public List<Libro> obtenerLibrosDisponibles() {
        List<Libro> disponibles = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                disponibles.add(libro);
            }
        }
        return disponibles;
    }

    // Prestar libro
    public boolean prestarLibro(Libro libro, Usuario usuario, String fecha) {
        if (libro.isDisponible()) {
            libro.prestar();
            prestamos.add(new Prestamo(libro, usuario, fecha));
            return true;
        }
        return false;
    }

    // Devolver libro
    public boolean devolverLibro(Libro libro) {
        if (!libro.isDisponible()) {
            libro.devolver();
            return true;
        }
        return false;
    }

    // Obtener lista de préstamos
    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
}
