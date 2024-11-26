package Controler;

import DAO.VentaDAO;
import Model.Cliente;
import Model.DetVenta;
import Model.Venta;
import java.sql.SQLException;
import java.util.List;

public class CVentas {

    private final VentaDAO ventaDAO;

    public CVentas() {
        this.ventaDAO = new VentaDAO();
    }

    public Venta procesarVenta(Cliente cliente, List<DetVenta> detalles) throws SQLException {
        Venta nuevaVenta = new Venta();
        nuevaVenta.setIdCli(cliente.getIdCli());
        nuevaVenta.setTotalVenta(detalles.stream().mapToDouble(d -> d.getPrecioUnitDetVenta() * d.getCantDetVenta()).sum());

        ventaDAO.guardar(nuevaVenta);

        for (DetVenta detalle : detalles) {
            detalle.setIdVenta(nuevaVenta.getIdVenta());
            // Guardar cada detalle en la base de datos.
        }

        return nuevaVenta;
    }

    public void cancelarVenta(String idVenta) throws SQLException {
        ventaDAO.eliminar(idVenta);
    }

    public List<Venta> obtenerVentasPorCliente(String idCliente) throws SQLException {
        return ventaDAO.obtenerVentasPorCliente(idCliente);
    }
}
