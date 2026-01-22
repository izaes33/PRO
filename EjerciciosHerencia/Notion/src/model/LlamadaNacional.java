package model;

public class LlamadaNacional extends Llamada {

    private int franja;

    public LlamadaNacional(long nOrigen, long nDestino, int duracion, int franja) {
        super(nOrigen, nDestino, duracion);
        this.franja = franja;
    }

    @Override
    public void calcularCoste() {
        switch (franja) {
            case 1:
                setCosteSegundo(0.20);
                break;
            case 2:
                setCosteSegundo(0.25);
                break;
            case 3:
                setCosteSegundo(0.30);
                break;
            default:
                setCosteSegundo(0.35);
        }

        setCoste(getDuracion() * getCosteSegundo());
    }

    public int getFranja() {
        return franja;
    }

    public void setFranja(int franja) {
        this.franja = franja;
    }
}
