import controller.Tienda;
import model.Cliente;
import java.util.Scanner;

/**
 * CLASE PRINCIPAL (Punto de entrada):
 * Aquí es donde arranca tu aplicación. Contiene el método 'main'.
 * Actúa como la "vista" o interfaz con el usuario (por consola), recogiendo los datos
 * y pasándoselos a la capa de control (Tienda).
 */
public class Main {

    public static void main(String[] args) {

        // 1. Inicializamos la capa de lógica de negocio.
        // Al hacer el 'new', el flujo viaja al constructor de Tienda,
        // este crea el ClienteDAO, y el DAO establece la conexión (Singleton) con MySQL.
        Tienda miTienda = new Tienda();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("=========================================");
        System.out.println(" ¡Bienvenido al Gestor de la Tienda! ");
        System.out.println("=========================================");

        // 2. Bucle infinito del menú interactivo (se rompe al elegir la opción 4)
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Agregar nuevo cliente");
            System.out.println("2. Actualizar nombre de cliente existente");
            System.out.println("3. Lanzar campaña de fidelización");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            try {
                // Leemos toda la línea y la convertimos a número para evitar
                // el famoso "bug" de que el Scanner se salte líneas al usar nextInt()
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        // --- FLUJO DE CREACIÓN ---
                        System.out.println("\n-- REGISTRO DE CLIENTE --");
                        System.out.print("Introduce el nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Introduce el apellido: ");
                        String apellido = scanner.nextLine();
                        System.out.print("Introduce el correo: ");
                        String correo = scanner.nextLine();
                        System.out.print("Introduce el saldo inicial (número entero): ");
                        int saldo = Integer.parseInt(scanner.nextLine());
                        System.out.print("Introduce el ID del perfil (ej. 1, 2, 3): ");
                        int idPerfil = Integer.parseInt(scanner.nextLine());

                        // Empaquetamos los datos en el Modelo
                        Cliente nuevoCliente = new Cliente(nombre, apellido, correo, saldo, idPerfil);

                        // Le pasamos la pelota al Controlador
                        miTienda.agregarUsuario(nuevoCliente);
                        break;

                    case 2:
                        // --- FLUJO DE ACTUALIZACIÓN ---
                        System.out.println("\n-- ACTUALIZAR CLIENTE --");
                        System.out.print("Introduce el correo del cliente a actualizar: ");
                        String correoActualizar = scanner.nextLine();
                        System.out.print("Introduce el nuevo nombre: ");
                        String nuevoNombre = scanner.nextLine();

                        // Delegamos al Controlador pasándole los datos clave
                        miTienda.actualizarUsuario(correoActualizar, nuevoNombre);
                        break;

                    case 3:
                        // --- FLUJO DE LECTURA Y LÓGICA ---
                        System.out.println("\n-- CAMPAÑA DE FIDELIZACIÓN --");
                        System.out.println("Revisando base de datos y buscando clientes con saldo < 50...");
                        miTienda.lanzarFidelizacion();
                        break;

                    case 4:
                        System.out.println("\nCerrando la conexión. ¡Hasta pronto!");
                        break;

                    default:
                        System.out.println("\n[!] Opción no válida. Por favor, elige un número del 1 al 4.");
                }
            } catch (NumberFormatException e) {
                // Capturamos el error por si el usuario teclea letras en vez de números en el menú
                System.out.println("\n[!] Error: Debes introducir un número válido, no letras.");
            } catch (Exception e) {
                System.out.println("\n[!] Ocurrió un error inesperado: " + e.getMessage());
            }

        } while (opcion != 4); // Si la opción es 4, sale del bucle y el programa termina.

        // Es una buena práctica cerrar el escáner al terminar de usarlo
        scanner.close();
    }
}