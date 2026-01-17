package Ej07_01;

public class Direccion {
    private String calle;
    private String ciudad;
    private String codigoPostal;

    // Constructor
    public Direccion(String calle, String ciudad, String codigoPostal) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    // Método para mostrar la dirección en formato legible
    @Override
    public String toString() {
        return calle + ", " + ciudad + ", " + codigoPostal;
    }
}
