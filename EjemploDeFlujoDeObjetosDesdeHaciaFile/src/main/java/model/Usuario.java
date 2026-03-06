package model;

import java.io.Serializable;

// Implementar Serializable es vital para que Java pueda convertir el objeto en bytes
public class Usuario implements Serializable {

    // Identificador de versión para asegurar la compatibilidad durante la deserialización
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String apellido;
    private String dni;

    public Usuario(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    // Getters y Setters: permiten el acceso y modificación controlada de los atributos
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    // Método toString: facilita la impresión de los datos del usuario en consola
    @Override
    public String toString() {
        return "Usuario{" + "nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + ", dni='" + dni + '\'' + '}';
    }
}