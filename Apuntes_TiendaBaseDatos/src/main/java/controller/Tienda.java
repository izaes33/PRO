package controller;

import dao.ClienteDAO;
import model.Cliente;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * CLASE CONTROLADOR / SERVICIO:
 * Su responsabilidad es manejar la "lógica de negocio". No tiene código SQL,
 * sino que toma decisiones (ej. pedir otro correo si falla, decidir quién recibe fidelización)
 * y delega el trabajo sucio de la base de datos al ClienteDAO.
 */
public class Tienda {

    // Dependencia: La tienda necesita un DAO para comunicarse con la BD.
    private ClienteDAO clienteDAO;

    public Tienda(){
        // Al nacer la Tienda, instanciamos el DAO (que a su vez conectará con la BD)
        clienteDAO = new ClienteDAO();
    }

    public void agregarUsuario(Cliente cliente){
        System.out.println("Procedemos a meter el usuario en el sistema..");
        try {
            // Delegamos la inserción al DAO usando el método seguro (PreparedStatement)
            clienteDAO.insertarUsuarioPS(cliente);
        } catch (SQLException e) {
            // Si salta un SQLException, probablemente sea porque el correo está duplicado
            // (violación de clave única en MySQL).
            Scanner scanner = new Scanner(System.in);
            System.out.print("Este correo ya esta en uso, por favor indica otro diferente: ");
            String correo = scanner.next();
            // Actualizamos el objeto cliente con el nuevo correo
            cliente.setCorreo(correo);
            // RECURSIVIDAD: Volvemos a llamar a este mismo método para intentar insertarlo de nuevo
            agregarUsuario(cliente);
        }
    }

    public void actualizarUsuario(String correo, String nombre){
        System.out.println("Actualizando usuario");
        // Delegamos al DAO. Nos devuelve el número de filas modificadas (row).
        int row = clienteDAO.actualizarUsuario(correo,nombre);
        if (row == 0){
            System.out.println("El correo indicado no se encuenta en la bd");
        } else {
            System.out.println("El numero de elementos actualizados es de "+row);
        }
    }

    public void lanzarFidelizacion(){
        // Recuperamos TODOS los clientes mediante el DAO
        List<Cliente> listado = clienteDAO.obtenerClientes();

        // Uso de API Stream de Java 8+ para procesar colecciones de forma declarativa:
        listado.stream()
                .filter(data->data.getSaldo()<50) // Filtramos: solo pasan los que tienen saldo menor a 50
                .forEach(data-> {                 // Por cada uno que pasó el filtro, hacemos esto:
                    // Aquí iría la integración con JavaMail
                    System.out.println("Correo enviado a " + data.getCorreo());
                });
    }
}