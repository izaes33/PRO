package Ej03;

public class Estudiante extends Persona {
    private String curso;

    public Estudiante(String nombre, int edad, String curso) {
        super(nombre, edad); // Llamada al constructor de Persona
        this.curso = curso;
    }

    // Método específico de Estudiante
    public void estudiar() {
        System.out.println("Estoy estudiando " + curso);
    }
}
