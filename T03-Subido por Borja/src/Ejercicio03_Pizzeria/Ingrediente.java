package Ejercicio03_Pizzeria;

public enum Ingrediente {

    Queso( 10), Jamon( 15), Piña(8), Pepperoni(6 ), Tomate(12);

    int precio;

    Ingrediente(int precioP) {
        precio = precioP;
    }
}