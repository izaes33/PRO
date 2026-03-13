package model;

import lombok.*;
/* Lombok es una librería que genera código automáticamente
en tiempo de compilación (getters, setters, constructores, etc.). */

import java.io.Serializable;
/* Serializable es una interfaz que permite que los objetos de esta clase
puedan convertirse en una secuencia de bytes. Esto es útil si quieres:
Guardarlos en archivos; Enviarlos por red; Guardarlos en sesión */


@Getter
/* @Getter hace que Lombok genere automáticamente un método get
para cada atributo privado. P. ej. -> getIdLeague(), getStrLeague(), getStrSport() */

@Setter
/* @Setter hace que Lombok genere automáticamente un método set
para cada atributo privado. P. ej. -> setIdLeague(), setStrLeague(), setStrSport() */

@AllArgsConstructor
/* @AllArgsConstructor genera un constructor con TODOS los atributos.
Ejemplo: new Liga(idLeague, strLeague, strSport) */

@NoArgsConstructor
/* @NoArgsConstructor genera un constructor vacío. Ejemplo: new Liga()
Esto es importante para que librerías como Gson puedan crear objetos automáticamente. */

public class Liga implements Serializable {
// Que la clase Liga Implemente Serializable, significa que puede serializarse.

    private String idLeague, strLeague, strSport;
    /* Declaramos tres atributos privados para respetar el principio de encapsulación.
    (Solo se accede a ellos mediante getters y setters). */

    @Override
    public String toString() {
        /* Sobrescribimos el método toString() de la clase Object.
        Este método se ejecuta automáticamente cuando se hace
        System.out.println(liga); */

        return String.format("%s - %s", idLeague, strLeague);
        // String.format permite crear un String formateado.
    }
}