/* Crea una aplicación que simule el funcionamiento del wordle. Para ello realiza
las siguientes acciones:
a. Crea una palabra de 5 letras. (funcionará como la palabra a adivinar)
b. El programa debe seleccionar aleatoriamente una palabra del array y
almacenarla como la palabra secreta.
c. El usuario tiene 5 intentos como máximo para adivinar la palabra secreta.
d. En cada intento, el usuario introduce una palabra por teclado.
e. Tras cada intento, el programa debe indicar al usuario:
i. Aciertos: cuántas letras tiene en la misma posición que la palabra
secreta.
ii. Aproximaciones: cuántas letras están en la palabra secreta, pero en una
posición diferente.
iii. Fallos: cuántas letras no están presentes en la palabra secreta.
El juego termina cuando el usuario adivina la palabra o se acaban los 5 intentos. */

package Ejercicio02_WordleSimulator;

import java.util.Scanner;
import java.util.Random;

public class Main {

    // Lista de palabras de 5 letras para el juego (a)
    private static final String[] PALABRAS_DISPONIBLES = {
            "LIBRO", "CALDO", "PERRO", "NOCHE"
    };
    private static final int LONGITUD_PALABRA = 5;
    private static final int INTENTOS_MAXIMOS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // b. Seleccionar aleatoriamente la palabra secreta
        Random random = new Random();
        String palabraSecreta = PALABRAS_DISPONIBLES[random.nextInt(PALABRAS_DISPONIBLES.length)];
        /*Esta línea de código en Java selecciona una palabra aleatoria de un array de cadenas
        (String[]) y la asigna a una nueva variable, realizando 3 acciones principales:
        1 -> Obtener el Límite Superior del Índice (PALABRAS_DISPONIBLES.length)
        2 -> Generar el Índice Aleatorio (random.nextInt(...))
        3 -> Acceder al Elemento y Asignar la Palabra (PALABRAS_DISPONIBLES[...])
        El resultado del paso 2 (el número aleatorio) se utiliza como el índice
        dentro de los corchetes [...] del array.
        (PALABRAS_DISPONIBLES[índice_aleatorio] accede y recupera la String que se encuentra
        en esa posición específica del array.)
String palabraSecreta = ... toma la cadena recuperada y la almacena en la variable palabraSecreta, que es la que el usuario debe adivinar. */

        int intentosRestantes = INTENTOS_MAXIMOS;
        boolean adivinado = false;
        String intentoUsuario;

        System.out.println("--- JUEGO WORDLE SIMULADO ---");
        System.out.println("Tienes que adivinar una palabra de " + LONGITUD_PALABRA + " letras.");
        System.out.println("Tienes " + INTENTOS_MAXIMOS + " intentos.");
        System.out.println("---------------------------------");

        // c. Bucle principal del juego (máximo 5 intentos)
        while (intentosRestantes > 0 && !adivinado) {
            System.out.println("Intentos restantes: " + intentosRestantes);

            // d. El usuario introduce una palabra por teclado (con validación básica)
            do {
                System.out.print("Introduce tu palabra (" + LONGITUD_PALABRA + " letras): ");

                // Leer la línea completa y convertirla a mayúsculas
                // Se asume que scanner.hasNextLine() siempre será verdadero en un flujo de consola estándar
                intentoUsuario = scanner.nextLine().toUpperCase();

                // VALIDACIÓN: Comprobar si la longitud es incorrecta
                if (intentoUsuario.length() != LONGITUD_PALABRA) {
                    System.out.println("---------------------------------------------------------");
                    System.out.println("ERROR: La palabra introducida debe contener 5 caracteres!");
                    System.out.println("---------------------------------------------------------");
                }
                // El bucle repite MIENTRAS la longitud no sea la correcta.
            } while (intentoUsuario.length() != LONGITUD_PALABRA);

            // Verificar si acertó
            if (intentoUsuario.equals(palabraSecreta)) {
                adivinado = true;
                break; // Salir del bucle
            }

            // e. Calcular y mostrar resultados
            evaluarIntento(palabraSecreta, intentoUsuario);
            //Llama al metodo de la linea 108, y le pasa el valor de las variables
            //a sus parametros

            intentosRestantes--;
        }

        // Resultado final
        System.out.println("\n=================================");
        if (adivinado) {
            System.out.println("¡🎉 FELICIDADES! Has adivinado la palabra: " + palabraSecreta);
        } else {
            System.out.println("¡OH NO! Te has quedado sin intentos.");
            System.out.println("La palabra secreta era: " + palabraSecreta);
        }
        System.out.println("=================================");

        scanner.close();
    }

    /**
     * Evalúa el intento del usuario y muestra Aciertos, Aproximaciones y Fallos.
     *
     * @param secreta La palabra a adivinar.
     * @param intento La palabra introducida por el usuario.
     */
    private static void evaluarIntento(String secreta, String intento) {
        /* Aquí, palabraSecreta e intentoUsuario son las variables originales que existen en el
        ámbito del método main. Cuando se ejecuta la llamada, Java hace lo siguiente por posición:
        El valor almacenado en la variable palabraSecreta se copia y se asigna al parámetro local secreta.
        El valor almacenado en la variable intentoUsuario se copia y se asigna al parámetro local intento.
        Una vez dentro del método evaluarIntento las variables originales (palabraSecreta e intentoUsuario)
        dejan de ser accesibles. El código (incluido el bucle for) solo conoce y utiliza los nombres secreta e intento. */

        int aciertos = 0;       // Letra correcta en posición correcta (i)
        int aproximaciones = 0;  // Letra correcta en posición incorrecta (ii)

        // Usamos un array de booleanos para marcar las letras de la palabra secreta
        // van a contarse como Acierto o Aproximación.
        boolean[] secretaUsada = new boolean[LONGITUD_PALABRA];
        /* boolean[]	Tipo de Dato	Declara que la variable
           almacenará un array de valores booleanos (true o false).
        * new boolean[...]	- Inicialización:	Crea la estructura del array en la memoria.
        * [LONGITUD_PALABRA]	- Tamaño:	Define el número exacto de elementos en el array. Su tamaño es igual
          a la constante que define el número de letras de la palabra (5, en este caso).
        (El propósito de secretaUsada es actuar como un mapa de banderas o marcadores sobre la palabra secreta).
        Inicialización de Banderas:
        Cuando se ejecuta la línea, se crea un array de 5 elementos (si LONGITUD_PALABRA es 5),
        y por defecto, todos sus valores son false.
        * Durante la primera pasada del código (donde se buscan los aciertos o casillas verdes):
        Si la letra del usuario coincide exactamente con la letra secreta en la posición $i$,
        se considera un acierto.En ese momento, se marca la bandera: secretaUsada[i] = true;.
        Esto garantiza que si una letra es contada como un acierto (verde), la lógica de
        la segunda pasada (donde se buscan las aproximaciones o casillas amarillas) ignorará
        esa posición de la palabra secreta, ya que esa letra ya ha cumplido su función.
        Sin este mecanismo, una sola letra correcta en la palabra secreta podría contarse
        varias veces si el usuario la intenta en diferentes posiciones, rompiendo la lógica
        del juego.
         */

        // --- PRIMERA PASADA: ENCONTRAR ACIERTOS (Verdes) ---
        for (int i = 0; i < LONGITUD_PALABRA; i++) { //El bucle itera cinco veces (para una palabra de 5 letras),
            // con el índice i yendo de 0 a 4.
            if (intento.charAt(i) == secreta.charAt(i)) { // es la comparación de posición y letra.
                aciertos++; //Incrementa el contador de aciertos (la variable que se mostrará como "Aciertos").
                secretaUsada[i] = true; // Aquí es donde se utiliza la bandera. Al establecer el valor true
                // en el índice i del array secretaUsada, estás diciendo: "La letra secreta en
                // esta posición ya ha sido contada, no la consideres para las aproximaciones."
            }
        }

        // --- SEGUNDA PASADA: ENCONTRAR APROXIMACIONES (Amarillas) ---
        /*La segunda pasada en el código simula la lógica de las casillas amarillas de Wordle:
        las aproximaciones. Su objetivo es contar cuántas letras del intento están presentes
        en la palabra secreta, pero en una posición diferente a la que el usuario las
        introdujo. Esta Esta sección debe ser ejecutada después de la primera pasada
        (la de los aciertos) para evitar confusiones y errores de doble conteo. */

        //Este bloque utiliza dos bucles anidados (for con índices i y j) para comparar cada letra
        // del intento (i) con cada letra de la palabra secreta (j).
        for (int i = 0; i < LONGITUD_PALABRA; i++) {
            //El índice i recorre cada letra de la palabra introducida por el usuario (intento).
            //Filtro de Aciertos: La condición if (intento.charAt(i) != secreta.charAt(i)) es esencial.
            // Solo procesa la letra del intento si no fue un acierto directo (verde) en la primera pasada.
            // Si la letra ya es verde, se salta este if para pasar a la siguiente letra del intento.
            if (intento.charAt(i) != secreta.charAt(i)) {

                for (int j = 0; j < LONGITUD_PALABRA; j++) {
                    if (!secretaUsada[j] && intento.charAt(i) == secreta.charAt(j)) { /*
                        Para cada letra no-acertada del intento (i), el índice j recorre cada letra de la
                        palabra secreta.
                        El if anidado tiene dos partes clave que deben ser ambas verdaderas (&&):
                        * !secretaUsada[j]: Asegura que la letra secreta en la posición j aún no
                        haya sido contada (ni como acierto ni como aproximación anterior).
                        Si ya es true (fue usada), esta parte es false.
                        * intento.charAt(i) == secreta.charAt(j): Verifica que la letra del intento (i) coincida con la
                        letra secreta (j) en alguna posición. */
                        aproximaciones++;
                        secretaUsada[j] = true; // Marca la letra secreta como usada para esta aproximación
                        break; // Sale del bucle interior, ya que se encontró una coincidencia para la letra i
                    }
                }
            }
        }

        // Los fallos son las letras que no fueron Aciertos ni Aproximaciones.
        // Como solo reportamos 3 categorías, podemos inferir los fallos restando.
        // En el Wordle real, se indica qué letras NO existen en la palabra secreta.
        int fallos = LONGITUD_PALABRA - (aciertos + aproximaciones);

        System.out.println("---------------------------------------------------------");
        System.out.println("Resultados:");
        System.out.println("Aciertos: " + aciertos + " (Letra y posición correctas)");
        System.out.println("Aproximaciones: " + aproximaciones + " (Letra correcta, posición incorrecta)");
        // iii. Fallos: Esta métrica es más compleja de calcular de forma precisa en este contexto simple,
        // pero se puede inferir que las letras restantes fueron fallos.
        System.out.println("Fallos: " + fallos + " letras restantes no fueron Aciertos/Aproximaciones.");
        System.out.println("---------------------------------------------------------");

    }
}