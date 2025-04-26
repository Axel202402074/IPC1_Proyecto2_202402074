package Modelo;

import Controlador.ControladorRegistroCliente;

public class ModeloLogin {

    // Método para autenticar usuarios admin
    public boolean esAdmin(String usuario, String password) {
        return "axel".equals(usuario) && "123".equals(password);
    }

    // Método para autenticar clientes (si decides usarlo)
    public boolean autenticar(String usuario, String password) {
        RegistroCliente[] clientes = ControladorRegistroCliente.getInstancia().getClientes();

        for (RegistroCliente cliente : clientes) {
            if (cliente != null &&
                cliente.getNombreUsuario().equals(usuario) &&
                cliente.getContrasena().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
