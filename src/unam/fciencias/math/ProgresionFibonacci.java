package unam.fciencias.math;

public class ProgresionFibonacci extends Progresion {
    protected int previo1; // Cambiado a protected para acceso desde Main
    protected int previo2; // Cambiado a protected para acceso desde Main

    public ProgresionFibonacci() {
        previo1 = 0;
        previo2 = 1;
    }

    // Método para establecer los valores iniciales
    public void setPrevios(int n, int m) {
        previo1 = n;
        previo2 = m;
    }

    @Override
    public int getSiguiente() {
        int temporal = valorActual;
        valorActual = valorActual + previo1;
        previo1 = previo2;
        previo2 = valorActual;
        return valorActual;
    }
}