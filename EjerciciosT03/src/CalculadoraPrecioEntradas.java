/*Escribe un programa para calcular el precio de entrada a un museo.
        Pide la edad del usuario y el día de la semana (1=Lunes, 2=Martes...
        7=Domingo). Las reglas son: Menores de 12 años: entrada gratis.
        Entre 12 y 17 años: 5€ (pero gratis los martes). Entre 18 y 64 años:
        10€ (pero 7€ los jueves). 65 años o más: 6€. Usa operadores lógicos
        para determinar el precio correcto y muestra el cálculo.
Ejemplo de salida por consola:
Introduce tu edad: 15
Introduce el día de la semana (1-7): 2
Edad: 15 años
Día de la semana: 2 (Martes)
¿Eres menor de 12?: false
¿Tienes entre 12 y 17?: true
¿Es martes?: true
Precio de entrada: 0.0€ (Entrada gratuita para menores en martes)*/

/*Explicación: (paso a paso)
1) Lectura de datos
Scanner sc = new Scanner(System.in); crea un lector de teclado.
sc.nextInt() lee un número entero de la consola. En este caso pedimos primero la edad y luego el día.
2) Validación básica
Antes de calcular nada comprobamos que los datos tengan sentido:
edad < 0 || edad > 120 — si la edad es negativa o demasiado alta, mostramos error y salimos con return.
dia < 1 || dia > 7 — si el día no está entre 1 y 7 también salimos.
Esto evita comportamientos raros después.
3) Evaluación de rangos con booleans
Creamos variables boolean (verdadero/falso) para cada rango de edad:
menor12 si la edad es menor que 12.
entre12y17 si la edad está entre 12 y 17 (incluidos).
entre18y64 si la edad está entre 18 y 64.
mayorOigual65 si tiene 65 o más.
Estas variables se calculan usando operadores lógicos:
&& significa “y” (ambas condiciones deben cumplirse).
>= y <= comparan inclusive.
4) Día de la semana
esMartes = dia == 2 y esJueves = dia == 4.
== compara igualdad numérica.
5) Lógica del precio (if / else if)
Usamos if/else if para entrar sólo en el bloque que corresponde a la edad del usuario
(evitamos que múltiples bloques se ejecuten).
Si menor12 → precio = 0.0.
Si entre12y17 → comprobamos esMartes. Si es martes: gratis, si no: 5€.
Si entre18y64 → comprobamos esJueves. Si es jueves: 7€, si no: 10€.
Si mayorOigual65 → 6€.
Observa la combinación de condiciones: primero filtramos por edad y dentro de
cada rango aplicamos reglas por día.
6) Salida explicativa
Imprimimos la edad, el día con nombre (usando nombreDia(dia)), y el valor de cada boolean
para que el usuario vea qué comprobaciones se han hecho.
Finalmente mostramos el precio y un texto adicional que explica el motivo si hay una condición
especial (por ejemplo: "Entrada gratuita para jóvenes en martes").
7) Buenas prácticas y notas
Validar siempre la entrada: evita crashs o resultados extraños.
Variables booleanas ayudan a que el código sea legible: en lugar de escribir condiciones complejas
repetidas, las calculas una vez y las reutilizas.
Estructura if/else if: garantiza que sólo un bloque de edad se ejecute.
Cerrar el scanner: sc.close() libera recursos. Si tu programa fuera a leer más entradas en otro punto,
podrías evitar cerrarlo hasta el final del programa.
Rangos no solapados: las condiciones están escritas de forma que no haya solapamiento entre rangos
(p.ej. 17 está en entre12y17 y no en entre18y64).*/

import java.util.Scanner;

public class CalculadoraPrecioEntradas {

    /**
     * Método principal que pide edad y día, valida la entrada y calcula el precio.
     * Está escrito paso a paso y con comentarios para que se entienda cada operación.
     */
    public static void calcularPrecioEntrada() {
        Scanner sc = new Scanner(System.in); // Creamos el lector para la entrada por consola

        // --- Entrada de datos ---
        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt(); // Leemos la edad como un entero

        System.out.print("Introduce el día de la semana (1-7): ");
        int dia = sc.nextInt(); // Leemos el número del día (1=Lunes ... 7=Domingo)

        // --- Validación básica de datos ---
        // Comprobamos si la edad es razonable (ejemplo: 0-120). Si no, avisamos.
        if (edad < 0 || edad > 120) {
            System.out.println("\nEdad introducida no válida. Debe ser un número entre 0 y 120.");
            // No continuamos el cálculo si los datos son inválidos
            return;
        }

        // Comprobamos si el día está en el rango 1-7
        if (dia < 1 || dia > 7) {
            System.out.println("\nDía de la semana no válido. Debe ser un número entre 1 y 7.");
            return;
        }

        // --- Evaluamos rangos de edad usando operadores lógicos ---
        // Cada boolean indica si se cumple esa condición de edad
        boolean menor12 = edad < 12;                    // true si es menor de 12 años
        boolean entre12y17 = edad >= 12 && edad <= 17;  // true si está entre 12 y 17 inclusive
        boolean entre18y64 = edad >= 18 && edad <= 64;  // true si está entre 18 y 64 inclusive
        boolean mayorOigual65 = edad >= 65;             // true si tiene 65 o más

        // --- Evaluamos el día de la semana ---
        boolean esMartes = dia == 2;   // true si el usuario introdujo 2 (Martes)
        boolean esJueves = dia == 4;   // true si el usuario introdujo 4 (Jueves)

        // --- Cálculo del precio según las reglas ---
        double precio = 0.0;

        // Usamos una estructura if/else if para elegir el bloque aplicable según la edad
        if (menor12) {
            // Menores de 12 años: entrada gratuita (0€)
            precio = 0.0;
        } else if (entre12y17) {
            // Entre 12 y 17: normalmente 5€, pero gratis los martes
            if (esMartes) {
                precio = 0.0;
            } else {
                precio = 5.0;
            }
        } else if (entre18y64) {
            // Entre 18 y 64: normalmente 10€, pero cuesta 7€ los jueves
            if (esJueves) {
                precio = 7.0;
            } else {
                precio = 10.0;
            }
        } else if (mayorOigual65) {
            // 65 o más: precio fijo 6€
            precio = 6.0;
        }

        // --- Salida: mostramos todos los datos y las comprobaciones ---
        System.out.println("\nEdad: " + edad + " años");
        System.out.println("Día de la semana: " + dia + " (" + nombreDia(dia) + ")");
        System.out.println("¿Eres menor de 12?: " + menor12);
        System.out.println("¿Tienes entre 12 y 17?: " + entre12y17);
        System.out.println("¿Tienes entre 18 y 64?: " + entre18y64);
        System.out.println("¿Eres mayor o igual a 65?: " + mayorOigual65);
        System.out.println("¿Es martes?: " + esMartes);
        System.out.println("¿Es jueves?: " + esJueves);

        // Mostramos el precio con un mensaje adicional según la condición especial
        System.out.println("Precio de entrada: " + precio + "€" + mensajeExtra(edad, dia));

        // No cerramos System.in si el programa fuera a pedir más datos después.
        // En esta función terminamos aquí, así que podríamos cerrar el scanner si queremos:
        sc.close();
    }

    /**
     * Método auxiliar que devuelve el nombre del día según su número.
     * Sirve solo para mostrar salida más legible.
     */
    public static String nombreDia(int dia) {
        switch (dia) {
            case 1: return "Lunes";
            case 2: return "Martes";
            case 3: return "Miércoles";
            case 4: return "Jueves";
            case 5: return "Viernes";
            case 6: return "Sábado";
            case 7: return "Domingo";
            default: return "Día inválido"; // nunca ocurrirá aquí porque ya validamos antes
        }
    }

    /**
     * Método auxiliar que agrega un texto explicativo según descuentos/reglas especiales.
     * Ayuda a entender por qué el precio es ese.
     */
    public static String mensajeExtra(int edad, int dia) {
        if (edad < 12) {
            return " (Entrada gratuita para menores de 12 años)";
        }
        if (edad >= 12 && edad <= 17 && dia == 2) {
            return " (Entrada gratuita para jóvenes en martes)";
        }
        if (edad >= 18 && edad <= 64 && dia == 4) {
            return " (Descuento de jueves: precio especial)";
        }
        return ""; // si no hay mensaje extra, devolvemos cadena vacía
    }

    // Método main para ejecutar el programa
    public static void main(String[] args) {
        calcularPrecioEntrada();
    }
}
