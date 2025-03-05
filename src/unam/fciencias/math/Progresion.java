package unam.fciencias.math;

public abstract class Progresion {
    protected int valorActual; // Valor actual de la progresión

    /**
     * Constructor de la clase. Inicializa el valor actual a 0.
     */
    public Progresion() {
        valorActual = 0;
    }

    /**
     * Método que devuelve el valor actual de la progresión.
     *
     * @return El valor actual de la progresión.
     */
    public int getValorActual() {
        return valorActual;
    }

    /**
     * Método para reiniciar la progresión al valor inicial.
     */
    public void reestablecerValor() {
        valorActual = 0;
    }

    /**
     * Método abstracto que devuelve el siguiente valor de la progresión.
     *
     * @return El siguiente valor de la progresión.
     */
    public abstract int getSiguiente();

    /**
     * Método que devuelve el i-ésimo valor de la progresión.
     *
     * @param i El índice del valor deseado.
     * @return El i-ésimo valor de la progresión.
     */
    public int getIesimo(int i) {
        reestablecerValor();
        for (int j = 0; j < i; j++) {
            getSiguiente();
        }
        return getValorActual();
    }

    /**
     * Método para imprimir los primeros n valores de la progresión en formato [a, b, c, ...].
     *
     * param n El número de valores a imprimir.
     */
    public void imprimeNValores(int n) {
        reestablecerValor(); // Reinicia la progresión al valor inicial
        StringBuilder sb = new StringBuilder("["); // Inicia el StringBuilder con un corchete de apertura

        for (int i = 0; i < n; i++) {
            sb.append(getValorActual()); // Agrega el valor actual al StringBuilder
            if (i < n - 1) {
                sb.append(", "); // Agrega una coma y un espacio si no es el último valor
            }
            getSiguiente(); // Avanza al siguiente valor
        }

        sb.append("]"); // Cierra el StringBuilder con un corchete de cierre
        System.out.println(sb.toString()); // Imprime el resultado
    }
}