package Ej07_01;

public class Cliente {
    private String nombre;
    private String email;
    private Direccion direccion;

    // Constructor
    public Cliente(String nombre, String email, Direccion direccion) {
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
    }

    // Método para mostrar todos los datos del cliente
    public void mostrarDatos() {
        System.out.println("Cliente: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Dirección: " + direccion);
    }
}