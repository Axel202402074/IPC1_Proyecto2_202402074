package Controlador;

import Modelo.Servicio;
import Modelo.Repuesto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;

public class ControladorServicios {
    private Servicio[] servicios;
    private int cantidad;
    private static ControladorServicios instancia;

    private ControladorServicios() {
        servicios = new Servicio[10];  // Iniciamos el arreglo de tamaño 10
        cantidad = 0;
    }

    public static ControladorServicios getInstancia() {
        if (instancia == null) {
            instancia = new ControladorServicios();
        }
        return instancia;
    }

    public void agregarServicio(String nombre, String marca, String modelo, int año, Repuesto[] repuestos, double precioManoObra) {
        if (cantidad == servicios.length) expandirArreglo();  // Si el arreglo está lleno, expandirlo
        Servicio nuevo = new Servicio(nombre, marca, modelo, año, repuestos, precioManoObra);
        servicios[cantidad++] = nuevo;
    }

    public void modificarServicio(String id, String nuevoNombre, String nuevaMarca, String nuevoModelo, 
                                  int nuevoAño, Repuesto[] nuevosRepuestos, double nuevoPrecioManoObra) {
        Servicio servicio = buscarPorId(id);
        if (servicio != null) {
            servicio.setNombre(nuevoNombre);
            servicio.setMarca(nuevaMarca);
            servicio.setModelo(nuevoModelo);
            servicio.setAño(nuevoAño);
            servicio.setRepuestos(nuevosRepuestos);
            servicio.setPrecioManoObra(nuevoPrecioManoObra);
            servicio.recalcularTotal();
        }
    }

    public void eliminarServicio(String id) {
        for (int i = 0; i < cantidad; i++) {
            if (servicios[i].getId().equals(id)) {  // Comparamos el ID usando equals()
                for (int j = i; j < cantidad - 1; j++) {
                    servicios[j] = servicios[j + 1];
                }
                cantidad--;
                break;
            }
        }
    }

    public Servicio buscarPorId(String id) {
        for (int i = 0; i < cantidad; i++) {
            if (servicios[i].getId().equals(id)) {
                return servicios[i];
            }
        }
        return null;
    }

    public Servicio[] obtenerServicios() {
        Servicio[] copia = new Servicio[cantidad];
        System.arraycopy(servicios, 0, copia, 0, cantidad);
        return copia;
    }

    private void expandirArreglo() {
        Servicio[] nuevo = new Servicio[servicios.length * 2];
        System.arraycopy(servicios, 0, nuevo, 0, servicios.length);
        servicios = nuevo;
    }

    public void cargarDesdeArchivo(String rutaArchivo) {
        cargarDesdeArchivo(rutaArchivo, null);
    }

    public void cargarDesdeArchivo(String rutaArchivo, Repuesto[] repuestosDisponibles) {
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split("-");
                if (partes.length < 4) {
                    System.out.println("Formato incorrecto en línea: " + linea);
                    continue;  // Si tiene menos de 4 partes, se omite
                }
                
                try {
                    String nombre = partes[0].trim();
                    String marca = partes[1].trim();
                    
                    // Separamos el modelo y año
                    String modeloConAño = partes[2].trim();
                    String modelo;
                    int año;
                    
                    // Buscamos el espacio entre modelo y año
                    int ultimoEspacio = modeloConAño.lastIndexOf(" ");
                    if (ultimoEspacio > 0) {
                        modelo = modeloConAño.substring(0, ultimoEspacio);
                        año = Integer.parseInt(modeloConAño.substring(ultimoEspacio + 1));
                    } else {
                        // Si no hay espacio, asumimos que todo es modelo
                        modelo = modeloConAño;
                        año = 0; // Valor por defecto
                    }
                    
                    // El cuarto campo podría contener códigos que podríamos usar como referencia de repuestos
                    String codigoRepuestos = "";
                    if (partes.length > 3 && !partes[3].trim().isEmpty()) {
                        codigoRepuestos = partes[3].trim();
                    }
                    
                    // El precio es el último campo
                    double precioManoObra = Double.parseDouble(partes[partes.length - 1].trim());
                    
                    // Si hay repuestos disponibles, intentamos asociarlos
                    Repuesto[] repuestosAsociados;
                    if (repuestosDisponibles != null) {
                        // Filtrar repuestos por marca y modelo
                        int contadorRepuestos = 0;
                        for (Repuesto r : repuestosDisponibles) {
                            if (r != null && r.getMarca().equalsIgnoreCase(marca) && 
                                r.getModelo().equalsIgnoreCase(modelo)) {
                                contadorRepuestos++;
                            }
                        }
                        
                        // Crear un nuevo array con los repuestos filtrados
                        repuestosAsociados = new Repuesto[contadorRepuestos];
                        int idx = 0;
                        for (Repuesto r : repuestosDisponibles) {
                            if (r != null && r.getMarca().equalsIgnoreCase(marca) && 
                                r.getModelo().equalsIgnoreCase(modelo)) {
                                repuestosAsociados[idx++] = r;
                            }
                        }
                    } else {
                        // Si no hay repuestos disponibles, crear un array vacío
                        repuestosAsociados = new Repuesto[0];
                    }
                    
                    // Agregamos el servicio con los repuestos asociados
                    agregarServicio(nombre, marca, modelo, año, repuestosAsociados, precioManoObra);
                    
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error al procesar la línea: " + linea);
                    e.printStackTrace();
                }
            }
            System.out.println("Servicios cargados correctamente: " + cantidad);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + rutaArchivo);
            e.printStackTrace();
        }
    }
    
    // Guardar servicios en archivo binario
public void guardarServicios(String rutaArchivo) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
        oos.writeInt(cantidad); // Guardamos la cantidad real
        for (int i = 0; i < cantidad; i++) {
            oos.writeObject(servicios[i]);
        }
        System.out.println("Servicios guardados correctamente.");
    } catch (IOException e) {
        System.out.println("Error al guardar los servicios: " + e.getMessage());
        e.printStackTrace();
    }
}

// Cargar servicios desde archivo binario
public void cargarServicios(String rutaArchivo) {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
        cantidad = ois.readInt(); // Leemos la cantidad de elementos
        servicios = new Servicio[Math.max(10, cantidad)]; // Aseguramos un tamaño mínimo
        for (int i = 0; i < cantidad; i++) {
            servicios[i] = (Servicio) ois.readObject();
        }
        System.out.println("Servicios cargados desde archivo correctamente.");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error al cargar los servicios: " + e.getMessage());
        e.printStackTrace();
    }
}
}