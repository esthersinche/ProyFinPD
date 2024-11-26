package DAO;

import Interface.ICrud_DAO;
import Model.Cliente;
import util.SQLConexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements ICrud_DAO<Cliente> {

    @Override
    public void guardar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO CLIENTES (ID_CLI, DNI_CLI, NOM_CLI, APE_CLI, DIREC_CLI, CEL_CLI, FECHA_REG, ID_NAC) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getIdCli());
            stmt.setInt(2, cliente.getDniCli());
            stmt.setString(3, cliente.getNomCli());
            stmt.setString(4, cliente.getApeCli());
            stmt.setString(5, cliente.getDirecCli());
            stmt.setInt(6, cliente.getCelCli());
            stmt.setDate(7, Date.valueOf(cliente.getFechaReg()));
            stmt.setString(8, cliente.getIdNac());
            stmt.executeUpdate();
        }
    }

    @Override
    public Cliente obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM CLIENTES WHERE ID_CLI = ?";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                            rs.getString("ID_CLI"),
                            rs.getInt("DNI_CLI"),
                            rs.getString("NOM_CLI"),
                            rs.getString("APE_CLI"),
                            rs.getString("DIREC_CLI"),
                            rs.getInt("CEL_CLI"),
                            rs.getDate("FECHA_REG").toLocalDate(),
                            rs.getString("ID_NAC")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<Cliente> obtenerTodos() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTES";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getString("ID_CLI"),
                        rs.getInt("DNI_CLI"),
                        rs.getString("NOM_CLI"),
                        rs.getString("APE_CLI"),
                        rs.getString("DIREC_CLI"),
                        rs.getInt("CEL_CLI"),
                        rs.getDate("FECHA_REG").toLocalDate(),
                        rs.getString("ID_NAC")
                );
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    @Override
    public void actualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE CLIENTES SET DNI_CLI = ?, NOM_CLI = ?, APE_CLI = ?, DIREC_CLI = ?, CEL_CLI = ?, FECHA_REG = ?, ID_NAC = ? WHERE ID_CLI = ?";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cliente.getDniCli());
            stmt.setString(2, cliente.getNomCli());
            stmt.setString(3, cliente.getApeCli());
            stmt.setString(4, cliente.getDirecCli());
            stmt.setInt(5, cliente.getCelCli());
            stmt.setDate(6, Date.valueOf(cliente.getFechaReg()));
            stmt.setString(7, cliente.getIdNac());
            stmt.setString(8, cliente.getIdCli());
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM CLIENTES WHERE ID_CLI = ?";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }

    // Método adicional para buscar cliente por DNI
    public Cliente buscarPorDni(int dni) throws SQLException {
        String sql = "SELECT * FROM CLIENTES WHERE DNI_CLI = ?";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, dni);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                            rs.getString("ID_CLI"),
                            rs.getInt("DNI_CLI"),
                            rs.getString("NOM_CLI"),
                            rs.getString("APE_CLI"),
                            rs.getString("DIREC_CLI"),
                            rs.getInt("CEL_CLI"),
                            rs.getDate("FECHA_REG").toLocalDate(),
                            rs.getString("ID_NAC")
                    );
                }
            }
        }
        return null;
    }

    // Método adicional para obtener clientes registrados en un rango de fechas
    public List<Cliente> obtenerClientesPorFechaRegistro(LocalDate fechaInicio, LocalDate fechaFin) throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTES WHERE FECHA_REG BETWEEN ? AND ?";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, Date.valueOf(fechaInicio));
            stmt.setDate(2, Date.valueOf(fechaFin));
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = new Cliente(
                            rs.getString("ID_CLI"),
                            rs.getInt("DNI_CLI"),
                            rs.getString("NOM_CLI"),
                            rs.getString("APE_CLI"),
                            rs.getString("DIREC_CLI"),
                            rs.getInt("CEL_CLI"),
                            rs.getDate("FECHA_REG").toLocalDate(),
                            rs.getString("ID_NAC")
                    );
                    clientes.add(cliente);
                }
            }
        }
        return clientes;
    }
}
