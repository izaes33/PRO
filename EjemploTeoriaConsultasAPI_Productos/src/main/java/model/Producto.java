package model;

public class Producto {
    // Atributos básicos del producto
    private String codigo;
    private String titulo;
    private double precio;

    public Producto() {  // Constructor vacío (siempre)
    }

    // Constructor con parámetros para inicializar el objeto rápido
    public Producto(String codigo, String titulo, double precio) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.precio = precio;
    }

    // Getters y Setters para acceder a los datos privados
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    // Método para imprimir el producto de forma legible
    public void mostrarDatos() {
        System.out.println("Código: " + codigo + " | Título: " + titulo + " | Precio: " + precio);
    }
}