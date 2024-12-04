package DAO;

import Interface.ICrud_DAO;
import Model.Autor;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import util.SQLConexion;

public class AutorDAO implements ICrud_DAO<Autor> {

    private static final Logger logger = Logger.getLogger(AutorDAO.class.getName());
    private static final String TABLE_NAME = "AUTOR";
    private static final String COLUMN_ID = "ID_AUTOR";
    private static final String COLUMN_NAME = "NOM_AUTOR";
    private static final String COLUMN_LASTNAME = "APE_AUTOR";
    private static final String COLUMN_NATION = "ID_NAC";

    @Override
    public void guardar(Autor autor) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_ID + ", " + COLUMN_NAME + ", " + COLUMN_LASTNAME + ", " + COLUMN_NATION + ") VALUES (?, ?, ?, ?)";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, autor.getIdAutor());
            stmt.setString(2, autor.getNomAutor());
            stmt.setString(3, autor.getApeAutor());
            stmt.setString(4, autor.getIdNac());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Autor guardado correctamente: {0}", autor.getIdAutor());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al guardar autor", e);
            throw e;
        }
    }

    @Override
    public Autor obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Autor(
                            rs.getString(COLUMN_ID),
                            rs.getString(COLUMN_NAME),
                            rs.getString(COLUMN_LASTNAME),
                            rs.getString(COLUMN_NATION)
                    );
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener autor por ID: " + id, e);
            throw e;
        }
        logger.log(Level.WARNING, "No se encontró autor con ID: {0}", id);
        return null;
    }

    @Override
    public List<Autor> obtenerTodos() throws SQLException {
        List<Autor> autores = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                autores.add(new Autor(
                        rs.getString(COLUMN_ID),
                        rs.getString(COLUMN_NAME),
                        rs.getString(COLUMN_LASTNAME),
                        rs.getString(COLUMN_NATION)
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener todos los autores", e);
            throw e;
        }
        return autores;
    }

    @Override
    public void actualizar(Autor autor) throws SQLException {
        String sql = "UPDATE " + TABLE_NAME + " SET " + COLUMN_NAME + " = ?, " + COLUMN_LASTNAME + " = ?, " + COLUMN_NATION + " = ? WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, autor.getNomAutor());
            stmt.setString(2, autor.getApeAutor());
            stmt.setString(3, autor.getIdNac());
            stmt.setString(4, autor.getIdAutor());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Autor actualizado correctamente: {0}", autor.getIdAutor());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar autor", e);
            throw e;
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
            logger.log(Level.INFO, "Autor eliminado correctamente: {0}", id);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar autor", e);
            throw e;
        }
    }
}
