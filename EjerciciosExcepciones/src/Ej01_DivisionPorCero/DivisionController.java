package Ej01_DivisionPorCero;

public class DivisionController { // Definimos la clase controlador

    private DivisionModel model; // Declaramos una variable del modelo
    private DivisionView view; // Declaramos una variable de la vista

    public DivisionController(DivisionModel model, DivisionView view) { // Constructor que recibe el modelo y la vista

        this.model = model; // Guardamos el modelo recibido en el atributo de la clase
        this.view = view; // Guardamos la vista recibida en el atributo de la clase
    }
    /*La razón por la que se pasan como argumentos view y model en el constructores seguir correctamente el patrón MVC y aplicar
    inyección de dependencias.
     El Controller es la pieza que conecta el Model con la View. Por tanto, necesita tener acceso a ambos objetos.
    Esto significa: Main crea los objetos -> Controller los recibe.
     Ventajas:  Separación de responsabilidades:
    Clase	        Responsabilidad
    Model-----------lógica
    View------------interacción
    Controller------coordinar
                Código más reutilizable: El controlador no depende de crear sus propios objetos.
                Más fácil de testear: En pruebas puedes pasar objetos simulados (mocks).
     (Qué pasaría si NO se pasaran:
    Si el controlador creara los objetos dentro:
    public DivisionController() {
        model = new DivisionModel();
        view = new DivisionView();
    }
     Problemas:
    El controlador queda acoplado a esas clases.
    No puedes cambiar la vista o el modelo fácilmente.
    Rompe el principio de bajo acoplamiento.*/


    public void iniciar() { // Método que inicia el flujo del programa

        try { // Bloque try: aquí colocamos el código que podría generar una excepción
            int numero1 = view.pedirNumero("Introduce el primer número: "); // Pedimos el primer número usando la vista
            int numero2 = view.pedirNumero("Introduce el segundo número: "); // Pedimos el segundo número usando la vista
            double resultado = model.dividir(numero1, numero2); // Llamamos al modelo para realizar la división
            view.mostrarResultado(resultado); // Mostramos el resultado en la vista

        } catch (ArithmeticException e) { // Capturamos la excepción específica que ocurre cuando se divide entre cero

            view.mostrarError("No se puede dividir por cero"); // Mostramos el mensaje de error al usuario

        }
    }
}