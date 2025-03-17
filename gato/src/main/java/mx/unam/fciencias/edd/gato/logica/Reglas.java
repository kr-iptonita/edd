package mx.unam.fciencias.edd.gato.logica;

import mx.unam.fciencias.edd.gato.modelo.Matriz;
/*
 * La clase Reglas es la encargada de manejar la lógica del juego.
 */
public class Reglas {//Clase que contiene las reglas del juego
    private Matriz matriz;

    public Reglas() {
        matriz = new Matriz();//Se crea una nueva matriz
    }

    public void cambiarJugador() {
        String jugadorActual = matriz.getJugadorActual();//Se obtiene el jugador actual
        matriz.setJugadorActual(jugadorActual.equals("X") ? "O" : "X");//Se cambia el jugador actual
    }

    public boolean realizarMovimiento(int posicion) {//Método que realiza un movimiento
        if (matriz.esMovimientoValido(posicion)) {//Si el movimiento es válido
            matriz.realizarMovimiento(posicion, matriz.getJugadorActual());
            return true;//Se realiza el movimiento
        }
        return false;
    }

    public boolean hayGanador() {//Método que verifica si hay un ganador
        return matriz.hayGanador();
    }

    public boolean hayEmpate() {//Método que verifica si hay un empate
        return matriz.hayEmpate();
    }

    public String getJugadorActual() {//Método que obtiene el jugador actual
        return matriz.getJugadorActual();
    }

    public String[] getEstadomatriz() {//Método que obtiene el estado de la matriz
        return matriz.getCeldas();
    }
}