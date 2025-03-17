package mx.unam.fciencias.edd.gato.logica;

import mx.unam.fciencias.edd.gato.modelo.Matriz;

public class Reglas {
    private Matriz matriz;

    public Reglas() {
        matriz = new Matriz();
    }

    public void cambiarJugador() {
        String jugadorActual = matriz.getJugadorActual();
        matriz.setJugadorActual(jugadorActual.equals("X") ? "O" : "X");
    }

    public boolean realizarMovimiento(int posicion) {
        if (matriz.esMovimientoValido(posicion)) {
            matriz.realizarMovimiento(posicion, matriz.getJugadorActual());
            return true;
        }
        return false;
    }

    public boolean hayGanador() {
        return matriz.hayGanador();
    }

    public boolean hayEmpate() {
        return matriz.hayEmpate();
    }

    public String getJugadorActual() {
        return matriz.getJugadorActual();
    }

    public String[] getEstadomatriz() {
        return matriz.getCeldas();
    }
}