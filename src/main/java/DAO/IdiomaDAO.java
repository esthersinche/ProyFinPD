package DAO;

import Interface.ICrud_DAO;
import Model.Idioma;
import util.SQLConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IdiomaDAO implements ICrud_DAO<Idioma> {

    private static final Logger logger = Logger.getLogger(IdiomaDAO.class.getName());
    private static final String TABLE_NAME = "IDIOMA";
    private static final String COLUMN_ID = "ID_IDIOMA";
    private static final String COLUMN_NAME = "IDIOMA";

    @Override
    public void guardar(Idioma idioma) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_ID + ", " + COLUMN_NAME + ") VALUES (?, ?)";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idioma.getIdIdioma());
            stmt.setString(2, idioma.getIdioma());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Idioma guardado correctamente: {0}", idioma.getIdIdioma());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al guardar idioma", e);
            throw e;
        }
    }

    @Override
    public Idioma obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearIdioma(rs);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener idioma por ID: " + id, e);
            throw e;
        }
        logger.log(Level.WARNING, "No se encontró idioma con ID: {0}", id);
        return null;
    }

    @Override
    public List<Idioma> obtenerTodos() throws SQLException {
        List<Idioma> idiomas = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                idiomas.add(mapearIdioma(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener todos los idiomas", e);
            throw e;
        }
        return idiomas;
    }

    @Override
    public void actualizar(Idioma idioma) throws SQLException {
        String sql = "UPDATE " + TABLE_NAME + " SET " + COLUMN_NAME + " = ? WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idioma.getIdioma());
            stmt.setString(2, idioma.getIdIdioma());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Idioma actualizado correctamente: {0}", idioma.getIdIdioma());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar idioma", e);
            throw e;
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
            logger.log(Level.INFO, "Idioma eliminado correctamente: {0}", id);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar idioma", e);
            throw e;
        }
    }

    private Idioma mapearIdioma(ResultSet rs) throws SQLException {
        return new Idioma(
                rs.getString(COLUMN_ID),
                rs.getString(COLUMN_NAME)
        );
    }
}
