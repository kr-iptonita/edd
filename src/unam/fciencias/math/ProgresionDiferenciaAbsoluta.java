package unam.fciencias.math;

// Clase que representa una progresión basada en la diferencia absoluta de los dos valores anteriores
public class ProgresionDiferenciaAbsoluta extends Progresion {
    // Variables para almacenar los dos valores previos en la progresión
    private int previo1;
    private int previo2;

    // Constructor por defecto que inicializa la progresión con valores predeterminados
    public ProgresionDiferenciaAbsoluta() {
        this(2, 200); // Llama al constructor con parámetros
    }

    // Constructor que permite inicializar la progresión con valores específicos
    public ProgresionDiferenciaAbsoluta(int inicio1, int inicio2) {
        previo1 = inicio1; // Asigna el primer valor inicial
        previo2 = inicio2; // Asigna el segundo valor inicial
        valorActual = inicio2; // Establece el valor actual de la progresión
    }

    // Método que calcula y devuelve el siguiente valor en la progresión
    @Override
    public int getSiguiente() {
        int siguiente = Math.abs(previo1 - previo2); // Calcula la diferencia absoluta entre los dos valores previos
        previo1 = previo2; // Actualiza previo1 al valor de previo2
        previo2 = siguiente; // Actualiza previo2 al nuevo valor calculado
        valorActual = siguiente; // Actualiza el valor actual de la progresión
        return valorActual; // Devuelve el valor actual
    }
}
