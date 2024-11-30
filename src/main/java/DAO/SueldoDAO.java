package DAO;

import Interface.ICrud_DAO;
import Model.Sueldo;
import util.SQLConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SueldoDAO implements ICrud_DAO<Sueldo> {

    private static final Logger logger = Logger.getLogger(SueldoDAO.class.getName());
    private static final String TABLE_NAME = "SUELOS";
    private static final String COLUMN_TIP_SUELDO = "TIP_SUELDO";
    private static final String COLUMN_CANT_SUELDO = "CANT_SUELDO";

    @Override
    public void guardar(Sueldo sueldo) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_TIP_SUELDO + ", " + COLUMN_CANT_SUELDO + ") VALUES (?, ?)";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, sueldo.getTipSueldo());
            stmt.setDouble(2, sueldo.getCantSueldo());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Sueldo guardado correctamente: {0}", sueldo.getTipSueldo());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al guardar sueldo", e);
            throw e;
        }
    }

    @Override
    public Sueldo obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_TIP_SUELDO + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearSueldo(rs);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener sueldo por ID: " + id, e);
            throw e;
        }
        logger.log(Level.WARNING, "No se encontró sueldo con ID: {0}", id);
        return null;
    }

    @Override
    public List<Sueldo> obtenerTodos() throws SQLException {
        List<Sueldo> sueldos = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                sueldos.add(mapearSueldo(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener todos los sueldos", e);
            throw e;
        }
        return sueldos;
    }

    @Override
    public void actualizar(Sueldo sueldo) throws SQLException {
        String sql = "UPDATE " + TABLE_NAME + " SET " + COLUMN_CANT_SUELDO + " = ? WHERE " + COLUMN_TIP_SUELDO + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, sueldo.getCantSueldo());
            stmt.setString(2, sueldo.getTipSueldo());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Sueldo actualizado correctamente: {0}", sueldo.getTipSueldo());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar sueldo", e);
            throw e;
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_TIP_SUELDO + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
            logger.log(Level.INFO, "Sueldo eliminado correctamente: {0}", id);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar sueldo", e);
            throw e;
        }
    }

    private Sueldo mapearSueldo(ResultSet rs) throws SQLException {
        return new Sueldo(
                rs.getString(COLUMN_TIP_SUELDO),
                rs.getDouble(COLUMN_CANT_SUELDO)
        );
    }
}
