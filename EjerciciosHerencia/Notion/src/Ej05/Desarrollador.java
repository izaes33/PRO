package Ej05;

public class Desarrollador extends Empleado {
    private String lenguajePrincipal;

    public Desarrollador(String nombre, double salarioBase, String lenguajePrincipal) {
        super(nombre, salarioBase);
        this.lenguajePrincipal = lenguajePrincipal;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Empleado: " + nombre);
        System.out.println("Puesto: Desarrollador");
        System.out.println("Salario base: " + salarioBase + "€");
        System.out.println("Lenguaje principal: " + lenguajePrincipal);
    }
}
