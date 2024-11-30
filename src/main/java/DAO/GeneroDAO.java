package DAO;

import Interface.ICrud_DAO;
import Model.Genero;
import util.SQLConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneroDAO implements ICrud_DAO<Genero> {

    private static final Logger logger = Logger.getLogger(GeneroDAO.class.getName());
    private static final String TABLE_NAME = "GENERO";
    private static final String COLUMN_ID = "ID_GEN";
    private static final String COLUMN_NAME = "GENERO";

    @Override
    public void guardar(Genero genero) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_ID + ", " + COLUMN_NAME + ") VALUES (?, ?)";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, genero.getIdGen());
            stmt.setString(2, genero.getGenero());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Género guardado correctamente: {0}", genero.getIdGen());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al guardar género", e);
            throw e;
        }
    }

    @Override
    public Genero obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearGenero(rs);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener género por ID: " + id, e);
            throw e;
        }
        logger.log(Level.WARNING, "No se encontró género con ID: {0}", id);
        return null;
    }

    @Override
    public List<Genero> obtenerTodos() throws SQLException {
        List<Genero> generos = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                generos.add(mapearGenero(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener todos los géneros", e);
            throw e;
        }
        return generos;
    }

    @Override
    public void actualizar(Genero genero) throws SQLException {
        String sql = "UPDATE " + TABLE_NAME + " SET " + COLUMN_NAME + " = ? WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, genero.getGenero());
            stmt.setString(2, genero.getIdGen());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Género actualizado correctamente: {0}", genero.getIdGen());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar género", e);
            throw e;
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
            logger.log(Level.INFO, "Género eliminado correctamente: {0}", id);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar género", e);
            throw e;
        }
    }

    private Genero mapearGenero(ResultSet rs) throws SQLException {
        return new Genero(
                rs.getString(COLUMN_ID),
                rs.getString(COLUMN_NAME)
        );
    }
}
