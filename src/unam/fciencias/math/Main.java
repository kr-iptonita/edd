package unam.fciencias.math;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Bucle principal del menú
        do {

            System.out.println("\n  |\\__/,|   (`\\");
            System.out.println("  |_ _  |.--.) )");
            System.out.println("  ( T   )     /");
            System.out.println(" (((^_(((/(((_/");

            // Mostrar el menú de opciones
            System.out.println("\nMenú de Progresiones:");
            System.out.println("1. Progresión Geométrica");
            System.out.println("2. Progresión de Fibonacci");
            System.out.println("3. Progresión de Diferencia Absoluta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            // Switch para manejar la opción seleccionada por el usuario
            switch (opcion) {
                case 1:
                    // Llamar al método para probar la progresión geométrica
                    probarProgresionGeometrica(scanner);
                    break;
                case 2:
                    // Llamar al método para probar la progresión de Fibonacci
                    probarProgresionFibonacci(scanner);
                    break;
                case 3:
                    // Llamar al método para probar la progresión de diferencia absoluta
                    probarProgresionDiferenciaAbsoluta(scanner);
                    break;
                case 4:
                    // Salir del programa
                    System.out.println("Saliendo...");
                    break;
                default:
                    // Opción no válida
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4); // Continuar hasta que el usuario seleccione salir

        // Cerrar el scanner
        scanner.close();
    }

    // Método para probar la progresión geométrica
    private static void probarProgresionGeometrica(Scanner scanner) {
        // Solicitar al usuario el factor de incremento
        System.out.print("Ingrese el factor de incremento: ");
        int factor = scanner.nextInt();

        // Crear una instancia de ProgresionGeometrica con el factor proporcionado
        ProgresionGeometrica pg = new ProgresionGeometrica(factor);

        // Imprimir los primeros 15 valores de la progresión geométrica
        System.out.print("Progresión Geométrica: ");
        pg.imprimeNValores(15);
    }

    // Método para probar la progresión de Fibonacci
    private static void probarProgresionFibonacci(Scanner scanner) {
        // Mostrar submenú para la progresión de Fibonacci
        System.out.println("1. Primeros 15 números de Fibonacci");
        System.out.println("2. Calcular progresión dados dos números (n y m)");
        System.out.print("Seleccione una opción: ");
        int subOpcion = scanner.nextInt();

        if (subOpcion == 1) {
            // Crear una instancia de ProgresionFibonacci y mostrar los primeros 15 números
            ProgresionFibonacci pf = new ProgresionFibonacci();
            System.out.print("Progresión de Fibonacci: ");
            pf.imprimeNValores(15);
        } else if (subOpcion == 2) {
            // Solicitar al usuario los valores iniciales n y m
            System.out.print("Ingrese el primer número (n): ");
            int n = scanner.nextInt();
            System.out.print("Ingrese el segundo número (m): ");
            int m = scanner.nextInt();

            // Crear una instancia de ProgresionFibonacci
            ProgresionFibonacci pf = new ProgresionFibonacci();

            // Inicializar los valores previos con n y m
            pf.setPrevios(n, m);

            // Imprimir los primeros 15 valores de la progresión personalizada
            System.out.print("Progresión de Fibonacci personalizada: ");
            pf.imprimeNValores(15);
        } else {
            // Opción no válida
            System.out.println("Opción no válida.");
        }
    }

    // Método para probar la progresión de diferencia absoluta
    private static void probarProgresionDiferenciaAbsoluta(Scanner scanner) {
        // Mostrar submenú para la progresión de diferencia absoluta
        System.out.println("1. Constructor por omisión (2 y 200)");
        System.out.println("2. Constructor con valores de inicio dados por el usuario");
        System.out.print("Seleccione una opción: ");
        int subOpcion = scanner.nextInt();

        if (subOpcion == 1) {
            // Crear una instancia de ProgresionDiferenciaAbsoluta con valores por omisión
            ProgresionDiferenciaAbsoluta pda = new ProgresionDiferenciaAbsoluta();
            System.out.print("Progresión de Diferencia Absoluta: ");
            pda.imprimeNValores(15);
        } else if (subOpcion == 2) {
            // Solicitar al usuario los valores iniciales
            System.out.print("Ingrese el primer valor de inicio: ");
            int inicio1 = scanner.nextInt();
            System.out.print("Ingrese el segundo valor de inicio: ");
            int inicio2 = scanner.nextInt();

            // Crear una instancia de ProgresionDiferenciaAbsoluta con los valores proporcionados
            ProgresionDiferenciaAbsoluta pda = new ProgresionDiferenciaAbsoluta(inicio1, inicio2);

            // Imprimir los primeros 15 valores de la progresión personalizada
            System.out.print("Progresión de Diferencia Absoluta personalizada: ");
            pda.imprimeNValores(15);
        } else {
            // Opción no válida
            System.out.println("Opción no válida.");
        }
    }
}