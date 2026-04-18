package model;

import lombok.*;

/**
 * MODELO / POJO (Plain Old Java Object):
 * Esta clase es una "plantilla" que representa exactamente una fila de la tabla 'clientes'
 * de la base de datos en la memoria de Java.

 (Si trabajásemos con Springboot o Hibernate, no sería necesario crear nada en la base de datos porque se nos crearía
 automáticamente desde el código de programación, pero esto implicaría que los nombres fueran exactamente
 los que queremos que se reflejen en la BD (o bien que las variables se llamen igual, o bien que se implementen a través
 de la interfaz SchemDB).
 */

/* El @Data es peligroso porque implementa TODAS las funciones que trae Lombok, incluído el toString,
* por lo que puede llegar a dar problemas */
@Getter // Lombok: Genera automáticamente métodos getNombre(), getSaldo(), etc.
@Setter // Lombok: Genera automáticamente métodos setNombre(), setSaldo(), etc.
@NoArgsConstructor // Lombok: Genera un constructor vacío public Cliente(){} necesario para frameworks o inicializaciones vacías.
public class Cliente {

    private long id;
    private String nombre, apellido, correo;
    private int saldo, idPerfil;

    // Constructor personalizado para crear clientes antes de tener el ID
    // (el ID se suele autogenerar en la base de datos)
    public Cliente(String nombre, String apellido, String correo, int saldo, int idPerfil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.saldo = saldo;
        this.idPerfil = idPerfil;
    }
}