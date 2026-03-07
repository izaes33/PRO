package Ej09_Agenda;

public class Usuario { // Definimos la clase Usuario que representa la entidad de nuestra agenda
    private String nombre; // Atributo privado para el nombre del usuario
    private String apellido; // Atributo privado para el apellido
    private String dni; // Atributo privado para el DNI (identificador único)

    // Constructor para inicializar un objeto Usuario con todos sus datos
    public Usuario(String nombre, String apellido, String dni) {
        this.nombre = nombre; // Asignamos el nombre recibido al atributo de la clase
        this.apellido = apellido; // Asignamos el apellido recibido al atributo de la clase
        this.dni = dni; // Asignamos el DNI recibido al atributo de la clase
    } // Cerramos el constructor

    // Métodos Getter para acceder a los datos privados desde fuera de la clase
    public String getNombre() { return nombre; } // Retorna el nombre
    public String getApellido() { return apellido; } // Retorna el apellido
    public String getDni() { return dni; } // Retorna el DNI

    // Sobrescribimos el método toString para definir cómo se verá el usuario al imprimirlo
    @Override
    public String toString() {
        return "DNI: " + dni + " | Nombre: " + nombre + " " + apellido; // Formato de visualización
    } // Cerramos toString
} // Cerramos la clase Usuario