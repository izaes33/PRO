package Ej11;

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }

    // Reducir stock al vender
    public boolean reducirStock(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
            return true;
        }
        return false;
    }

    public void aumentarStock(int cantidad) {
        stock += cantidad;
    }

    @Override
    public String toString() {
        return nombre + " (" + String.format("%.2f", precio) + "€)";
    }
}
