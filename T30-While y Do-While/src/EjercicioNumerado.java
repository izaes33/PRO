import java.util.Scanner;
import java.util.Random; /*He utilizado la clase Random para que
el número secreto del ejercicio04 sea diferente cada vez que se ejecute
el programa */

public class EjercicioNumerado {

    public void ejercicio01(){ //Contador básico con while
/*Crea un programa que pida un número N y use un bucle while para contar
desde 1 hasta N, mostrando cada número. */

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int numeroN = sc.nextInt();

        System.out.print("Contando con while: ");

        int contador=1;
        while (contador <=numeroN) {
            System.out.println(contador);
            contador++;
        }
        System.out.print("Fin del conteo.");

        /* Ejemplo de salida por consola:
        Introduce un número: 5
        Contando con while:
        1
        2
        3
        4
        5
        Fin del conteo */
    }

    public void ejercicio02(){ //Validación de contraseña con do-while
/* Desarrolla un programa que pida al usuario una contraseña. La contraseña
correcta es "1234". Usa un bucle do-while para seguir pidiendo la contraseña
hasta que el usuario la introduzca correctamente. */

/* El bucle do-while es ideal para esto porque ejecuta el bloque de código
al menos una vez antes de verificar la condición. */

        Scanner sc = new Scanner(System.in);

        String passUsuario;
        final String PASS_CORRECTA = "1234";

        do {
            // Pide la contraseña
            System.out.print("Introduce la contraseña: ");
            passUsuario = sc.nextLine();

            // Comprueba si la contraseña introducida es incorrecta
            if (!passUsuario.equals(PASS_CORRECTA)) {
                System.out.println("Contraseña incorrecta. Intenta de nuevo.");
            }
            /* La condición del 'while' es: repetir el bucle MIENTRAS
            la contraseña sea incorrecta.
            La razón por la que la condición del while es "repetir mientras la
            contraseña sea incorrecta" se basa en cómo las estructuras de control
            (if, while, do-while) funcionan con valores booleanos (true o false).
            (El bucle do-while opera bajo el principio de continuación: repite
            el bloque de código (el do) si y solo si la condición del while es
            evaluada como true).
             */
        } while (!passUsuario.equals(PASS_CORRECTA));
        System.out.println("¡Contraseña correcta! Acceso permitido.");

        /* Ejemplo de salida por consola:
        Introduce la contraseña: hola
        Contraseña incorrecta. Intenta de nuevo.
        Introduce la contraseña: 5678
        Contraseña incorrecta. Intenta de nuevo.
        Introduce la contraseña: 1234
        ¡Contraseña correcta! Acceso permitido. */
    }

    public void ejercicio03(){ //Suma acumulativa con while
/* Escribe un programa que pida números al usuario y los vaya sumando.
El bucle while debe continuar mientras el usuario introduzca números
positivos. Cuando introduzca un número negativo o cero, el programa
debe terminar y mostrar la suma total. */

        Scanner sc = new Scanner(System.in);

        int sumaTotal=0; // Variable para acumular la suma de los números
        int numero = 1; // Variable para almacenar el número introducido en cada iteración
        // (Inicializamos 'numero' con un valor positivo para asegurar la primera ejecución del bucle)

        System.out.println("--- Sumador de Números Positivos ---");

        while (numero > 0) {  // El bucle while se ejecutará MIENTRAS el número introducido sea mayor que cero.

            System.out.print("Introduce un número (0 o negativo para terminar): ");
            numero = sc.nextInt();

            if (numero > 0) { //Comprobar si el número sigue siendo positivo (la condición del bucle)
                sumaTotal += numero;
                System.out.println("Suma actual: " + sumaTotal);
            }
            // Si el número es 0 o negativo, el 'if' se salta y la condición
            // del 'while' (numero > 0) será falsa en la siguiente verificación,
            // deteniendo el bucle.
        }

        System.out.println("Programa terminado. Suma total: " + sumaTotal);

/* Ejemplo de salida por consola:
Introduce un número (0 o negativo para terminar): 5
Suma actual: 5
Introduce un número (0 o negativo para terminar): 10
Suma actual: 15
Introduce un número (0 o negativo para terminar): 3
Suma actual: 18
Introduce un número (0 o negativo para terminar): 0
Programa terminado. Suma total: 18 */
    }

    public void ejercicio04(){ //Adivinar número con do-while
/* Crea un juego donde el programa elige un número secreto entre 1 y 10
(por ejemplo, 7). Usa un bucle do-while para pedir al usuario que adivine
el número. El programa debe indicar si el número es mayor o menor,
y continuar hasta que el usuario acierte. */

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        final int NUMERO_SECRETO = random.nextInt(10) + 1;
        /* Delaro una constante en la que se llama al metodo nextInt del objeto random,
        de la clase Random importada al principio de EjercicioNumerado;
        El argumento 10 le dice al generador que produzca un número entero,
        empezando desde 0 e incluyendo todos los números hasta el 9.
        +1 Suma la unidad 1 al número aleatorio que acaba de generar random.nextInt(10),
        desplazando el rango de números (0+1=1 ; 9+1=10) */

        int intento;
        int contadorIntentos = 0;

        System.out.println("¡Adivina el número entre 1 y 10!");

        // El bucle do-while garantiza que se pida el número al menos una vez
        do {
            // Incrementar el contador de intentos
            contadorIntentos++;

            // Pedir el intento al usuario
            System.out.print("Introduce tu intento: ");

            // Asegurarse de que la entrada sea un entero válido
            if (sc.hasNextInt()) {
                intento = sc.nextInt();
                /* El método sc.hasNextInt() (donde sc es un objeto Scanner) realiza la siguiente verificación:
                Inspecciona la Siguiente Ficha (Token), verifica el Formato y devuelve un booleano */

                // Evaluar si el intento es correcto, mayor o menor
                if (intento < NUMERO_SECRETO) {
                    System.out.println("El número es mayor. Intenta de nuevo.");
                } else if (intento > NUMERO_SECRETO) {
                    System.out.println("El número es menor. Intenta de nuevo.");
                }
            } else {
                // Manejar entradas no numéricas
                System.out.println("Entrada inválida. Por favor, introduce un número entero.");
                sc.next(); // Limpiar el buffer de entrada
                intento = 0; // Asignar un valor que no detiene el bucle
            }

            // El bucle continúa MIENTRAS el intento NO sea igual al número secreto
        } while (intento != NUMERO_SECRETO);

        // Mensaje final cuando se acierta el número
        System.out.println("¡Correcto! Has adivinado el número en " + contadorIntentos + " intentos.");

        sc.close();

/* Ejemplo de salida por consola:
¡Adivina el número entre 1 y 10!
Introduce tu intento: 5
El número es mayor. Intenta de nuevo.
Introduce tu intento: 8
El número es menor. Intenta de nuevo.
Introduce tu intento: 7
¡Correcto! Has adivinado el número en 3 intentos. */
    }

    public void ejercicio05(){ //Menú interactivo con do-while y switch
/* Desarrolla un programa con un menú que se repita usando do-while.
El menú debe tener 4 opciones: 1=Saludar, 2=Despedirse, 3=Ver hora actual
(puedes mostrar un mensaje fijo), 4=Salir. Usa switch para procesar cada opción.
El programa solo debe terminar cuando el usuario elija la opción 4. */

        Scanner scanner = new Scanner(System.in);
        int opcion;

        // El bucle do-while garantiza que el menú se muestre al menos una vez
        do {
            // 1. Mostrar el menú
            mostrarMenu();

            // 2. Leer la opción del usuario
            System.out.print("Elige una opción: ");

            // Verificamos que la entrada sea un entero antes de leerla
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();

                // Consumir el salto de línea pendiente después de nextInt()
                scanner.nextLine();
                /* El código scanner.nextLine(); después de un scanner.nextInt()
                (o nextDouble(), nextFloat(), etc.) es una técnica común para limpiar el
                buffer de entrada del Scanner y evitar un error de lectura en la siguiente lectura
                (si la hubiera);
                (CUANDO introduces un número (por ejemplo, 5) y PRESIONAS ENTER,
                EL FLUJO DE ENTRADA (BUFFER) RECIBE dos cosas: El número que tecleaste,
                Y El CARACTER DE SALTO DE LINEA \n, PERO EL METODO SCANNER.nextInt() lee y consume
                solo los caracteres del número (5) y DEJA EL CARACTER DE SALTO DE LINEA (\n)
                PENDIENTE EN EL BUFFER.
                Por lo tanto si la siguiente instrucción que usas para leer entrada es otra llamada a
                scanner.next...(), el metodo no espera a que el usuario escriba nada, porque
                encuentra y consume el carácter \n que dejó pendiente el nextInt()). */

                // 3. Procesar la opción usando switch
                switch (opcion) {
                    case 1:
                        System.out.println("¡Hola! ¿Cómo estás?");
                        break;
                    case 2:
                        System.out.println("¡Adiós! Que tengas un buen día.");
                        break;
                    case 3:
                        // Mensaje fijo para simular la hora
                        System.out.println("La hora actual es: 13:12 CET");
                        break;
                    case 4:
                        System.out.println("Saliendo del programa. ¡Hasta pronto!");
                        break;
                    default:
                        // Mensaje para opciones no válidas (ej. 5, -1)
                        System.out.println("Opción no válida. Por favor, elige un número entre 1 y 4.");
                }
            } else {
                // Manejo de entrada no numérica
                System.out.println("Entrada inválida. Por favor, introduce un número.");
                scanner.next(); // Limpiar el buffer de entrada para evitar un bucle infinito
                /* Si el usuario ingresara un texto no numérico (ej: "hola"), la condición
                scanner.hasNextInt() devolvería false y el programa entraría en el else. Y,
                si dentro del else no se incluyera scanner.next();, el buffer de entrada seguiría
                conteniendo la ficha no consumida ("hola"). En la siguiente iteración del do-while,
                el scanner.hasNextInt() volvería a ver "hola", devolvería false y entraría en el else
                ad infinitum, repitiendo el mensaje de error sin dejar al usuario ingresar un nuevo valor. */
                opcion = 0; // Asignar 0 para que el bucle continúe
                /* asegura que el bucle do-while continúe a pesar del error de entrada, ya que el bucle
                do-while se repite mientras opcion != 4, y por ello se asigna un 0 a la variable opcion. */
            }

            System.out.println("----------------------------------------"); // Separador

            // El bucle se repite MIENTRAS la opción NO sea 4
        } while (opcion != 4);

        scanner.close();
        }

    // Método auxiliar para mantener el código principal limpio
    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Saludar");
        System.out.println("2. Despedirse");
        System.out.println("3. Ver hora");
        System.out.println("4. Salir");

/* Ejemplo de salida por consola:
--- MENÚ ---
1. Saludar
2. Despedirse
3. Ver hora
4. Salir
Elige una opción: 1
¡Hola! ¿Cómo estás? */
    }

    public void ejercicio06(){ //Cuenta atrás con while
/*Escribe un programa que pida un número N y use un bucle while para
hacer una cuenta atrás desde N hasta 1, mostrando cada número.
Al llegar a 1, debe mostrar "¡Despegue!". */



/* Ejemplo de salida por consola:
Introduce un número: 5
Cuenta atrás:
5
4
3
2
1
¡Despegue! */
    }
}
