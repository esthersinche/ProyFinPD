package Controler;

import DAO.DetVentaDAO;
import DAO.VentaDAO;
import Model.Cliente;
import Model.DetVenta;
import Model.Venta;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class CVentas {

    private final VentaDAO ventaDAO;
    private final DetVentaDAO detVentaDAO;

    public CVentas() {
        this.ventaDAO = new VentaDAO();
        this.detVentaDAO = new DetVentaDAO();
    }

    /**
     * Procesar la venta con detalles
     *
     * @param cliente Cliente relacionado con la venta
     * @param detalles Lista de detalles de venta
     * @throws SQLException Si ocurre algún error al guardar en la base de datos
     */
    public void procesarVenta(Cliente cliente, List<DetVenta> detalles) throws SQLException {
        // Crear la venta (sin ID_VENTA aún)
        Venta nuevaVenta = new Venta();
        nuevaVenta.setIdCli(cliente.getIdCli());
        nuevaVenta.setFechaVenta(LocalDate.now());
        nuevaVenta.setTotalVenta(detalles.stream()
                .mapToDouble(d -> d.getPrecioUnitDetVenta() * d.getCantDetVenta())
                .sum());

        // Guardar la venta en la base de datos (el ID_VENTA será generado automáticamente si está configurado así)
        ventaDAO.guardar(nuevaVenta);

        // Recuperar el ID generado por la base de datos para la venta
        String idVentaGenerado = nuevaVenta.getIdVenta(); // Suponiendo que `ventaDAO.guardar()` actualiza `nuevaVenta` con el ID generado

        // Ahora que tenemos el ID_VENTA, asignarlo a los detalles y guardarlos
        for (DetVenta detalle : detalles) {
            detalle.setIdVenta(idVentaGenerado); // Asociar el ID_VENTA al detalle
            detalle.setIdDetVenta(UUID.randomUUID().toString().substring(0, 5)); // Crear un ID único para cada detalle
            detVentaDAO.guardar(detalle); // Guardar cada detalle de venta
        }
    }

    /**
     * Cancelar una venta y sus detalles asociados
     *
     * @param idVenta ID de la venta a cancelar
     * @throws SQLException Si ocurre algún error al eliminar en la base de
     * datos
     */
    public void cancelarVenta(String idVenta) throws SQLException {
        ventaDAO.eliminar(idVenta); // Elimina la venta y sus detalles en cascada
    }

    /**
     * Obtener todas las ventas de un cliente específico
     *
     * @param idCliente ID del cliente
     * @return Lista de ventas del cliente
     * @throws SQLException Si ocurre algún error al consultar la base de datos
     */
    public List<Venta> obtenerVentasPorCliente(String idCliente) throws SQLException {
        return ventaDAO.obtenerVentasPorCliente(idCliente);
    }
    
    public void guardarVenta(Venta venta) throws SQLException {
        // Llamar al DAO para guardar la venta y sus detalles en la base de datos
        ventaDAO.guardar(venta);
    }
}
