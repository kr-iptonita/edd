package unam.fciencias.math;

public class ProgresionGeometrica extends Progresion {
    private int razon;

    public ProgresionGeometrica(int razon) {
        this.razon = razon;
    }

    @Override
    public int getSiguiente() {
        valorActual = valorActual == 0 ? 1 : valorActual * razon;
        return valorActual;
    }
}