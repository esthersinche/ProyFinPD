package DAO;

import Interface.ICrud_DAO;
import Model.Modalidad;
import util.SQLConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModalidadDAO implements ICrud_DAO<Modalidad> {

    private static final Logger logger = Logger.getLogger(ModalidadDAO.class.getName());
    private static final String TABLE_NAME = "MODALIDAD";
    private static final String COLUMN_TIP_MOD = "TIP_MOD";
    private static final String COLUMN_MODALIDAD = "MODALIDAD";

    @Override
    public void guardar(Modalidad modalidad) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_TIP_MOD + ", " + COLUMN_MODALIDAD + ") VALUES (?, ?)";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, modalidad.getTipMod());
            stmt.setString(2, modalidad.getModalidad());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Modalidad guardada correctamente: {0}", modalidad.getTipMod());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al guardar modalidad", e);
            throw e;
        }
    }

    @Override
    public Modalidad obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_TIP_MOD + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearModalidad(rs);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener modalidad por ID: " + id, e);
            throw e;
        }
        logger.log(Level.WARNING, "No se encontró modalidad con ID: {0}", id);
        return null;
    }

    @Override
    public List<Modalidad> obtenerTodos() throws SQLException {
        List<Modalidad> modalidades = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                modalidades.add(mapearModalidad(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener todas las modalidades", e);
            throw e;
        }
        return modalidades;
    }

    @Override
    public void actualizar(Modalidad modalidad) throws SQLException {
        String sql = "UPDATE " + TABLE_NAME + " SET " + COLUMN_MODALIDAD + " = ? WHERE " + COLUMN_TIP_MOD + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, modalidad.getModalidad());
            stmt.setString(2, modalidad.getTipMod());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Modalidad actualizada correctamente: {0}", modalidad.getTipMod());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar modalidad", e);
            throw e;
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_TIP_MOD + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
            logger.log(Level.INFO, "Modalidad eliminada correctamente: {0}", id);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar modalidad", e);
            throw e;
        }
    }

    private Modalidad mapearModalidad(ResultSet rs) throws SQLException {
        return new Modalidad(
                rs.getString(COLUMN_TIP_MOD),
                rs.getString(COLUMN_MODALIDAD)
        );
    }
}
