import controller.APIController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        APIController controller = new APIController();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Estas son todas las ligas de las que tengo info");
            controller.obtenerLigas();

            System.out.println("-------------------------------------------------");
            System.out.println("De que liga quieres consultar su tabla (ingresa el ID)");
            String id = scanner.next();

            try {
                controller.obtenerClasificacionCompleta(id);
            } catch (RuntimeException e) {
                System.err.println("Error al obtener la clasificación: No se pudo conectar con el servidor o el ID no es válido.");
                // Opcional: imprimir el error técnico para depuración
                // System.err.println("Detalle: " + e.getMessage());
            }

        } catch (RuntimeException e) {
            System.err.println("Error crítico: No se pudo obtener la lista de ligas. Revisa tu conexión a internet.");
            // Opcional: imprimir el error técnico para depuración
            // System.err.println("Detalle: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Programa finalizado.");
        }
    }
}