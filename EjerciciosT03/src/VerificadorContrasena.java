/*Crea un programa que pida al usuario crear una contraseña.
        La contraseña debe cumplir estos requisitos: tener al menos 8 caracteres
        de longitud, contener al menos un número, y NO puede ser "12345678" o
        "password". El programa debe verificar cada condición por separado
        usando operadores lógicos y mostrar si la contraseña es válida o no,
        indicando qué requisitos no cumple.

        Nota: Para este ejercicio, asume que tienes funciones auxiliares como
        longitudCadena(texto), contienNumero(texto).

Ejemplo de salida por consola:
Introduce una contraseña: abc123
Longitud de la contraseña: 6
¿Tiene al menos 8 caracteres?: false
¿Contiene al menos un número?: true
¿Es una contraseña prohibida?: false
¿Es válida? (cumple todos los requisitos): false
Contraseña NO válida. Debe tener al menos 8 caracteres.*/

/*Explicación:
import java.util.Scanner;
Traemos la clase Scanner, que sirve para leer texto desde la consola (entrada estándar).
public class VerificadorContrasena { ... }
Declaramos la clase que contiene todo el programa.
longitudCadena(String texto)
Método auxiliar que devuelve texto.length().
length() cuenta cuántos caracteres hay en la cadena (espacios incluidos).
contieneNumero(String texto)
Recorre cada carácter de la cadena con for (char c : texto.toCharArray()).
Usa Character.isDigit(c) para saber si el carácter es un dígito (0 a 9).
Devuelve true en cuanto encuentre uno; si no encuentra ninguno devuelve false.
Scanner sc = new Scanner(System.in);
Creamos un lector para leer lo que el usuario escribe en la consola.
sc.nextLine() lee una línea completa (hasta que el usuario pulsa Enter).
Cálculo de comprobaciones individuales:
int longitud = longitudCadena(contrasena); → número de caracteres.
boolean tieneLongitud = longitud >= 8; → true si longitud es 8 o más.
boolean tieneNumero = contieneNumero(contrasena); → true si hay algún dígito.
boolean esProhibida = contrasena.equals("12345678") || contrasena.equalsIgnoreCase("password");
equals compara exacto (case-sensitive). Para "12345678" usamos equals.
equalsIgnoreCase compara ignorando mayúsculas/minúsculas: así "Password", "PASSWORD" o "password" se tratan igual.
boolean esValida = tieneLongitud && tieneNumero && !esProhibida;
Aquí usamos operadores lógicos:
&& (AND): todas las condiciones a ambos lados deben ser true.
! (NOT): niega el valor booleano (si esProhibida es true, !esProhibida es false).
La contraseña solo es válida si tiene longitud, contiene número y no es prohibida.
Impresión de resultados:
Primero mostramos cada chequeo por separado — así sabes qué comprueba el programa.
Luego, si esValida es true, imprimimos "Contraseña válida."
Si no es válida, imprimimos todos los requisitos que no cumple. Importante: no solo el primero;
mostramos todos los que fallen. Esto ayuda al usuario a corregir la contraseña.
sc.close();
Nota: si la aplicación sigue pidiendo entradas más adelante, cerrar el scanner al final del programa;
cerrar System.in puede impedir más lecturas si se vuelve a intentar leer con otro Scanner.
Conceptos lógicos en palabras simples
Comprobar cada condición por separado: hacemos tieneLongitud, tieneNumero y esProhibida por separado
para poder mostrar cada resultado por pantalla y saber exactamente qué falla.
Operadores lógicos:
&& (AND): ambas condiciones deben ser verdaderas.
|| (OR): al menos una debe ser verdadera.
! (NOT): invierte verdadero ↔ falso.
Por qué equalsIgnoreCase para "password": la gente puede escribir "Password" o "PASSWORD";
queremos prohibir cualquiera de esas variantes, así que comparamos sin considerar mayúsculas.
Mostrar todos los fallos: si la contraseña no tiene longitud y además no tiene número,
el programa mostrará las dos fallas; así el usuario no arregla solo una y sigue fallando.*/
import java.util.Scanner;

public class VerificadorContrasena {

    /**
     * Devuelve la longitud de la cadena recibida.
     * (Función auxiliar solicitada en el enunciado.)
     */
    public static int longitudCadena(String texto) {
        // length() devuelve el número de caracteres de la cadena
        return texto.length();
    }

    /**
     * Comprueba si la cadena contiene al menos un dígito.
     * (Función auxiliar solicitada en el enunciado.)
     */
    public static boolean contieneNumero(String texto) {
        // Recorremos cada carácter de la cadena
        for (char c : texto.toCharArray()) {
            // Character.isDigit(c) devuelve true si 'c' es un dígito (0-9)
            if (Character.isDigit(c)) {
                return true; // encontramos al menos un número → devolvemos true
            }
        }
        return false; // no se encontró ningún dígito → devolvemos false
    }

    /**
     * Método que pide al usuario una contraseña y verifica todas las condiciones.
     * Muestra por consola cada chequeo por separado y, si no es válida, indica
     * exactamente qué requisitos no cumple (puede listar varios).
     */
    public static void crearContrasena() {
        Scanner sc = new Scanner(System.in); // lector para entrada por consola

        // Pedimos la contraseña al usuario
        System.out.print("Introduce una contraseña: ");
        String contrasena = sc.nextLine();

        // --- Comprobaciones individuales ---
        int longitud = longitudCadena(contrasena);        // longitud de la cadena
        boolean tieneLongitud = longitud >= 8;           // true si tiene al menos 8 caracteres
        boolean tieneNumero = contieneNumero(contrasena); // true si contiene al menos un número
        // Consideramos dos contraseñas explícitamente prohibidas:
        // "12345678" (exacto) y "password" (sin diferenciar mayúsculas/minúsculas)
        boolean esProhibida = contrasena.equals("12345678") || contrasena.equalsIgnoreCase("password");

        // La contraseña es válida SOLO si cumple longitud, tiene número y NO es prohibida
        boolean esValida = tieneLongitud && tieneNumero && !esProhibida;

        // --- Salida con el formato que pediste ---
        System.out.println("Longitud de la contraseña: " + longitud);
        System.out.println("¿Tiene al menos 8 caracteres?: " + tieneLongitud);
        System.out.println("¿Contiene al menos un número?: " + tieneNumero);
        System.out.println("¿Es una contraseña prohibida?: " + esProhibida);
        System.out.println("¿Es válida? (cumple todos los requisitos): " + esValida);

        // Mensaje final: si no es válida, indicamos exactamente todos los requisitos que falla
        if (esValida) {
            System.out.println("Contraseña válida.");
        } else {
            System.out.println("Contraseña NO válida. Requisitos no cumplidos:");
            // Aquí comprobamos cada requisito por separado y los mostramos todos los que fallen
            if (!tieneLongitud) {
                System.out.println(" - Debe tener al menos 8 caracteres.");
            }
            if (!tieneNumero) {
                System.out.println(" - Debe contener al menos un número.");
            }
            if (esProhibida) {
                System.out.println(" - No puede ser una contraseña prohibida (por ejemplo: '12345678' o 'password').");
            }
        }

        sc.close(); // cerramos el scanner (libera el recurso). Si vas a pedir más entradas, evita cerrarlo aquí.
    }

    // main para ejecutar y probar el programa
    public static void main(String[] args) {
        crearContrasena();
    }
}
