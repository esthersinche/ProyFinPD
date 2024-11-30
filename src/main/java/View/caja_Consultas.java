package View;

import Controler.CInventario;
import DAO.EditorialDAO;
import DAO.GeneroDAO;
import DAO.IdiomaDAO;
import DAO.InventarioDAO;
import DAO.LibroDAO;
import Model.Editorial;
import Model.Genero;
import Model.Idioma;
import Model.Inventario;
import Model.Libro;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BeeIsMega
 */
public class caja_Consultas extends javax.swing.JPanel {

    DefaultTableModel m = new DefaultTableModel();
    private static final Logger logger = Logger.getLogger(CInventario.class.getName());

    public caja_Consultas() {
        initComponents();
        mostrarCabecera();
    }

    public void mostrarCabecera() {
        m.addColumn("id");
        m.addColumn("Titulo");
        m.addColumn("Genero");
        m.addColumn("Idioma");
        m.addColumn("Editorial");
        m.addColumn("Stock");
        tblStock.setModel(m);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCliente = new javax.swing.JTabbedPane();
        pnlRegistro = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlCliente.setBackground(new java.awt.Color(187, 142, 211));
        pnlCliente.setForeground(new java.awt.Color(255, 255, 255));

        pnlRegistro.setBackground(new java.awt.Color(255, 255, 255));

        txtId.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N

        btnBuscar.setBackground(new java.awt.Color(187, 142, 211));
        btnBuscar.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Codigo de Libro:");

        tblStock.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblStock);

        javax.swing.GroupLayout pnlRegistroLayout = new javax.swing.GroupLayout(pnlRegistro);
        pnlRegistro.setLayout(pnlRegistroLayout);
        pnlRegistroLayout.setHorizontalGroup(
            pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistroLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnlRegistroLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );
        pnlRegistroLayout.setVerticalGroup(
            pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlCliente.addTab("Consultar Stock", pnlRegistro);

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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // Inicializar los DAOs y controlador necesarios
        CInventario ci = new CInventario();
        InventarioDAO id = new InventarioDAO();
        LibroDAO ld = new LibroDAO();
        IdiomaDAO idd = new IdiomaDAO();
        GeneroDAO gd = new GeneroDAO();
        EditorialDAO ed = new EditorialDAO();

        // Limpiar la tabla antes de agregar nuevos datos
        m.setRowCount(0);

        // Obtener el ID del libro desde el campo de texto
        String idLibro = txtId.getText().trim();

        try {
            // Si el ID no está vacío, consultar el stock de ese libro usando CInventario
            if (!idLibro.isEmpty()) {
                int stock = ci.consultarStock(idLibro);
                if (stock > 0) {
                    // Si hay stock, mostrarlo en la tabla (puedes agregar más detalles si lo deseas)
                    Libro libro = ld.obtenerPorId(idLibro);
                    Genero genero = gd.obtenerPorId(libro.getIdGen());
                    Idioma idioma = idd.obtenerPorId(libro.getIdIdioma());
                    Editorial editorial = ed.obtenerPorId(libro.getIdEdito());

                    Object[] data = {
                        libro.getIdLibro(),
                        libro.getTitulo(),
                        genero.getGenero(),
                        idioma.getIdioma(),
                        editorial.getNomEdito(),
                        stock
                    };
                    m.addRow(data); // Mostrar la fila del libro consultado
                } else {
                    // Si no hay stock, mostrar mensaje
                    JOptionPane.showMessageDialog(this, "El libro no tiene stock disponible", "Sin Stock", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                // Si el ID está vacío, listar todos los inventarios
                List<Inventario> vi = id.obtenerTodos(); // Este método lanza SQLException

                // Iterar sobre cada inventario y obtener los datos relacionados
                for (Inventario inventario : vi) {
                    Libro libro = ld.obtenerPorId(inventario.getIdLibro());
                    Genero genero = gd.obtenerPorId(inventario.getIdGen());
                    Idioma idioma = idd.obtenerPorId(inventario.getIdIdioma());
                    Editorial editorial = ed.obtenerPorId(inventario.getIdEdito());

                    Object[] data = {
                        inventario.getIdLibro(),
                        libro.getTitulo(),
                        genero.getGenero(),
                        idioma.getIdioma(),
                        editorial.getNomEdito(),
                        inventario.getStock()
                    };
                    m.addRow(data); // Mostrar cada inventario
                }
            }
        } catch (SQLException e) {
            // Manejar el error mostrando un mensaje al usuario
            JOptionPane.showMessageDialog(this, "Error al obtener datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.SEVERE, "Error al obtener los datos del inventario", e); // Loguear el error para depuración
            e.printStackTrace(); // Opcional para depuración adicional
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane pnlCliente;
    private javax.swing.JPanel pnlRegistro;
    private javax.swing.JTable tblStock;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
