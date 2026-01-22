package Ej05;

public class Gerente extends Empleado {
    private double bonus;

    public Gerente(String nombre, double salarioBase, double bonus) {
        super(nombre, salarioBase);
        this.bonus = bonus;
    }

    public double calcularSalarioTotal() {
        return salarioBase + bonus;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Empleado: " + nombre);
        System.out.println("Puesto: Gerente");
        System.out.println("Salario base: " + salarioBase + "€");
        System.out.println("Bonus: " + bonus + "€");
        System.out.println("Salario total: " + calcularSalarioTotal() + "€");
    }
}
