/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

/**
 *
 * @author Charisse Livia
 */
public class caja_clientes extends javax.swing.JPanel {

    /**
     * Creates new form admin_clientes
     */
    public caja_clientes() {
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

        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        txt = new javax.swing.JTextField();
        Actualizar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        pnlCliente = new javax.swing.JTabbedPane();
        pnlRegistro = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtDirec = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        AgregarCliente = new javax.swing.JButton();
        txtape = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        pnlBuscarXdni = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel10.setText("NUEVO STOCK:");

        jTextField1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N

        txt.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N

        Actualizar.setBackground(new java.awt.Color(255, 204, 153));
        Actualizar.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        Actualizar.setText("Actualizar");
        Actualizar.setBorder(null);
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel9.setText("ID LIBRO:");

        jLabel8.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel8.setText("Actualizar el stock de libros");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel18.setText("CELULAR:");

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 471));

        pnlCliente.setBackground(new java.awt.Color(187, 142, 211));
        pnlCliente.setForeground(new java.awt.Color(255, 255, 255));

        pnlRegistro.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("FECHA HOY:");

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("CELULAR:");

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("NOMBRE:");

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("NACIONALIDAD:");

        txtnombre.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N

        txtDirec.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N

        txtId.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N

        AgregarCliente.setBackground(new java.awt.Color(187, 142, 211));
        AgregarCliente.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        AgregarCliente.setForeground(new java.awt.Color(255, 255, 255));
        AgregarCliente.setText("Agregar");
        AgregarCliente.setBorder(null);
        AgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarClienteActionPerformed(evt);
            }
        });

        txtape.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("ID CLIENTE:");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("APELLIDO:");

        txtFecha.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("DNI:");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("DIRECCION:");

        jComboBox1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnlRegistroLayout = new javax.swing.GroupLayout(pnlRegistro);
        pnlRegistro.setLayout(pnlRegistroLayout);
        pnlRegistroLayout.setHorizontalGroup(
            pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19)
                    .addComponent(jLabel17)
                    .addComponent(jLabel20)
                    .addComponent(jLabel14))
                .addGap(34, 34, 34)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtape, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(txtDirec, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(jSpinner1)
                    .addComponent(jSpinner2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(AgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pnlRegistroLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel11, jLabel12, jLabel14, jLabel15, jLabel16, jLabel17, jLabel19, jLabel20});

        pnlRegistroLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBox1, jSpinner1, jSpinner2, txtDirec, txtFecha, txtId, txtape, txtnombre});

        pnlRegistroLayout.setVerticalGroup(
            pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(txtape, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtDirec, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlRegistroLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(AgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pnlRegistroLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBox1, jSpinner1, jSpinner2, txtDirec, txtFecha, txtId, txtape, txtnombre});

        pnlCliente.addTab("Registrar Cliente", pnlRegistro);

        pnlBuscarXdni.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        jLabel1.setText("Ingrese el DNI:");

        txtDNI.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N

        btnbuscar.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        btnbuscar.setText("Buscar");

        javax.swing.GroupLayout pnlBuscarXdniLayout = new javax.swing.GroupLayout(pnlBuscarXdni);
        pnlBuscarXdni.setLayout(pnlBuscarXdniLayout);
        pnlBuscarXdniLayout.setHorizontalGroup(
            pnlBuscarXdniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarXdniLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBuscarXdniLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        pnlBuscarXdniLayout.setVerticalGroup(
            pnlBuscarXdniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBuscarXdniLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnlBuscarXdniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pnlCliente.addTab("Buscar Cliente por DNI", pnlBuscarXdni);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(pnlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(pnlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActualizarActionPerformed

    private void AgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgregarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton AgregarCliente;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel pnlBuscarXdni;
    private javax.swing.JTabbedPane pnlCliente;
    private javax.swing.JPanel pnlRegistro;
    private javax.swing.JTextField txt;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDirec;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtape;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
