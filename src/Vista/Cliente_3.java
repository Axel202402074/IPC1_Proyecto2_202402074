
package Vista;

import Controlador.ControladorAutomovil;
import Modelo.Automovil;
import Modelo.RegistroCliente;
import javax.swing.JOptionPane;

public class Cliente_3 extends javax.swing.JFrame {
private RegistroCliente cliente;

   public Cliente_3() {
        initComponents();
        this.setTitle("Cliente");
        this.setLocationRelativeTo(null);
       
    }

    public Cliente_3(RegistroCliente cliente) {
        initComponents();
        this.cliente = cliente;
        this.setTitle("Cliente: " + cliente.getNombre());
        this.setLocationRelativeTo(null);
        //mostrarAutomoviles();
        
    }

/*private void mostrarAutomoviles() {
    if (cliente.getCantidadAutos() == 0) {
        JOptionPane.showMessageDialog(this, "No tiene automóviles registrados.");
    } else {
        for (Automovil auto : cliente.getAutomoviles()) {
            System.out.println(" Placa: " + auto.getPlaca() +
                               ", Marca: " + auto.getMarca() +
                               ", Modelo: " + auto.getModelo());
        }
     
    }
}*/
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnReportes1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCerrarSesion = new javax.swing.JButton();
        btnVerMisAutos = new javax.swing.JButton();
        btnRegistrarAutomovil = new javax.swing.JButton();
        btnVerProgreso = new javax.swing.JButton();
        btnFacturas = new javax.swing.JButton();

        btnReportes1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnReportes1.setForeground(new java.awt.Color(0, 0, 0));
        btnReportes1.setText("Facturas");
        btnReportes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportes1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnVerMisAutos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnVerMisAutos.setForeground(new java.awt.Color(0, 0, 0));
        btnVerMisAutos.setText("Ver mis automoviles");
        btnVerMisAutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMisAutosActionPerformed(evt);
            }
        });

        btnRegistrarAutomovil.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnRegistrarAutomovil.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrarAutomovil.setText("Registrar automovil");
        btnRegistrarAutomovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAutomovilActionPerformed(evt);
            }
        });

        btnVerProgreso.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnVerProgreso.setForeground(new java.awt.Color(0, 0, 0));
        btnVerProgreso.setText("Ver progreso");
        btnVerProgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerProgresoActionPerformed(evt);
            }
        });

        btnFacturas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnFacturas.setForeground(new java.awt.Color(0, 0, 0));
        btnFacturas.setText("Facturas");
        btnFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrarAutomovil, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(btnVerProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(109, 109, 109)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVerMisAutos, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(btnFacturas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnCerrarSesion)
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarAutomovil, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerMisAutos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
         Login_1 nuevaVista = new Login_1();
       nuevaVista.setVisible(true);    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnVerMisAutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMisAutosActionPerformed
        VistaVerMisAutomoviles nuevaVista =new VistaVerMisAutomoviles();
        nuevaVista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVerMisAutosActionPerformed

    private void btnRegistrarAutomovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAutomovilActionPerformed
        VistaRegistrarAutomovil nuevaVista =new VistaRegistrarAutomovil();     
    nuevaVista.setVisible(true);
    this.dispose();

    }//GEN-LAST:event_btnRegistrarAutomovilActionPerformed

    private void btnVerProgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerProgresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerProgresoActionPerformed

    private void btnReportes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportes1ActionPerformed

    private void btnFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFacturasActionPerformed

    
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
            java.util.logging.Logger.getLogger(Cliente_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente_3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnFacturas;
    private javax.swing.JButton btnRegistrarAutomovil;
    private javax.swing.JButton btnReportes1;
    private javax.swing.JButton btnVerMisAutos;
    private javax.swing.JButton btnVerProgreso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
