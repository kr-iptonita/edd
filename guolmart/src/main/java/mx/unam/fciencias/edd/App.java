package mx.unam.fciencias.edd;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        GestorColas gestor = new GestorColas(4); // Inicializa 4 cajas
        // Puedes cambiar el número de cajas según sea necesario
        InterfazUsuario interfaz = new InterfazUsuario(gestor);
        interfaz.iniciar();
    }
}

class Cliente {   // Clase Cliente para representar a un cliente
    // con su ID y la cantidad de artículos que tiene
    private String id;  // ID del cliente
    private int cantidadArticulos; // Cantidad de artículos del cliente
    
    public Cliente(String id, int cantidadArticulos) {
        this.id = id;
        this.cantidadArticulos = cantidadArticulos; // Inicializa el ID y la cantidad de artículos
    }
    
    public String getId() {
        return id; // Devuelve el ID del cliente
    }
    
    public int getCantidadArticulos() {
        return cantidadArticulos; // Devuelve la cantidad de artículos del cliente
    }
    
    public void setCantidadArticulos(int cantidad) {// Cambia la cantidad de artículos del cliente
        this.cantidadArticulos = cantidad;
    }
    
    @Override
    public String toString() {
        return "Cliente " + id + " (" + cantidadArticulos + " artículos)";
    }
}
// La clase Caja representa una caja de supermercado
// y contiene una cola de clientes que esperan para ser atendidos
// La clase Caja tiene métodos para agregar y remover clientes de la cola
class Caja { 
    private int numero;
    private Queue<Cliente> cola;
    private int totalArticulosEnCola;
    // Constructor de la clase Caja
    // Inicializa el número de caja y la cola de clientes
    public Caja(int numero) {
        this.numero = numero;
        this.cola = new LinkedList<>();
        this.totalArticulosEnCola = 0;
    }
    // Método para agregar un cliente a la cola
    // y actualizar el total de artículos en la cola
    public void agregarCliente(Cliente cliente) {
        cola.offer(cliente);
        totalArticulosEnCola += cliente.getCantidadArticulos();
    }
    // Método para remover un cliente de la cola
    public Cliente removerCliente() {// Remueve el cliente al frente de la cola
        Cliente cliente = cola.poll();
        if (cliente != null) {// Si el cliente no es nulo, actualiza el total de artículos
            totalArticulosEnCola -= cliente.getCantidadArticulos();
        }
        return cliente;
    }
    
    public boolean removerClienteEspecifico(String idCliente) {// Remueve un cliente específico de la cola
        Queue<Cliente> colaTemporal = new LinkedList<>();
        boolean encontrado = false;
        // 
        while (!cola.isEmpty()) {
            Cliente cliente = cola.poll(); // Remueve el cliente al frente de la cola 
            if (cliente.getId().equals(idCliente)) {// Si el cliente es el que se busca
                // Actualiza el total de artículos en la cola
                totalArticulosEnCola -= cliente.getCantidadArticulos();
                encontrado = true;// Marca que se encontró el cliente
                break;
            }
            colaTemporal.offer(cliente);// Si no es el cliente buscado, lo agrega a la cola temporal
        }
        
        // Reconstruir la cola
        while (!colaTemporal.isEmpty()) {
            cola.offer(colaTemporal.poll());// Agrega los clientes de la cola temporal a la cola original
        }
        
        return encontrado;// Devuelve true si se encontró y removió el cliente, false en caso contrario
    }
    
    public int getTotalArticulosEnCola() {// Devuelve el total de artículos en la cola
        return totalArticulosEnCola;
    }
    
    public int getNumeroClientesEnCola() {// Devuelve el número de clientes en la cola
        return cola.size();
    }
    
    public int getNumero() {// Devuelve el número de la caja
        return numero;
    }
    
    public Queue<Cliente> getCola() {// Devuelve la cola de clientes
        // Se devuelve una copia de la cola para evitar modificaciones externas
        return cola;
    }
    
    public boolean actualizarCliente(String idCliente, int nuevaCantidad) {// Actualiza la cantidad de artículos de un cliente específico
        for (Cliente cliente : cola) {
            if (cliente.getId().equals(idCliente)) {// Si el cliente es el que se busca
                int diferencia = nuevaCantidad - cliente.getCantidadArticulos();
                cliente.setCantidadArticulos(nuevaCantidad);
                totalArticulosEnCola += diferencia;// Actualiza el total de artículos en la cola
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {// Devuelve una representación en cadena de la caja
        return "Caja " + numero + " - " + getNumeroClientesEnCola() + 
               " clientes (" + totalArticulosEnCola + " artículos)";
    }
}

class GestorColas {// Clase GestorColas para gestionar las cajas y los clientes
    // Contiene un arreglo de cajas y métodos para asignar clientes a las cajas
    private Caja[] cajas;
    
    public GestorColas(int numeroCajas) {// Constructor de la clase GestorColas
        cajas = new Caja[numeroCajas];// Inicializa el arreglo de cajas
        for (int i = 0; i < numeroCajas; i++) {
            cajas[i] = new Caja(i + 1);// Crea una nueva caja con el número correspondiente
        }
    }
    
    public int asignarClienteACola(Cliente cliente) {// Asigna un cliente a la caja con menos artículos en cola
        int mejorCaja = 0;// Inicializa la mejor caja como la primera
        int menorArticulos = cajas[0].getTotalArticulosEnCola();// Obtiene el total de artículos en la primera caja
        
        for (int i = 1; i < cajas.length; i++) {
            int articulos = cajas[i].getTotalArticulosEnCola();// Obtiene el total de artículos en la caja actual
            if (articulos < menorArticulos) {
                menorArticulos = articulos;// Actualiza el menor total de artículos
                mejorCaja = i;// Actualiza la mejor caja
            }
        }
        
        cajas[mejorCaja].agregarCliente(cliente);// Agrega el cliente a la mejor caja
        return mejorCaja + 1; // +1 porque las cajas se numeran desde 1
    }
    
    public boolean removerClienteDeCola(int numeroCaja, String idCliente) {// Remueve un cliente de la cola de una caja específica
        if (numeroCaja < 1 || numeroCaja > cajas.length) return false;// Verifica que el número de caja sea válido
        return cajas[numeroCaja - 1].removerClienteEspecifico(idCliente);// Remueve el cliente de la caja especificada
    }
    
    public boolean actualizarArticulosCliente(String idCliente, int nuevaCantidad) {
        for (Caja caja : cajas) {// Recorre todas las cajas
            if (caja.actualizarCliente(idCliente, nuevaCantidad)) {
                return true;// Si se actualiza el cliente, devuelve true
            }
        }
        return false;
    }
    
    public void mostrarEstadoCajas() {// Muestra el estado actual de todas las cajas
        System.out.println("\n--- Estado actual de las cajas ---");
        for (Caja caja : cajas) {// Recorre todas las cajas
            System.out.println(caja);
            for (Cliente cliente : caja.getCola()) {// Recorre la cola de clientes de cada caja
                System.out.println("  " + cliente); 
            }
        }
        System.out.println("-----------------------------------\n");// Muestra una línea divisoria para embellecer la salida
    }
    
    public Caja[] getCajas() {// Devuelve el arreglo de cajas
        return cajas;
    }
}

class InterfazUsuario {// Clase InterfazUsuario para interactuar con el usuario
    // Contiene un objeto GestorColas y un Scanner para leer la entrada del usuario
    private GestorColas gestor;
    private Scanner scanner;
    
    public InterfazUsuario(GestorColas gestor) {

        this.gestor = gestor;// Inicializa el gestor de colas
        // Inicializa el escáner para leer la entrada del usuario
        this.scanner = new Scanner(System.in);
    }
    
    public void iniciar() {// Muestra el título del sistema
        System.out.println("Bienvenido al sistema de gestión de colas de Güol-Mart.\n");
        
        while (true) {// Bucle infinito para mostrar el menú hasta que el usuario decida salir
            System.out.println("Opciones escriba el número correspondiente a la acción que desea elegir:");// Muestra las opciones disponibles
            System.out.println("1. Agregar nuevo cliente");
            System.out.println("2. Actualizar artículos de cliente");
            System.out.println("3. Remover cliente (abandono)");
            System.out.println("4. Mostrar estado de cajas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();// Lee la opción seleccionada por el usuario
            scanner.nextLine(); // Consumir el salto de línea
            
            switch (opcion) {// Evalúa la opción seleccionada
                case 1:// Agregar nuevo cliente
                    agregarCliente();
                    break;
                case 2:// Actualizar artículos de cliente
                    actualizarCliente();
                    break;
                case 3:// Remover cliente (abandono)
                    removerCliente();
                    break;
                case 4:// Mostrar estado de cajas
                    gestor.mostrarEstadoCajas();
                    break;
                case 5:// Salir del sistema
                    System.out.println("Saliendo del sistema...");
                    return;
                default:// Opción no válida
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
    
    private void agregarCliente() {
        System.out.print("Ingrese ID del cliente: ");// Solicita el ID del cliente
        String id = scanner.nextLine();// Lee el ID del cliente
        // Verifica que el ID no esté vacío
        if (id.isEmpty()) {
            System.out.println("El ID del cliente no puede estar vacío.");
            return;
        }
        
        System.out.print("Ingrese cantidad de artículos: ");
        int articulos = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        // Verifica que la cantidad de artículos sea mayor a 0
        if (articulos <= 0) {
            System.out.println("La cantidad de artículos debe ser mayor a 0.");
            return;
        }

        
        Cliente cliente = new Cliente(id, articulos);
        int cajaAsignada = gestor.asignarClienteACola(cliente);// Asigna el cliente a la caja con menos artículos en cola
        // Muestra el ID del cliente y la caja a la que fue asignado 
        System.out.println("Cliente " + cliente.getId() + " asignado a la Caja " + cajaAsignada);
        // Muestra el estado actual de las cajas
        System.out.println("Cliente " + cliente.getId() + " con " + cliente.getCantidadArticulos() + " artículos.");
        // Muestra el estado actual de las cajas
        System.out.println("Cliente asignado a la Caja " + cajaAsignada);// Muestra la caja asignada
        gestor.mostrarEstadoCajas();
    }
    
    private void actualizarCliente() {// Actualiza la cantidad de artículos de un cliente
        System.out.print("Ingrese ID del cliente a actualizar: ");// Solicita el ID del cliente puede ser cualquier cliente un no necesariamente el primero de la cola
        String id = scanner.nextLine();
        // Verifica que el ID no esté vacío
        if (id.isEmpty()) {
            System.out.println("El ID del cliente no puede estar vacío.");
            return;
        }
        System.out.print("Ingrese nueva cantidad de artículos: ");// Solicita la nueva cantidad de artículos
        int nuevaCantidad = scanner.nextInt();// Lee la nueva cantidad de artículos
        scanner.nextLine(); // Consumir el salto de línea
        // Verifica que la nueva cantidad de artículos sea mayor a 0
        if (nuevaCantidad <= 0) {
            System.out.println("La cantidad de artículos debe ser mayor a 0.");
            return;
        }

        boolean exito = gestor.actualizarArticulosCliente(id, nuevaCantidad);// Actualiza la cantidad de artículos del cliente
        // Verifica si la actualización fue exitosa
         // Si el cliente fue encontrado y actualizado, muestra un mensaje de éxito
         // Si no fue encontrado, muestra un mensaje de error
        // y no se actualiza la cantidad de artículos
        
        if (exito) {// Si el cliente fue encontrado y actualizado
            System.out.println("Cliente " + id + " actualizado a " + nuevaCantidad + " artículos.");
            //System.out.println("Cliente actualizado correctamente.");
            gestor.mostrarEstadoCajas();
        } else {
            System.out.println("No se encontró al cliente con ID " + id); // Si no fue encontrado, muestra un mensaje de error
            //System.out.println("No se pudo actualizar al cliente. Verifique los datos.");
        }
    }
    
    private void removerCliente() {// Remueve un cliente de la cola
        System.out.println("Remover cliente de la cola de una caja.");  // Muestra un mensaje indicando que se va a remover un cliente

        gestor.mostrarEstadoCajas();// Muestra el estado actual de las cajas
        
        System.out.print("Ingrese número de caja donde está el cliente: ");// Solicita el número de caja donde está el cliente
        // Verifica que el número de caja sea válido
        // Si no es válido, muestra un mensaje de error y sale del método
        int caja = scanner.nextInt();// Lee el número de caja
        scanner.nextLine(); // Consumir el salto de línea
        
        System.out.print("Ingrese ID del cliente a remover: ");// Solicita el ID del cliente a remover
        // Verifica que el ID no esté vacío
        // Si está vacío, muestra un mensaje de error y sale del método
        if (caja < 1 || caja > gestor.getCajas().length) {
            System.out.println("Número de caja no válido. Debe estar entre 1 y " + gestor.getCajas().length);
            return;
        }
        String id = scanner.nextLine(); // Lee el ID del cliente a remover
        
        boolean exito = gestor.removerClienteDeCola(caja, id);// Remueve el cliente de la cola de la caja especificada
        // Verifica si la remoción fue exitosa
        // Si el cliente fue encontrado y removido, muestra un mensaje de éxito
        // Si no fue encontrado, muestra un mensaje de error
        
        if (exito) {// Si el cliente fue encontrado y removido
            System.out.println("Cliente " + id + " removido de la Caja " + caja + ".");// Muestra un mensaje de éxito
            //System.out.println("Cliente removido correctamente.");
            gestor.mostrarEstadoCajas();
        } else {// Si no fue encontrado, muestra un mensaje de error
            System.out.println("No se encontró al cliente con ID " + id + " en la Caja " + caja);// Muestra un mensaje de error
        }
    }
}