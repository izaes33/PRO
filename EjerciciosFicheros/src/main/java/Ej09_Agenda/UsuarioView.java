package Ej09_Agenda;

import java.util.Scanner; // Importamos Scanner para leer la entrada del teclado
import java.util.List; // Importamos List para poder mostrar la agenda completa

public class UsuarioView { // Clase encargada de la interfaz de usuario por consola
    private Scanner sc = new Scanner(System.in); // Instanciamos el lector de consola

    public int mostrarMenu() { // Método para mostrar las opciones disponibles
        System.out.println("\n--- AGENDA DE CONTACTOS ---"); // Título del menú
        System.out.println("1. Agregar usuario"); // Opción 1
        System.out.println("2. Listar usuarios"); // Opción 2
        System.out.println("3. Exportar a .txt"); // Opción 3
        System.out.println("4. Salir"); // Opción de salida
        System.out.print("Seleccione una opción: "); // Indicador de acción
        int opcion = sc.nextInt(); // Leemos el número de la opción
        sc.nextLine(); // Limpiamos el búfer después de leer un entero para evitar errores con Strings
        return opcion; // Devolvemos la opción seleccionada
    } // Cerramos mostrarMenu

    public Usuario pedirDatosUsuario() { // Método para capturar un nuevo contacto
        System.out.print("Introduce nombre: "); // Pedimos el nombre
        String nombre = sc.nextLine(); // Leemos el nombre
        System.out.print("Introduce apellido: "); // Pedimos el apellido
        String apellido = sc.nextLine(); // Leemos el apellido
        System.out.print("Introduce DNI: "); // Pedimos el DNI
        String dni = sc.nextLine(); // Leemos el DNI
        return new Usuario(nombre, apellido, dni); // Devolvemos un nuevo objeto Usuario con esos datos
    } // Cerramos pedirDatosUsuario

    public void listar(List<Usuario> usuarios) { // Método para imprimir la lista de contactos
        System.out.println("\n--- LISTADO DE USUARIOS ---"); // Cabecera del listado
        if (usuarios.isEmpty()) { // Comprobamos si la lista está vacía
            System.out.println("No hay usuarios registrados."); // Avisamos si no hay datos
        } else { // Si hay datos...
            for (Usuario u : usuarios) { // Recorremos la lista de usuarios
                System.out.println(u.toString()); // Imprimimos cada usuario usando su método toString
            } // Cerramos el bucle
        } // Cerramos el condicional
    } // Cerramos listar

    public void mostrarMensaje(String msg) { // Método genérico para mensajes informativos
        System.out.println(msg); // Imprimimos el mensaje
    } // Cerramos mostrarMensaje
} // Cerramos la clase UsuarioView