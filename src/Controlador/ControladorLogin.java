package Controlador;

import Modelo.ModeloLogin;
import Modelo.RegistroCliente;
import Vista.Administrador_2;
import Vista.Cliente_3;
import Vista.Login_1;
import javax.swing.JOptionPane;

public class ControladorLogin {
    private ModeloLogin modelo;
    private ControladorRegistroCliente ctrlRegistro;

    // Constructor para inicializar el modelo y controlador
    public ControladorLogin(ModeloLogin modelo, ControladorRegistroCliente ctrlRegistro) {
        this.modelo = modelo;
        this.ctrlRegistro = ctrlRegistro;
    }

    // Método para autenticar al usuario
    public boolean autenticar(String usuario, String contraseña, Login_1 vista) {
        if (usuario.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Campos vacíos. Complete todos los datos.");
            return false;
        }

        // Verifica si es un admin
        if (modelo.esAdmin(usuario, contraseña)) {
            new Administrador_2().setVisible(true);
            vista.dispose();
            return true;
        }

        // Verifica si es un cliente registrado
        for (RegistroCliente cliente : ctrlRegistro.getClientes()) {
            if (cliente != null &&
                cliente.getNombreUsuario().equals(usuario) &&
                cliente.getContrasena().equals(contraseña)) {
                new Cliente_3(cliente).setVisible(true);
                vista.dispose();
                return true;
            }
        }

        JOptionPane.showMessageDialog(vista, "Usuario o contraseña incorrectos.");
        return false;
    }
}
