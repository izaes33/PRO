package Ej07;

public class Producto {

    // Atributos
    private String nombre;
    private double precio;
    private int cantidad;

    // Constructor
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Sobrescribir toString() para mostrar información legible
    @Override
    public String toString() {
        return "Producto{nombre='" + nombre +
                "', precio=" + String.format("%.2f", precio) + "€, cantidad=" + cantidad + "}";
    }

}
