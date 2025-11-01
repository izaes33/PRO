 /*Crea un programa que calcule el coste de envío de un paquete.
    Pide: peso del paquete (kg), distancia de envío (km), y si es envío urgente (true/false).
    Las reglas son: Precio base: 5€. Si el peso es mayor de 5kg, añadir 2€ por cada kg adicional.
    Si la distancia es mayor de 100km, añadir 10€. Si es envío urgente, multiplicar el precio total
    por 1.5. Muestra todos los cálculos paso a paso.
Ejemplo de salida por consola:
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

 /*Explicación detallada y fácil — paso a paso
Entrada de datos
Scanner sc = new Scanner(System.in); crea un lector para la consola.
Pedimos tres valores:
peso (double): permite kilos con decimales.
distancia (double).
esUrgente (boolean): true o false.
Validación básica
Si peso o distancia son negativos, el programa muestra un error y sale (return).
Es mejor validar para evitar resultados raros.
Precio base
precioBase = 5.0 siempre se aplica.
Coste adicional por peso
Solo se aplica si peso > 5.0.
excesoKg = peso - 5.0 (si peso es 7 → exceso 2).
costeAdicionalPeso = excesoKg * 2.0 (2€ por cada kg extra).
Si no hay exceso, excesoKg = 0 y costeAdicionalPeso = 0.
Coste adicional por distancia
Si distancia > 100.0 añadimos 10.0€, si no, 0.0€.
Subtotal
subtotal = precioBase + costeAdicionalPeso + costeAdicionalDistancia.
Urgencia
Si esUrgente es true, multiplicamos el precio total por 1.5.
Para mostrar claramente cuánto se añade, calculamos recargoUrgencia =
subtotal * 0.5 y costeTotal = subtotal + recargoUrgencia.
Si no es urgente, recargoUrgencia = 0 y costeTotal = subtotal.
Salida paso a paso
Imprimimos:
Precio base.
Detalle del peso: cuánto pesa, si excede 5kg y coste adicional por peso.
Detalle de la distancia y coste adicional si aplica.
Subtotal.
Si es urgente y el recargo.
Coste total final.
Uso System.out.printf con %.2f para mostrar siempre dos decimales (más claro para precios).*/

 import java.util.Scanner;

 public class CalculadoraCosteEnvio {

     /**
      * Método que pide datos del paquete, calcula el coste paso a paso
      * y muestra cada parte del cálculo por consola.
      */
     public static void calcularCosteEnvio() {
         Scanner sc = new Scanner(System.in);

         // --- ENTRADA: pedimos los datos al usuario ---
         System.out.print("Introduce el peso del paquete (kg): ");
         double peso = sc.nextDouble(); // peso en kilogramos (puede ser decimal)

         System.out.print("Introduce la distancia de envío (km): ");
         double distancia = sc.nextDouble(); // distancia en kilómetros

         System.out.print("¿Es envío urgente? (true/false): ");
         boolean esUrgente = sc.nextBoolean(); // true o false

         // --- VALIDACIÓN BÁSICA ---
         if (peso < 0) {
             System.out.println("\nPeso no válido. Debe ser >= 0.");
             sc.close();
             return;
         }
         if (distancia < 0) {
             System.out.println("\nDistancia no válida. Debe ser >= 0.");
             sc.close();
             return;
         }

         // --- REGLAS Y CÁLCULOS ---
         double precioBase = 5.0; // precio base siempre
         // Si el peso supera 5kg, se cobran 2€ por cada kg adicional.
         double excesoKg = 0.0;
         if (peso > 5.0) {
             excesoKg = peso - 5.0;
         }
         double costeAdicionalPeso = excesoKg * 2.0; // 2€ por kg extra

         // Si la distancia es mayor de 100km, añadir 10€
         double costeAdicionalDistancia = (distancia > 100.0) ? 10.0 : 0.0;
         /*La línea de código  es una forma concisa de escribir una estructura condicional (if/else)
         y se conoce como Operador Condicional Ternario o simplemente Operador Ternario.
         tipo\_de\_dato variable = condición ? valor\_si\_verdadero : valor\_si\_falso
          */

         // Subtotal antes de urgencia
         double subtotal = precioBase + costeAdicionalPeso + costeAdicionalDistancia;

         // Si es urgente, multiplicar el precio total por 1.5
         // Es más claro calcular el recargo: recargo = subtotal * 0.5 (porque 1.5x = subtotal + 0.5*subtotal)
         double recargoUrgencia = 0.0;
         double costeTotal = subtotal;
         if (esUrgente) {
             recargoUrgencia = subtotal * 0.5;
             costeTotal = subtotal + recargoUrgencia;
         }

         // --- SALIDA: mostramos todo paso a paso ---
         // Usamos formato con 2 decimales para mayor claridad
         System.out.println();
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

         sc.close();
     }

     // main para probar el método
     public static void main(String[] args) {
         calcularCosteEnvio();
     }
 }
