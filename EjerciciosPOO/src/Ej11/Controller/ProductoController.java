package Ej11.Controller;

import Ej11.Producto;

public class ProductoController {

    // Verificar si hay stock suficiente
    public boolean verificarStock(Producto producto, int cantidad) {
        return cantidad <= producto.getStock();
    }

    // Reducir stock al finalizar compra
    public boolean venderProducto(Producto producto, int cantidad) {
        return producto.reducirStock(cantidad);
    }
}
