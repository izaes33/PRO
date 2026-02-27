import controller.UsuarioRepository;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Se crean los usuarios en la capa de negocio
        Usuario u1 = new Usuario("Juan", "Pérez", "123A");
        Usuario u2 = new Usuario("Ana", "López", "456B");

        // Se agregan a una lista
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(u1);
        listaUsuarios.add(u2);

        // Se crea el repositorio
        UsuarioRepository repo = new UsuarioRepository();

        // Se guardan los usuarios
        repo.guardarUsuarios("usuarios.dat", listaUsuarios);
    }
}