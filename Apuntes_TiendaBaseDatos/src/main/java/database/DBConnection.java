package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * CLASE DE CONEXIÓN A BASE DE DATOS (Patrón Singleton):
 * Su trabajo es fabricar y gestionar el "cable" (Connection) que une
 * nuestra aplicación Java con el servidor MySQL.
 */
public class DBConnection {

    /**
     * VARIABLE ESTÁTICA (El Singleton):
     * Al ser 'static', esta variable pertenece a la clase y es compartida por toda la app,
     * por lo que para acceder a ella no es necesario hacerlo creando un objeto DBConnection.
     * Guardará nuestra única conexión. Empieza valiendo 'null' (vacía).
     */
    private static Connection connection;

    /**
     * MÉTODO DE ACCESO GLOBAL:
     * Cuando cualquier otra clase (como el Main o un controlador) necesite
     * hablar con la base de datos, llamará a este método.
     * @return El objeto Connection activo.
     */
    public static Connection getConnection(){
        /* * LA MAGIA DEL SINGLETON:
         * "Si la conexión está vacía (nadie la ha creado aún), la creo."
         * "Si ya estaba creada de antes, me salto el if y devuelvo la que ya existe."
         */
        if(connection == null){
            createConnection();
        }
        return connection;
    }

    /**
     * MÉTODO DE FABRICACIÓN (Oculto):
     * Es 'private' porque nadie desde fuera debe poder llamar a este método directamente,
     * solo la propia clase a través de getConnection() controla cuándo se fabrica.
     */
    private static void createConnection(){
        // 1. Credenciales de acceso a tu MySQL (XAMPP por defecto suele ser root y contraseña vacía, aquí usas root/root)
        String user = "root";
        String pass = "root";
        String database = "Tienda_thepw"; // Nombre exacto de la BD en phpMyAdmin

        try {
            /**
             * DRIVER MANAGER (El telefonista):
             * Le damos la URL de conexión.
             * - jdbc:mysql:// -> Es el protocolo (como el http:// de las webs).
             * - 127.0.0.1: -> Es 'localhost' (tu propio ordenador).
             * - 3306 (por defecto) -> puerto de MySQL.
             * - /database -> A qué base de datos concreta queremos entrar.
             */
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3407/"+database, user, pass);

        } catch (SQLException e){
            // 2. Control de errores por si el servidor MySQL está apagado, la contraseña está mal o la BD no existe.
            System.out.println("Error en la conexion con la base de datos");
            System.out.println(e.getMessage());
        }
    }
}