/* Crea un sistema de tienda online con las clases: Producto (codigo,
nombre, precio, stock), Cliente (nombre, email, carrito) y Carrito
(lista de productos, cantidades). Implementa métodos para añadir productos
al carrito, eliminarlos, calcular el total y finalizar la compra (actualizando
el stock). Simula una compra completa. */

package Ej11;

import Ej11.Controller.CarritoController;
import Ej11.Controller.ProductoController;

public class MainEj11 {

    public static void main(String[] args) {

        System.out.println("--- TIENDA ONLINE ---");

        // Crear controladores
        ProductoController productoController = new ProductoController();
        CarritoController carritoController = new CarritoController(productoController);

        // Crear productos
        Producto p1 = new Producto("P001", "Portátil", 899.99, 10);
        Producto p2 = new Producto("P002", "Ratón", 25.50, 50);
        Producto p3 = new Producto("P003", "Teclado", 45.99, 30);

        // Crear cliente y carrito
        Cliente cliente = new Cliente("Ana Martínez", "ana@email.com");
        Carrito carrito = new Carrito();

        System.out.println("Cliente: " + cliente + "\n");

        // Añadir productos
        carritoController.agregarProducto(carrito, p1, 1);
        carritoController.agregarProducto(carrito, p2, 2);
        carritoController.agregarProducto(carrito, p3, 1);

        carritoController.mostrarCarrito(carrito, "CARRITO DE COMPRA");

        // Eliminar un producto
        carritoController.eliminarProducto(carrito, p2);

        carritoController.mostrarCarrito(carrito, "CARRITO ACTUALIZADO");

        // Finalizar compra
        carritoController.finalizarCompra(carrito);
    }
}
