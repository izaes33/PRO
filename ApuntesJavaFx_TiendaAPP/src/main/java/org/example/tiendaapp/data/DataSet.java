package org.example.tiendaapp.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.tiendaapp.model.User;
// [ACTUALIZACIÓN]: Importamos la clase Product para poder gestionar la lógica del carrito de compras
import org.example.tiendaapp.model.Product;

import java.util.Optional;

/**
 * DATASET (Simulación de Base de Datos):
 * Esta clase centraliza la información de los usuarios.
 * Se usa 'static' para que los datos persistan mientras la app esté abierta,
 * permitiendo que diferentes controladores accedan a la misma información.
 */
public class DataSet {

    /**
     * OBSERVABLE LIST DE USUARIOS:
     * Usamos ObservableList en lugar de un ArrayList común para que las
     * vistas de JavaFX (como el ListView del administrador) se enteren
     * automáticamente si añadimos o borramos a alguien.
     * La palabra clave static en Java define miembros (variables, métodos o clases anidadas) que pertenecen
     * a la clase en sí y no a instancias (objetos) específicas. Esto significa que el miembro estático se
     * comparte entre todos los objetos de esa clase, ahorrando memoria y permitiendo acceder a ellos sin crear
     * un objeto nuevo.
     * (Variables estáticas (variables de clase): Se utiliza para compartir un único valor entre todas las
     * instancias de una clase (ej. un contador de objetos).
     * Métodos estáticos: Permite invocar funciones sin necesidad de instanciar la clase (ej. Math.sqrt()).
     * Los métodos estáticos solo pueden acceder directamente a otros miembros estáticos).
     */
    static private ObservableList<User> listUsers =
            FXCollections.observableArrayList(
                    // Usuarios precargados para poder probar el Login nada más empezar
                    new User("Admin", "Admin", "admin@gmail.com", "admin", "1234", "femenino", "admin", 50),
                    new User("Maria", "Martin", "maria@gmail.com", "maria", "1234", "femenino", "usuario", 50)
            );

    // [ACTUALIZACIÓN]: NUEVA LISTA PARA EL CARRITO
    /**
     * CARRITO DE COMPRAS:
     * Creamos una lista estática de productos. Al ser 'static', el carrito será único
     * para toda la aplicación y se compartirá entre la tienda y cualquier otra vista.
     */
    static private ObservableList<Product> carrito =
            FXCollections.observableArrayList();

    /**
     * getListUsers(): Permite a los controladores obtener la lista completa
     * para mostrarla en tablas o listas.
     */
    public static ObservableList<User> getListUsers() {
        return listUsers;
    }

    // [ACTUALIZACIÓN]: ACCESO AL CARRITO
    /**
     * getCarrito(): Método getter para obtener la lista de productos comprados.
     * Servirá para que otros controladores puedan mostrar el contenido del carrito.
     */
    public static ObservableList<Product> getCarrito() {
        return carrito;
    }

    /**
     * addUser(User user): El método que usa el FormController para registrar
     * a alguien nuevo. Aquí se podría añadir lógica para evitar correos duplicados.
     */
    public static void addUser(User user) {
        listUsers.add(user);
    }

    // [ACTUALIZACIÓN]: MÉTODO PARA AÑADIR AL CARRITO
    /**
     * addCarrito(Product product): Este método es llamado desde el TiendaController.
     * Recibe el producto seleccionado y lo añade a nuestra lista "carrito".
     */
    public static void addCarrito(Product product) {
        // lógica -> aquí podríamos añadir comprobaciones antes de insertar
        carrito.add(product);
    }

    /**
     * getLogin(String mail, String pass): El motor de seguridad.
     * Utiliza Streams de Java para buscar de forma eficiente.
     * * @return El objeto User si coincide, o null si las credenciales fallan.
     */
    public static User getLogin(String mail, String pass) {
        /*
         * .stream(): Convierte la lista en un flujo de datos.
         * .filter(): Busca elementos que cumplan la condición (mail y pass iguales).
         * .findFirst(): Se queda con el primero que encuentre.
         */
        Optional<User> userOptional = listUsers.stream()
                .filter(item -> item.getCorreo().equals(mail) && item.getPass().equals(pass))
                .findFirst();

        // .orElse(null): Si no encontró nada, devuelve nulo para que el Login sepa que falló.
        return userOptional.orElse(null);
    }
}