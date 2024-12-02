package Controler;
import DAO.ClienteDAO;
import Model.Cliente;

import java.sql.SQLException;

public class CCliente {
    private final ClienteDAO clienteDAO;

    public CCliente() {
        this.clienteDAO = new ClienteDAO();
    }

    public Cliente registrarCliente(Cliente cliente) throws SQLException {
        clienteDAO.guardar(cliente);
        return cliente;
    }

    

    
}
