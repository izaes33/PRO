package Ej09_Agenda;

import java.io.BufferedWriter; // Importamos para escribir texto de forma eficiente
import java.io.FileWriter; // Importamos para abrir el flujo hacia el archivo
import java.io.IOException; // Importamos para gestionar errores de escritura
import java.util.ArrayList; // Importamos para usar la lista dinámica
import java.util.List; // Importamos la interfaz List

public class UsuarioController { // Clase que coordina la lógica y los datos
    private List<Usuario> listaUsuarios; // Nuestra base de datos temporal en memoria (RAM)
    private UsuarioView view; // Referencia a la vista

    public UsuarioController(UsuarioView view) { // Constructor del controlador
        this.listaUsuarios = new ArrayList<>(); // Inicializamos la lista vacía
        this.view = view; // Guardamos la vista inyectada
    } // Cerramos el constructor

    public void iniciar() { // Método que gestiona el bucle principal de la aplicación
        int opcion; // Variable para almacenar la opción del menú
        do { // Iniciamos el bucle del programa
            opcion = view.mostrarMenu(); // Mostramos menú y capturamos opción
            switch (opcion) { // Evaluamos la opción seleccionada
                case 1: // Agregar usuario
                    Usuario nuevo = view.pedirDatosUsuario(); // Pedimos datos a la vista
                    listaUsuarios.add(nuevo); // Añadimos el objeto a nuestra lista
                    view.mostrarMensaje("Usuario agregado con éxito."); // Confirmamos
                    break; // Salimos del caso 1
                case 2: // Listar usuarios
                    view.listar(listaUsuarios); // Pasamos la lista a la vista para mostrarla
                    break; // Salimos del caso 2
                case 3: // Exportar usuarios
                    exportarAFichero(); // Llamamos al método interno de guardado
                    break; // Salimos del caso 3
            } // Cerramos el switch
        } while (opcion != 4); // El bucle sigue hasta que la opción sea 4 (Salir)
    } // Cerramos iniciar

    private void exportarAFichero() { // Lógica para guardar los datos en disco
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.txt"))) { // Abrimos/creamos el fichero
            for (Usuario u : listaUsuarios) { // Recorremos nuestra lista de contactos
                bw.write(u.toString()); // Escribimos los datos del usuario en el archivo
                bw.newLine(); // Añadimos un salto de línea
            } // Cerramos el bucle
            view.mostrarMensaje("Datos exportados a 'usuarios.txt' correctamente."); // Éxito
        } catch (IOException e) { // Si hay un error al escribir (disco lleno, permisos...)
            view.mostrarMensaje("Error al exportar: " + e.getMessage()); // Informamos
        } // Cerramos try-catch
    } // Cerramos exportarAFichero
} // Cerramos la clase UsuarioController