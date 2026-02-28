import controller.UsuarioRepository;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 1. Definimos la ruta del archivo de datos
        String nombreArchivo = "usuarios.dat";

        // 2. Creación de datos de prueba (Capa de Negocio)
        Usuario u1 = new Usuario("Juan", "Pérez", "123A");
        Usuario u2 = new Usuario("Ana", "López", "456B");

        List<Usuario> listaOriginal = new ArrayList<>();
        listaOriginal.add(u1);
        listaOriginal.add(u2);

        // 3. Inicializamos el repositorio para gestionar los datos
        UsuarioRepository repo = new UsuarioRepository();

        // 4. Guardamos la lista en el disco
        System.out.println("--- Iniciando guardado ---");
        repo.guardarUsuarios(nombreArchivo, listaOriginal);

        // 5. Recuperamos la lista del disco (Implementación añadida)
        System.out.println("\n--- Iniciando lectura ---");
        try {
            List<Usuario> listaRecuperada = repo.lecturaObjeto(nombreArchivo);

            // 6. Mostramos los datos recuperados para verificar que todo es correcto
            System.out.println("Datos recuperados con éxito:");
            for (Usuario u : listaRecuperada) {
                System.out.println("- " + u); // Usa el método toString() definido en Usuario
            }
        } catch (RuntimeException e) {
            System.err.println("Error al recuperar los datos: " + e.getMessage());
        }
    }
}