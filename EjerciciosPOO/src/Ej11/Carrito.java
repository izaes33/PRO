package Ej11;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos;
    private List<Integer> cantidades;

    public Carrito() {
        productos = new ArrayList<>();
        cantidades = new ArrayList<>();
    }

    public List<Producto> getProductos() { return productos; }
    public List<Integer> getCantidades() { return cantidades; }
}

