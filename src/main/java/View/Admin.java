/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.CardLayout;

/**
 *
 * @author PERSONAL
 */
public class Admin extends javax.swing.JFrame {
    
    private CardLayout cardlayout;//se crea para inicializarse luego
    private admin_registrarusuario regusu= new admin_registrarusuario();//instancia de los paneles del primer boton
    private admin_libros reglib= new admin_libros();//instancia de los paneles del segundo boton
    private admin_inventario regstock= new admin_inventario();
    

    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
        cardlayout= new CardLayout();
        viewpaneladmin.setLayout(cardlayout);
        
        //tarjetas
        viewpaneladmin.add(regusu, "Operaciones Admin Usuarios");
        viewpaneladmin.add(reglib, "Operaciones Admin Libros");
        viewpaneladmin.add(regstock, "Operaciones Admin Stock");
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BTNadminusu = new javax.swing.JButton();
        BTNadminlib = new javax.swing.JButton();
        BTNadminstock = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        viewpaneladmin = new javax.swing.JPanel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(187, 142, 211));

        BTNadminusu.setBackground(new java.awt.Color(187, 142, 211));
        BTNadminusu.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        BTNadminusu.setText("Usuarios");
        BTNadminusu.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 3, 4, 3, new java.awt.Color(176, 111, 211)));
        BTNadminusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNadminusuActionPerformed(evt);
            }
        });

        BTNadminlib.setBackground(new java.awt.Color(187, 142, 211));
        BTNadminlib.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        BTNadminlib.setText("Libros");
        BTNadminlib.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 3, 4, 3, new java.awt.Color(176, 111, 211)));
        BTNadminlib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNadminlibActionPerformed(evt);
            }
        });

        BTNadminstock.setBackground(new java.awt.Color(187, 142, 211));
        BTNadminstock.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        BTNadminstock.setText("Stock");
        BTNadminstock.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 3, 4, 3, new java.awt.Color(176, 111, 211)));
        BTNadminstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNadminstockActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        btnLogout.setText("Cerrar Sesion");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BTNadminusu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BTNadminlib, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BTNadminstock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel4)
                .addContainerGap(126, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel4)
                .addGap(64, 64, 64)
                .addComponent(BTNadminusu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BTNadminlib, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BTNadminstock, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(21, 21, 21))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 510));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Bienvenido, Administrador! <3");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Se puede realizar diferentes operaciones");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 640, 130));

        javax.swing.GroupLayout viewpaneladminLayout = new javax.swing.GroupLayout(viewpaneladmin);
        viewpaneladmin.setLayout(viewpaneladminLayout);
        viewpaneladminLayout.setHorizontalGroup(
            viewpaneladminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        viewpaneladminLayout.setVerticalGroup(
            viewpaneladminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        jPanel1.add(viewpaneladmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 640, 380));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNadminusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNadminusuActionPerformed
        cardlayout.show(viewpaneladmin, "Operaciones Admin Usuarios");
    }//GEN-LAST:event_BTNadminusuActionPerformed

    private void BTNadminlibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNadminlibActionPerformed
        // TODO add your handling code here:
        cardlayout.show(viewpaneladmin, "Operaciones Admin Libros");
    }//GEN-LAST:event_BTNadminlibActionPerformed

    private void BTNadminstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNadminstockActionPerformed
        // TODO add your handling code here:
        cardlayout.show(viewpaneladmin, "Operaciones Admin Stock");
    }//GEN-LAST:event_BTNadminstockActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNadminlib;
    private javax.swing.JButton BTNadminstock;
    private javax.swing.JButton BTNadminusu;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel viewpaneladmin;
    // End of variables declaration//GEN-END:variables
}
