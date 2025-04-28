
package Controlador;

import Modelo.RegistroCliente;
import java.io.*;

public class ControladorRegistroCliente {
    private static final int INICIAL_CAPACIDAD = 5;
    private static ControladorRegistroCliente instancia;

    private RegistroCliente[] listaClientes;
    private int capacidad;
    private int tamaño;

    private ControladorRegistroCliente() {
        this.capacidad = INICIAL_CAPACIDAD;
        this.listaClientes = new RegistroCliente[capacidad];
        this.tamaño = 0;
        cargarDatos();
    }

    public static ControladorRegistroCliente getInstancia() {
        if (instancia == null) {
            instancia = new ControladorRegistroCliente();
        }
        return instancia;
    }

    public boolean registrarCliente(String dpi, String nombre, String usuario, String pass1, String pass2) {
        System.out.println("[DEBUG] Registrando: " + usuario);
        // 1) Validar contraseñas
        if (!pass1.equals(pass2)) {
            System.out.println("[ERROR] Contraseñas no coinciden");
            return false;
        }
        // 2) Verificar usuario único
        for (int i = 0; i < tamaño; i++) {
            if (listaClientes[i].getNombreUsuario().equals(usuario)) {
                System.out.println("[ERROR] Usuario ya existe");
                return false;
            }
        }
        // 3) Expandir array si es necesario
        if (tamaño == capacidad) {
            int nuevaCap = capacidad * 2;
            if (nuevaCap == 0) nuevaCap = INICIAL_CAPACIDAD;
            RegistroCliente[] tmp = new RegistroCliente[nuevaCap];
            System.arraycopy(listaClientes, 0, tmp, 0, tamaño);
            listaClientes = tmp;
            capacidad = nuevaCap;
            System.out.println("[DEBUG] Nueva capacidad: " + capacidad);
        }
        // 4) Registrar y persistir
        listaClientes[tamaño++] = new RegistroCliente(nombre, dpi, usuario, pass1);
        guardarDatos();
        System.out.println("[OK] Registro exitoso: " + usuario);
        return true;
    }

    public RegistroCliente[] getClientes() {
        RegistroCliente[] activos = new RegistroCliente[tamaño];
        System.arraycopy(listaClientes, 0, activos, 0, tamaño);
        return activos;
    }

    public RegistroCliente buscarClientePorUsuario(String usuario) {
    for (int i = 0; i < tamaño; i++) {
        if (listaClientes[i].getNombreUsuario().equals(usuario)) {
            return listaClientes[i];
        }
    }
    return null; // No encontrado
}
    
    
    private void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
            oos.writeInt(tamaño);
            for (int i = 0; i < tamaño; i++) {
                oos.writeObject(listaClientes[i]);
            }
        } catch (IOException ex) {
            System.out.println("[ERROR] Guardando datos: " + ex.getMessage());
        }
    }

    private void cargarDatos() {
        File f = new File("clientes.dat");
        if (!f.exists()) {
            System.out.println("[INFO] No hay datos previos");
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            int size = ois.readInt();
            // Mantener al menos la capacidad inicial
            if (size > capacidad) {
                capacidad = size;
                listaClientes = new RegistroCliente[capacidad];
            }
            tamaño = size;
            for (int i = 0; i < tamaño; i++) {
                listaClientes[i] = (RegistroCliente) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("[ERROR] Cargando datos: " + ex.getMessage());
        }
    }

    // Ordenamiento burbuja por DPI
    public void ordenarClientesBurbuja() {
        for (int i = 0; i < tamaño - 1; i++) {
            for (int j = 0; j < tamaño - i - 1; j++) {
                if (listaClientes[j].getDpi().compareTo(listaClientes[j + 1].getDpi()) > 0) {
                    RegistroCliente tmp = listaClientes[j];
                    listaClientes[j] = listaClientes[j + 1];
                    listaClientes[j + 1] = tmp;
                }
            }
        }
    }

    // Shell sort por nombre
    public void ordenarClientesShellSort() {
        int n = tamaño;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                RegistroCliente temp = listaClientes[i];
                int j = i;
                while (j >= gap && listaClientes[j - gap].getNombre().compareTo(temp.getNombre()) > 0) {
                    listaClientes[j] = listaClientes[j - gap];
                    j -= gap;
                }
                listaClientes[j] = temp;
            }
        }
    }

    // Verificar y ascender clientes a Oro
    public void verificarClientesOro() {
        boolean actualizado = false;
        for (int i = 0; i < tamaño; i++) {
            RegistroCliente c = listaClientes[i];
            if (c.getServiciosRealizados() >= 5 && !"Oro".equals(c.getTipo())) {
                c.setTipo("Oro");
                System.out.println("[ASCENSO] Cliente " + c.getNombreUsuario() + " ahora es Oro");
                actualizado = true;
            }
        }
        if (actualizado) guardarDatos();
    }
    
    public void agregarCliente(RegistroCliente cliente) {
    if (tamaño == capacidad) {
        int nuevaCap = capacidad * 2;
        if (nuevaCap == 0) nuevaCap = INICIAL_CAPACIDAD;
        RegistroCliente[] tmp = new RegistroCliente[nuevaCap];
        System.arraycopy(listaClientes, 0, tmp, 0, tamaño);
        listaClientes = tmp;
        capacidad = nuevaCap;
    }
    listaClientes[tamaño++] = cliente;
    guardarDatos();
}

public RegistroCliente buscarClientePorDpi(String dpi) {
    if (dpi == null || dpi.isEmpty()) return null;
    for (int i = 0; i < tamaño; i++) {
        if (listaClientes[i] != null && listaClientes[i].getDpi().equals(dpi)) {
            return listaClientes[i];
        }
    }
    return null;
}
    
    
    public void eliminarClientePorDpi(String dpi) {
    for (int i = 0; i < tamaño; i++) {
        if (listaClientes[i].getDpi().equals(dpi)) {
            for (int j = i; j < tamaño - 1; j++) {
                listaClientes[j] = listaClientes[j + 1];
            }
            tamaño--;
            guardarDatos();
            break;
        }
    }
}


public void cargarClientesDesdeArchivo(File archivo) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split("-");
            if (partes.length >= 5) {
                String dpi = partes[0];
                String nombre = partes[1];
                String usuario = partes[2];
                String contrasena = partes[3];
                String tipoCliente = partes[4];

                RegistroCliente nuevo = new RegistroCliente(nombre, dpi, usuario, contrasena);
                nuevo.setTipo(tipoCliente);
                agregarClienteDirectamente(nuevo); // Método que no pide validaciones
            }
        }
    }
    guardarDatos();
}

// Método de apoyo
private void agregarClienteDirectamente(RegistroCliente cliente) {
    if (tamaño == capacidad) {
        int nuevaCap = capacidad * 2;
        RegistroCliente[] tmp = new RegistroCliente[nuevaCap];
        System.arraycopy(listaClientes, 0, tmp, 0, tamaño);
        listaClientes = tmp;
        capacidad = nuevaCap;
    }
    listaClientes[tamaño++] = cliente;
}
}
