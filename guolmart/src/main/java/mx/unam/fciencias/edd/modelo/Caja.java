package mx.unam.fciencias.edd.modelo;// Clase Caja que representa una caja de supermercado

import java.util.LinkedList;// Importa la clase LinkedList para usar como cola
import java.util.Queue;// Importa la interfaz Queue para definir la cola de clientes

public class Caja {// Clase Caja que representa una caja de supermercado
    private int numero;// Número de la caja (1, 2, 3, ...)
    // Cola de clientes que esperan para ser atendidos en la caja
    private Queue<Cliente> cola;// Cola de clientes
    private int totalArticulosEnCola;
    
    public Caja(int numero) {// Constructor de la clase Caja
        this.numero = numero;// Asigna el número de la caja
        this.cola = new LinkedList<>();// Inicializa la cola de clientes
        this.totalArticulosEnCola = 0;// Inicializa el total de artículos en la cola
    }
    
    public void agregarCliente(Cliente cliente) {// Método para agregar un cliente a la cola de la caja
        cola.offer(cliente);// Agrega el cliente a la cola
        // Se actualiza el total de artículos en la cola sumando los artículos del cliente
        totalArticulosEnCola += cliente.getCantidadArticulos();
    }
    
    public Cliente removerCliente() {// Método para remover el cliente al frente de la cola
        // Se verifica si la cola está vacía antes de intentar remover un cliente
        // Si la cola está vacía, no se puede remover ningún cliente
        if (cola.isEmpty()) return null;// Si la cola está vacía, devuelve null
        Cliente cliente = cola.poll();// Remueve el cliente al frente de la cola
        if (cliente != null) {// Verifica que el cliente no sea null
            totalArticulosEnCola -= cliente.getCantidadArticulos();
        }
        return cliente;// Devuelve el cliente removido
    }
    
    public boolean removerClienteEspecifico(String idCliente) {// Método para remover un cliente específico de la cola
        // Se verifica si la cola está vacía antes de intentar remover un cliente
        // Si la cola está vacía, no se puede remover ningún cliente
        if (cola.isEmpty()) return false;// Si la cola está vacía, devuelve false
        Queue<Cliente> colaTemporal = new LinkedList<>();// Cola temporal para almacenar los clientes mientras se busca el cliente específico  
        boolean encontrado = false;
        while (!cola.isEmpty()) {// Mientras la cola no esté vacía
            Cliente cliente = cola.poll();
            if (cliente.getId().equals(idCliente)) {// Si se encuentra el cliente específico
                totalArticulosEnCola -= cliente.getCantidadArticulos();// Actualiza el total de artículos en la cola
                encontrado = true;// Marca que se encontró el client4
                break;// Sale del bucle si se encuentra el cliente
            }
            colaTemporal.offer(cliente);// Agrega el cliente a la cola temporal si no es el cliente específico
        }
        while (!colaTemporal.isEmpty()) {// Mientras la cola temporal no esté vacía
            // Se vuelve a agregar los clientes a la cola original
            cola.offer(colaTemporal.poll());
        }
        return encontrado;
    }
    
    /*
     * Las siguientes clases son muy parecidas entre sí y se pueden optimizar pero por el momento solo se dejarán así
     * para que sea más fácil de entender el código.
     * Se pueden crear métodos genéricos para evitar la repetición de código, Pero no tenia tiempo de realizar eso
     */

    public int getTotalArticulosEnCola() {// Método para obtener el total de artículos en la cola
        // Se verifica si la cola está vacía antes de intentar obtener el total de artículos
        // Si la cola está vacía, no se puede obtener el total de artículos
        if (cola.isEmpty()) return 0;// Si la cola está vacía, devuelve 0
        return totalArticulosEnCola;
    }
    
    public int getNumeroClientesEnCola() { //// Método para obtener el número de clientes en la cola
        // Se verifica si la cola está vacía antes de intentar obtener el número de clientes
        // Si la cola está vacía, no se puede obtener el número de clientes
        if (cola.isEmpty()) return 0;// Si la cola está vacía, devuelve 0
        return cola.size();
    }
    
    public int getNumero(){//// Método para obtener el número de la caja
        // Se verifica si la cola está vacía antes de intentar obtener el número de la caja
        // Si la cola está vacía, no se puede obtener el número de la caja
        if (cola.isEmpty()) return 0;// Si la cola está vacía, devuelve 0
        return numero;
    }
    
    public Queue<Cliente> getCola() {// Método para obtener la cola de clientes
        return cola;
    }
/*
* La siguiente parte del codigo es para actualizar la cantidad de artículos de un cliente específico en la cola
* se busca el cliente por su ID y se actualiza la cantidad de artículos
* Se actualiza el total de artículos en la cola restando la diferencia entre la nueva cantidad y la cantidad anterior
*/    
    public boolean actualizarCliente(String idCliente, int nuevaCantidad) { //// Método para actualizar la cantidad de artículos de un cliente específico
        for (Cliente cliente : cola) { // aqu se itera sobre la cola de clientes
            if (cliente.getId().equals(idCliente)) {// Si se encuentra el cliente específico
                int diferencia = nuevaCantidad - cliente.getCantidadArticulos();// Se calcula la diferencia entre la nueva cantidad y la cantidad anterior
                // Se actualiza el total de artículos en la cola restando la diferencia
                cliente.setCantidadArticulos(nuevaCantidad);
                totalArticulosEnCola += diferencia;// Se actualiza el total de artículos en la cola
                return true;
            }// Si se encuentra el cliente específico
        }
        return false;// Si no se encuentra el cliente, devuelve false
    }
    
    //@Override//// Método para obtener una representación en cadena de la caja
    // Se utiliza para mostrar el estado de la caja y la cola de clientes
    public String toString() {
        return "Caja " + numero + " - " + getNumeroClientesEnCola() + // Número de clientes en cola
               " clientes (" + totalArticulosEnCola + " artículos)";
    }
}