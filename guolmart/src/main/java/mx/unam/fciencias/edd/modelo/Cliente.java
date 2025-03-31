package mx.unam.fciencias.edd.modelo;

public class Cliente {// Clase Cliente que representa a un cliente en la cola
    // Atributos de la clase Cliente
    private String id;// ID del cliente (cadena de caracteres)
    private int cantidadArticulos;// Cantidad de artículos que lleva el cliente (entero)
    
    public Cliente(String id, int cantidadArticulos) {
        this.id = id;// Asigna el ID del cliente
        this.cantidadArticulos = cantidadArticulos;// Asigna la cantidad de artículos del cliente
        // Validación para asegurarse de que la cantidad de artículos sea positiva
        if (cantidadArticulos < 0) {
            throw new IllegalArgumentException("La cantidad de artículos no puede ser negativa.");
        }
    }
    
    public String getId() {// Método para obtener el ID del cliente
        return id;// Devuelve el ID del cliente
    }
    
    public int getCantidadArticulos() {
        return cantidadArticulos;// Devuelve la cantidad de artículos del cliente
    }
    
    public void setCantidadArticulos(int cantidad) {
        this.cantidadArticulos = cantidad;// Asigna una nueva cantidad de artículos al cliente
    }
    
    //@Override

    public String toString() {// Método para representar al cliente como una cadena de caracteres
        return "Cliente " + id + " (" + cantidadArticulos + " artículos)";// Devuelve una representación del cliente
    }
}