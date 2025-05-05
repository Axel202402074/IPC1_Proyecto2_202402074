package Vista;

import Controlador.ControladorRegistroCliente;
import Modelo.Automovil;
import Modelo.RegistroCliente;
import Vista.VistaEditarClienteAuto;
import java.io.BufferedReader;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

public class VistaClientesAutos extends javax.swing.JFrame {

    public VistaClientesAutos() {
        initComponents();
        this.setTitle("Clientes y automóviles");
        this.setLocationRelativeTo(null);
        cargarClientesTabla();
        cargarClientesComboBox();
        inicializarTablaVehiculos();
    }

    void cargarClientesTabla() {
        String[] columnas = {"DPI", "Nombre", "Usuario"};
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(null, columnas);
        for (RegistroCliente cliente : ControladorRegistroCliente.getInstancia().getClientes()) {
            String[] fila = {
                cliente.getDpi(),
                cliente.getNombre(),
                cliente.getNombreUsuario()
            };
            modelo.addRow(fila);
        }
        tblDatos.setModel(modelo);
    }

    void cargarClientesComboBox() {
        boxCliente.removeAllItems();
        for (RegistroCliente cliente : ControladorRegistroCliente.getInstancia().getClientes()) {
            boxCliente.addItem(cliente.getDpi() + " - " + cliente.getNombre());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar1 = new javax.swing.JButton();
        btnCargar = new javax.swing.JButton();
        boxCliente = new javax.swing.JComboBox<>();
        btnBuscarVehiculos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        jTextField4.setText("jTextField1");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        btnAgregar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnModificar1.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar1.setText("Modificar");
        btnModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar1ActionPerformed(evt);
            }
        });

        btnCargar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCargar.setForeground(new java.awt.Color(0, 0, 0));
        btnCargar.setText("Cargar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        boxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBuscarVehiculos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBuscarVehiculos.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarVehiculos.setText("Buscar vehiculos");
        btnBuscarVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVehiculosActionPerformed(evt);
            }
        });

        tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblVehiculos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 116, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addGap(31, 31, 31)
                        .addComponent(btnEliminar)
                        .addGap(38, 38, 38)
                        .addComponent(btnCargar)
                        .addGap(34, 34, 34)
                        .addComponent(btnModificar1)
                        .addGap(95, 95, 95))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarVehiculos)
                            .addComponent(boxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar1)
                    .addComponent(btnCargar))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(boxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnBuscarVehiculos))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
      
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try {
                File archivo = fileChooser.getSelectedFile();
                String nombreArchivo = archivo.getName().toLowerCase();

                if (nombreArchivo.endsWith(".tmca")) {
                    cargarClientesYAutosDesdeArchivo(archivo);
                } else {
                    ControladorRegistroCliente.getInstancia().cargarClientesDesdeArchivo(archivo);
                }
                actualizarTablaClientes();
                actualizarComboBoxClientes();
                inicializarTablaVehiculos(); // Limpiar tabla vehiculos
                JOptionPane.showMessageDialog(this, "Archivo cargado exitosamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error cargando archivo: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
int fila = tblDatos.getSelectedRow();
    if (fila < 0) {
        JOptionPane.showMessageDialog(this, "Seleccione un cliente para modificar.");
        return;
    }
    String dpi = tblDatos.getValueAt(fila, 0).toString();
    RegistroCliente cliente = ControladorRegistroCliente.getInstancia().buscarClientePorDpi(dpi);
    if (cliente == null) {
        JOptionPane.showMessageDialog(this, "No se encontró el cliente.");
        return;
    }
    VistaEditarClienteAuto editar = new VistaEditarClienteAuto(cliente, this);
    editar.setVisible(true);
    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblDatos.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un cliente para eliminar.");
        return;
    }

    String dpi = (String) tblDatos.getValueAt(fila, 0); // columna del DPI
    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar este cliente?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

    if (confirmacion == JOptionPane.YES_OPTION) {
        ControladorRegistroCliente.getInstancia().eliminarClientePorDpi(dpi);
        actualizarTablaClientes();
        actualizarComboBoxClientes();
        inicializarTablaVehiculos(); // 👉 Limpiamos la tabla de vehículos
        JOptionPane.showMessageDialog(this, "Cliente eliminado exitosamente.");
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre completo del cliente:");
        if (nombre == null || nombre.trim().isEmpty()) {
            return;
        }

        String dpi = JOptionPane.showInputDialog(this, "Ingrese el DPI del cliente:");
        if (dpi == null || dpi.trim().isEmpty()) {
            return;
        }

        String usuario = JOptionPane.showInputDialog(this, "Ingrese el nombre de usuario:");
        if (usuario == null || usuario.trim().isEmpty()) {
            return;
        }

        String contrasena = JOptionPane.showInputDialog(this, "Ingrese la contraseña:");
        if (contrasena == null || contrasena.trim().isEmpty()) {
            return;
        }
        RegistroCliente nuevoCliente = new RegistroCliente(nombre, dpi, usuario, contrasena);
        ControladorRegistroCliente.getInstancia().agregarCliente(nuevoCliente);
        actualizarTablaClientes();
        actualizarComboBoxClientes();

        JOptionPane.showMessageDialog(this, "Cliente agregado exitosamente.");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVehiculosActionPerformed
    String seleccionado = (String) boxCliente.getSelectedItem();
    if (seleccionado == null || seleccionado.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Seleccione un cliente primero.");
        return;
    }

    // Extraer el DPI del texto del ComboBox
    String dpiSeleccionado = seleccionado.split(" - ")[0].trim();

    RegistroCliente cliente = ControladorRegistroCliente.getInstancia().buscarClientePorDpi(dpiSeleccionado);
    if (cliente == null) {
        JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
        return;
    }

    // Crear modelo de la tabla de vehículos
    String[] columnas = {"Placa", "Marca", "Modelo"};
    DefaultTableModel modelo = new DefaultTableModel(null, columnas);

    // Verificar qué tipo de colección devuelve getAutomoviles
    Object vehiculos = cliente.getAutomoviles();
    boolean hayVehiculos = false;
    
    if (vehiculos instanceof Automovil[]) {
        // Si es un array de Automovil
        Automovil[] autos = (Automovil[]) vehiculos;
        for (Automovil auto : autos) {
            if (auto != null) {
                modelo.addRow(new Object[]{
                    auto.getPlaca(),
                    auto.getMarca(),
                    auto.getModelo()
                });
                hayVehiculos = true;
            }
        }
    } else if (vehiculos instanceof java.util.Collection) {
        // Si es una colección (ArrayList, List, etc.)
        java.util.Collection<Automovil> autos = (java.util.Collection<Automovil>) vehiculos;
        for (Automovil auto : autos) {
            if (auto != null) {
                modelo.addRow(new Object[]{
                    auto.getPlaca(),
                    auto.getMarca(),
                    auto.getModelo()
                });
                hayVehiculos = true;
            }
        }
    }
    
    if (!hayVehiculos) {
        JOptionPane.showMessageDialog(this, "Este cliente no tiene vehículos registrados.");
    }

    tblVehiculos.setModel(modelo);
    }//GEN-LAST:event_btnBuscarVehiculosActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaClientesAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaClientesAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaClientesAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaClientesAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaClientesAutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCliente;
    public javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarVehiculos;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTable tblVehiculos;
    // End of variables declaration//GEN-END:variables

    private void actualizarTablaClientes() {
        String[] columnas = {"DPI", "Nombre", "Usuario"};
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(null, columnas);
        for (RegistroCliente cliente : ControladorRegistroCliente.getInstancia().getClientes()) {
            String[] fila = {
                cliente.getDpi(),
                cliente.getNombre(),
                cliente.getNombreUsuario(),};
            modelo.addRow(fila);
        }
        tblDatos.setModel(modelo);
    }

private void actualizarComboBoxClientes() {
    boxCliente.removeAllItems();
    RegistroCliente[] clientes = ControladorRegistroCliente.getInstancia().getClientes();
    
    for (RegistroCliente cliente : clientes) {
        boxCliente.addItem(cliente.getDpi() + " - " + cliente.getNombre());
    }

    // Si ya no hay clientes, desactivar el botón
    btnBuscarVehiculos.setEnabled(clientes.length > 0);
}

    void inicializarTablaVehiculos() {
        String[] columnas = {"Placa", "Marca", "Modelo"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        tblVehiculos.setModel(modelo);
    }

    private void cargarClientesYAutosDesdeArchivo(File archivo) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader(archivo));
    String linea;

    while ((linea = br.readLine()) != null) {
        linea = linea.trim();
        if (linea.isEmpty()) {
            continue;
        }

        String[] partesPrincipales = linea.split("-", 6); // Limitar la división a 6 partes
        if (partesPrincipales.length >= 5) {
            String dpi = partesPrincipales[0].trim();
            String nombre = partesPrincipales[1].trim();
            String usuario = partesPrincipales[2].trim();
            String contrasena = partesPrincipales[3].trim();
            String tipo = partesPrincipales[4].trim();

            RegistroCliente clienteActual = new RegistroCliente(nombre, dpi, usuario, contrasena);
            clienteActual.setTipo(tipo);
            
            // Verificar si hay información de vehículos
            if (partesPrincipales.length > 5) {
                String infoVehiculos = partesPrincipales[5].trim();
                // Los vehículos están separados por punto y coma
                String[] vehiculos = infoVehiculos.split(";");
                
                for (String vehiculo : vehiculos) {
                    String[] partesAuto = vehiculo.split(",");
                    if (partesAuto.length >= 4) {
                        String placa = partesAuto[0].trim();
                        String marca = partesAuto[1].trim();
                        String modelo = partesAuto[2].trim();
                        String rutaFoto = partesAuto[3].trim();

                        Automovil auto = new Automovil(placa, marca, modelo, rutaFoto);
                        clienteActual.agregarAutomovil(auto);
                        System.out.println("Agregado vehículo: " + placa + " a cliente: " + dpi);
                    }
                }
            }
            
            ControladorRegistroCliente.getInstancia().agregarCliente(clienteActual);
        }
    }
    br.close();
}
    
    public void recargarDatos() {
    cargarClientesTabla();
    cargarClientesComboBox();
    inicializarTablaVehiculos();
}
    
    
    
}
