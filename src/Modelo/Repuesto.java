
package Modelo;

import java.io.Serializable;

public class Repuesto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String nombre;
    private String marca;
    private String modelo;
    private int existencias;
    private double precio;

    public Repuesto(String id, String nombre, String marca, String modelo, int existencias, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.existencias = existencias;
        this.precio = precio;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getExistencias() { return existencias; }
    public double getPrecio() { return precio; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setExistencias(int existencias) { this.existencias = existencias; }
    public void setPrecio(double precio) { this.precio = precio; }
}
