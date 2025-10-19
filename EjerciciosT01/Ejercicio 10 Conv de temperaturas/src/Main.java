public class Main {
    public static void main(String[] args) {

    float celsius = 25.0f;
    // 2. Aplicar la fórmula de conversión a Fahrenheit: (C * 9/5) + 32
    // Se usan valores double (9.0 / 5.0) para asegurar un cálculo preciso con decimales.
    double fahrenheit = celsius * (9.0 / 5.0) + 32.0;

    System.out.println("Temperatura en Celsius: " + celsius + " grados (°C)");
    System.out.println("Temperatura en Fahrenheit: " + fahrenheit + " grados (°F)");
    }
}
