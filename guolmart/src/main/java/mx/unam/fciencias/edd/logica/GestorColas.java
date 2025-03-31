package mx.unam.fciencias.edd.logica;

import mx.unam.fciencias.edd.modelo.Caja;// Clase Caja que representa una caja de supermercado
import mx.unam.fciencias.edd.modelo.Cliente; // Clase Cliente que representa a un cliente en la cola

public class GestorColas {// Clase GestorColas que gestiona las colas de los clientes en las cajas
    private Caja[] cajas;// Arreglo de cajas que representa las diferentes colas
    
    public GestorColas(int numeroCajas) {
        cajas = new Caja[numeroCajas];// Inicializa el arreglo de cajas
        for (int i = 0; i < numeroCajas; i++) {// Crea cada caja en el arreglo
            // Se asigna un número a cada caja (1, 2, 3, ...)
            cajas[i] = new Caja(i + 1);
        }
    }
    
    public int asignarClienteACola(Cliente cliente) {// Método para asignar un cliente a la caja con menos artículos en cola
        int mejorCaja = 0;// Inicializa la mejor caja como la primera
        // Se obtiene el número de artículos en la primera caja
        int menorArticulos = cajas[0].getTotalArticulosEnCola();// Total de artículos en la cola de la primera caja
        // Se recorre el resto de las cajas para encontrar la que tiene menos artículos en cola
        for (int i = 1; i < cajas.length; i++) {
            int articulos = cajas[i].getTotalArticulosEnCola();
            if (articulos < menorArticulos) {// Si la caja actual tiene menos artículos que la mejor caja encontrada
                // Se actualiza la mejor caja y el número de artículos
        
                menorArticulos = articulos;
                mejorCaja = i;// Se asigna el índice de la mejor caja
            }
        }
        cajas[mejorCaja].agregarCliente(cliente);// Se agrega el cliente a la mejor caja encontrada
        return mejorCaja + 1;// Se devuelve el número de la caja (1, 2, 3, ...)
    }
    
    public boolean removerClienteDeCola(int numeroCaja, String idCliente) {// Método para remover un cliente de una caja específica
        if (numeroCaja < 1 || numeroCaja > cajas.length) return false;// Verifica que el número de caja sea válido
        // Se verifica que la caja no esté vacía y que el cliente exista en la cola
        if (cajas[numeroCaja - 1].getNumeroClientesEnCola() == 0) return false;// Si la caja está vacía, no se puede remover
        return cajas[numeroCaja - 1].removerClienteEspecifico(idCliente);
    }
    
    public boolean actualizarArticulosCliente(String idCliente, int nuevaCantidad) {// Método para actualizar la cantidad de artículos de un cliente
        // Se recorre cada caja para encontrar al cliente
        for (Caja caja : cajas) {// Se itera sobre cada caja
            // Se verifica si el cliente está en la cola de la caja
            if (caja.actualizarCliente(idCliente, nuevaCantidad)) {// Si se encuentra al cliente
                // Se actualiza la cantidad de artículos del cliente
                // Se devuelve true para indicar que la actualización fue exitosa
                // Se actualiza la cantidad de artículos del cliente
                return true;
            }
        }
        return false;
    }
    
    public void mostrarEstadoCajas() {// Método para mostrar el estado de las cajas y sus colas
        System.out.println("--- Estado de las cajas ---"); // Encabezado de la sección
        for (Caja caja : cajas) {// Se itera sobre cada caja
            System.out.println("Caja " + caja.getNumero() + ": " + caja.getNumeroClientesEnCola() + " clientes en cola, " + // Número de clientes en cola
                               caja.getTotalArticulosEnCola() + " artículos en total.");
        } // Total de artículos en la cola
        System.out.println("Total de cajas: " + cajas.length);// Total de cajas
        System.out.println("---------------------------"); // Separador de la sección
    }
    
    public Caja[] getCajas() {// Método para obtener el arreglo de cajas
        return cajas;   //// Se devuelve el arreglo de cajas
    }
}