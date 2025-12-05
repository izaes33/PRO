package CalculaSumaPromedio;

public class CalculaSumaPromedio {
    public void calculaSumaPromedio(){

        double[] numeros = {4.5, 7.2, 3.8, 9.1, 5.6, 8.3, 6.7, 4.9};

        // Mostrar el array
        System.out.print("Array: [");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        double suma = 0;

        // Calcular suma
        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }

        // Calcular promedio
        double promedio = suma / numeros.length;

        System.out.println("Suma total: " + suma);
        System.out.println("Promedio: " + promedio);
    }
}
