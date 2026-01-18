package Ej11.Controller;

import Ej11.Carrito;
import Ej11.Producto;

public class CarritoController {

    private ProductoController productoController;

    public CarritoController(ProductoController productoController) {
        this.productoController = productoController;
    }

    // Agregar producto al carrito
    public void agregarProducto(Carrito carrito, Producto producto, int cantidad) {
        if (!productoController.verificarStock(producto, cantidad)) {
            System.out.println("No hay suficiente stock de " + producto.getNombre());
            return;
        }

        int index = carrito.getProductos().indexOf(producto);
        if (index >= 0) {
            carrito.getCantidades().set(index, carrito.getCantidades().get(index) + cantidad);
        } else {
            carrito.getProductos().add(producto);
            carrito.getCantidades().add(cantidad);
        }

        System.out.println("Añadiendo " + producto.getNombre() + " (" + String.format("%.2f", producto.getPrecio()) + "€) x" + cantidad + " al carrito... ✓");
    }

    // Eliminar producto del carrito
    public void eliminarProducto(Carrito carrito, Producto producto) {
        int index = carrito.getProductos().indexOf(producto);
        if (index >= 0) {
            carrito.getProductos().remove(index);
            carrito.getCantidades().remove(index);
            System.out.println("Eliminando " + producto.getNombre() + " del carrito... ✓");
        }
    }

    // Calcular total del carrito
    public double calcularTotal(Carrito carrito) {
        double total = 0;
        for (int i = 0; i < carrito.getProductos().size(); i++) {
            total += carrito.getProductos().get(i).getPrecio() * carrito.getCantidades().get(i);
        }
        return total;
    }

    // Mostrar carrito
    public void mostrarCarrito(Carrito carrito, String titulo) {
        System.out.println("\n--- " + titulo + " ---");
        for (int i = 0; i < carrito.getProductos().size(); i++) {
            Producto p = carrito.getProductos().get(i);
            int cantidad = carrito.getCantidades().get(i);
            System.out.println((i + 1) + ". " + p.getNombre() + " x" + cantidad +
                    " - " + String.format("%.2f", p.getPrecio() * cantidad) + "€");
        }
        System.out.println("Total: " + String.format("%.2f", calcularTotal(carrito)) + "€\n");
    }

    // Finalizar compra
    public void finalizarCompra(Carrito carrito) {
        for (int i = 0; i < carrito.getProductos().size(); i++) {
            productoController.venderProducto(carrito.getProductos().get(i), carrito.getCantidades().get(i));
        }
        carrito.getProductos().clear();
        carrito.getCantidades().clear();

        System.out.println("Finalizando compra...");
        System.out.println("✓ Compra realizada con éxito");
        System.out.println("Stock actualizado");
    }
}
