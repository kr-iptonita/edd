package mx.unam.fciencias.edd;

import mx.unam.fciencias.edd.logica.GestorColas;
import mx.unam.fciencias.edd.vista.InterfazUsuario;

public class App {
    public static void main(String[] args) {
        GestorColas gestor = new GestorColas(4); // Inicializa 4 cajas o el número deseado
        InterfazUsuario interfaz = new InterfazUsuario(gestor);
        interfaz.iniciar();
    }
}