/*Desarrolla un programa que determine si una persona es elegible para un préstamo bancario.
Pide: edad, ingresos mensuales (€), y si tiene deudas pendientes (true/false). Los requisitos son:
Edad entre 21 y 65 años, ingresos mensuales de al menos 1000€, y NO tener deudas pendientes.
El programa debe evaluar cada condición y mostrar si es elegible o no, explicando qué requisitos no cumple.
Ejemplo de salida por consola:
Introduce tu edad: 25
Introduce tus ingresos mensuales: 1200
¿Tienes deudas pendientes? (true/false): false
¿Edad entre 21 y 65?: true
¿Ingresos >= 1000€?: true
¿Sin deudas pendientes?: true
¿Es elegible para el préstamo?: true
¡Felicidades! Eres elegible para solicitar el préstamo.*/

/*Explicación:
Scanner sc = new Scanner(System.in);
Crea un objeto que permite leer lo que el usuario escribe en la consola.
System.in es la entrada estándar (teclado).
Lectura de datos:
int edad = sc.nextInt(); lee un entero.
double ingresos = sc.nextDouble(); lee un número con decimales.
boolean tieneDeudas = sc.nextBoolean(); espera true o false.
Si el usuario escribe algo que no corresponde al tipo pedido (p. ej. "hola" en vez de un número),
el programa fallará — por eso validamos límites simples después.
Validaciones básicas:
if (edad < 0 || edad > 120) — verificamos que la edad esté en un rango razonable.
if (ingresos < 0) — los ingresos no pueden ser negativos.
Si alguno falla, mostramos mensaje y usamos return para salir de la función sin seguir calculando.
Cálculo de condiciones con boolean:
boolean edadValida = (edad >= 21) && (edad <= 65);
&& significa Y lógico: ambas expresiones deben ser verdaderas.
boolean ingresosSuficientes = ingresos >= 1000.0;
Comprueba que los ingresos sean al menos 1000€.
boolean sinDeudas = !tieneDeudas;
! es negación: si tieneDeudas es true, sinDeudas será false. Queremos true cuando NO tenga deudas.
Decisión final:
boolean esElegible = edadValida && ingresosSuficientes && sinDeudas;
Solo será true si las tres condiciones son true. Si falta una, esElegible será false.
Salida informativa:
Imprimimos el resultado de cada comprobación por separado para que el usuario vea exactamente qué se ha evaluado.
Si no cumple, listamos todas las razones (no solo la primera). Eso ayuda a corregir los fallos.
sc.close()
Cierra el Scanner y libera el recurso. Útil cuando ya no se leerá más. Si vas a leer después en
otro lugar del programa, no lo cierres aquí.
Conceptos importantes que aprendes con este ejercicio
Tipos de datos: int, double, boolean.
Lectura desde consola con Scanner.
Operadores de comparación (>=, <=, ==, <, >).
Operadores lógicos: && (Y), || (O), ! (NO).
Uso de if, else y return para controlar el flujo.
Mostrar mensajes claros al usuario para que entienda por qué algo falla.

 */
import java.util.Scanner;

public class ElegibilidadPrestamo {

    /**
     * Lee datos del usuario (edad, ingresos, deudas), evalúa cada requisito
     * y muestra si la persona es elegible para un préstamo, explicando qué falla.
     */
    public static void verificarElegibilidadPrestamo() {
        // Creamos un Scanner para leer desde la consola (System.in)
        Scanner sc = new Scanner(System.in);

        // --- ENTRADA: pedimos los datos al usuario ---
        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt();                 // Leemos la edad como entero

        System.out.print("Introduce tus ingresos mensuales (€): ");
        double ingresos = sc.nextDouble();       // Leemos ingresos como número decimal

        System.out.print("¿Tienes deudas pendientes? (true/false): ");
        boolean tieneDeudas = sc.nextBoolean();  // Leemos true o false

        // --- VALIDACIÓN BÁSICA DE ENTRADA ---
        // Si los datos introducidos no tienen sentido, avisamos y salimos.
        if (edad < 0 || edad > 120) {
            System.out.println("\nEdad introducida no válida. Debe estar entre 0 y 120.");
            sc.close();
            return; // terminamos la función porque los datos son inválidos
        }
        if (ingresos < 0) {
            System.out.println("\nIngresos no válidos. No pueden ser negativos.");
            sc.close();
            return;
        }

        // --- EVALUACIÓN DE CADA REQUISITO (separado y claro) ---
        // 1) Edad entre 21 y 65 inclusive
        boolean edadValida = (edad >= 21) && (edad <= 65);

        // 2) Ingresos mensuales al menos 1000€
        boolean ingresosSuficientes = ingresos >= 1000.0;

        // 3) No tener deudas pendientes -> si tieneDeudas es true, sinDeudas será false
        boolean sinDeudas = !tieneDeudas; // operador ! invierte el booleano

        // --- DECISIÓN FINAL: todas las condiciones deben ser verdaderas ---
        boolean esElegible = edadValida && ingresosSuficientes && sinDeudas;

        // --- SALIDA: mostramos el detalle de cada comprobación ---
        System.out.println();
        System.out.println("¿Edad entre 21 y 65?: " + edadValida);
        System.out.println("¿Ingresos >= 1000€?: " + ingresosSuficientes);
        System.out.println("¿Sin deudas pendientes?: " + sinDeudas);
        System.out.println("¿Es elegible para el préstamo?: " + esElegible);

        // --- MENSAJE FINAL: si no es elegible, detallamos todas las razones ---
        if (esElegible) {
            System.out.println("¡Felicidades! Eres elegible para solicitar el préstamo.");
        } else {
            System.out.println("No cumples todos los requisitos. Razones:");
            if (!edadValida) {
                // explicamos exactamente por qué falla la edad
                if (edad < 21) {
                    System.out.println(" - Eres demasiado joven. Debes tener al menos 21 años.");
                } else {
                    System.out.println(" - Excedes la edad máxima permitida (65 años).");
                }
            }
            if (!ingresosSuficientes) {
                System.out.println(" - Tus ingresos mensuales son insuficientes (mínimo 1000€).");
            }
            if (!sinDeudas) {
                System.out.println(" - Tienes deudas pendientes; para ser elegible no puedes tenerlas.");
            }
        }

        // Cerramos el Scanner (buena práctica cuando ya no vamos a leer más)
        sc.close();
    }

    // Método main para ejecutar la verificación
    public static void main(String[] args) {
        verificarElegibilidadPrestamo();
    }
}

