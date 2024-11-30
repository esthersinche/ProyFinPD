package DAO;

import Interface.ICrud_DAO;
import Model.Puesto;
import util.SQLConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PuestoDAO implements ICrud_DAO<Puesto> {

    private static final Logger logger = Logger.getLogger(PuestoDAO.class.getName());
    private static final String TABLE_NAME = "PUESTO";
    private static final String COLUMN_TIP_PUESTO = "TIP_PUESTO";
    private static final String COLUMN_PUESTO = "PUESTO";

    @Override
    public void guardar(Puesto puesto) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_TIP_PUESTO + ", " + COLUMN_PUESTO + ") VALUES (?, ?)";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puesto.getTipPuesto());
            stmt.setString(2, puesto.getPuesto());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Puesto guardado correctamente: {0}", puesto.getTipPuesto());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al guardar puesto", e);
            throw e;
        }
    }

    @Override
    public Puesto obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_TIP_PUESTO + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearPuesto(rs);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener puesto por ID: " + id, e);
            throw e;
        }
        logger.log(Level.WARNING, "No se encontró puesto con ID: {0}", id);
        return null;
    }

    @Override
    public List<Puesto> obtenerTodos() throws SQLException {
        List<Puesto> puestos = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                puestos.add(mapearPuesto(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener todos los puestos", e);
            throw e;
        }
        return puestos;
    }

    @Override
    public void actualizar(Puesto puesto) throws SQLException {
        String sql = "UPDATE " + TABLE_NAME + " SET " + COLUMN_PUESTO + " = ? WHERE " + COLUMN_TIP_PUESTO + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puesto.getPuesto());
            stmt.setString(2, puesto.getTipPuesto());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Puesto actualizado correctamente: {0}", puesto.getTipPuesto());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar puesto", e);
            throw e;
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_TIP_PUESTO + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
            logger.log(Level.INFO, "Puesto eliminado correctamente: {0}", id);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar puesto", e);
            throw e;
        }
    }

    private Puesto mapearPuesto(ResultSet rs) throws SQLException {
        return new Puesto(
                rs.getString(COLUMN_TIP_PUESTO),
                rs.getString(COLUMN_PUESTO)
        );
    }
}
