package Ej03_CopiarArchivo;

import java.util.Scanner; // Importa la utilidad Scanner para capturar las rutas introducidas por el usuario

public class CopiaView { // Definimos la clase CopiaView, responsable de la interfaz con el usuario
    private Scanner entrada; // Declaramos el objeto Scanner como un atributo privado de la clase

    public CopiaView() { // Definimos el constructor de la Vista
        entrada = new Scanner(System.in); // Inicializamos el Scanner para leer desde la entrada estándar (teclado)
    } // Fin del constructor

    public String solicitarRuta(String mensaje) { // Método para pedir una ruta específica al usuario
        System.out.print(mensaje + ": "); // Mostramos el mensaje (Origen o Destino) para guiar al usuario
        return entrada.nextLine(); // Capturamos y devolvemos la cadena de texto que el usuario escriba
    } // Fin del método solicitarRuta

    public void mostrarExito() { // Método para informar que la operación se completó correctamente
        System.out.println("\nEl archivo ha sido copiado correctamente."); // Imprimimos el mensaje de confirmación
    } // Fin del método mostrarExito

    public void mostrarError(String detalle) { // Método para informar sobre cualquier fallo ocurrido
        System.out.println("Error al copiar el archivo: " + detalle); // Imprimimos el error concatenado con su descripción técnica
    } // Fin del método mostrarError
} // Fin de la clase CopiaView