package unam.fciencias.math;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de Progresiones:");
            System.out.println("1. Progresión Geométrica");
            System.out.println("2. Progresión de Fibonacci");
            System.out.println("3. Progresión de Diferencia Absoluta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    probarProgresionGeometrica(scanner);
                    break;
                case 2:
                    probarProgresionFibonacci(scanner);
                    break;
                case 3:
                    probarProgresionDiferenciaAbsoluta(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void probarProgresionGeometrica(Scanner scanner) {
        System.out.print("Ingrese el factor de incremento: ");
        int factor = scanner.nextInt();
        ProgresionGeometrica pg = new ProgresionGeometrica(factor);
        System.out.print("Progresión Geométrica: ");
        pg.imprimeNValores(15);
    }

    private static void probarProgresionFibonacci(Scanner scanner) {
        System.out.println("1. Primeros 15 números de Fibonacci");
        System.out.println("2. Calcular progresión dados dos números (n y m)");
        System.out.print("Seleccione una opción: ");
        int subOpcion = scanner.nextInt();

        if (subOpcion == 1) {
            ProgresionFibonacci pf = new ProgresionFibonacci();
            System.out.print("Progresión de Fibonacci: ");
            pf.imprimeNValores(15);
        } else if (subOpcion == 2) {
            System.out.print("Ingrese el primer número (n): ");
            int n = scanner.nextInt();
            System.out.print("Ingrese el segundo número (m): ");
            int m = scanner.nextInt();

            // Crear una instancia de ProgresionFibonacci
            ProgresionFibonacci pf = new ProgresionFibonacci();

            // Inicializar los valores previos con n y m
            pf.setPrevios(n, m);

            System.out.print("Progresión de Fibonacci personalizada: ");
            pf.imprimeNValores(15);
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private static void probarProgresionDiferenciaAbsoluta(Scanner scanner) {
        System.out.println("1. Constructor por omisión (2 y 200)");
        System.out.println("2. Constructor con valores de inicio dados por el usuario");
        System.out.print("Seleccione una opción: ");
        int subOpcion = scanner.nextInt();

        if (subOpcion == 1) {
            ProgresionDiferenciaAbsoluta pda = new ProgresionDiferenciaAbsoluta();
            System.out.print("Progresión de Diferencia Absoluta: ");
            pda.imprimeNValores(15);
        } else if (subOpcion == 2) {
            System.out.print("Ingrese el primer valor de inicio: ");
            int inicio1 = scanner.nextInt();
            System.out.print("Ingrese el segundo valor de inicio: ");
            int inicio2 = scanner.nextInt();
            ProgresionDiferenciaAbsoluta pda = new ProgresionDiferenciaAbsoluta(inicio1, inicio2);
            System.out.print("Progresión de Diferencia Absoluta personalizada: ");
            pda.imprimeNValores(15);
        } else {
            System.out.println("Opción no válida.");
        }
    }
}