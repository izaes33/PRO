import database.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * CLASE PRINCIPAL:
 * Punto de entrada temporal para testear que el puente entre Java y MySQL funciona.
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 1. SOLICITAMOS LA CONEXIÓN:
         * Llamamos a nuestro Singleton. Como es la primera vez que se llama en toda la ejecución,
         * connection valdrá null, así que entrará al 'if' y ejecutará el createConnection().
         */
        Connection connection1 = DBConnection.getConnection();

        try {
            /**
             * 2. COMPROBACIÓN (Prueba de vida):
             * 'getCatalog()' es un método que le pregunta a MySQL: "Oye, ¿en qué base de datos estoy metido ahora mismo?"
             * Si por consola te imprime "tienda_thepw", significa que todo está conectado.
             */
            System.out.println("Conectado exitosamente a la base de datos: " + connection1.getCatalog());

        } catch (SQLException e) {
            // Si hubo algún problema y 'connection1' no se creó bien (quedó en null), esto capturará el error.
            throw new RuntimeException("Fallo al obtener el catálogo de la conexión: " + e.getMessage(), e);
        }
    }
}