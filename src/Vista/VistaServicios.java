
package Vista;

import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Controlador.ControladorServicios;
import Controlador.ControladorRepuestos;
import Modelo.Repuesto;
import Modelo.Servicio;
import javax.swing.*;
import javax.swing.JFileChooser;
import java.io.File;

public class VistaServicios extends javax.swing.JFrame {

    private DefaultTableModel modeloTabla;
    
    private ControladorServicios controlador = ControladorServicios.getInstancia();
    private ControladorRepuestos controladorRepuestos = ControladorRepuestos.getInstancia();

    public VistaServicios() {
    initComponents();
    this.setLocationRelativeTo(null);
    this.setTitle("Servicios");
    ControladorRepuestos.getInstancia().imprimirRepuestosCargados();

    modeloTabla = new DefaultTableModel(new String[]{"ID","Servicio","Marca","Modelo","total"}, 0);
    tablaServicios.setModel(modeloTabla);

    try {
        controlador.cargarServicios("servicios.dat");
    } catch (Exception e) {
        System.out.println("No se encontraron servicios previamente guardados.");
    }

    cargarTabla();
}
    
    public void dispose() {
    try {
        controlador.guardarServicios("servicios.dat"); // Ruta donde guardas los datos
        System.out.println("Servicios guardados automáticamente al cerrar la ventana.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al guardar servicios al cerrar: " + e.getMessage());
        e.printStackTrace();
    }
    super.dispose();
}
    
       private void cargarTabla() {
    
    while (modeloTabla.getRowCount() > 0) {
        modeloTabla.removeRow(0);
    }
    
   
    Servicio[] serviciosArray = controlador.obtenerServicios();
    
    
    for (Servicio s : serviciosArray) {
        if (s == null) continue;
       
        String modeloConAño = s.getModelo();
        if (s.getAño() > 0) {
            modeloConAño += " " + s.getAño();
        }
    
        String precioFormateado = String.format("%.2f", s.getPrecioTotal());
        
        Object[] fila = {
            s.getId(),
            s.getNombre(),
            s.getMarca(),
            modeloConAño,
          
            precioFormateado
        };
        
        modeloTabla.addRow(fila);
    }
    
    
    if (tablaServicios.getColumnCount() >= 6) {
        tablaServicios.getColumnModel().getColumn(0).setPreferredWidth(60);  // ID
        tablaServicios.getColumnModel().getColumn(1).setPreferredWidth(150); // Nombre
        tablaServicios.getColumnModel().getColumn(2).setPreferredWidth(80);  // Marca
        tablaServicios.getColumnModel().getColumn(3).setPreferredWidth(100); // Modelo con año
        
        tablaServicios.getColumnModel().getColumn(4).setPreferredWidth(80);  // Precio total
    }
}


    private void limpiarCampos() {
    txtNombre.setText("");
    txtMarca.setText("");
    txtModelo.setText("");
    txtPrecioObra.setText("");
}

    private void tablaServiciosMouseClicked(java.awt.event.MouseEvent evt) {
    int fila = tablaServicios.getSelectedRow();
    if (fila != -1) {
        txtNombre.setText(modeloTabla.getValueAt(fila, 1).toString());
        txtMarca.setText(modeloTabla.getValueAt(fila, 2).toString());
        txtModelo.setText(modeloTabla.getValueAt(fila, 3).toString());
        txtPrecioObra.setText(""); 
    }
}

    private boolean validarCampos() {
    if (txtNombre.getText().trim().isEmpty() ||
        txtMarca.getText().trim().isEmpty() ||
        txtModelo.getText().trim().isEmpty() ||
        txtPrecioObra.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
        return false;
    }

    try {
        Double.parseDouble(txtPrecioObra.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El precio de mano de obra debe ser un número válido.");
        return false;
    }

    return true;
}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCargar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtPrecioObra = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));

        tablaServicios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaServicios);

        btnAgregar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
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

        btnCargar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCargar.setForeground(new java.awt.Color(0, 0, 0));
        btnCargar.setText("Cargar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre servicio");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Marca");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Modelo");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Precio mano de obra");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloActionPerformed(evt);
            }
        });

        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        txtPrecioObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioObraActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(102, 255, 102));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Servicios");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioObra, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(62, 62, 62))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtPrecioObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       if (!validarCampos()) {
        return; // Detener si la validación falla
    }
    
    String nombre = txtNombre.getText();
    String marca = txtMarca.getText();
    String modeloCompleto = txtModelo.getText(); // Ahora contiene modelo y posiblemente año
    double precioObra;

    try {
        precioObra = Double.parseDouble(txtPrecioObra.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Precio mano de obra inválido.");
        return;
    }

    // Separar modelo y año si es posible
    String modelo;
    int año = 0;
    
    // Intentamos extraer el año si está presente en el formato "modelo año"
    String[] partes = modeloCompleto.split(" ");
    if (partes.length > 1) {
        try {
            // El último elemento podría ser el año
            año = Integer.parseInt(partes[partes.length - 1]);
            // El resto sería el modelo
            StringBuilder modeloBuilder = new StringBuilder();
            for (int i = 0; i < partes.length - 1; i++) {
                modeloBuilder.append(partes[i]);
                if (i < partes.length - 2) {
                    modeloBuilder.append(" ");
                }
            }
            modelo = modeloBuilder.toString();
        } catch (NumberFormatException e) {
            // Si no se puede convertir a número, asumimos que todo es modelo
            modelo = modeloCompleto;
        }
    } else {
        modelo = modeloCompleto;
    }

    // Filtrar repuestos válidos por marca y modelo
    Repuesto[] todos = controladorRepuestos.getRepuestos();
    int count = 0;
    for (Repuesto r : todos) {
        if (r.getMarca().equalsIgnoreCase(marca) && r.getModelo().equalsIgnoreCase(modelo)) {
            count++;
        }
    }

    Repuesto[] repuestos = new Repuesto[count];
    int idx = 0;
    for (Repuesto r : todos) {
        if (r.getMarca().equalsIgnoreCase(marca) && r.getModelo().equalsIgnoreCase(modelo)) {
            repuestos[idx++] = r;
        }
    }

    controlador.agregarServicio(nombre, marca, modelo, año, repuestos, precioObra);
    JOptionPane.showMessageDialog(this, "Servicio agregado.");
    cargarTabla();
    limpiarCampos();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
if (!validarCampos()) {
        return; // Detener si la validación falla
    }
    
    int fila = tablaServicios.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un servicio a modificar.");
        return;
    }

    String id = modeloTabla.getValueAt(fila, 0).toString();
    String nombre = txtNombre.getText();
    String marca = txtMarca.getText();
    String modeloCompleto = txtModelo.getText();
    double precioObra;

    try {
        precioObra = Double.parseDouble(txtPrecioObra.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Precio mano de obra inválido.");
        return;
    }

    // Separar modelo y año si es posible
    String modelo;
    int año = 0;
    
    // Intentamos extraer el año si está presente en el formato "modelo año"
    String[] partes = modeloCompleto.split(" ");
    if (partes.length > 1) {
        try {
            // El último elemento podría ser el año
            año = Integer.parseInt(partes[partes.length - 1]);
            // El resto sería el modelo
            StringBuilder modeloBuilder = new StringBuilder();
            for (int i = 0; i < partes.length - 1; i++) {
                modeloBuilder.append(partes[i]);
                if (i < partes.length - 2) {
                    modeloBuilder.append(" ");
                }
            }
            modelo = modeloBuilder.toString();
        } catch (NumberFormatException e) {
            // Si no se puede convertir a número, asumimos que todo es modelo
            modelo = modeloCompleto;
        }
    } else {
        modelo = modeloCompleto;
    }

    // Filtrar repuestos válidos
    Repuesto[] todos = controladorRepuestos.getRepuestos();
    int count = 0;
    for (Repuesto r : todos) {
        if (r.getMarca().equalsIgnoreCase(marca) && r.getModelo().equalsIgnoreCase(modelo)) {
            count++;
        }
    }

    Repuesto[] repuestos = new Repuesto[count];
    int idx = 0;
    for (Repuesto r : todos) {
        if (r.getMarca().equalsIgnoreCase(marca) && r.getModelo().equalsIgnoreCase(modelo)) {
            repuestos[idx++] = r;
        }
    }

    controlador.modificarServicio(id, nombre, marca, modelo, año, repuestos, precioObra);
    JOptionPane.showMessageDialog(this, "Servicio modificado.");
    cargarTabla();
    limpiarCampos();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         int fila = tablaServicios.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un servicio para eliminar.");
        return;
    }

    String id = modeloTabla.getValueAt(fila, 0).toString();
    controlador.eliminarServicio(id);
    JOptionPane.showMessageDialog(this, "Servicio eliminado.");
    cargarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
   JFileChooser fileChooser = new JFileChooser();
    int seleccion = fileChooser.showOpenDialog(this);
    if (seleccion == JFileChooser.APPROVE_OPTION) {
        File archivo = fileChooser.getSelectedFile();
        String nombreArchivo = archivo.getName().toLowerCase();

        try {
            if (nombreArchivo.endsWith(".tms")) {
                // Modo texto (carga masiva original)
                Repuesto[] repuestosDisponibles = controladorRepuestos.getRepuestos();
                if (repuestosDisponibles != null && repuestosDisponibles.length > 0) {
                    controlador.cargarDesdeArchivo(archivo.getAbsolutePath(), repuestosDisponibles);
                } else {
                    controlador.cargarDesdeArchivo(archivo.getAbsolutePath());
                }
                JOptionPane.showMessageDialog(this, "Servicios cargados desde archivo .tms exitosamente.");
            } else if (nombreArchivo.endsWith(".dat")) {
                // Modo binario (serializado)
                controlador.cargarServicios(archivo.getAbsolutePath());
                JOptionPane.showMessageDialog(this, "Servicios cargados desde archivo .dat exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un archivo con extensión .tms o .dat.");
                return;
            }

            cargarTabla(); // Refresca la tabla en pantalla

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_btnCargarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtPrecioObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioObraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioObraActionPerformed

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
       tablaServicios.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        tablaServiciosMouseClicked(evt);
    }
});

    }//GEN-LAST:event_btnAgregarMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(VistaServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaServicios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnCargar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable tablaServicios;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioObra;
    // End of variables declaration//GEN-END:variables
   }
