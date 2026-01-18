package Ej02.Controller;

import Ej02.Coche;
import Ej02.Vehiculo;

public class TestVehiculo {
    public static void main(String[] args) {

        Vehiculo v1 = new Vehiculo("Toyota", "Corolla");
        Coche c1 = new Coche("Ford", "Focus", 5);
        Coche c2 = new Coche("Seat", "Ibiza", 3);

        System.out.println(v1);
        System.out.println(c1);
        System.out.println(c2);
    }
}
