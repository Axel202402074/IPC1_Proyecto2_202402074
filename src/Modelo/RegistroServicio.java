package Modelo;

import java.io.Serializable;

public class RegistroServicio implements Serializable {
    private Automovil automovil;
    private String cliente;
    private String mecanico;  // solo se llena cuando pasa a "en atención"
    private String servicio;  // solo se llena cuando pasa a "carros listos"
    private int total;        // lo mismo
    private int estado;       // 0: espera, 1: en atención, 2: listo

    public RegistroServicio(Automovil automovil, String cliente) {
        this.automovil = automovil;
        this.cliente = cliente;
        this.estado = 0;
    }

    public Automovil getAutomovil() { return automovil; }
    public String getCliente() { return cliente; }
    public String getMecanico() { return mecanico; }
    public String getServicio() { return servicio; }
    public int getTotal() { return total; }
    public int getEstado() { return estado; }

    public void setMecanico(String mecanico) { this.mecanico = mecanico; }
    public void setServicio(String servicio) { this.servicio = servicio; }
    public void setTotal(int total) { this.total = total; }
    public void setEstado(int estado) { this.estado = estado; }
}
