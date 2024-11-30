package DAO;

import Interface.ICrud_DAO;
import Model.Inventario;
import util.SQLConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InventarioDAO implements ICrud_DAO<Inventario> {

    private static final Logger logger = Logger.getLogger(InventarioDAO.class.getName());
    private static final String TABLE_NAME = "INVENTARIO";
    private static final String COLUMN_ID_LIBRO = "ID_LIBRO";
    private static final String COLUMN_ID_GEN = "ID_GEN";
    private static final String COLUMN_ID_IDIOMA = "ID_IDIOMA";
    private static final String COLUMN_ID_EDITO = "ID_EDITO";
    private static final String COLUMN_STOCK = "STOCK";

    @Override
    public void guardar(Inventario inventario) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_ID_LIBRO + ", " + COLUMN_ID_GEN + ", " + COLUMN_ID_IDIOMA + ", " + COLUMN_ID_EDITO + ", " + COLUMN_STOCK + ") VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, inventario.getIdLibro());
            stmt.setString(2, inventario.getIdGen());
            stmt.setString(3, inventario.getIdIdioma());
            stmt.setString(4, inventario.getIdEdito());
            stmt.setInt(5, inventario.getStock());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Inventario guardado correctamente: {0}", inventario.getIdLibro());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al guardar inventario", e);
            throw e;
        }
    }

    @Override
    public Inventario obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID_LIBRO + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearInventario(rs);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener inventario por ID: " + id, e);
            throw e;
        }
        logger.log(Level.WARNING, "No se encontró inventario con ID: {0}", id);
        return null;
    }

    @Override
    public List<Inventario> obtenerTodos() throws SQLException {
        List<Inventario> inventarios = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                inventarios.add(mapearInventario(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener todos los inventarios", e);
            throw e;
        }
        return inventarios;
    }

    @Override
    public void actualizar(Inventario inventario) throws SQLException {
        String sql = "UPDATE " + TABLE_NAME + " SET " + COLUMN_ID_GEN + " = ?, " + COLUMN_ID_IDIOMA + " = ?, " + COLUMN_ID_EDITO + " = ?, " + COLUMN_STOCK + " = ? WHERE " + COLUMN_ID_LIBRO + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, inventario.getIdGen());
            stmt.setString(2, inventario.getIdIdioma());
            stmt.setString(3, inventario.getIdEdito());
            stmt.setInt(4, inventario.getStock());
            stmt.setString(5, inventario.getIdLibro());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Inventario actualizado correctamente: {0}", inventario.getIdLibro());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar inventario", e);
            throw e;
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID_LIBRO + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
            logger.log(Level.INFO, "Inventario eliminado correctamente: {0}", id);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar inventario", e);
            throw e;
        }
    }

    private Inventario mapearInventario(ResultSet rs) throws SQLException {
        return new Inventario(
                rs.getString(COLUMN_ID_LIBRO),
                rs.getString(COLUMN_ID_GEN),
                rs.getString(COLUMN_ID_IDIOMA),
                rs.getString(COLUMN_ID_EDITO),
                rs.getInt(COLUMN_STOCK)
        );
    }
}
