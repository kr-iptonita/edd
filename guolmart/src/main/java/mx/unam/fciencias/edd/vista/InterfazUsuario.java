package mx.unam.fciencias.edd.vista;

import java.util.Scanner;
import mx.unam.fciencias.edd.logica.GestorColas;
import mx.unam.fciencias.edd.modelo.Cliente;

public class InterfazUsuario {
    private GestorColas gestor;
    private Scanner scanner;
    
    public InterfazUsuario(GestorColas gestor) {
        this.gestor = gestor;
        this.scanner = new Scanner(System.in);
    }
    
    public void iniciar() {
        System.out.println("Bienvenido al sistema de gestión de colas de Güol-Mart.");
        
        while (true) {
            System.out.println("Opciones escriba el número correspondiente a la acción que desea elegir:");
            System.out.println("1. Agregar nuevo cliente ");
            System.out.println("2. Actualizar artículos de cliente");
            System.out.println("3. Remover cliente (abandono)");
            System.out.println("4. Mostrar estado de cajas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    actualizarCliente();
                    break;
                case 3:
                    removerCliente();
                    break;
                case 4:
                    gestor.mostrarEstadoCajas();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
    
    private void agregarCliente() {
        System.out.print("Ingrese ID del cliente: ");
        String id = scanner.nextLine();
        if (id.isEmpty()) {
            System.out.println("El ID del cliente no puede estar vacío.");
            return;
        }
        System.out.print("Ingrese cantidad de artículos: ");
        int articulos = scanner.nextInt();
        scanner.nextLine();
        if (articulos <= 0) {
            System.out.println("La cantidad de artículos debe ser mayor a 0.");
            return;
        }
        
        Cliente cliente = new Cliente(id, articulos);
        int cajaAsignada = gestor.asignarClienteACola(cliente);
        System.out.println("Cliente " + cliente.getId() + " asignado a la Caja " + cajaAsignada);
        gestor.mostrarEstadoCajas();
    }
    
    private void actualizarCliente() {
        System.out.print("Ingrese ID del cliente a actualizar: ");
        String id = scanner.nextLine();
        if (id.isEmpty()) {
            System.out.println("El ID del cliente no puede estar vacío.");
            return;
        }
        System.out.print("Ingrese nueva cantidad de artículos: ");
        int nuevaCantidad = scanner.nextInt();
        scanner.nextLine();
        if (nuevaCantidad <= 0) {
            System.out.println("La cantidad de artículos debe ser mayor a 0.");
            return;
        }
        
        boolean exito = gestor.actualizarArticulosCliente(id, nuevaCantidad);
        if (exito) {
            System.out.println("Cliente " + id + " actualizado a " + nuevaCantidad + " artículos.");
            gestor.mostrarEstadoCajas();
        } else {
            System.out.println("No se encontró al cliente con ID " + id);
        }
    }
    
    private void removerCliente() {
        System.out.println("Remover cliente de la cola de una caja.");
        gestor.mostrarEstadoCajas();
        System.out.print("Ingrese número de caja donde está el cliente: ");
        int caja = scanner.nextInt();
        scanner.nextLine();
        if (caja < 1 || caja > gestor.getCajas().length) {
            System.out.println("Número de caja no válido. Debe estar entre 1 y " + gestor.getCajas().length);
            return;
        }
        System.out.print("Ingrese ID del cliente a remover: ");
        String id = scanner.nextLine();
        boolean exito = gestor.removerClienteDeCola(caja, id);
        if (exito) {
            System.out.println("Cliente " + id + " removido de la Caja " + caja + ".");
            gestor.mostrarEstadoCajas();
        } else {
            System.out.println("No se encontró al cliente con ID " + id + " en la Caja " + caja);
        }
    }
}