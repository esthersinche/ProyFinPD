package View;

import Controler.CCliente;
import DAO.ClienteDAO;
import Model.Cliente;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;
import javax.swing.JOptionPane;

/**
 *
 * @author BeeIsMega
 */
public class caja_clientes extends javax.swing.JPanel {

    public caja_clientes() {
        initComponents();
    }

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
        jLabel19 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtDirec = new javax.swing.JTextField();
        AgregarCliente = new javax.swing.JButton();
        txtApe = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbxNacionalidad = new javax.swing.JComboBox<>();
        txtDni = new javax.swing.JTextField();
        txtCel = new javax.swing.JTextField();

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

        txtApe.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("APELLIDO:");

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("DNI:");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("DIRECCION:");

        cbxNacionalidad.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cbxNacionalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Peruana", "Mexicana", "Española", "Venezolana", "Brasileña", "Francesa", "Estadounidense", "Canadiense" }));

        javax.swing.GroupLayout pnlRegistroLayout = new javax.swing.GroupLayout(pnlRegistro);
        pnlRegistro.setLayout(pnlRegistroLayout);
        pnlRegistroLayout.setHorizontalGroup(
            pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistroLayout.createSequentialGroup()
                        .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRegistroLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(34, 34, 34)
                                .addComponent(cbxNacionalidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlRegistroLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(34, 34, 34)
                                .addComponent(txtCel))
                            .addGroup(pnlRegistroLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(34, 34, 34)
                                .addComponent(txtDirec, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                        .addContainerGap(323, Short.MAX_VALUE))
                    .addGroup(pnlRegistroLayout.createSequentialGroup()
                        .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addGap(34, 34, 34)
                        .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtApe, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(txtDni))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );

        pnlRegistroLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel11, jLabel14, jLabel15, jLabel16, jLabel19, jLabel20});

        pnlRegistroLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbxNacionalidad, txtApe, txtCel, txtDirec, txtDni, txtnombre});

        pnlRegistroLayout.setVerticalGroup(
            pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroLayout.createSequentialGroup()
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistroLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(txtApe, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(txtDirec, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cbxNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pnlRegistroLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbxNacionalidad, txtApe, txtCel, txtDirec, txtDni, txtnombre});

        pnlCliente.addTab("Registrar Cliente", pnlRegistro);

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
        // Paso 1: Obtener los valores ingresados
        String nombre = txtnombre.getText().trim();
        String apellido = txtApe.getText().trim();
        String dni = txtDni.getText().trim();
        String direccion = txtDirec.getText().trim();
        String celular = txtCel.getText().trim();
        String nac = (String) cbxNacionalidad.getSelectedItem();
        CCliente cc = new CCliente();  

        // Paso 2: Validar los datos
        if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || direccion.isEmpty() || celular.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Paso 3: Validar que dni y celular sean números válidos
        int dniInt = 0, celularInt = 0;
        try {
            dniInt = Integer.parseInt(dni);
            celularInt = Integer.parseInt(celular);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El DNI y el celular deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Paso 4: Obtener el ID de la nacionalidad usando el nombre seleccionado
        String idNacionalidad = null;
        try {
            idNacionalidad = cc.obtenerIdNacionalidad(nac);  // Llamamos al método para obtener el ID
            if (idNacionalidad == null) {
                JOptionPane.showMessageDialog(this, "No se encontró la nacionalidad.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener el ID de nacionalidad: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Paso 5: Generar idCli automáticamente (puedes usar UUID.randomUUID().toString().substring(0, 5))
        String idCli = UUID.randomUUID().toString().substring(0, 5);

        // Paso 6: Obtener la fecha actual (fecha de registro)
        LocalDate fechaReg = LocalDate.now();

        // Paso 7: Crear un objeto Cliente
        Cliente nuevoCliente = new Cliente(idCli, dniInt, nombre, apellido, direccion, celularInt, fechaReg, idNacionalidad);

        // Paso 8: Llamar al DAO para guardar el cliente
        boolean exito = cc.registrarCliente(nuevoCliente);

        // Paso 9: Mostrar mensaje de confirmación o error
        if (exito) {
            JOptionPane.showMessageDialog(this, "Cliente registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            // Limpiar campos
            txtnombre.setText("");
            txtApe.setText("");
            txtDni.setText("");
            txtDirec.setText("");
            txtCel.setText("");
            cbxNacionalidad.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AgregarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton AgregarCliente;
    private javax.swing.JComboBox<String> cbxNacionalidad;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTabbedPane pnlCliente;
    private javax.swing.JPanel pnlRegistro;
    private javax.swing.JTextField txt;
    private javax.swing.JTextField txtApe;
    private javax.swing.JTextField txtCel;
    private javax.swing.JTextField txtDirec;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
