/* Crea una clase Empleado con atributos nombre y salarioBase.
Crea dos clases hijas: Gerente (con atributo bonus) y Desarrollador
(con atributo lenguajePrincipal). Implementa un método calcularSalarioTotal()
en Gerente que sume el bonus al salario base. Crea objetos de ambos tipos
y muestra su información completa. */

package Ej05;

public class MainEj05 {
    public static void main(String[] args) {

        Gerente g = new Gerente("Ana García", 40000.0, 10000.0);
        Desarrollador d = new Desarrollador("Luis Martínez", 35000.0, "Java");

        g.mostrarInfo();
        System.out.println();
        d.mostrarInfo();
    }
}
