package unam.fciencias.math;

/**
 * Clase abstracta que define una progresión numérica.
 */
public abstract class Progresion {
    protected long actual;

    // Constructor por omisión
    public Progresion() {
        this.actual = 0;
    }

    // Constructor con parámetro inicial
    public Progresion(long inicio) {
        this.actual = inicio;
    }

    // Método abstracto que define cómo avanza la progresión
    protected abstract void avanzar();

    // Método que imprime los primeros n términos de la progresión
    public void imprimir(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(actual + " ");
            avanzar();
        }
        System.out.println();
    }
}
