package Modelo;
import java.io.Serializable;

public class Servicio implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int contador = 1;
    private String id;
    private String nombre;
    private String marca;
    private String modelo;
    private int año;      // Nuevo campo para el año del vehículo
    private Repuesto[] repuestos;
    private double precioManoObra;
    private double precioTotal;
    private RegistroCliente cliente;
    private Automovil automovil;
    private String mecanico;
    private String estado; 
    
    // Constructor original modificado para incluir el año
    public Servicio(String nombre, String marca, String modelo, int año, Repuesto[] repuestos, double precioManoObra) {
        this.id = generarId();
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;   // Inicializamos el año
        this.repuestos = repuestos;
        this.precioManoObra = precioManoObra;
        recalcularTotal();
    }
    
    // Constructor sobrecargado para mantener compatibilidad con código existente
    public Servicio(String nombre, String marca, String modelo, Repuesto[] repuestos, double precioManoObra) {
        this(nombre, marca, modelo, 0, repuestos, precioManoObra); // Año por defecto es 0
    }
    
    private String generarId() {
        return "SRV-" + (contador++);
    }
    
    public void recalcularTotal() {
        double total = precioManoObra;
        if (repuestos != null) {
            for (Repuesto r : repuestos) {
                if (r != null) {
                    total += r.getPrecio();
                }
            }
        }
        this.precioTotal = total;
    }
    
    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAño() { return año; }  // Nuevo getter para el año
    public Repuesto[] getRepuestos() { return repuestos; }
    public double getPrecioManoObra() { return precioManoObra; }
    public double getPrecioTotal() { return precioTotal; }
    
    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setAño(int año) { this.año = año; }  // Nuevo setter para el año
    public void setRepuestos(Repuesto[] repuestos) { 
        this.repuestos = repuestos; 
        recalcularTotal(); // recalcular al cambiar repuestos
    }
    public void setPrecioManoObra(double precioManoObra) { 
        this.precioManoObra = precioManoObra;
        recalcularTotal(); // recalcular al cambiar mano de obra
    }
    
    @Override
    public String toString() {
        return nombre + " - " + marca + " " + modelo + " (" + año + ") - $" + precioTotal;
    }
    
    public String getEstado() {
    return estado;
}

    public void setEstado(String estado) {
    this.estado = estado;
}
    
}