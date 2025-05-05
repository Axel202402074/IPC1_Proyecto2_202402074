package Controlador;

import Modelo.RegistroCliente;
import Modelo.Automovil;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.JOptionPane;


public class ControladorAutomovil {
    private RegistroCliente cliente;

    public ControladorAutomovil(RegistroCliente cliente) {
        this.cliente = cliente;
    }

   public void registrarAutomovil(String placa, String marca, String modelo, String fotoPathOriginal) {
    if (placa.isEmpty() || marca.isEmpty() || modelo.isEmpty() || fotoPathOriginal == null || fotoPathOriginal.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Todos los campos y la foto son obligatorios.");
        return;
    }

    try {
        // Crear carpeta si no existe
        File carpetaFotos = new File("src/Archivos");
        if (!carpetaFotos.exists()) {
            carpetaFotos.mkdirs();
        }

        // Obtener el nombre original del archivo
        File archivoOriginal = new File(fotoPathOriginal);
        String nombreArchivo = archivoOriginal.getName();

        // Definir la ruta destino
        File destino = new File(carpetaFotos, nombreArchivo);

        // Copiar el archivo (sobrescribe si ya existe)
        Files.copy(archivoOriginal.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);

        // Solo se guarda el nombre del archivo, no la ruta completa
        Automovil auto = new Automovil(placa, marca, modelo, nombreArchivo);
        cliente.agregarAutomovil(auto);
        cliente.guardarEnArchivo();

        JOptionPane.showMessageDialog(null, "Automóvil registrado correctamente.");

    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error al copiar la imagen: " + e.getMessage());
    }
}
}
