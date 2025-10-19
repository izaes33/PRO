public class Main {
    public static void main(String[] args) {

        // 1. Declaración y asignación de variables con diferentes tipos de datos

        // Cadena de texto (para nombres, mensajes, etc.)
        String nombreProducto = "Café Orgánico";

        // Número entero (para conteo, edad, cantidad sin decimales)
        int cantidadEnStock = 150;

        // Booleano (para verdadero/falso, sí/no)
        boolean esDescuentoActivo = true;

        // Número de punto flotante de doble precisión (para precios, mediciones con decimales)
        double precioUnidad = 12.99;

        // Carácter (para una sola letra, símbolo o dígito)
        char codigoClase = 'A';

        // 2. Mostrar el valor y una descripción del tipo de cada variable
        System.out.println("--- Variables y Tipos de Datos en Java ---");

        // String
        System.out.println("Variable: nombreProducto");
        System.out.println("  Tipo: String (Cadena de texto)");
        System.out.println("  Valor: " + nombreProducto);
        System.out.println("------------------------------------------");

        // int
        System.out.println("Variable: cantidadEnStock");
        System.out.println("  Tipo: int (Número entero)");
        System.out.println("  Valor: " + cantidadEnStock);
        System.out.println("------------------------------------------");

        // boolean
        System.out.println("Variable: esDescuentoActivo");
        System.out.println("  Tipo: boolean (Booleano - verdadero/falso)");
        System.out.println("  Valor: " + esDescuentoActivo);
        System.out.println("------------------------------------------");

        // double
        System.out.println("Variable: precioUnidad");
        System.out.println("  Tipo: double (Número decimal de doble precisión)");
        System.out.println("  Valor: " + precioUnidad);
        System.out.println("------------------------------------------");

        // char
        System.out.println("Variable: codigoClase");
        System.out.println("  Tipo: char (Carácter simple)");
        System.out.println("  Valor: " + codigoClase);
        System.out.println("------------------------------------------");
    }
}
