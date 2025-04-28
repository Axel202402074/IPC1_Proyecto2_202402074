
package Modelo;

import java.io.Serializable;

public class RegistroCliente implements Serializable {
    private static final long serialVersionUID = 1L;

    // Datos básicos
    private String nombre;
    private String dpi;
    private String nombreUsuario;
    private String contrasena;

    // Estado de cliente
    private String tipo;             // "Normal" o "Oro"
    private int serviciosRealizados; // Cuenta de servicios

    // Automóviles
    private Automovil[] automoviles;
    private int cantidadAutos;

    public RegistroCliente(String nombre, String dpi, String nombreUsuario, String contrasena) {
        this.nombre = nombre;
        this.dpi = dpi;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.tipo = "Normal";
        this.serviciosRealizados = 0;
        this.automoviles = new Automovil[5];
        this.cantidadAutos = 0;
    }

    // Getters / Setters básicos
    public String getNombre() { return nombre; }
    public String getDpi() { return dpi; }
    public String getNombreUsuario() { return nombreUsuario; }
    public String getContrasena() { return contrasena; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDpi(String dpi) { this.dpi = dpi; }
    public void setNombreUsuario(String usuario) { this.nombreUsuario = usuario; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getServiciosRealizados() { return serviciosRealizados; }
    public void incrementarServicios() {
        serviciosRealizados++;
        // Ascenso automático si llega a 4
        if (serviciosRealizados >= 4 && !"Oro".equals(tipo)) {
            tipo = "Oro";
            System.out.println("[ASCENSO] Cliente " + nombreUsuario + " ahora es Oro");
        }
    }

    // Gestión de automóviles
    public void agregarAutomovil(Automovil auto) {
        if (cantidadAutos == automoviles.length) {
            expandirCapacidadAutomoviles();
        }
        automoviles[cantidadAutos++] = auto;
    }

    private void expandirCapacidadAutomoviles() {
        int nuevaLong = automoviles.length * 2;
        if (nuevaLong == 0) nuevaLong = 5;
        Automovil[] tmp = new Automovil[nuevaLong];
        System.arraycopy(automoviles, 0, tmp, 0, cantidadAutos);
        automoviles = tmp;
    }

    public Automovil[] getAutomoviles() {
        Automovil[] activos = new Automovil[cantidadAutos];
        System.arraycopy(automoviles, 0, activos, 0, cantidadAutos);
        return activos;
    }

    public int getCantidadAutos() { return cantidadAutos; }

    // Shell Sort por placa
    public void ordenarAutomovilesPorPlaca(boolean ascendente) {
        int gap = cantidadAutos / 2;
        while (gap > 0) {
            for (int i = gap; i < cantidadAutos; i++) {
                Automovil temp = automoviles[i];
                int j = i;
                while (j >= gap && 
                       (ascendente
                         ? automoviles[j-gap].getPlaca().compareTo(temp.getPlaca()) > 0
                         : automoviles[j-gap].getPlaca().compareTo(temp.getPlaca()) < 0)) {
                    automoviles[j] = automoviles[j - gap];
                    j -= gap;
                }
                automoviles[j] = temp;
            }
            gap /= 2;
        }
    }
    
public void eliminarAutomovilPorPlaca(String placa) {
    for (int i = 0; i < cantidadAutos; i++) {
        if (automoviles[i].getPlaca().equals(placa)) {
            for (int j = i; j < cantidadAutos - 1; j++) {
                automoviles[j] = automoviles[j + 1];
            }
            cantidadAutos--;
            break;
        }
    }
}

public Automovil getAutomovilPorPlaca(String placa) {
    for (int i = 0; i < cantidadAutos; i++) {
        if (automoviles[i].getPlaca().equals(placa)) {
            return automoviles[i];
        }
    }
    return null;
}
 


}
