public class Main {

    // =======================================================
    // 1. DEFINICIÓN DE CONSTANTES (Valores fijos)
    // Se usa 'final' y se escriben en MAYÚSCULAS por convención.
    // Se definen como 'static' si se usan sin crear una instancia de la clase.
    // =======================================================
    public static final double VALOR_PI = 3.14159;
    public static final String NOMBRE_APLICACION = "Calculadora Geométrica v1.0";
    public static final int DIAS_SEMANA = 7;

    public static void main(String[] args) {

        // =======================================================
        // 2. DEFINICIÓN DE VARIABLES (Valores que pueden cambiar)
        // =======================================================

        // Variable para un valor de entrada, como el radio de un círculo
        double radioCirculo = 5.0;

        // Variable para un estado o contador
        int contadorTareas = 2;

        // Variable para el resultado de un cálculo
        double areaCalculada;

        // 3. Uso de la constante para calcular un valor variable
        areaCalculada = VALOR_PI * radioCirculo * radioCirculo;

        // 4. Modificar una variable (simulando que se añade una tarea)
        contadorTareas = contadorTareas + 1; // Ahora es 3

        // 5. Mostrar todos los valores (Constantes y Variables)
        System.out.println("=========================================");
        System.out.println("          INFORMACIÓN DE LA APLICACIÓN     ");
        System.out.println("=========================================");

        // Mostrar Constantes (Valores Fijos)
        System.out.println("--- CONSTANTES (No Cambian) ---");
        System.out.println("Nombre de la Aplicación: " + NOMBRE_APLICACION);
        System.out.println("Valor de PI: " + VALOR_PI);
        System.out.println("Días de la Semana: " + DIAS_SEMANA);

        // Mostrar Variables (Valores Cambiantes)
        System.out.println("\n--- VARIABLES (Cambiantes) ---");
        System.out.println("Radio del Círculo Usado: " + radioCirculo + " cm");
        System.out.println("Contador de Tareas (Final): " + contadorTareas);
        System.out.println("Área Calculada (PI * radio^2): " + areaCalculada + " cm²");

        System.out.println("=========================================");
    }
}