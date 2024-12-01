package Controler;
import DAO.ClienteDAO;
import DAO.NacionalidadDAO;
import Model.Cliente;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
public class CCliente {
    private final ClienteDAO clienteDAO;
    private final NacionalidadDAO nacionalidadDAO;

    public CCliente() {
        this.clienteDAO = new ClienteDAO();
        this.nacionalidadDAO = new NacionalidadDAO();
    }

    public boolean registrarCliente(Cliente cliente) {
        // Generar idCli automáticamente
        cliente.setIdCli(UUID.randomUUID().toString().substring(0, 5));

        try {
            // Verificar si el DNI ya existe
            Cliente clienteExistente = obtenerClientePorDni(cliente.getDniCli());
            if (clienteExistente != null) {
                throw new SQLException("El DNI ya está registrado.");
            }

            // Si no existe, registrar el cliente
            clienteDAO.guardar(cliente);
            return true;  // Retornar true si se guardó exitosamente
        } catch (SQLException e) {
            // Manejar la excepción y retornar false en caso de error
            e.printStackTrace();  // Puedes registrar el error en un logger si lo deseas
            return false;  // Retornar false si ocurrió un error
        }
    }
    
    public String obtenerIdNacionalidad(String nacionalidad) throws SQLException {
        return nacionalidadDAO.obtenerIdNacionalidadPorNombre(nacionalidad);
    }

    public Cliente obtenerClientePorDni(int dni) throws SQLException {
        return clienteDAO.buscarPorDni(dni);
    }

    public List<Cliente> obtenerClientesPorFechaRegistro(LocalDate fechaInicio, LocalDate fechaFin) throws SQLException {
        return clienteDAO.obtenerClientesPorFechaRegistro(fechaInicio, fechaFin);
    }
}
