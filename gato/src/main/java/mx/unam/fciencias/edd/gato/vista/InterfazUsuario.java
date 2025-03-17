package mx.unam.fciencias.edd.gato.vista;

import mx.unam.fciencias.edd.gato.logica.Reglas;
import java.util.Scanner;

public class InterfazUsuario {
    private Reglas reglas;
    private Scanner scanner;

    public InterfazUsuario() {
        reglas = new Reglas();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("¡Bienvenido a Tic-Tac-Toe!");
        mostrarTablero();

        while (true) {
            System.out.println("Es el turno de " + reglas.getJugadorActual() + ". Ingresa una posición (1-9):");
            int posicion = scanner.nextInt() - 1;

            if (posicion >= 0 && posicion < 9 && reglas.realizarMovimiento(posicion)) {
                mostrarTablero();

                if (reglas.hayGanador()) {
                    System.out.println("¡Felicidades! " + reglas.getJugadorActual() + " ha ganado.");
                    break;
                } else if (reglas.hayEmpate()) {
                    System.out.println("¡Es un empate!");
                    break;
                }

                reglas.cambiarJugador();
            } else {
                System.out.println("Movimiento inválido. Intenta de nuevo.");
            }
        }
    }

    private void mostrarTablero() {
        String[] celdas = reglas.getEstadomatriz();
        System.out.println("#############");
        System.out.println("| " + celdas[0] + " | " + celdas[1] + " | " + celdas[2] + " |");
        System.out.println("| " + celdas[3] + " | " + celdas[4] + " | " + celdas[5] + " |");
        System.out.println("| " + celdas[6] + " | " + celdas[7] + " | " + celdas[8] + " |");
        System.out.println("#############");
    }
}