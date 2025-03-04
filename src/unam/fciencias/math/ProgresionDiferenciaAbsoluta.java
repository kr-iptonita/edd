package unam.fciencias.math;

public class ProgresionDiferenciaAbsoluta extends Progresion {
    private int previo1;
    private int previo2;

    public ProgresionDiferenciaAbsoluta() {
        this(2, 200);
    }

    public ProgresionDiferenciaAbsoluta(int inicio1, int inicio2) {
        previo1 = inicio1;
        previo2 = inicio2;
        valorActual = inicio2;
    }

    @Override
    public int getSiguiente() {
        int siguiente = Math.abs(previo1 - previo2);
        previo1 = previo2;
        previo2 = siguiente;
        valorActual = siguiente;
        return valorActual;
    }
}
