/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controler.*;
import DAO.LibroDAO;
import DAO.UsuarioDAO;
import Model.Usuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PERSONAL
 */
public class admin_registrarusuario extends javax.swing.JPanel {
    DefaultTableModel a = new DefaultTableModel();
    private static final Logger logger = Logger.getLogger(CUsuario.class.getName());


    /**
     * Creates new form admin_registrarusuario
     */
    public admin_registrarusuario() {
        initComponents();
        
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        TBPpaneladmin = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TXTadminregidusu = new javax.swing.JTextField();
        TXTadminregusu = new javax.swing.JTextField();
        TXTadminregcontra = new javax.swing.JTextField();
        TXTadminregrang = new javax.swing.JTextField();
        TXTadminregidemp = new javax.swing.JTextField();
        BTNadminregreg = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TXTadminactuidusu = new javax.swing.JTextField();
        TXTadminactuusu = new javax.swing.JTextField();
        TXTadminactucontra = new javax.swing.JTextField();
        TXTadminacturang = new javax.swing.JTextField();
        TXTadminactuidemp = new javax.swing.JTextField();
        BTNadminactuactu = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBadminbustablausuarios = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        TXTadminbuscaridusu = new javax.swing.JTextField();
        BTNadminbuscbusc = new javax.swing.JButton();
        BTNadminbuselimusu = new javax.swing.JButton();

        jTextField4.setText("jTextField4");

        setBackground(new java.awt.Color(255, 255, 255));

        TBPpaneladmin.setBackground(new java.awt.Color(187, 142, 211));
        TBPpaneladmin.setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("ID Usuario: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Usuario: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Contraseña: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Rango: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("ID Empleado: ");

        TXTadminregidusu.setBackground(new java.awt.Color(204, 204, 204));
        TXTadminregidusu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TXTadminregidusu.setForeground(new java.awt.Color(51, 51, 51));
        TXTadminregidusu.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray));

        TXTadminregusu.setBackground(new java.awt.Color(204, 204, 204));
        TXTadminregusu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TXTadminregusu.setForeground(new java.awt.Color(51, 51, 51));
        TXTadminregusu.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray));

        TXTadminregcontra.setBackground(new java.awt.Color(204, 204, 204));
        TXTadminregcontra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TXTadminregcontra.setForeground(new java.awt.Color(51, 51, 51));
        TXTadminregcontra.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray));

        TXTadminregrang.setBackground(new java.awt.Color(204, 204, 204));
        TXTadminregrang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TXTadminregrang.setForeground(new java.awt.Color(51, 51, 51));
        TXTadminregrang.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray));

        TXTadminregidemp.setBackground(new java.awt.Color(204, 204, 204));
        TXTadminregidemp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TXTadminregidemp.setForeground(new java.awt.Color(51, 51, 51));
        TXTadminregidemp.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray));

        BTNadminregreg.setBackground(new java.awt.Color(178, 118, 211));
        BTNadminregreg.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        BTNadminregreg.setForeground(new java.awt.Color(255, 255, 255));
        BTNadminregreg.setText("Registrar");
        BTNadminregreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNadminregregActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXTadminregidemp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTadminregrang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTadminregusu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTadminregidusu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TXTadminregcontra, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(BTNadminregreg, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TXTadminregidusu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXTadminregusu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TXTadminregcontra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(BTNadminregreg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TXTadminregrang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TXTadminregidemp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        TBPpaneladmin.addTab("Registrar Usuarios", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("ID Usuario: ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Usuario: ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Contraseña:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Rango: ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("ID Empleado: ");

        TXTadminactuidusu.setBackground(new java.awt.Color(204, 204, 204));
        TXTadminactuidusu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TXTadminactuidusu.setForeground(new java.awt.Color(51, 51, 51));
        TXTadminactuidusu.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray));

        TXTadminactuusu.setBackground(new java.awt.Color(204, 204, 204));
        TXTadminactuusu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TXTadminactuusu.setForeground(new java.awt.Color(51, 51, 51));
        TXTadminactuusu.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray));

        TXTadminactucontra.setBackground(new java.awt.Color(204, 204, 204));
        TXTadminactucontra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TXTadminactucontra.setForeground(new java.awt.Color(51, 51, 51));
        TXTadminactucontra.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray));

        TXTadminacturang.setBackground(new java.awt.Color(204, 204, 204));
        TXTadminacturang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TXTadminacturang.setForeground(new java.awt.Color(51, 51, 51));
        TXTadminacturang.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray));

        TXTadminactuidemp.setBackground(new java.awt.Color(204, 204, 204));
        TXTadminactuidemp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TXTadminactuidemp.setForeground(new java.awt.Color(51, 51, 51));
        TXTadminactuidemp.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray));

        BTNadminactuactu.setBackground(new java.awt.Color(178, 118, 211));
        BTNadminactuactu.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        BTNadminactuactu.setForeground(new java.awt.Color(255, 255, 255));
        BTNadminactuactu.setText("Actualizar");
        BTNadminactuactu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNadminactuactuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXTadminactuidusu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXTadminactuusu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXTadminacturang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXTadminactuidemp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(238, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(TXTadminactucontra, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTNadminactuactu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TXTadminactuidusu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TXTadminactuusu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TXTadminactucontra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNadminactuactu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TXTadminacturang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(TXTadminactuidemp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        TBPpaneladmin.addTab("Actualizar Usuarios", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        TBadminbustablausuarios.setBackground(new java.awt.Color(224, 224, 224));
        TBadminbustablausuarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TBadminbustablausuarios.setForeground(new java.awt.Color(51, 51, 51));
        TBadminbustablausuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Usuario", "Usuario", "Contraseña", "Rango", "ID Empleado"
            }
        ));
        TBadminbustablausuarios.setGridColor(new java.awt.Color(153, 102, 255));
        TBadminbustablausuarios.setSelectionBackground(new java.awt.Color(153, 102, 255));
        jScrollPane1.setViewportView(TBadminbustablausuarios);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("ID Usuario: ");

        TXTadminbuscaridusu.setBackground(new java.awt.Color(204, 204, 204));
        TXTadminbuscaridusu.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray));

        BTNadminbuscbusc.setBackground(new java.awt.Color(178, 118, 211));
        BTNadminbuscbusc.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        BTNadminbuscbusc.setForeground(new java.awt.Color(255, 255, 255));
        BTNadminbuscbusc.setText("Buscar");
        BTNadminbuscbusc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNadminbuscbuscActionPerformed(evt);
            }
        });

        BTNadminbuselimusu.setBackground(new java.awt.Color(179, 120, 211));
        BTNadminbuselimusu.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        BTNadminbuselimusu.setForeground(new java.awt.Color(255, 255, 255));
        BTNadminbuselimusu.setText("Eliminar");
        BTNadminbuselimusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNadminbuselimusuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(TXTadminbuscaridusu, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(BTNadminbuscbusc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(BTNadminbuselimusu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(TXTadminbuscaridusu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNadminbuscbusc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNadminbuselimusu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        TBPpaneladmin.addTab("Buscar/ Eliminar Usuario", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TBPpaneladmin)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TBPpaneladmin)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BTNadminregregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNadminregregActionPerformed
        // obtener texto del testfield
        String idusu= TXTadminregidusu.getText();
        String usu= TXTadminregusu.getText();
        String contra= TXTadminregcontra.getText();
        String range= TXTadminregrang.getText();
        String idemp= TXTadminregidemp.getText();
        
        CUsuario cusu= new CUsuario();
        
        if (!idusu.isEmpty()&&!usu.isEmpty()&&!contra.isEmpty()&&!range.isEmpty()&&!idemp.isEmpty()) {
                Usuario newusuario= new Usuario(idusu, usu, contra, range, idemp);  
                
            try{
                cusu.registrarUsuario(newusuario);
                JOptionPane.showMessageDialog(this, "Usuario ingresado con éxito", "Felicidades Shinji", JOptionPane.INFORMATION_MESSAGE);                
            }catch(SQLException porfafunciona){
                JOptionPane.showMessageDialog(this, "Error al ingresar el Usuario" + porfafunciona.getMessage(), "Fue", JOptionPane.ERROR_MESSAGE); 
                logger.log(Level.SEVERE, "Error al agregar los datos del inventario", porfafunciona); // Loguear el error para depuración

                porfafunciona.printStackTrace();
            }
            }else{
                JOptionPane.showMessageDialog(this, "Rellenar todos los campos", "Información Incompleta", JOptionPane.INFORMATION_MESSAGE);
               }
        
        
        TXTadminregidusu.setText("");
        TXTadminregusu.setText("");
        TXTadminregcontra.setText("");
        TXTadminregrang.setText("");
        TXTadminregidemp.setText("");
    }//GEN-LAST:event_BTNadminregregActionPerformed

    private void BTNadminactuactuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNadminactuactuActionPerformed
        // obtener texto del testfield
        String idusu= TXTadminactuidusu.getText();
        String usu= TXTadminactuusu.getText();
        String contra= TXTadminactucontra.getText();
        String range= TXTadminacturang.getText();
        String idemp= TXTadminactuidemp.getText();
        
        CUsuario cusu= new CUsuario();       
        
        
        if (!idusu.isEmpty()&&!usu.isEmpty()&&!contra.isEmpty()&&!range.isEmpty()&&!idemp.isEmpty()) { 
            try{
                Usuario actuusu= cusu.obtenerUsuarioPorId(idusu);//guardar en un objeto usuario
                actuusu.setUsuario(usu);//actualizar
                actuusu.setContrasena(contra);
                actuusu.setRango(range);
                actuusu.setIdEmp(idemp);
                cusu.actualizarUsuario(actuusu);  
                JOptionPane.showMessageDialog(this, "Usuario actualizado con éxito", "Felicidades Shinji", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException deviltrigger){
                JOptionPane.showMessageDialog(this, "Error al actualizar el Usuario" + deviltrigger.getMessage(), "Fue", JOptionPane.ERROR_MESSAGE); 
                logger.log(Level.SEVERE, "Error al actualizar los datos del inventario", deviltrigger); // Loguear el error para depuración

                deviltrigger.printStackTrace();                
            }       
            }else{
                JOptionPane.showMessageDialog(this, "Rellenar todos los campos", "Información Incompleta", JOptionPane.INFORMATION_MESSAGE);
                } 
        
        TXTadminactuidusu.setText("");
        TXTadminactuusu.setText("");
        TXTadminactucontra.setText("");
        TXTadminacturang.setText("");
        TXTadminactuidemp.setText("");
        
    }//GEN-LAST:event_BTNadminactuactuActionPerformed

    private void BTNadminbuscbuscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNadminbuscbuscActionPerformed
        // love u beyonce
        String idusu= TXTadminbuscaridusu.getText();
        CUsuario cusu= new CUsuario();
        UsuarioDAO usudao= new UsuarioDAO();
        DefaultTableModel a= (DefaultTableModel) TBadminbustablausuarios.getModel();
        a.setRowCount(0);
        
        //TBadminbustablausuarios
        
            try{
                if (!idusu.isEmpty()) {//id usuario no esta vacio
                    Usuario buscado= cusu.obtenerUsuarioPorId(idusu); 
                    if (buscado != null) {
                        Object[] datos= {buscado.getIdUsuario(), buscado.getUsuario(), buscado.getContrasena(),
                        buscado.getRango(), buscado.getIdEmp()};
                    
                        a.addRow(datos);               
                    }else{
                        JOptionPane.showMessageDialog(this, "No se encontro el Usuario o No Existe", "Por favor no", JOptionPane.WARNING_MESSAGE);                        
                    }
                                                          
                }else{//id usuario esta vacio
                    List<Usuario> allusers= usudao.obtenerTodos();
                    for(Usuario usuario: allusers){
                        Object[] datos2= {usuario.getIdUsuario(), usuario.getUsuario(), usuario.getContrasena(),
                        usuario.getRango(), usuario.getIdEmp()};
                        
                        a.addRow(datos2);                       
                    }                  
                }
                              
            }catch(SQLException papermoon){
                JOptionPane.showMessageDialog(this, "Problemas con la BD" + papermoon.getMessage(), "Por favor no", JOptionPane.ERROR_MESSAGE);
                logger.log(Level.SEVERE, "Error al obtener los datos del inventario", papermoon); // Loguear el error para depuración
                papermoon.printStackTrace(); 
                TXTadminbuscaridusu.setText("");                
            }
           
        
    }//GEN-LAST:event_BTNadminbuscbuscActionPerformed

    private void BTNadminbuselimusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNadminbuselimusuActionPerformed
        // idusu columna 0
        DefaultTableModel a= (DefaultTableModel) TBadminbustablausuarios.getModel();
        int fila= TBadminbustablausuarios.getSelectedRow();
        String idusu= TBadminbustablausuarios.getModel().getValueAt(fila, 0).toString();
        
        CUsuario cusu= new CUsuario();
        
        try{
            int confirm= JOptionPane.showConfirmDialog(this, "Confirmar Eliminación del Usuario: "+ idusu, "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {//confirmar la eliminacion del usuario, por si ns seleccionan mal
                cusu.eliminarUsuario(idusu);
                JOptionPane.showMessageDialog(this, "Usuario eliminado con éxito", "Felicidades Shinji", JOptionPane.INFORMATION_MESSAGE);               
            }else{
                JOptionPane.showMessageDialog(this, "Eliminación Cancelada", "Felicidades Shinji", JOptionPane.INFORMATION_MESSAGE);                               
            }
                       
        }catch(SQLException laragedupeuple){
            JOptionPane.showMessageDialog(this, "No se pudo eliminar el Usuario" + laragedupeuple.getMessage(), "Por favor no", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.SEVERE, "Error al eliminar los datos del inventario", laragedupeuple); // Loguear el error para depuración

            laragedupeuple.printStackTrace(); 
        }
        
    }//GEN-LAST:event_BTNadminbuselimusuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNadminactuactu;
    private javax.swing.JButton BTNadminbuscbusc;
    private javax.swing.JButton BTNadminbuselimusu;
    private javax.swing.JButton BTNadminregreg;
    private javax.swing.JTabbedPane TBPpaneladmin;
    private javax.swing.JTable TBadminbustablausuarios;
    private javax.swing.JTextField TXTadminactucontra;
    private javax.swing.JTextField TXTadminactuidemp;
    private javax.swing.JTextField TXTadminactuidusu;
    private javax.swing.JTextField TXTadminacturang;
    private javax.swing.JTextField TXTadminactuusu;
    private javax.swing.JTextField TXTadminbuscaridusu;
    private javax.swing.JTextField TXTadminregcontra;
    private javax.swing.JTextField TXTadminregidemp;
    private javax.swing.JTextField TXTadminregidusu;
    private javax.swing.JTextField TXTadminregrang;
    private javax.swing.JTextField TXTadminregusu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
