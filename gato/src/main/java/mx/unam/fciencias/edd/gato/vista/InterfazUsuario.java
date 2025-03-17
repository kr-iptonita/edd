package mx.unam.fciencias.edd.gato.vista;

import mx.unam.fciencias.edd.gato.logica.Reglas;
import java.util.Scanner;

public class InterfazUsuario {//Clase que contiene la interfaz de usuario
    private Reglas reglas;
    private Scanner scanner;

    public InterfazUsuario() {
        reglas = new Reglas();
        scanner = new Scanner(System.in);//Se crea un nuevo scanner
    }

    public void iniciar() {//Método que inicia el juego
        System.out.println("Gatito. ¡Juega conmigo!");
        mostrarTablero();

        while (true) {
            System.out.println("Es el turno de " + reglas.getJugadorActual() + ". Ingresa una posición (1-9):");
            int posicion = scanner.nextInt() - 1;//Se obtiene la posición

            if (posicion >= 0 && posicion < 9 && reglas.realizarMovimiento(posicion)) {
                mostrarTablero();//Se muestra el tablero

                if (reglas.hayGanador()) {//Si hay un ganador
                    System.out.println("¡Felicidades! " + reglas.getJugadorActual() + " ha ganado.");
                    break; //Se termina el juego
                } else if (reglas.hayEmpate()) {
                    System.out.println("Empate");
                    break;//Si hay un empate se termina el juego
                }

                reglas.cambiarJugador();
            } else {
                System.out.println("Movimiento inválido. Intenta de nuevo.");//Si el movimiento es inválido
            }
        }
    }

    private void mostrarTablero() {
        String[] celdas = reglas.getEstadomatriz();//Se obtiene el estado de la matriz
        System.out.println("================");//Se muestra el tablero
        System.out.println("|| " + celdas[0] + " || " + celdas[1] + " || " + celdas[2] + " ||");
        System.out.println("|| " + celdas[3] + " || " + celdas[4] + " || " + celdas[5] + " ||");
        System.out.println("|| " + celdas[6] + " || " + celdas[7] + " || " + celdas[8] + " ||");
        System.out.println("================");
}
}


