package mx.unam.fciencias.edd.gato;

import mx.unam.fciencias.edd.gato.vista.InterfazUsuario;
/*
 * Clase principal que inicia la aplicación. Aquí se crea una instancia de la interfaz de usuario y se inicia el juego.
 */
public class App {
    public static void main(String[] args) {
        InterfazUsuario interfaz = new InterfazUsuario(); //Se crea una instancia de la interfaz de usuario
        interfaz.iniciar();
    }
}
