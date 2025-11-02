import java.util.Scanner;

public class EjercicioNumerado {

    public void ejercicio01() {  //Operadores aritméticos básicos
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        int primerNumero = lectorTeclado.nextInt();
        lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce el segundo número: ");
        int segundoNumero = lectorTeclado.nextInt();

        int suma = primerNumero + segundoNumero;
        int resta = primerNumero - segundoNumero;
        int multiplicacion = primerNumero * segundoNumero;
        int division = primerNumero / segundoNumero;
        int modulo = primerNumero % segundoNumero;


        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicación: " + multiplicacion);
        System.out.println("División: " + division);
        System.out.println("Módulo (resto): " + modulo);

        lectorTeclado.close();
    }

    public void ejercicio02() {  //Comparación de números
        Scanner lectorTeclado = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        int primerNumero = lectorTeclado.nextInt();
        System.out.print("Introduce el segundo número: ");
        int segundoNumero = lectorTeclado.nextInt();

        boolean mayorQue = primerNumero > segundoNumero;
        boolean menorQue = primerNumero < segundoNumero;
        boolean igual = primerNumero == segundoNumero;
        boolean diferente = primerNumero != segundoNumero;
        boolean mayorOIgual = primerNumero >= segundoNumero;
        boolean menorOIgual = primerNumero <= segundoNumero;

        System.out.println("¿" + primerNumero + " es mayor que " + segundoNumero + "?: " + mayorQue);
        System.out.println("¿" + primerNumero + " es menor que " + segundoNumero + "?: " + menorQue);
        System.out.println("¿" + primerNumero + " es igual que " + segundoNumero + "?: " + igual);
        System.out.println("¿" + primerNumero + " es diferente que " + segundoNumero + "?: " + diferente);
        System.out.println("¿" + primerNumero + " es mayor o igual que " + segundoNumero + "?: " + mayorOIgual);
        System.out.println("¿" + primerNumero + " es menor o igual que " + segundoNumero + "?: " + menorOIgual);

        lectorTeclado.close();
    }

    public void ejercicio03() {  //Operadores de asignación compuesta
        int valorInicial = 100;
        System.out.println("Valor inicial: " + valorInicial);
        int suma = 50;
        int trasSumar = valorInicial += suma;
        System.out.println("Después de sumar " + suma + " (+=): " + trasSumar);
        int resta = 30;
        int trasResta = trasSumar -= resta;
        System.out.println("Después de restar " + resta + " (-=): " + trasResta);
        int multiplica = 2;
        int trasMultiplicacion = trasResta *= multiplica;
        System.out.println("Después de multiplicar por " + multiplica + " (*=): " + trasMultiplicacion);
        int divide = 4;
        int trasDividir = trasMultiplicacion /= divide;
        System.out.println("Después de dividir entre " + divide + " (/=): " + trasDividir);
    }

    public void ejercicio04() { //Numero par o impar
        Scanner lectorTeclado = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int numeroIntroducido = lectorTeclado.nextInt();

        int modulo = numeroIntroducido % 2;
        String resultadoParImpar; // Declaras la variable
        if (modulo == 0) {
            resultadoParImpar = "par"; // Asignas "par" si la condición es true
        } else {
            resultadoParImpar = "impar"; // Asignas "impar" si la condición es false
        }
        System.out.print("El número " + numeroIntroducido + " es " + resultadoParImpar + " (resto al dividir entre 2: " + modulo + ")");

        lectorTeclado.close();
    }

    public void ejercicio05() { //Operadores lógicos AND y OR
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce tu edad: ");
        int edad = lectorTeclado.nextInt();
        boolean mayor21 = edad >= 21;

        System.out.print("¿Tienes carnet de conducir? (true/false): ");
        boolean carnet = lectorTeclado.nextBoolean();

        boolean compara = carnet && mayor21;

        System.out.println("¿Eres mayor de 21 años?: " + mayor21);
        System.out.println("¿Tienes carnet?: " + carnet);
        System.out.println("¿Puedes alquilar un coche? (AND): " + compara);

        lectorTeclado.close();
    }

    public void ejercicio06() {  //Calculadora de descuento
        Scanner lectorTeclado = new Scanner(System.in);

        System.out.print("Introduce el precio del producto: ");
        int precio = lectorTeclado.nextInt();

        System.out.print("Introduce el porcentaje de descuento: ");
        int porcentajeDescuento = lectorTeclado.nextInt();

        double descuento = (double) precio * porcentajeDescuento / 100;
        double precioFinal = precio - descuento;

        System.out.println("Precio original: " + (double) precio + "€");
        System.out.println("Descuento (" + porcentajeDescuento + "%): " + descuento + "€");
        System.out.print("Precio final: " + precioFinal + "€");

        lectorTeclado.close();
    }

    public void ejercicio07() { //Operador NOT y condiciones compuestas
        Scanner lectorTeclado = new Scanner(System.in);

        System.out.print("Introduce tu edad: ");
        int edad = lectorTeclado.nextInt();
        lectorTeclado.nextLine(); // Limpiar el buffer
        System.out.print("¿Eres estudiante? (true/false): ");
        boolean esEstudiante = lectorTeclado.nextBoolean();


        boolean descuentoJoven = edad < 26;
        boolean descuentoEspecial = esEstudiante && descuentoJoven;

        System.out.println("¿Eres menor de 26 años?: " + descuentoJoven);
        System.out.println("¿Eres estudiante?: " + esEstudiante);
        System.out.println("¿Tienes descuento joven? (menor de 26): " + descuentoJoven);
        System.out.println("¿Tienes descuento estudiante?: " + esEstudiante);
        System.out.print("¿Tienes descuento especial?: " + descuentoEspecial);

        lectorTeclado.close();
    }

    public void ejercicio08() {  //Operaciones combinadas
        Scanner lectorTeclado = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        int primerNumero = lectorTeclado.nextInt();
        lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce el segundo número: ");
        int segundoNumero = lectorTeclado.nextInt();
        System.out.print("Introduce el tercer número: ");
        int tercerNumero = lectorTeclado.nextInt();

        int suma = primerNumero+segundoNumero+tercerNumero;
        double promedio = ((double)primerNumero+segundoNumero+tercerNumero)/3;
        double combi = (double)primerNumero*segundoNumero/tercerNumero;

        System.out.println("Suma de los tres números: " +suma);
        System.out.printf("Promedio: %.2f\n",promedio);
        System.out.printf("Resultado de (número1 * número2) / número3: %.2f",combi);

        lectorTeclado.close();
    }

    public void ejercicio09() {  //Sistema de calificaciones
        Scanner lectorTeclado = new Scanner(System.in);

        System.out.print("Introduce la nota del primer examen: ");
        int primerExamen = lectorTeclado.nextInt();
        System.out.print("Introduce la nota del segundo examen: ");
        int segundoExamen = lectorTeclado.nextInt();
        System.out.print("Introduce la nota del tercer examen: ");
        int tercerExamen = lectorTeclado.nextInt();

        double notaMedia = ((double)primerExamen+segundoExamen+tercerExamen)/3;
        boolean aprobado= notaMedia>=5;
        boolean notable= notaMedia>=7;
        boolean sobresaliente= notaMedia>=9;

        System.out.printf("Nota media: %.2f\n",notaMedia);
        System.out.println("¿Ha aprobado? (>=5): " +aprobado);
        System.out.println("¿Tiene notable? (>=7): " +notable);
        System.out.println("¿Tiene sobresaliente? (>=9): " +sobresaliente);

        lectorTeclado.close();
    }

    public void ejercicio10() { //Calculadora de salario con condiciones
        Scanner lectorTeclado = new Scanner(System.in);

        System.out.print("Introduce el salario por hora: ");
        int salarioHora = lectorTeclado.nextInt();
        System.out.print("Introduce las horas trabajadas: ");
        int horas = lectorTeclado.nextInt();
        lectorTeclado.nextLine(); // Limpiar el buffer

        int horasNormales = Math.min(horas, 40);
        int horasExtra = Math.max(0, horas - 40);
        boolean horasExtraSiNo = horas>40;
        double salarioNormales = (double)salarioHora*horasNormales;
        double salarioExtras = (double)horasExtra*(salarioHora*2);
        double salarioTotal = (double)salarioExtras+salarioNormales;


        System.out.println("¿Has hecho horas extra? (true/false): " +horasExtraSiNo);
        System.out.println("Horas normales (máximo 40): " +horasNormales);
        System.out.println("Horas extras: " + Math.max(0, horas - 40));
        System.out.println("Trabajaste más de 40 horas?: " +horasExtraSiNo);
        System.out.println("Tienes derecho a horas extra?: " +horasExtraSiNo);
        System.out.println("Se aplican horas extra (>40 AND permitido)?: " +horasExtraSiNo);
        System.out.printf("Salario por horas normales: %.2f\n",salarioNormales);
        System.out.printf("Salario por horas extra (al doble): %.2f\n",salarioExtras);
        System.out.printf("Salario TOTAL: %.2f\n",salarioTotal);

        lectorTeclado.close();
    }
}
/*
Las funciones estáticas Math.max() y Math.min() son métodos de la clase java.lang.Math que se usan
para encontrar el mayor o el menor de un conjunto de dos valores que se le proporcionan, respectivamente.
En los ejemplos que acabamos de ver, estas funciones fueron clave para establecer límites y calcular excesos
de una manera limpia y segura.
1. Math.min(a, b) (Encontrar el Valor Mínimo)
La función Math.min() devuelve el valor más pequeño de los dos argumentos que se le pasan.
Es perfecta para establecer un tope o límite máximo.
Ejemplo de Math.min(): Contador de Horas
int horas = lectorTeclado.nextInt();
int contadorHoras = Math.min(horas, 40);
Explicación:
Propósito: Garantizar que el valor almacenado en contadorHoras nunca exceda de 40.
Si horas es 30: Math.min(30, 40) devuelve 30. (Se usa el valor de entrada).
Si horas es 50: Math.min(50, 40) devuelve 40. (Se usa el límite máximo).
2. Math.max(a, b) (Encontrar el Valor Máximo)
La función Math.max() devuelve el valor más grande de los dos argumentos que se le pasan.
Es ideal para garantizar que un valor no sea negativo o para calcular un exceso o excedente.
Ejemplo de Math.max(): Contador de Horas Extras
int horasExtra = Math.max(0, horas - 40);
Explicación:
Propósito: Calcular la diferencia de horas sobre 40, asegurándose de que el resultado no sea negativo.
Si horas es 50: La expresión interna es 50−40=10. Entonces, Math.max(0, 10) devuelve 10. (El exceso).
Si horas es 30: La expresión interna es 30−40=−10. Entonces, Math.max(0, -10) devuelve 0. (No hay horas extras).
De esta forma, al comparar la resta con 0, nos aseguramos de que horasExtra siempre sea cero o positivo.
 */