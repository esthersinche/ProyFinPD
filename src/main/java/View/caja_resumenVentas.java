package View;

import Controler.CVentas;
import DAO.DetVentaDAO;
import DAO.VentaDAO;
import Model.DetVenta;
import Model.Venta;
import java.awt.CardLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author BeeIsMega
 */
public class caja_resumenVentas extends javax.swing.JPanel {

    private VentaDAO ventaDAO = new VentaDAO();
    private String idVenta;

    public caja_resumenVentas(String idVenta) {
        initComponents();
        this.idVenta = idVenta;
        cargarResumenVenta();
    }

    private void cargarResumenVenta() {
        try {
            Venta venta = ventaDAO.obtenerPorId(idVenta);
            if (venta != null) {
                txtResumenVenta.setText(venta.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Venta no encontrada con ID: " + idVenta, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            Logger.getLogger(caja_resumenVentas.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Error al cargar el resumen de la venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarResumenVenta(Venta venta, List<DetVenta> listaDeDetalles) {
        StringBuilder resumen = new StringBuilder();
        resumen.append("RESUMEN DE VENTA\n");
        resumen.append("===================================\n");
        resumen.append("Código de Venta: ").append(venta.getIdVenta()).append("\n");
        resumen.append("Fecha: ").append(venta.getFechaVenta()).append("\n");
        resumen.append("Cliente: ").append(venta.getIdCli()).append("\n");
        resumen.append("===================================\n");
        resumen.append("Detalle de Productos:\n");
        resumen.append("Código Libro | Cantidad | Precio Unit. | Subtotal\n");

        double total = 0.0;
        for (DetVenta detalle : listaDeDetalles) {
            double subtotal = detalle.getCantDetVenta() * detalle.getPrecioUnitDetVenta();
            total += subtotal;
            resumen.append(detalle.getIdLibro()).append(" | ")
                    .append(detalle.getCantDetVenta()).append(" | ")
                    .append(String.format("%.2f", detalle.getPrecioUnitDetVenta())).append(" | ")
                    .append(String.format("%.2f", subtotal)).append("\n");
        }

        resumen.append("===================================\n");
        resumen.append("Total: ").append(String.format("%.2f", total)).append("\n");

        // Mostrar el resumen en el JTextArea
        txtResumenVenta.setText(resumen.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtResumenVenta = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGenerarBoleta = new javax.swing.JButton();

        setBackground(new java.awt.Color(224, 174, 249));

        txtResumenVenta.setEditable(false);
        txtResumenVenta.setColumns(20);
        txtResumenVenta.setRows(5);
        jScrollPane1.setViewportView(txtResumenVenta);

        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Resumen de Venta");

        btnCancelar.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGenerarBoleta.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        btnGenerarBoleta.setText("Generar Boleta");
        btnGenerarBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarBoletaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerarBoleta)
                .addGap(115, 115, 115))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGenerarBoleta))
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea cancelar esta venta?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                ventaDAO.eliminar(idVenta);
                JOptionPane.showMessageDialog(this, "Venta cancelada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                // Aquí podrías redirigir a otro panel o cerrar el actual
            } catch (SQLException e) {
                Logger.getLogger(caja_resumenVentas.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(this, "Error al cancelar la venta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        volver();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGenerarBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarBoletaActionPerformed
        try {
            Venta venta = ventaDAO.obtenerPorId(idVenta);
            if (venta != null) {
                generarArchivoBoleta(venta);
                JOptionPane.showMessageDialog(this, "Boleta generada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Venta no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | IOException e) {
            Logger.getLogger(caja_resumenVentas.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Error al generar la boleta", "Error", JOptionPane.ERROR_MESSAGE);
        }
        volver();
    }//GEN-LAST:event_btnGenerarBoletaActionPerformed
    private void generarArchivoBoleta(Venta venta) throws IOException {
        String carpetaDestino = "boletas"; // Carpeta para guardar las boletas
        File carpeta = new File(carpetaDestino);
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

        File archivo = new File(carpeta, "Boleta_" + venta.getIdVenta() + ".txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write(venta.toString()); // Asegúrate de que toString de Venta tenga el formato necesario
        }
    }
    private void volver(){
        JPanel pnlCajero = (JPanel) this.getParent();
        CardLayout cardLayout = (CardLayout) pnlCajero.getLayout();

        // Mostrar el panel anterior (en este caso, "Ventas")
        cardLayout.show(pnlCajero, "Ventas");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGenerarBoleta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtResumenVenta;
    // End of variables declaration//GEN-END:variables
}
