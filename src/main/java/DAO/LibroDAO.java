package DAO;

import Interface.ICrud_DAO;
import Model.Libro;
import util.SQLConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibroDAO implements ICrud_DAO<Libro> {

    private static final Logger logger = Logger.getLogger(LibroDAO.class.getName());
    private static final String TABLE_NAME = "LIBROS";
    private static final String COLUMN_ID_LIBRO = "ID_LIBRO";
    private static final String COLUMN_TITULO = "TITULO";
    private static final String COLUMN_PRECIO = "PRECIO";
    private static final String COLUMN_ID_AUTOR = "ID_AUTOR";
    private static final String COLUMN_ID_EDITO = "ID_EDITO";
    private static final String COLUMN_ID_GEN = "ID_GEN";
    private static final String COLUMN_ID_IDIOMA = "ID_IDIOMA";

    @Override
    public void guardar(Libro libro) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_ID_LIBRO + ", " + COLUMN_TITULO + ", " + COLUMN_PRECIO + ", " + COLUMN_ID_AUTOR + ", " + COLUMN_ID_EDITO + ", " + COLUMN_ID_GEN + ", " + COLUMN_ID_IDIOMA + ") VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, libro.getIdLibro());
            stmt.setString(2, libro.getTitulo());
            stmt.setDouble(3, libro.getPrecio());
            stmt.setString(4, libro.getIdAutor());
            stmt.setString(5, libro.getIdEdito());
            stmt.setString(6, libro.getIdGen());
            stmt.setString(7, libro.getIdIdioma());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Libro guardado correctamente: {0}", libro.getIdLibro());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al guardar libro", e);
            throw e;
        }
    }

    @Override
    public Libro obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID_LIBRO + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearLibro(rs);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener libro por ID: " + id, e);
            throw e;
        }
        logger.log(Level.WARNING, "No se encontró libro con ID: {0}", id);
        return null;
    }

    @Override
    public List<Libro> obtenerTodos() throws SQLException {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                libros.add(mapearLibro(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener todos los libros", e);
            throw e;
        }
        return libros;
    }

    @Override
    public void actualizar(Libro libro) throws SQLException {
        String sql = "UPDATE " + TABLE_NAME + " SET " + COLUMN_TITULO + " = ?, " + COLUMN_PRECIO + " = ?, " + COLUMN_ID_AUTOR + " = ?, " + COLUMN_ID_EDITO + " = ?, " + COLUMN_ID_GEN + " = ?, " + COLUMN_ID_IDIOMA + " = ? WHERE " + COLUMN_ID_LIBRO + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, libro.getTitulo());
            stmt.setDouble(2, libro.getPrecio());
            stmt.setString(3, libro.getIdAutor());
            stmt.setString(4, libro.getIdEdito());
            stmt.setString(5, libro.getIdGen());
            stmt.setString(6, libro.getIdIdioma());
            stmt.setString(7, libro.getIdLibro());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Libro actualizado correctamente: {0}", libro.getIdLibro());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar libro", e);
            throw e;
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID_LIBRO + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
            logger.log(Level.INFO, "Libro eliminado correctamente: {0}", id);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar libro", e);
            throw e;
        }
    }

    private Libro mapearLibro(ResultSet rs) throws SQLException {
        return new Libro(
                rs.getString(COLUMN_ID_LIBRO),
                rs.getString(COLUMN_TITULO),
                rs.getDouble(COLUMN_PRECIO),
                rs.getString(COLUMN_ID_AUTOR),
                rs.getString(COLUMN_ID_EDITO),
                rs.getString(COLUMN_ID_GEN),
                rs.getString(COLUMN_ID_IDIOMA)
        );
    }
}
