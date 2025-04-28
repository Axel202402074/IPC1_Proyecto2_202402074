
package Modelo;

import java.io.Serializable;

public class Automovil implements Serializable {
    private String placa;
    private String marca;
    private String modelo;
    private String foto;

    public Automovil(String placa, String marca, String modelo, String foto) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.foto = foto;
    }

    public String getPlaca() { return placa; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getFoto() { return foto; }

    public void setPlaca(String placa) { this.placa = placa; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setFoto(String foto) { this.foto = foto; }
}
