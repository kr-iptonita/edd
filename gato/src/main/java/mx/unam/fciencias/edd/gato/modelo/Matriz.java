package mx.unam.fciencias.edd.gato.modelo;

public class Matriz {
    private String[] celdas;
    private String jugadorActual;

    public Matriz() {
        celdas = new String[9];
        jugadorActual = "X";
        inicializarMatriz();
    }

    private void inicializarMatriz() {
        for (int i = 0; i < 9; i++) {
            celdas[i] = String.valueOf(i + 1);
        }
    }

    public String[] getCeldas() {
        return celdas;
    }

    public String getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(String jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public void realizarMovimiento(int posicion, String jugador) {
        celdas[posicion] = jugador;
    }

    public boolean esMovimientoValido(int posicion) {
        return celdas[posicion].equals(String.valueOf(posicion + 1));
    }

    public boolean hayGanador() {
        int[][] combinaciones = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Filas
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columnas
            {0, 4, 8}, {2, 4, 6}            // Diagonales
        };

        for (int[] combinacion : combinaciones) {
            if (celdas[combinacion[0]].equals(celdas[combinacion[1]]) &&
                celdas[combinacion[1]].equals(celdas[combinacion[2]])) {
                return true;
            }
        }
        return false;
    }

    public boolean hayEmpate() {
        for (String celda : celdas) {
            if (celda.matches("[1-9]")) {
                return false;
            }
        }
        return true;
    }
}