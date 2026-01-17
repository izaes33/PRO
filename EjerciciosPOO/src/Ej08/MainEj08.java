/* Crea una clase Empleado con atributos nombre, puesto y salario.
En el método main, crea un array de 5 empleados, inicialízalos con
datos y luego muestra: todos los empleados, el empleado con mayor salario
y el salario promedio. */

package Ej08;

public class MainEj08 {
    public static void main(String[] args) {
        // Crear array de 5 empleados
        Empleado[] empleados = new Empleado[5];
        empleados[0] = new Empleado("Ana Pérez", "Desarrolladora", 35000.0);
        empleados[1] = new Empleado("Luis García", "Diseñador", 28000.0);
        empleados[2] = new Empleado("María Torres", "Project Manager", 42000.0);
        empleados[3] = new Empleado("Jorge Díaz", "Analista", 32000.0);
        empleados[4] = new Empleado("Laura Sánchez", "Tester", 26000.0);

        // Mostrar todos los empleados
        System.out.println("Lista de empleados:");
        for (int i = 0; i < empleados.length; i++) {
            System.out.println((i + 1) + ". " + empleados[i]);
        }

        // Encontrar empleado con mayor salario
        Empleado mayorSalario = empleados[0];
        double sumaSalarios = 0;
        for (Empleado emp : empleados) {
            if (emp.getSalario() > mayorSalario.getSalario()) {
                mayorSalario = emp;
            }
            sumaSalarios += emp.getSalario();
        }

        // Calcular salario promedio
        double promedio = sumaSalarios / empleados.length;

        // Mostrar resultados
        System.out.println();
        System.out.println("Empleado con mayor salario: " + mayorSalario.getNombre() +
                " (" + mayorSalario.getSalario() + "€)");
        System.out.println("Salario promedio: " + promedio + "€");
    }
}
