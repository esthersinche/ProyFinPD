package Controler;
import DAO.ClienteDAO;
import Model.Cliente;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
public class CCliente {
    private final ClienteDAO clienteDAO;

    public CCliente() {
        this.clienteDAO = new ClienteDAO();
    }

    public Cliente registrarCliente(Cliente cliente) throws SQLException {
        clienteDAO.guardar(cliente);
        return cliente;
    }

    public Cliente obtenerClientePorDni(int dni) throws SQLException {
        return clienteDAO.buscarPorDni(dni);
    }

    public List<Cliente> obtenerClientesPorFechaRegistro(LocalDate fechaInicio, LocalDate fechaFin) throws SQLException {
        return clienteDAO.obtenerClientesPorFechaRegistro(fechaInicio, fechaFin);
    }
}
