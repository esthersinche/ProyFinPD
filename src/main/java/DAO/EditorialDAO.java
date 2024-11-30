package DAO;

import Interface.ICrud_DAO;
import Model.Editorial;
import util.SQLConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditorialDAO implements ICrud_DAO<Editorial> {

    private static final Logger logger = Logger.getLogger(EditorialDAO.class.getName());
    private static final String TABLE_NAME = "EDITORIAL";
    private static final String COLUMN_ID = "ID_EDITO";
    private static final String COLUMN_NAME = "NOM_EDITO";
    private static final String COLUMN_ADDRESS = "DIREC_EDITO";
    private static final String COLUMN_PHONE = "CEL_EDITO";

    @Override
    public void guardar(Editorial editorial) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_ID + ", " + COLUMN_NAME + ", " +
                COLUMN_ADDRESS + ", " + COLUMN_PHONE + ") VALUES (?, ?, ?, ?)";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, editorial.getIdEdito());
            stmt.setString(2, editorial.getNomEdito());
            stmt.setString(3, editorial.getDirecEdito());
            stmt.setInt(4, editorial.getCelEdito());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Editorial guardada correctamente: {0}", editorial.getIdEdito());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al guardar editorial", e);
            throw e;
        }
    }

    @Override
    public Editorial obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearEditorial(rs);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener editorial por ID: " + id, e);
            throw e;
        }
        logger.log(Level.WARNING, "No se encontró editorial con ID: {0}", id);
        return null;
    }

    @Override
    public List<Editorial> obtenerTodos() throws SQLException {
        List<Editorial> editoriales = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                editoriales.add(mapearEditorial(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener todas las editoriales", e);
            throw e;
        }
        return editoriales;
    }

    @Override
    public void actualizar(Editorial editorial) throws SQLException {
        String sql = "UPDATE " + TABLE_NAME + " SET " + COLUMN_NAME + " = ?, " + COLUMN_ADDRESS + " = ?, " +
                COLUMN_PHONE + " = ? WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, editorial.getNomEdito());
            stmt.setString(2, editorial.getDirecEdito());
            stmt.setInt(3, editorial.getCelEdito());
            stmt.setString(4, editorial.getIdEdito());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Editorial actualizada correctamente: {0}", editorial.getIdEdito());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar editorial", e);
            throw e;
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
            logger.log(Level.INFO, "Editorial eliminada correctamente: {0}", id);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar editorial", e);
            throw e;
        }
    }

    private Editorial mapearEditorial(ResultSet rs) throws SQLException {
        return new Editorial(
            rs.getString(COLUMN_ID),
            rs.getString(COLUMN_NAME),
            rs.getString(COLUMN_ADDRESS),
            rs.getInt(COLUMN_PHONE)
        );
    }
}