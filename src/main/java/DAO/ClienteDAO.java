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
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO implements ICrud_DAO<Cliente> {

    private static final Logger logger = Logger.getLogger(ClienteDAO.class.getName());
    private static final String TABLE_NAME = "CLIENTES";
    private static final String COLUMN_ID = "ID_CLI";
    private static final String COLUMN_DNI = "DNI_CLI";
    private static final String COLUMN_NAME = "NOM_CLI";
    private static final String COLUMN_LASTNAME = "APE_CLI";
    private static final String COLUMN_ADDRESS = "DIREC_CLI";
    private static final String COLUMN_PHONE = "CEL_CLI";
    private static final String COLUMN_REG_DATE = "FECHA_REG";
    private static final String COLUMN_NATION = "ID_NAC";

    @Override
    public void guardar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_ID + ", " + COLUMN_DNI + ", " + COLUMN_NAME + ", "
                + COLUMN_LASTNAME + ", " + COLUMN_ADDRESS + ", " + COLUMN_PHONE + ", " + COLUMN_REG_DATE + ", " + COLUMN_NATION + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getIdCli());
            stmt.setInt(2, cliente.getDniCli());
            stmt.setString(3, cliente.getNomCli());
            stmt.setString(4, cliente.getApeCli());
            stmt.setString(5, cliente.getDirecCli());
            stmt.setInt(6, cliente.getCelCli());
            stmt.setDate(7, Date.valueOf(cliente.getFechaReg()));
            stmt.setString(8, cliente.getIdNac());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Cliente guardado correctamente: {0}", cliente.getIdCli());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al guardar cliente", e);
            throw e;
        }
    }

    @Override
    public Cliente obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearCliente(rs);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener cliente por ID: " + id, e);
            throw e;
        }
        logger.log(Level.WARNING, "No se encontró cliente con ID: {0}", id);
        return null;
    }

    @Override
    public List<Cliente> obtenerTodos() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                clientes.add(mapearCliente(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener todos los clientes", e);
            throw e;
        }
        return clientes;
    }

    @Override
    public void actualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE " + TABLE_NAME + " SET " + COLUMN_DNI + " = ?, " + COLUMN_NAME + " = ?, "
                + COLUMN_LASTNAME + " = ?, " + COLUMN_ADDRESS + " = ?, " + COLUMN_PHONE + " = ?, "
                + COLUMN_REG_DATE + " = ?, " + COLUMN_NATION + " = ? WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getDniCli());
            stmt.setString(2, cliente.getNomCli());
            stmt.setString(3, cliente.getApeCli());
            stmt.setString(4, cliente.getDirecCli());
            stmt.setInt(5, cliente.getCelCli());
            stmt.setDate(6, Date.valueOf(cliente.getFechaReg()));
            stmt.setString(7, cliente.getIdNac());
            stmt.setString(8, cliente.getIdCli());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Cliente actualizado correctamente: {0}", cliente.getIdCli());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar cliente", e);
            throw e;
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
            logger.log(Level.INFO, "Cliente eliminado correctamente: {0}", id);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar cliente", e);
            throw e;
        }
    }

    public Cliente buscarPorDni(int dni) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_DNI + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, dni);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearCliente(rs);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al buscar cliente por DNI: " + dni, e);
            throw e;
        }
        return null;
    }

    public List<Cliente> obtenerClientesPorFechaRegistro(LocalDate fechaInicio, LocalDate fechaFin) throws SQLException {
        if (fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin");
        }
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_REG_DATE + " BETWEEN ? AND ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(fechaInicio));
            stmt.setDate(2, Date.valueOf(fechaFin));
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    clientes.add(mapearCliente(rs));
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener clientes por rango de fechas", e);
            throw e;
        }
        return clientes;
    }

    private Cliente mapearCliente(ResultSet rs) throws SQLException {
        return new Cliente(
                rs.getString(COLUMN_ID),
                rs.getInt(COLUMN_DNI),
                rs.getString(COLUMN_NAME),
                rs.getString(COLUMN_LASTNAME),
                rs.getString(COLUMN_ADDRESS),
                rs.getInt(COLUMN_PHONE),
                rs.getDate(COLUMN_REG_DATE).toLocalDate(),
                rs.getString(COLUMN_NATION)
        );
    }
    
    
}
