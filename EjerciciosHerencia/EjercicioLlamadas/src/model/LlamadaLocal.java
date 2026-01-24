package model;

public final class LlamadaLocal extends Llamada{

    public LlamadaLocal(long nOrigen, long nDestino, int duracion){
        super(nOrigen, nDestino, duracion);
    }

    public LlamadaLocal(){}
    @Override
    public void calcularCoste() {
        setCoste(0);
    }


}