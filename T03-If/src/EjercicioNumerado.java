import java.util.Scanner;
public class EjercicioNumerado {

    public void ejercicio01() {
        /*Crea un programa que pida la edad del usuario y determine
        si es mayor de edad (18 años o más). Muestra un mensaje indicando
        si puede votar o no.
Ejemplo de salida por consola:
Introduce tu edad: 20
Eres mayor de edad. Puedes votar.*/

        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce tu edad: ");
        int edad = lectorTeclado.nextInt();
        if (edad >= 18) {
            System.out.println("Eres mayor de edad. Puedes votar.");
        } else {
            System.out.println("Eres menor de edad y no puedes votar.");
        }
        lectorTeclado.close();
    }

    public void ejercicio02() {
    /*Desarrolla un programa que pida un número al usuario y determine
    si es positivo, negativo o cero. Muestra el resultado por consola.
Ejemplo de salida por consola:
Introduce un número: -5
El número es negativo.*/

        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int valor = lectorTeclado.nextInt();
        if (valor == 0) {
            System.out.println("El valor es cero.");
        } else if (valor > 0) {
            System.out.println("El valor es positivo.");
        } else {
            System.out.println("El valor es negativo");
        }
        lectorTeclado.close();
    }

    public void ejercicio03() {
        /*Escribe un programa que pida la nota de un examen (entre 0 y 10)
        y determine si el alumno ha aprobado (nota mayor o igual a 5)
        o ha suspendido.
Ejemplo de salida por consola:
Introduce tu nota: 6.5
¡Enhorabuena! Has aprobado.*/

        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce tu nota: ");
        double nota = lectorTeclado.nextDouble();
        if (nota >= 5) {
            System.out.println("¡Enhorabuena! Has aprobado.");
        } else {
            System.out.println("Lo siento. Has suspendido.");
        }
        lectorTeclado.close();
    }

    public void ejercicio04() {
        /*Crea un programa que pida el importe de una compra. Si el importe
        es mayor o igual a 100€, aplica un descuento del 10%.
        Muestra el importe original y el importe final a pagar.
Ejemplo de salida por consola:
Introduce el importe de la compra: 120
Importe original: 120.0€
Descuento aplicado: 12.0€
Importe final: 108.0€*/

        /*Pseudocódigo:
        1-Pide datos
        2-Realica cálculos
        3-Muestra por consola
         */

        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce el importe de la compra: ");
        double importeCompra = lectorTeclado.nextDouble();
        double descuento;
        if (importeCompra >= 100) {
            descuento = importeCompra * 0.1;
        } else {
            descuento = 0;
        }
        double importeFinal = importeCompra - descuento;
        System.out.println("Importe original: " + importeCompra + "€");
        System.out.printf("Descuento aplicado: %.2f€%n", descuento);
        System.out.printf("Importe final: %.2f€", importeFinal);

        lectorTeclado.close();
    }

    public void ejercicio05() {
        /*Desarrolla un programa que pida un número entero y determine
        si es par o impar usando el operador módulo. Muestra un mensaje
        personalizado para cada caso.
Ejemplo de salida por consola:
Introduce un número: 8
El número 8 es par.*/
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int numero = lectorTeclado.nextInt();
        if (numero % 2 == 0) {
            System.out.println("El número " + numero + " es PAR.");
        } else {
            System.out.println("El número " + numero + " es IMPAR.");
        }

        lectorTeclado.close();
    }

    public void ejercicio06() {
        /*Escribe un programa que pida la edad del usuario y determine
        si puede acceder a contenido para mayores de 16 años.
        Si tiene 16 o más años, muestra "Acceso permitido", si no,
        muestra "Acceso denegado".

Ejemplo de salida por consola:
Introduce tu edad: 15
Acceso denegado. Debes tener al menos 16 años.*/
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce tu edad: ");
        int edad = lectorTeclado.nextInt();
        if (edad >= 16) {
            System.out.println("Acceso permitido. Tienes más de " + edad + " años");
        } else {
            System.out.println("Acceso denegado. Tienes menos de " + edad + " años");
        }

        lectorTeclado.close();
    }

    public void ejercicio07() {
        /*Crea un programa que pida una nota numérica (0-10) y determine
        la calificación: Suspenso (0-4), Aprobado (5-6), Notable (7-8) o
        Sobresaliente (9-10).
Ejemplo de salida por consola:
Introduce tu nota: 8
Tu calificación es: Notable*/
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce tu nota: ");
        double nota = lectorTeclado.nextDouble();
        if (nota < 5) {
            System.out.println("Tu calificación es: Suspenso");
        } else if (nota <= 6) {
            System.out.println("Tu calificación es: Aprobado");
        } else if (nota <= 8) {
            System.out.println("Tu calificación es: Notable");
        } else {
            System.out.println("Tu calificación es: Sobresaliente");
        }
        lectorTeclado.close();
    }

    public void ejercicio08() {
        /*Desarrolla un programa que pida dos números al usuario y determine
        cuál es mayor, o si son iguales. Muestra el resultado por consola.
Ejemplo de salida por consola:
Introduce el primer número: 15
Introduce el segundo número: 10
El número 15 es mayor que 10.*/
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        double primerNumero = lectorTeclado.nextDouble();
        System.out.print("Introduce el segundo número: ");
        double segundoNumero = lectorTeclado.nextDouble();
        if (primerNumero > segundoNumero) {
            System.out.println("El número " + primerNumero + " es mayor que " + segundoNumero);
        } else if (primerNumero < segundoNumero) {
            System.out.println("El número " + primerNumero + " es menor que " + segundoNumero);
        } else {
            System.out.println("Los números son iguales");
        }
        lectorTeclado.close();
    }

    public void ejercicio09() {
        /*Escribe un programa que pida el peso (en kg) y la altura (en metros)
        del usuario. Calcula el IMC (peso / altura²) y determina si está en
        peso normal (IMC entre 18.5 y 24.9), por debajo del peso normal
        (IMC menor a 18.5) o por encima del peso normal (IMC mayor a 24.9).

Ejemplo de salida por consola:
Introduce tu peso en kg: 70
Introduce tu altura en metros: 1.75
Tu IMC es: 22.86
Estás en peso normal.*/
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce tu peso en Kg: ");
        double peso = lectorTeclado.nextDouble();
        System.out.print("Introduce tu altura en metros: ");
        double altura = lectorTeclado.nextDouble();
        double imc = peso / (altura * altura);
        System.out.printf("Tu IMC es: %.2f\n", imc);
        if (imc < 18.5) {
            System.out.println("Estás por debajo del peso normal");
        } else if (imc <= 24.9) {
            System.out.println("Estás en tu peso normal");
        } else {
            System.out.println("Estás por encima del peso normal");
        }
        lectorTeclado.close();
    }

    public void ejercicio10() {
        /*Crea un programa que pida la altura del usuario (en cm) y determine
        si puede subir a una atracción. La altura mínima es 120 cm y la máxima
        es 200 cm. Si está dentro del rango, muestra "Puedes subir", si no,
        indica el motivo (demasiado bajo o demasiado alto).
Ejemplo de salida por consola:
Introduce tu altura en cm: 115
No puedes subir a la atracción. Altura mínima: 120 cm.*/
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce tu altura en cm: ");
        int altura = lectorTeclado.nextInt();
        int alturaMinima = 120;
        int alturaMaxima = 200;
        if (altura < alturaMinima) {
            System.out.println("No puedes subir a la atracción. Altura mímima: " + alturaMinima);
        } else if (altura >= alturaMinima && altura <= alturaMaxima) {
            System.out.println("Puedes subir");
        } else {
            System.out.println("No puedes subir a la atracción. Altura máxima: " + alturaMaxima);
        }
        lectorTeclado.close();
    }

    public void ejercicio11() {
        /*Desarrolla un programa que pida el importe de una compra y si el
        cliente es socio (true/false). Aplica descuentos según estas reglas:
        Si es socio Y la compra es mayor o igual a 200€, descuento del 20%.
        Si es socio Y la compra es menor de 200€, descuento del 10%.
        Si NO es socio pero la compra es mayor o igual a 300€, descuento del 5%.
        En cualquier otro caso, no hay descuento. Muestra el importe original,
        el descuento aplicado y el importe final.
Ejemplo de salida por consola:
Introduce el importe de la compra: 250
¿Eres socio? (true/false): true
Importe original: 250.0€
Eres socio y tu compra es >= 200€
Descuento aplicado (20%): 50.0€
Importe final: 200.0€*/
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce el importe de la compra: ");
        double importe = lectorTeclado.nextDouble();
        System.out.print("¿Eres socio? (true/false): ");
        boolean socio = lectorTeclado.nextBoolean();
        System.out.printf("Importe: %.2f€%n", importe);
        if ((importe >= 200) && (socio)) {
            double descuento = importe * 0.2;
            double precioFinal = importe - descuento;
            System.out.printf("Eres socio y tu compra es >= %.2f€%n", importe);
            System.out.printf("Descuento aplicado (20%%): %.2f€%n", descuento);
            System.out.printf("Importe final: %.2f€%n", precioFinal);
        } else if (socio && importe < 200) {
            double descuento = importe * 0.1;
            double precioFinal = importe - descuento;
            System.out.printf("Eres socio y tu compra es < %.2f€%n", importe);
            System.out.printf("Descuento aplicado (10%%): %.2f€%n", descuento);
            System.out.printf("Importe final: %.2f€%n", precioFinal);
        } else if (!socio && importe >= 300) {
            double descuento = importe * 0.05;
            double precioFinal = importe - descuento;
            System.out.printf("No eres socio y tu compra es > %.2f€%n", importe);
            System.out.printf("Descuento aplicado (5%%): %.2f€%n", descuento);
            System.out.printf("Importe final: %.2f€%n", precioFinal);
        } else {
            System.out.println("Descuento aplicado: (0%)");
            System.out.printf("Importe final: %.2f€", importe);
        }
        lectorTeclado.close();
    }

    public void ejercicio12() {
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
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce una contraseña: ");
        String pass = lectorTeclado.nextLine();
        int caracteres = pass.length();
        boolean nCaracteres = pass.length() >= 8;
        boolean esProhibida = (pass.equals("12345678") || pass.equalsIgnoreCase("password"));
        boolean contieneNumero = pass.contains("1") || pass.contains("2") || pass.contains("3") || pass.contains("4") || pass.contains("5") ||
                pass.contains("6") || pass.contains("7") || pass.contains("8") || pass.contains("9") || pass.contains("0");
        boolean esValida = nCaracteres && contieneNumero && (!esProhibida);

        System.out.println("Longitud de la contraseña:" + caracteres);
        System.out.println("¿Tiene al menos 8 caracteres?: " + nCaracteres);
        System.out.println("¿Contiene al menos un número?: " + contieneNumero);
        System.out.println("¿Es una contraseña prohibida?: " + esProhibida);
        System.out.println("¿Es válida? (cumple todos los requisitos): " + esValida);
    }


    /*Escribe un programa para calcular el precio de entrada a un museo.
        Pide la edad del usuario y el día de la semana (1=Lunes, 2=Martes...
        7=Domingo). Las reglas son: Menores de 12 años: entrada gratis.
        Entre 12 y 17 años: 5€ (pero gratis los martes). Entre 18 y 64 años:
        10€ (pero 7€ los jueves). 65 años o más: 6€. Usa operadores lógicos
        para determinar el precio correcto y muestra el cálculo.*/
    public void ejercicio13() {
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce tu edad: ");
        int edad = lectorTeclado.nextInt();
        System.out.print("Introduce el día de la semana: ");
        int dia = lectorTeclado.nextInt();
        int calculoEntrada = 0;
        if (edad < 12) {
            calculoEntrada = 0;
        } else if (edad < 17) {
            if (dia == 2) {
                calculoEntrada = 0;
            } else {
                calculoEntrada = 5;
            }
        } else if (edad < 64) {
            if (dia == 4) {
                calculoEntrada = 7;
            } else {
                calculoEntrada = 10;
            }
        } else {
            calculoEntrada = 6;
        }
        String diaSemana = "";
        if (dia == 1) {
            diaSemana = "Lunes";
        } else if (dia == 2) {
            diaSemana = "Martes";
        } else if (dia == 3) {
            diaSemana = "Miércoles";
        } else if (dia == 4) {
            diaSemana = "Jueves";
        } else if (dia == 5) {
            diaSemana = "Viernes";
        } else if (dia == 6) {
            diaSemana = "Sábado";
        } else if (dia == 2) {
            diaSemana = "Domingo";
        } else {
            diaSemana = "El número introducido NO es válido";
        }
        System.out.printf("Día de la semana (1-7): %d - %s%n", dia, diaSemana);
        //%d → inserta un número entero (dia).
        //%s → inserta una cadena (diaSemana).
        //%n → salto de línea (equivalente a \n, pero más portable).

        System.out.println("Precio de entrada: " + calculoEntrada + " €");
    }
    /*Ejemplo de salida por consola:
Introduce tu edad: 15
Introduce el día de la semana (1-7): 2
Edad: 15 años
Día de la semana: 2 (Martes)
¿Eres menor de 12?: false
¿Tienes entre 12 y 17?: true
¿Es martes?: true
Precio de entrada: 0.0€ (Entrada gratuita para menores en martes)*/


    public void ejercicio14() {
        /*Desarrolla un programa que determine si una persona es elegible
        para un préstamo bancario. Pide: edad, ingresos mensuales (€),
        y si tiene deudas pendientes (true/false). Los requisitos son:
        Edad entre 21 y 65 años, ingresos mensuales de al menos 1000€, y
        NO tener deudas pendientes. El programa debe evaluar cada condición y
        mostrar si es elegible o no, explicando qué requisitos no cumple.*/
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce tu edad: ");
        boolean edadAceptada = false;
        int edad = lectorTeclado.nextInt();
        if (edad >= 21 && edad <= 65) {
            edadAceptada = true;
        }
        System.out.print("Introduce tus ingresos mensuales: ");
        int ingreso = lectorTeclado.nextInt();
        boolean ingresoValido = false;
        if (ingreso >= 1000) {
            ingresoValido = true;
        }
        System.out.print("¿Tienes deudas pendientes? (true/false");
        boolean deuda = !lectorTeclado.nextBoolean();
        boolean elegible = edadAceptada && ingresoValido && deuda;
        System.out.println("¿Edad entre 21 y 65?: " + edadAceptada);
        System.out.println("¿Ingresos >= 1000€?: " + ingresoValido);
        System.out.println("¿Sin deudas pendientes?: " + deuda);
        System.out.println("¿Puedes disponer del préstamo?: " + elegible);
        if (elegible == true) {
            System.out.println("¡Felicidades! Puedes para solicitar el préstamo.");
        } else {
            System.out.println("Lo sentimos no cumples los requisitos para solicitar el préstamo.");
        }
/*Ejemplo de salida por consola:
Introduce tu edad: 25
Introduce tus ingresos mensuales: 1200
¿Tienes deudas pendientes? (true/false): false
¿Edad entre 21 y 65?: true
¿Ingresos >= 1000€?: true
¿Sin deudas pendientes?: true
¿Es elegible para el préstamo?: true
¡Felicidades! Eres elegible para solicitar el préstamo.*/
    }

    public void ejercicio15() {
        /*Crea un programa que calcule el coste de envío de un paquete.
    Pide: peso del paquete (kg), distancia de envío (km), y si es envío urgente (true/false).
    Las reglas son: Precio base: 5€. Si el peso es mayor de 5kg, añadir 2€ por cada kg adicional.
    Si la distancia es mayor de 100km, añadir 10€. Si es envío urgente, multiplicar el precio total
    por 1.5. Muestra todos los cálculos paso a paso.
    */
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce el peso del paquete: ");
        double peso = lectorTeclado.nextDouble();
        System.out.print("Introduce la distancia de envío (km): ");
        double distancia = lectorTeclado.nextDouble();
        System.out.print("¿Es envío urgente? (true/false): ");
        boolean esUrgente = lectorTeclado.nextBoolean();
        double precioBase = 5;
        double excesoKg = 0.0;
        if (peso > 5.0) {
            excesoKg = peso - 5.0;
        }
        double costeAdicionalPeso = excesoKg * 2.0;
        double costeAdicionalDistancia = (distancia > 100.0) ? 10.0 : 0.0;
        /*Esta línea de código  es una forma concisa de escribir una estructura condicional (if/else)
         y se conoce como Operador Condicional Ternario o simplemente Operador Ternario.
         tipo\_de\_dato variable = condición ? valor\_si\_verdadero : valor\_si\_falso
          */
        double subtotal = precioBase + costeAdicionalPeso + costeAdicionalDistancia;
        double recargoUrgencia = 0.0;
        double costeTotal = subtotal;
        if (esUrgente) {
            recargoUrgencia = subtotal * 0.5;
            costeTotal = subtotal + recargoUrgencia;
        }
        System.out.printf("Precio base: %.2f€%n", precioBase);

        // Mostramos detalles del peso
        if (excesoKg > 0.0) {
            System.out.printf("Peso: %.2fkg (excede 5kg en %.2fkg)%n", peso, excesoKg);
            System.out.printf("Coste adicional por peso: %.2f€%n", costeAdicionalPeso);
        } else {
            System.out.printf("Peso: %.2fkg (no excede 5kg)%n", peso);
            System.out.printf("Coste adicional por peso: %.2f€%n", costeAdicionalPeso);
        }

        // Detalle distancia
        if (costeAdicionalDistancia > 0.0) {
            System.out.printf("Distancia: %.2fkm (mayor de 100km)%n", distancia);
            System.out.printf("Coste adicional por distancia: %.2f€%n", costeAdicionalDistancia);
        } else {
            System.out.printf("Distancia: %.2fkm (no supera 100km)%n", distancia);
            System.out.printf("Coste adicional por distancia: %.2f€%n", costeAdicionalDistancia);
        }

        // Subtotal y urgencia
        System.out.printf("Subtotal: %.2f€%n", subtotal);
        System.out.printf("¿Es envío urgente?: %b%n", esUrgente);
        if (esUrgente) {
            System.out.printf("Recargo por urgencia (x1.5): %.2f€%n", recargoUrgencia);
        } else {
            System.out.printf("Recargo por urgencia (x1.5): %.2f€%n", recargoUrgencia);
        }

        System.out.printf("Coste total de envío: %.2f€%n", costeTotal);
/*Ejemplo de salida por consola:
Introduce el peso del paquete (kg): 7
Introduce la distancia de envío (km): 150
¿Es envío urgente? (true/false): true
Precio base: 5.0€
Peso: 7kg (excede 5kg en 2kg)
Coste adicional por peso: 4.0€
Distancia: 150km (mayor de 100km)
Coste adicional por distancia: 10.0€
Subtotal: 19.0€
¿Es envío urgente?: true
Recargo por urgencia (x1.5): 9.5€
Coste total de envío: 28.5€*/
    }
}