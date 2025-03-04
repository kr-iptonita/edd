package unam.fciencias.math;

/**
 * Clase principal para probar las progresiones.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Progresión de prueba:");
        
        // Prueba de una progresión anónima (ejemplo de una progresión que suma 1 en cada paso)
        Progresion progresion = new Progresion() {
            @Override
            protected void avanzar() {
                actual += 1;
            }
        };

        // Imprimir los primeros 10 términos de la progresión de prueba
        progresion.imprimir(10);
    }
}
