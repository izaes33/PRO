import java.util.Scanner;
public class EjercicioNumerado {

    public void ejercicio01(){
        /*Crea un programa que pida la edad del usuario y determine
        si es mayor de edad (18 años o más). Muestra un mensaje indicando
        si puede votar o no.
Ejemplo de salida por consola:
Introduce tu edad: 20
Eres mayor de edad. Puedes votar.*/

        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce tu edad: ");
        int edad =lectorTeclado.nextInt();
        if (edad>=18){
            System.out.println("Eres mayor de edad. Puedes votar.");
        } else {
            System.out.println("Eres menor de edad y no puedes votar.");
        }
        lectorTeclado.close();
    }

    public void ejercicio02(){
    /*Desarrolla un programa que pida un número al usuario y determine
    si es positivo, negativo o cero. Muestra el resultado por consola.
Ejemplo de salida por consola:
Introduce un número: -5
El número es negativo.*/

        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int valor = lectorTeclado.nextInt();
        if (valor==0){
            System.out.println("El valor es cero.");
        }else if (valor>0){
            System.out.println("El valor es positivo.");
        }else{
            System.out.println("El valor es negativo");
        }
        lectorTeclado.close();
    }
    public void ejercicio03(){
        /*Escribe un programa que pida la nota de un examen (entre 0 y 10)
        y determine si el alumno ha aprobado (nota mayor o igual a 5)
        o ha suspendido.
Ejemplo de salida por consola:
Introduce tu nota: 6.5
¡Enhorabuena! Has aprobado.*/

        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce tu nota: ");
        double nota =lectorTeclado.nextDouble();
        if (nota>=5){
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
        double importeCompra =lectorTeclado.nextDouble();
        double descuento;
        if (importeCompra>=100){
            descuento = importeCompra*0.1;
        }else {descuento=0;}
        double importeFinal= importeCompra-descuento;
        System.out.println("Importe original: " +importeCompra+ "€");
        System.out.printf("Descuento aplicado: %.2f€%n",descuento);
        System.out.printf("Importe final: %.2f€",importeFinal);

        lectorTeclado.close();
    }
    public void ejercicio05(){
        /*Desarrolla un programa que pida un número entero y determine
        si es par o impar usando el operador módulo. Muestra un mensaje
        personalizado para cada caso.
Ejemplo de salida por consola:
Introduce un número: 8
El número 8 es par.*/
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int numero =lectorTeclado.nextInt();
        if (numero % 2 == 0) {
            System.out.println("El número " + numero + " es PAR.");
        } else {
            System.out.println("El número " + numero + " es IMPAR.");
        }

        lectorTeclado.close();
    }
    public void ejercicio06(){
        /*Escribe un programa que pida la edad del usuario y determine
        si puede acceder a contenido para mayores de 16 años.
        Si tiene 16 o más años, muestra "Acceso permitido", si no,
        muestra "Acceso denegado".

Ejemplo de salida por consola:
Introduce tu edad: 15
Acceso denegado. Debes tener al menos 16 años.*/
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce tu edad: ");
        int edad =lectorTeclado.nextInt();
        if (edad >= 16) {
            System.out.println("Acceso permitido. Tienes más de " +edad+ " años");
        } else {
            System.out.println("Acceso denegado. Tienes menos de " +edad+ " años");
        }

        lectorTeclado.close();
    }
    public void ejercicio07(){
        /*Crea un programa que pida una nota numérica (0-10) y determine
        la calificación: Suspenso (0-4), Aprobado (5-6), Notable (7-8) o
        Sobresaliente (9-10).
Ejemplo de salida por consola:
Introduce tu nota: 8
Tu calificación es: Notable*/
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce tu nota: ");
        double nota =lectorTeclado.nextDouble();
        if (nota < 5 ) {
            System.out.println("Tu calificación es: Suspenso");
        } else if (nota <= 6){
            System.out.println("Tu calificación es: Aprobado");
        } else if (nota <=8){
            System.out.println("Tu calificación es: Notable");
        } else {
            System.out.println("Tu calificación es: Sobresaliente");
        }
        lectorTeclado.close();
    }
    public void ejercicio08(){
        /*Desarrolla un programa que pida dos números al usuario y determine
        cuál es mayor, o si son iguales. Muestra el resultado por consola.
Ejemplo de salida por consola:
Introduce el primer número: 15
Introduce el segundo número: 10
El número 15 es mayor que 10.*/
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        double primerNumero =lectorTeclado.nextDouble();
        System.out.print("Introduce el segundo número: ");
        double segundoNumero =lectorTeclado.nextDouble();
        if (primerNumero > segundoNumero ) {
            System.out.println("El número " +primerNumero+ " es mayor que " +segundoNumero);
        } else if (primerNumero < segundoNumero ){
            System.out.println("El número " +primerNumero+ " es menor que " +segundoNumero);
        } else {
            System.out.println("Los números son iguales");
        }
        lectorTeclado.close();
    }
    public void ejercicio09(){
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
        double peso =lectorTeclado.nextDouble();
        System.out.print("Introduce tu altura en metros: ");
        double altura =lectorTeclado.nextDouble();
        double imc = peso/(altura*altura);
        System.out.printf("Tu IMC es: %.2f\n",imc);
        if (imc<18.5) {
            System.out.println("Estás por debajo del peso normal");
        } else if (imc<=24.9){
            System.out.println("Estás en tu peso normal");
        } else {
            System.out.println("Estás por encima del peso normal");
        }
        lectorTeclado.close();
    }
    public void ejercicio10(){
        /*Crea un programa que pida la altura del usuario (en cm) y determine
        si puede subir a una atracción. La altura mínima es 120 cm y la máxima
        es 200 cm. Si está dentro del rango, muestra "Puedes subir", si no,
        indica el motivo (demasiado bajo o demasiado alto).
Ejemplo de salida por consola:
Introduce tu altura en cm: 115
No puedes subir a la atracción. Altura mínima: 120 cm.*/
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Introduce tu altura en cm: ");
        int altura =lectorTeclado.nextInt();
        int alturaMinima=120;
        int alturaMaxima=200;
        if (altura<alturaMinima) {
            System.out.println("No puedes subir a la atracción. Altura mímima: " +alturaMinima);
        } else if (altura >= alturaMinima && altura<= alturaMaxima) {
            System.out.println("Puedes subir");
        } else {
            System.out.println("No puedes subir a la atracción. Altura máxima: " +alturaMaxima);
        }
        lectorTeclado.close();
    }
}