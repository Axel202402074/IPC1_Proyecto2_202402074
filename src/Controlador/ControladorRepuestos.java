
package Controlador;

import Modelo.Repuesto;
import java.io.*;

public class ControladorRepuestos {
    private static ControladorRepuestos instancia;
    private Repuesto[] inventario = new Repuesto[20];
    private int tamaño = 0;
    private int idActual = 1;

    private ControladorRepuestos() {
        cargar();
    }
public void imprimirRepuestosCargados() {
    System.out.println("=== Repuestos Cargados ===");
    for (int i = 0; i < tamaño; i++) {
        Repuesto r = inventario[i];
        if (r != null) {
            System.out.println("ID: " + r.getId() +
                               ", Nombre: " + r.getNombre() +
                               ", Marca: " + r.getMarca() +
                               ", Modelo: " + r.getModelo() +
                               ", Existencias: " + r.getExistencias() +
                               ", Precio: " + r.getPrecio());
        }
    }
    System.out.println("===========================");
}

    public static ControladorRepuestos getInstancia() {
        if (instancia == null) instancia = new ControladorRepuestos();
        return instancia;
    }

    public void agregarRepuesto(String nombre, String marca, String modelo, int existencias, double precio) {
        if (tamaño == inventario.length) {
            Repuesto[] nuevo = new Repuesto[inventario.length * 2];
            System.arraycopy(inventario, 0, nuevo, 0, tamaño);
            inventario = nuevo;
        }
        String idGenerado = "R" + idActual++;
        inventario[tamaño++] = new Repuesto(idGenerado, nombre, marca, modelo, existencias, precio);
        guardar();
    }

    public void modificarRepuesto(String id, String nombre, String marca, String modelo, int existencias, double precio) {
        for (int i = 0; i < tamaño; i++) {
            if (inventario[i].getId().equals(id)) {
                inventario[i].setNombre(nombre);
                inventario[i].setMarca(marca);
                inventario[i].setModelo(modelo);
                inventario[i].setExistencias(existencias);
                inventario[i].setPrecio(precio);
                guardar();
                break;
            }
        }
    }

    public void eliminarRepuesto(String id) {
        for (int i = 0; i < tamaño; i++) {
            if (inventario[i].getId().equals(id)) {
                for (int j = i; j < tamaño - 1; j++) {
                    inventario[j] = inventario[j + 1];
                }
                tamaño--;
                guardar();
                break;
            }
        }
    }

    public Repuesto[] getRepuestos() {
        Repuesto[] copia = new Repuesto[tamaño];
        System.arraycopy(inventario, 0, copia, 0, tamaño);
        return copia;
    }

    public Repuesto[] getRepuestosPorMarcaModelo(String marca, String modelo) {
        int contador = 0;
        for (int i = 0; i < tamaño; i++) {
            if (inventario[i].getMarca().equalsIgnoreCase(marca)
                    && inventario[i].getModelo().equalsIgnoreCase(modelo)) {
                contador++;
            }
        }
        Repuesto[] compatibles = new Repuesto[contador];
        int index = 0;
        for (int i = 0; i < tamaño; i++) {
            if (inventario[i].getMarca().equalsIgnoreCase(marca)
                    && inventario[i].getModelo().equalsIgnoreCase(modelo)) {
                compatibles[index++] = inventario[i];
            }
        }
        return compatibles;
    }

    public void guardar() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("repuestos.dat"))) {
            oos.writeInt(tamaño);
            oos.writeInt(idActual);
            for (int i = 0; i < tamaño; i++) oos.writeObject(inventario[i]);
        } catch (IOException e) {
            System.out.println("[ERROR] Guardando repuestos: " + e.getMessage());
        }
    }

    public void cargar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("repuestos.dat"))) {
            tamaño = ois.readInt();
            idActual = ois.readInt();
            for (int i = 0; i < tamaño; i++) {
                inventario[i] = (Repuesto) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("[INFO] No se cargaron repuestos previos.");
        }
    }

    public void cargarDesdeArchivo(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("-");
                if (partes.length == 5) {
                    String nombre = partes[0];
                    String marca = partes[1];
                    String modelo = partes[2];
                    int existencia = Integer.parseInt(partes[3]);
                    double precio = Double.parseDouble(partes[4]);
                    agregarRepuesto(nombre, marca, modelo, existencia, precio);
                }
            }
        } catch (IOException e) {
            System.out.println("[ERROR] Leyendo archivo .tmr: " + e.getMessage());
        }
    }
}
