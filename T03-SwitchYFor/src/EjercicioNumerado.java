import java.util.Scanner;
public class EjercicioNumerado {

    public void ejercicio01(){
        /*Crea un programa que pida un número del 1 al 7 y use un
        switch para mostrar el día de la semana correspondiente
        (1=Lunes, 2=Martes, etc.).
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número (1-7): ");
        int numero = sc.nextInt();

        switch (numero) {
            case 1:
                System.out.println("El día 1 es: Lunes");
                break;
/*En Java, el switch no detiene la ejecución automáticamente después de ejecutar un case.
Si no pones break, el programa “cae” (fall through) hacia el siguiente caso y ejecuta
también su bloque, aunque no corresponda. */
            case 2:
                System.out.println("El día 2 es: Martes");
                break;
            case 3:
                System.out.println("El día 3 es: Miércoles");
                break;
            case 4:
                System.out.println("El día 4 es: Jueves");
                break;
            case 5:
                System.out.println("El día 5 es: Viernes");
                break;
            case 6:
                System.out.println("El día 6 es: Sábado");
                break;
            case 7:
                System.out.println("El día 7 es: Domingo");
                break;
            default:
                System.out.println("Número no válido. Debe ser un valor entre 1 y 7.");
/*La palabra clave default en un switch de Java funciona como un caso por defecto, es decir,
se ejecuta cuando ninguno de los case coincide con el valor evaluado.
No es obligatorio usar default.
Pero se recomienda, porque sirve como “seguro” si el valor no encaja con ningún case.
El default puede estar en cualquier parte, no tiene que ir al final.
Pero por claridad, normalmente se coloca al final.
(Si el default se colocase al principio del switch, también necesitaría un break para que el flujo
se detuviera si cumpliera su condición.*/
        }
        sc.close();
/*Ejemplo de salida por consola:
Introduce un número (1-7): 3
El día 3 es: Miércoles */
    }

    public void ejercicio02(){
        /*Desarrolla un programa que pida una letra de calificación (A, B, C, D, F)
        y use un switch para mostrar el mensaje correspondiente: A="Excelente",
        B="Muy bien", C="Bien", D="Suficiente", F="Insuficiente".*/

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce tu calificación (A-F): ");
        char calificacion = sc.next().toUpperCase().charAt(0); // Lee la letra y la pasa a mayúscula
/*sc.next(): lee el siguiente token del Scanner (una palabra separada por espacio, tab o salto de línea).
.toUpperCase(): transforma ese String a mayúsculas.
.charAt(0): devuelve el carácter en la posición 0 (el primer carácter) de la String resultante.
(El char resultante de charAt(0) se almacena en la variable calificacion). */

        switch (calificacion) {
            case 'A':
                System.out.println("Calificación A: Excelente");
                break;
            case 'B':
                System.out.println("Calificación B: Muy bien");
                break;
            case 'C':
                System.out.println("Calificación C: Bien");
                break;
            case 'D':
                System.out.println("Calificación D: Suficiente");
                break;
            case 'F':
                System.out.println("Calificación F: Insuficiente");
                break;
            default:
                System.out.println("Inserción incorrecta. Los valores esperados son A, B, C, D y F.");
        }

/*Ejemplo de salida por consola:
Introduce tu calificación (A-F): B
Calificación B: Muy bien*/
    }

    public void ejercicio03(){
        /*Escribe un programa que pida dos números y una operación (+, -, *, /).
        Usa un switch para realizar la operación correspondiente y mostrar el resultado. */
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        double num1 = sc.nextDouble();
        System.out.print("Introduce el segundo número: ");
        double num2 = sc.nextDouble();
        System.out.print("Introduce la operación (+, -, *, /): ");
        char operacion = sc.next().charAt(0);

        double resultado;

        switch (operacion) {
            case '+':
                resultado = num1 + num2;
                System.out.println("Resultado: " + num1 + " + " + num2 + " = " + resultado);
                break;
            case '-':
                resultado = num1 - num2;
                System.out.println("Resultado: " + num1 + " - " + num2 + " = " + resultado);
                break;
            case '*':
                resultado = num1 * num2;
                System.out.println("Resultado: " + num1 + " * " + num2 + " = " + resultado);
                break;
            case '/':
                if (num2 != 0) {
                    resultado = num1 / num2;
                    System.out.println("Resultado: " + num1 + " / " + num2 + " = " + resultado);
                } else {
                    System.out.println("Error: No se puede dividir entre cero.");
                }
                break;
            default:
                System.out.println("Operación no válida. Debes usar +, -, * o /.");
        }

/*Ejemplo de salida por consola:
Introduce el primer número: 10
Introduce el segundo número: 5
Introduce la operación (+, -, *, /): *
Resultado: 10 * 5 = 50 */
    }

    public void ejercicio04(){
        /*Crea un programa que muestre un menú con 4 opciones: 1=Ver perfil,
        2=Configuración, 3=Ayuda, 4=Salir. Pide al usuario que elija una opción
        y usa un switch para mostrar el mensaje correspondiente a cada opción. */

        Scanner sc = new Scanner(System.in);

        System.out.println("--- MENÚ ---");
        System.out.println("1. Ver perfil");
        System.out.println("2. Configuración");
        System.out.println("3. Ayuda");
        System.out.println("4. Salir");

        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Has seleccionado: Ver perfil");
                break;
            case 2:
                System.out.println("Has seleccionado: Configuración");
                break;
            case 3:
                System.out.println("Has seleccionado: Ayuda");
                break;
            case 4:
                System.out.println("Has seleccionado: Salir");
                break;
            default:
                System.out.println("Opción no válida. Debes elegir un número del 1 al 4.");
        }

        sc.close();

/*Ejemplo de salida por consola:
--- MENÚ ---
1. Ver perfil
2. Configuración
3. Ayuda
4. Salir
Elige una opción: 2
Has seleccionado: Configuración */
    }

    public void ejercicio05(){
        /*Desarrolla un programa que pida un mes (número del 1 al 12) y use un
        switch para determinar la estación del año: Invierno (12, 1, 2),
        Primavera (3, 4, 5), Verano (6, 7, 8), Otoño (9, 10, 11). */

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el número del mes (1-12): ");
        int mes = sc.nextInt();

        String estacion;

        switch (mes) {
            case 12:
            case 1:
            case 2:
                estacion = "Invierno";
                break;
            case 3:
            case 4:
            case 5:
                estacion = "Primavera";
                break;
            case 6:
            case 7:
            case 8:
                estacion = "Verano";
                break;
            case 9:
            case 10:
            case 11:
                estacion = "Otoño";
                break;
            default:
                estacion = "Mes no válido. Debe ser un número del 1 al 12.";
        }

        if (mes >= 1 && mes <= 12) {
            System.out.println("El mes " + mes + " corresponde a: " + estacion);
        } else {
            System.out.println(estacion);
        }

        sc.close();

/*Ejemplo de salida por consola:
Introduce el número del mes (1-12): 7
El mes 7 corresponde a: Verano */
    }

    public void ejercicio06(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int numero = sc.nextInt();

        System.out.println("Tabla del " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
/*Esto es un bucle for, y su estructura general es:
for (inicialización; condición; actualización) {
    // bloque de código que se repite
}
int i = 1 → Inicialización:
Se crea una variable i de tipo int. y se le asigna valor inicial 1.
Esta variable sirve como contador o índice del bucle.
i <= 10 → Condición:
Antes de cada iteración, Java evalúa esta condición.
Mientras sea verdadera, se ejecuta el bloque del bucle.
Cuando sea falsa, el bucle termina.
i++ → Actualización:
Después de ejecutar el bloque del bucle, y en caso de que se
siga cumpliendo la condición, i se incrementa en 1.
 */
        sc.close();
    }

    public void ejercicio07(){
        /*Crea un programa que pida un número N y use un bucle for
        para calcular la suma de todos los números desde 1 hasta N.
        Muestra el resultado final. */

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int n = sc.nextInt();

        int suma = 0;

        System.out.print("Sumando: ");
        for (int i = 1; i <= n; i++) {
            suma += i; // suma = suma + i
/*La clave está en el operador que usamos y cómo funciona la asignación.
suma += i NO es lo mismo que suma = i
suma = i reescribirá la variable suma cada vez con el valor de i,
borrando lo que tenía antes.
suma += i significa:
"toma el valor actual de suma, súmale i, y guarda el resultado de nuevo en suma" */
            System.out.print(i);
            if (i < n) {
                System.out.print(" + ");
            }
        }
        System.out.println(); // salto de línea
        System.out.println("La suma de números del 1 al " + n + " es: " + suma);

        sc.close();
/*System.out.print("Sumando: "); :
Muestra el texto "Sumando: " en la misma línea. No agrega un salto de línea al final.
suma += i; :
Equivalente a suma = suma + i;.
Ejemplo: i = 1 → suma = 0 + 1 = 1 */

/* Ejemplo de salida por consola:
Introduce un número: 5
Sumando: 1 + 2 + 3 + 4 + 5
La suma de números del 1 al 5 es: 15 */
    }

    public void ejercicio08(){
        /*Desarrolla un programa que pida un número N y use un bucle for
        para contar cuántos números pares e impares hay desde 1 hasta N.
        Muestra ambos contadores. */

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int n = sc.nextInt();

        int pares = 0;
        int impares = 0;

        System.out.println("Recorriendo números del 1 al " + n + "...");

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                pares++;      // si el número es par, incrementa el contador de pares
            } else {
                impares++;    // si no, incrementa el contador de impares
            }
        }

        System.out.println("Números pares encontrados: " + pares);
        System.out.println("Números impares encontrados: " + impares);

        sc.close();

/* Ejemplo de salida por consola:
Introduce un número: 10
Recorriendo números del 1 al 10...
Números pares encontrados: 5
Números impares encontrados: 5 */
    }

    public void ejercicio09(){
        /* Escribe un programa que pida un número entero positivo y calcule
        su factorial usando un bucle for. El factorial de N es:
        N! = N × (N-1) × (N-2) × ... × 1 */
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número entero positivo: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("El número debe ser positivo.");
        } else {
            long factorial = 1;
            System.out.println("Calculando " + n + "!");
            for (int i = n; i >= 1; i--) {
                factorial *= i;
                System.out.print(i);
                if (i > 1) {
                    System.out.print(" x ");
                }
            }
            System.out.println();
            System.out.println("El factorial de " + n + " es: " + factorial);
        }

        sc.close();
    }

    public void ejercicio10(){
        /* Crea un programa que muestre un menú con 3 tipos de ejercicios:
        1=Flexiones, 2=Abdominales, 3=Sentadillas.
        Pide al usuario que elija un ejercicio y cuántas repeticiones quiere hacer.
        Usa un switch para determinar el ejercicio y un for para contar las
        repeticiones una a una. */

        Scanner sc = new Scanner(System.in);

        System.out.println("--- EJERCICIOS ---");
        System.out.println("1. Flexiones");
        System.out.println("2. Abdominales");
        System.out.println("3. Sentadillas");
        System.out.print("Elige un ejercicio (1-3): ");
        int opcion = sc.nextInt();

        System.out.print("¿Cuántas repeticiones?: ");
        int repeticiones = sc.nextInt();

        String ejercicio = "";

        switch (opcion) {
            case 1:
                ejercicio = "Flexiones";
                break;
            case 2:
                ejercicio = "Abdominales";
                break;
            case 3:
                ejercicio = "Sentadillas";
                break;
            default:
                System.out.println("Opción no válida.");
                sc.close();
                return;
        }

        System.out.println("Has elegido: " + ejercicio);

        for (int i = 1; i <= repeticiones; i++) {
            System.out.println("Repetición " + i + " completada");
        }

        System.out.println("¡Ejercicio completado! Has hecho " + repeticiones + " " + ejercicio.toLowerCase() + ".");

        sc.close();

/* Ejemplo de salida por consola:
--- EJERCICIOS ---
1. Flexiones
2. Abdominales
3. Sentadillas
Elige un ejercicio (1-3): 1
¿Cuántas repeticiones?: 5
Has elegido: Flexiones
Repetición 1 completada
Repetición 2 completada
Repetición 3 completada
Repetición 4 completada
Repetición 5 completada
¡Ejercicio completado! Has hecho 5 flexiones. */
    }
}