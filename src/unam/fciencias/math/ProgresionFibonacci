package unam.fciencias.math;

public class ProgresionFibonacci extends Progresion {
    private int previo;

    public ProgresionFibonacci() {
        previo = 1;
    }

    @Override
    public int getSiguiente() {
        int temp = valorActual;
        valorActual = valorActual + previo;
        previo = temp;
        return valorActual;
    }
}