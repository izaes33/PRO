package Ej03_TextoANumero;

public class NumeroModel { // Definimos la clase del modelo

    public int convertirANumero(String texto) { // Método que recibe un texto y devuelve un número entero
        // Integer.parseInt intenta convertir el texto a entero
        // Si el texto no representa un número válido lanzará automáticamente NumberFormatException
        return Integer.parseInt(texto); // Devolvemos el número convertido
    }
}