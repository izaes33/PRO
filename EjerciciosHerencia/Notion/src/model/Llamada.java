package model;

public abstract class Llamada {
    private long nOrigen, nDestino;
    private int duracion;
    private double coste, costeSegundo;

    public Llamada() {
    }

    public Llamada(long nOrigen, long nDestino, int duracion) {
        this.nOrigen = nOrigen;
        this.nDestino = nDestino;
        this.duracion = duracion;
    }

    public void mostrarDatos(){
        System.out.println("nOrigen = " + nOrigen);
        System.out.println("nDestino = " + nDestino);
        System.out.println("duracion = " + duracion);
        System.out.println("coste = " + coste);
    }

    public abstract void calcularCoste(); //Un metodo ABSTRACTO NO PUEDE TENER CUERPO

    public long getnOrigen() {
        return nOrigen;
    }

    public void setnOrigen(long nOrigen) {
        this.nOrigen = nOrigen;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public long getnDestino() {
        return nDestino;
    }

    public void setnDestino(long nDestino) {
        this.nDestino = nDestino;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getCosteSegundo() {
        return costeSegundo;
    }

    public void setCosteSegundo(double costeSegundo) {
        this.costeSegundo = costeSegundo;
    }
}
