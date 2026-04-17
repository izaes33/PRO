package dao;

import database.DBConnection;
import database.SchemDB;
import model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DATA ACCESS OBJECT (DAO):
 * Permite ejecuciones CRUD (Create, Read, Update, Delete) sobre la base de datos.
 * Esta clase es la ÚNICA que debería contener sentencias SQL en todo el proyecto.
 */
public class ClienteDAO {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ClienteDAO() {
        // Al instanciar el DAO, obtenemos la conexión única (Singleton)
        connection = DBConnection.getConnection();
    }

    /**
     * INSERCIÓN INSEGURA (Usa Statement normal).
     * Vulnerable a Inyección SQL porque concatena Strings directamente.
     */
    public int insertarUsuario(Cliente cliente) {
        // String.format ayuda a construir el String inyectando las constantes de la interfaz SchemDB.
        String query = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) VALUES ('%s','%s','%s',%d,%d)",
                SchemDB.TAB_CLIENTES,
                SchemDB.COL_NAME, SchemDB.COL_SURNAME, SchemDB.COL_MAIL, SchemDB.COL_PRICE, SchemDB.COL_PROFILE,
                cliente.getNombre(), cliente.getApellido(), cliente.getCorreo(), cliente.getSaldo(), cliente.getIdPerfil()
        );
        try {
            statement = connection.createStatement();
            // executeUpdate() se usa para INSERT, UPDATE, DELETE. Devuelve filas afectadas.
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error en la ejecucion");
            System.out.println(e.getMessage());
        }
        return -1;
    }

    /**
     * INSERCIÓN SEGURA (Usa PreparedStatement).
     * Lanza la excepción hacia arriba (throws) para que la controle la clase Tienda.
     */
    public boolean insertarUsuarioPS(Cliente cliente) throws SQLException {
        // Los signos de interrogación (?) son parámetros que se rellenarán después de forma segura.
        String query = String.format("INSERT INTO %s ( %s, %s, %s, %s, %s ) VALUES (?,?,?,?,?)",
                SchemDB.TAB_CLIENTES,
                SchemDB.COL_NAME, SchemDB.COL_SURNAME, SchemDB.COL_MAIL, SchemDB.COL_PRICE, SchemDB.COL_PROFILE);

        System.out.println(query);

        // Pre-compilamos la consulta en MySQL
        preparedStatement = connection.prepareStatement(query);

        // Parametrizamos los datos indicando la posición del '?' y su valor correspondiente
        preparedStatement.setString(1, cliente.getNombre());
        preparedStatement.setString(2, cliente.getApellido());
        preparedStatement.setString(3, cliente.getCorreo());
        preparedStatement.setInt(4, cliente.getSaldo());
        preparedStatement.setInt(5, cliente.getIdPerfil());

        // execute() devuelve un booleano (true si el primer resultado es un ResultSet, false si es recuento de actualización)
        return preparedStatement.execute();
    }

    public int actualizarUsuario(String correo, String nombre) {
        String query = String.format("UPDATE %s SET %s=? WHERE %s=?",
                SchemDB.TAB_CLIENTES, SchemDB.COL_NAME, SchemDB.COL_MAIL);
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, correo);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la query");
        }
        return -1;
    }

    /**
     * LECTURA DE DATOS (READ):
     * Convierte los registros de MySQL en objetos Java (POJOs).
     */
    public List<Cliente> obtenerClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM " + SchemDB.TAB_CLIENTES;
        try {
            preparedStatement = connection.prepareStatement(query);
            // executeQuery() se usa SOLO para SELECT. Devuelve un ResultSet (como una tabla virtual en memoria).
            resultSet = preparedStatement.executeQuery();

            // resultSet.next() mueve el "cursor" fila por fila. Devuelve false cuando no hay más filas.
            while (resultSet.next()) {
                // Extraemos los datos de la fila actual usando los nombres de las columnas (constantes)
                String nombre = resultSet.getString(SchemDB.COL_NAME);
                String apellido = resultSet.getString(SchemDB.COL_SURNAME);
                String correo = resultSet.getString(SchemDB.COL_MAIL);
                int saldo = resultSet.getInt(SchemDB.COL_PRICE);
                int idPerfil = resultSet.getInt(SchemDB.COL_PROFILE);

                // Fabricamos el objeto Java y lo añadimos a la lista
                clientes.add(new Cliente(nombre, apellido, correo, saldo, idPerfil));
            }

        } catch (SQLException e) {
            System.out.println("Error en la SQL");
            System.out.println(e.getMessage());
        }

        return clientes;
    }
}