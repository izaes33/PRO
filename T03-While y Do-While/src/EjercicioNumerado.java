import java.util.ArrayList;
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

        Scanner scanner = new Scanner(System.in);

// 1. Pedir al usuario que introduzca el número inicial (N)
        System.out.print("Introduce un número: ");
        int N = scanner.nextInt();

        // Inicializar la variable de conteo (será N al inicio)
        int contador = N;

        System.out.println("Cuenta atrás:");

        // 2. Usar un bucle while para contar desde N hasta 1
        // El bucle se repite MIENTRAS el contador sea mayor o igual a 1
        while (contador >= 1) {

            // Mostrar el valor actual del contador sin salto de línea
            System.out.println(contador);

            // Decrementar el contador
            contador--;
        }

        // 3. Mostrar el mensaje final después de que el bucle termina
        System.out.println("¡Despegue!");

        scanner.close();

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

    public void ejercicio07(){ //Calcular promedio con while
/* Crea un programa que pida al usuario cuántas calificaciones va a introducir.
Luego, usa un bucle while para pedir cada calificación una por una, sumarlas
y al final calcular y mostrar el promedio. */

        Scanner scanner = new Scanner(System.in);

        // 1. Pido el número total de calificaciones
        System.out.print("¿Cuántas calificaciones vas a introducir?: ");
        int totalCalificaciones = scanner.nextInt();

        // Variables para el cálculo
        double sumaTotal = 0.0;
        int contador = 1; // Contador para saber qué calificación estamos pidiendo

        System.out.println("----------------------------------------");

        // 2. Usar el bucle while para pedir y sumar cada calificación
        // El bucle se repite MIENTRAS el contador sea menor o igual al total
        while (contador <= totalCalificaciones) {

            // Pedir la calificación actual
            System.out.print("Introduce la calificación " + contador + ": ");
            double calificacion = scanner.nextDouble();

            // Sumarla al acumulador
            sumaTotal += calificacion;

            // Incrementar el contador
            contador++;
        }

        // 3. Realizar los cálculos finales
        double promedio = 0.0;
        if (totalCalificaciones > 0) {
            promedio = sumaTotal / totalCalificaciones;
        }

        System.out.println("----------------------------------------");

        // 4. Mostrar los resultados
        System.out.println("Suma total: " + sumaTotal);
        // Usamos String.format para mostrar el promedio con dos decimales, como en el ejemplo
        System.out.printf("Promedio de calificaciones: %.2f\n", promedio);

        scanner.close();

/* Ejemplo de salida por consola:
¿Cuántas calificaciones vas a introducir?: 4
Introduce la calificación 1: 7.5
Introduce la calificación 2: 8.0
Introduce la calificación 3: 6.5
Introduce la calificación 4: 9.0
Suma total: 31.0
Promedio de calificaciones: 7.75 */

    }

    public void ejercicio08(){ //Validación de edad con do-while
/* Desarrolla un programa que pida la edad del usuario. Usa un bucle do-while
para validar que la edad introducida esté entre 0 y 120. Si no es válida,
debe volver a pedirla. Una vez válida, muestra un mensaje de confirmación. */

        Scanner scanner = new Scanner(System.in);
        int edad;
        boolean edadValida; // Bandera para controlar la validez

        // El bucle do-while garantiza que se pida la edad al menos una vez
        do {
            System.out.print("Introduce tu edad: ");

            // 1. Verificación de tipo de dato (opcional, pero buena práctica)
            if (scanner.hasNextInt()) {
                edad = scanner.nextInt();

                // 2. Verificación de rango
                if (edad >= 0 && edad <= 120) {
                    edadValida = true; // La edad es válida
                } else {
                    edadValida = false; // La edad está fuera del rango
                    System.out.println("Edad no válida. Debe estar entre 0 y 120.");
                }
            } else {
                // Manejo de entrada no numérica
                System.out.println("Entrada no válida. Por favor, introduce un número entero.");
                scanner.next(); // Consume la entrada no válida para evitar bucle infinito
                edadValida = false; // Forzar la repetición del bucle
                edad = -1; // Asignar un valor seguro para evitar errores de inicialización, aunque no se usará
            }

            // El bucle continúa MIENTRAS la edad NO sea válida
        } while (!edadValida);

        // 3. Mostrar el mensaje de confirmación
        System.out.println("Edad válida: " + edad + " años. ¡Gracias!");

/* Ejemplo de salida por consola:
Introduce tu edad: -5
Edad no válida. Debe estar entre 0 y 120.
Introduce tu edad: 150
Edad no válida. Debe estar entre 0 y 120.
Introduce tu edad: 25
Edad válida: 25 años. ¡Gracias! */

    }

    public void ejercicio09() { //Combinando while, for y switch - Sistema de notas
/* Crea un programa que pida al usuario cuántos estudiantes hay en una clase.
Para cada estudiante, usa un bucle while para pedir su calificación numérica
(0-10). Luego, usa un bucle for para mostrar todas las calificaciones y usa
un switch para convertir cada nota numérica en letra: 9-10=A, 7-8=B, 5-6=C,
3-4=D, 0-2=F. */

        Scanner scanner = new Scanner(System.in);

        // 1. Pedir el número total de estudiantes
        System.out.print("¿Cuántos estudiantes hay?: ");
        int numEstudiantes = scanner.nextInt();

        // Creamos un ArrayList para almacenar las calificaciones
        ArrayList<Integer> calificaciones = new ArrayList<>();
        /* La sintaxis ArrayList<Integer> nombre = new ArrayList<>();
        es la forma estándar en Java de declarar, inicializar y tipificar
        una lista dinámica que contendrá objetos de tipo Integer.
        ---------------------------------------------------------------
        *ArrayList es una clase en el paquete java.util que implementa la
        interfaz List y utiliza un array redimensionable dinámicamente
        para almacenar sus elementos.
        *<Integer>: Esto se conoce como genéricos (Generics). Indica el
        tipo de objeto que puede almacenar la lista. En Java, los arrays
        y ArrayLists no pueden almacenar tipos de datos primitivos
        (int, char, double, etc.) directamente, por lo que usamos la clase
        Wrapper (Integer) que envuelve al primitivo int. */
        //---------------------------------------------------------------
        /* new: Es la palabra clave que se utiliza para crear una nueva
        instancia (un nuevo objeto) de la clase especificada en la memoria.
        *ArrayList<>(): Llama al constructor de la clase ArrayList para crear
        el objeto de lista en sí.
        *La sintaxis de diamante (<>) se introdujo en Java 7 y se llama
        inferencia de tipo. Le dice al compilador que infiera el tipo de genérico
        (que ya se especificó como <Integer> en la declaración) sin tener que
        repetirlo. Es equivalente a escribir new ArrayList<Integer>(). */

        int contador = 1; // Inicializamos el contador para el bucle while

        // 2. Bucle WHILE para la entrada de calificaciones
        while (contador <= numEstudiantes) {
            System.out.print("Introduce la nota del estudiante " + contador + " (0-10): ");

            // Verificamos que sea un entero
            if (scanner.hasNextInt()) {
                int nota = scanner.nextInt();

                // Validación básica de rango (0-10)
                if (nota >= 0 && nota <= 10) {
                    calificaciones.add(nota); // Almacena la nota
                    contador++; // Avanza al siguiente estudiante
                } else {
                    System.out.println("Nota fuera de rango. Debe estar entre 0 y 10. Intenta de nuevo.");
                }
            } else {
                System.out.println("Entrada no válida. Por favor, introduce un número entero.");
                scanner.next(); // Limpiar el buffer de entrada
            }
        }

        scanner.close();

        // 3. Bucle FOR para procesar y mostrar las calificaciones
        System.out.println("--- REPORTE DE CALIFICACIONES ---");

        // Iteramos a través de la lista de calificaciones
        for (int i = 0; i < calificaciones.size(); i++) {
            int notaNumerica = calificaciones.get(i);
            /* Cabecera del Bucle -> Condición de Terminación: i < calificaciones.size():
            calificaciones.size(): Este metodo DEVUELVE EL Nº TOTAL de elementos
            ALMACENADOS actualmente EN EL ARRAYLIST llamado calificaciones.
            ------------------------------------------------
            Cuerpo ->Acceso al Elemento: int notaNumerica = calificaciones.get(i):
            calificaciones.get(i): Este es un método de la clase ArrayList.
            Utiliza el índice actual (i) para recuperar el objeto almacenado
            en esa posición de la lista.
             */
            String letra;
            // 4. Estructura SWITCH para convertir nota a letra
            switch (notaNumerica) {
                case 10:
                case 9:
                    letra = "A";
                    break;
                case 8:
                case 7:
                    letra = "B";
                    break;
                case 6:
                case 5:
                    letra = "C";
                    break;
                case 4:
                case 3:
                    letra = "D";
                    break;
                default:
                    letra = "F";
                    break;
            }

            // Mostrar el resultado
            System.out.println("Estudiante " + (i + 1) + ": " + notaNumerica + " puntos = Calificación " + letra);

        }
/* Ejemplo de salida por consola:
¿Cuántos estudiantes hay?: 3
Introduce la nota del estudiante 1 (0-10): 8
Introduce la nota del estudiante 2 (0-10): 6
Introduce la nota del estudiante 3 (0-10): 9

--- REPORTE DE CALIFICACIONES ---
Estudiante 1: 8 puntos = Calificación B
Estudiante 2: 6 puntos = Calificación C
Estudiante 3: 9 puntos = Calificación A */
    }

    public void ejercicio10(){ //Cajero automático con do-while, switch y while
/* Desarrolla un programa que simule un cajero automático. El saldo inicial es 1000€.
Usa un bucle do-while para mostrar un menú con opciones: 1=Consultar saldo,
2=Retirar dinero, 3=Depositar dinero, 4=Salir. Usa switch para cada opción.
Para retirar dinero, usa un bucle while para validar que no se retire más del saldo
disponible (si intenta retirar más, debe volver a pedir la cantidad). Para depositar,
valida que sea una cantidad positiva. */

        Scanner scanner = new Scanner(System.in);
        // Usamos double para manejar el dinero con decimales.
        double saldo = 1000.00;
        int opcion;

        System.out.println("--- CAJERO AUTOMÁTICO ---");
        System.out.printf("Saldo inicial: %.2f€\n", saldo);

        // El bucle do-while mantiene el menú activo hasta que se elige "Salir"
        do {
            // 1. Mostrar menú
            menu();

            System.out.print("Elige una opción: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                // Consumir el salto de línea pendiente
                scanner.nextLine();

                System.out.println("----------------------------------------");

                // 2. Procesar opción con switch
                switch (opcion) {
                    case 1:
                        consultarSaldo(saldo);
                        break;
                    case 2:
                        saldo = retirarDinero(scanner, saldo);
                        break;
                    case 3:
                        saldo = depositarDinero(scanner, saldo);
                        break;
                    case 4:
                        System.out.println("Gracias por usar el cajero. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, elige un número del 1 al 4.");
                }
            } else {
                System.out.println("Entrada no válida. Por favor, introduce un número.");
                scanner.next(); // Limpiar buffer
                opcion = 0; // Forzar repetición
            }

            System.out.println("----------------------------------------");

            // Repetir MIENTRAS la opción NO sea 4
        } while (opcion != 4);

        scanner.close();
    }

    // Métodos auxiliares para la lógica del cajero

    public static void menu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Depositar dinero");
        System.out.println("4. Salir");
    }

    public static void consultarSaldo(double saldo) {
        System.out.printf("Tu saldo actual es: %.2f€\n", saldo);
    }

    public static double retirarDinero(Scanner scanner, double saldoActual) {
        double cantidadRetiro;
        boolean retiroValido = false;

        // Bucle WHILE para validar que haya fondos suficientes
        while (!retiroValido) {
            System.out.print("¿Cuánto deseas retirar?: ");

            if (scanner.hasNextDouble()) {
                cantidadRetiro = scanner.nextDouble();
                scanner.nextLine(); // Limpiar buffer

                if (cantidadRetiro > 0) {
                    if (cantidadRetiro <= saldoActual) {
                        // Retiro válido
                        saldoActual -= cantidadRetiro;
                        System.out.printf("Retiro exitoso. Has retirado: %.2f€\n", cantidadRetiro);
                        System.out.printf("Nuevo saldo: %.2f€\n", saldoActual);
                        retiroValido = true;
                    } else {
                        // Fondos insuficientes
                        System.out.printf("Fondos insuficientes. Tu saldo es: %.2f€\n", saldoActual);
                    }
                } else {
                    System.out.println("La cantidad a retirar debe ser positiva.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, introduce un valor numérico.");
                scanner.next(); // Limpiar buffer
            }
        }
        return saldoActual;
    }

    public static double depositarDinero(Scanner scanner, double saldoActual) {
        double cantidadDeposito;
        boolean depositoValido = false;

        // Bucle WHILE para validar el depósito
        while (!depositoValido) {
            System.out.print("¿Cuánto deseas depositar?: ");

            if (scanner.hasNextDouble()) {
                cantidadDeposito = scanner.nextDouble();
                scanner.nextLine(); // Limpiar buffer

                if (cantidadDeposito > 0) {
                    // Depósito válido
                    saldoActual += cantidadDeposito;
                    System.out.printf("Depósito exitoso. Has depositado: %.2f€\n", cantidadDeposito);
                    System.out.printf("Nuevo saldo: %.2f€\n", saldoActual);
                    depositoValido = true;
                } else {
                    // Cantidad no positiva
                    System.out.println("El depósito debe ser una cantidad positiva.");
                    scanner.next(); // Limpiar buffer
                }
            } else {
                System.out.println("Entrada inválida. Por favor, introduce un valor numérico positivo.");
                scanner.next(); // Limpiar buffer
            }
        }
        return saldoActual;

/* Ejemplo de salida por consola:
--- CAJERO AUTOMÁTICO ---
Saldo inicial: 1000€

--- MENÚ ---
1. Consultar saldo
2. Retirar dinero
3. Depositar dinero
4. Salir
Elige una opción: 1
Tu saldo actual es: 1000€

--- MENÚ ---
1. Consultar saldo
2. Retirar dinero
3. Depositar dinero
4. Salir
Elige una opción: 2
¿Cuánto deseas retirar?: 1500
Fondos insuficientes. Tu saldo es: 1000€
¿Cuánto deseas retirar?: 300
Retiro exitoso. Has retirado: 300€
Nuevo saldo: 700€

--- MENÚ ---
1. Consultar saldo
2. Retirar dinero
3. Depositar dinero
4. Salir
Elige una opción: 3
¿Cuánto deseas depositar?: 200
Depósito exitoso. Has depositado: 200€
Nuevo saldo: 900€

--- MENÚ ---
1. Consultar saldo
2. Retirar dinero
3. Depositar dinero
4. Salir
Elige una opción: 4
Gracias por usar el cajero. ¡Hasta luego! */
    }
}
