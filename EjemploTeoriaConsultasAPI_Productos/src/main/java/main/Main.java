package main;

import controller.Gestor;
import model.Producto;

public class Main {
    public static void main(String[] args) {

        Gestor miGestor = new Gestor(); // 1. Instanciamos el controlador central

        System.out.println("Obteniendo datos de DummyJSON...");
        miGestor.obtenerProductosAPI(); // 2. Probamos la conexión HTTP real a la API

        // 3. Metemos un producto manualmente, pero con precio negativo para probar los Streams
        Producto productoRoto = new Producto("SKU-999", "Teclado Roto", -50.0);
        miGestor.agregarProducto(productoRoto);

        // 4. Mostramos los productos actuales (verás el de la API y el nuestro negativo)
        miGestor.mostrarProductos();

        // 5. Aplicamos la corrección de precios mediante Streams
        System.out.println("\nCorrigiendo precios negativos con Streams...");
        miGestor.asignarPrecios();

        miGestor.mostrarProductos(); // 6. Mostramos el resultado final
    }
}