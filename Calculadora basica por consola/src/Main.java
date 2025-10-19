import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //  Declara y crea un objeto de la clase 'Scanner'.
        //  Esta clase, importada desde 'java.util', permite leer la entrada de datos del usuario.
        //  'System.in' indica que la fuente de datos es la entrada estándar (la consola o terminal).

        double num1, num2, resultado;
        //  ^ Declara tres variables de tipo 'double'.
        //  'double' se usa para números de punto flotante (con decimales) para permitir cálculos más precisos
        //  y aceptar cualquier tipo de número real como entrada.

        char operacion;
        //  ^ Declara una variable de tipo 'char' (carácter) para almacenar el operador matemático
        //  que el usuario elija ('+', '-', '*', '/').

        System.out.print("Ingresa el primer número: ");
        num1 = scanner.nextDouble();
        //  ^ Muestra un mensaje y luego lee el siguiente valor 'double' que el usuario ingrese en la consola
        //  y lo asigna a la variable 'num1'.

        System.out.print("Selecciona la operación (+, -, *, /): ");
        operacion = scanner.next().charAt(0);
        //  ^ Muestra un mensaje y luego lee la entrada del usuario:
        //    - 'scanner.next()' lee el siguiente "token" (palabra o símbolo) ingresado.
        //    - '.charAt(0)' toma el primer carácter de esa entrada, asegurando que solo se almacene el símbolo de la operación.

        System.out.print("Ingresa el segundo número: ");
        num2 = scanner.nextDouble();
        //  ^ Lee el segundo número de tipo 'double' del usuario y lo asigna a 'num2'.

        // 2. Estructura de Control (Lógica de la Calculadora)
        resultado = 0; // Inicializa el resultado antes del switch (buena práctica).

        switch (operacion) {
            // ^ La estructura 'switch' evalúa el valor de la variable 'operacion'
            //   y ejecuta el bloque de código asociado al 'case' que coincida.

            case '+':
                resultado = num1 + num2;
                break; // 'break' es crucial: termina la ejecución del 'switch' para que no se ejecuten los siguientes 'case'.

            case '-':
                resultado = num1 - num2;
                break;

            case '*':
                resultado = num1 * num2;
                break;

            case '/':
                // 3. Validación de Errores
                if (num2 != 0) {
                    // ^ Estructura de control 'if': Verifica la condición para evitar un error de tiempo de ejecución (ArithmeticException).
                    resultado = num1 / num2;
                } else {
                    // ^ Bloque 'else': Se ejecuta si la condición (num2 != 0) es falsa (es decir, num2 es cero).
                    System.out.println("Error: No se puede dividir por cero.");
                    return; // 'return' termina la ejecución del método 'main' y, por lo tanto, del programa.
                }
                break;

            default:
                // ^ El 'default' se ejecuta si el valor de 'operacion' no coincide con ninguno de los 'case' anteriores.
                System.out.println("Operación no válida.");
                return; // Termina el programa si la operación ingresada es incorrecta.
        }

        // 4. Salida
        System.out.println("---------------------------------");
        System.out.println("Resultado: " + num1 + " " + operacion + " " + num2 + " = " + resultado);
        // ^ Muestra el resultado final al usuario, concatenando las variables ('num1', 'operacion', 'num2', 'resultado')
        //   con texto estático (cadenas de caracteres).

        // 5. Cierre
        scanner.close();
        // ^ Cierra el objeto 'Scanner'. Es una buena práctica para liberar los recursos del sistema (en este caso, la conexión a la entrada del sistema).
    }
}
