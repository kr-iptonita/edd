package mx.unam.fciencias.edd.gato.modelo;
/*
 * Clase que representa la matriz del juego del gato. Aqui se almacenan las celdas del juego, el jugador actual y se verifican si hay un ganador o un empate.
 */
public class Matriz {//Clase que contiene la matriz del juego
    private String[] celdas;//Arreglo de celdas
    private String jugadorActual;//Jugador actual

    public Matriz() {
        celdas = new String[9];//Se crea un nuevo arreglo de celdas
        jugadorActual = "X";
        inicializarMatriz();
    }
    private void inicializarMatriz() {
        for (int i = 0; i < 9; i++) {//Se inicializa la matriz
            celdas[i] = String.valueOf(i + 1);
        }
    }
    public String[] getCeldas() {
        return celdas;//Se obtienen las celdas
    }
    public String getJugadorActual() {
        return jugadorActual;//Se obtiene el jugador actual
    }
    public void setJugadorActual(String jugadorActual) {
        this.jugadorActual = jugadorActual;//Se cambia el jugador actual
    }
    public void realizarMovimiento(int posicion, String jugador) {
        celdas[posicion] = jugador;//Se realiza un movimiento
    }
    public boolean esMovimientoValido(int posicion) {
        return celdas[posicion].equals(String.valueOf(posicion + 1));//Se verifica si el movimiento es válido
    }
/*
 * Almacenamos las combinaciones de celdas que forman una línea ganadora en un arreglo de arreglos de enteros. Cada subarreglo contiene las posiciones de las celdas que forman una línea ganadora.
 */
    public boolean hayGanador() {//Método que verifica si hay un ganador
        int[][] combinaciones = {//
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Filas
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columnas   
            {0, 4, 8}, {2, 4, 6}            // Diagonales
        };

        /*  
         * Al almacenar las combinaciones de celdas que forman una línea ganadora no podemos escalar el juego a una matriz de tamaño diferente a 3x3.
         */

        for (int[] combinacion : combinaciones) {
            if (celdas[combinacion[0]].equals(celdas[combinacion[1]]) &&
                celdas[combinacion[1]].equals(celdas[combinacion[2]])) {
                return true;
            }
        }//Se verifica si hay un ganador
        return false;//Si no hay ganador
    }
    public boolean hayEmpate() {
        for (String celda : celdas) {
            if (celda.matches("[1-9]")) {
                return false;
            }
        }//Se verifica si hay un empate
        return true;
    }
}