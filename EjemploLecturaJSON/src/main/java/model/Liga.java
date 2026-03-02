package model;

// Lombok es una librería que genera código automáticamente
// en tiempo de compilación (getters, setters, constructores, etc.).
import lombok.*;


// Importamos Serializable.
// Esta interfaz permite que los objetos de esta clase
// puedan convertirse en una secuencia de bytes.
// Esto es útil si quieres:
// - Guardarlos en archivos
// - Enviarlos por red
// - Guardarlos en sesión
import java.io.Serializable;


// @Getter hace que Lombok genere automáticamente
// un método get para cada atributo privado.
// Ejemplo: getIdLeague(), getStrLeague(), getStrSport()
@Getter

// @Setter hace que Lombok genere automáticamente
// un método set para cada atributo privado.
// Ejemplo: setIdLeague(...), setStrLeague(...)
@Setter

// @AllArgsConstructor genera un constructor con TODOS los atributos.
// Ejemplo: new Liga(idLeague, strLeague, strSport)
@AllArgsConstructor

// @NoArgsConstructor genera un constructor vacío.
// Ejemplo: new Liga()
// Esto es importante para que librerías como Gson puedan
// crear objetos automáticamente.
@NoArgsConstructor

// Declaración de la clase Liga.
// Implementa Serializable, lo que significa que puede serializarse.
public class Liga implements Serializable {

    // Declaramos tres atributos privados.
    // Son privados para respetar el principio de encapsulación.
    // Solo se accede a ellos mediante getters y setters.
    private String idLeague, strLeague, strSport;

    // Sobrescribimos el método toString() de la clase Object.
    // Este método se ejecuta automáticamente cuando haces:
    // System.out.println(liga);
    @Override
    public String toString() {

        // String.format permite crear un String formateado.
        // "%s - %s" significa:
        // primer %s -> idLeague
        // segundo %s -> strLeague
        // Ejemplo de salida: 4328 - Spanish La Liga
        return String.format("%s - %s", idLeague, strLeague);
    }
}