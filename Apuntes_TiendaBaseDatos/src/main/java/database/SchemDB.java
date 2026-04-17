package database;

/**
 * DICCIONARIO DE DATOS:
 * Usar una interfaz para constantes evita los "Magic Strings" (textos sueltos por el código).
 * Si mañana la tabla "clientes" pasa a llamarse "usuarios", solo lo cambias aquí y
 * se actualizará automáticamente en todas las consultas SQL del DAO.
 */
public interface SchemDB {

    /* Una interfaz sirve para:
     * -implementar métodos abstractos.
     * -guardar constantes (por defecto son public static final) */

    String TAB_CLIENTES = "clientes";
    String COL_ID = "id";
    String COL_NAME = "nombre";
    String COL_SURNAME = "apellido";
    String COL_MAIL = "correo";
    String COL_PROFILE = "id_perfil";
    String COL_PRICE = "saldo";
}