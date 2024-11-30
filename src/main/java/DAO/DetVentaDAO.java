package DAO;

import Interface.ICrud_DAO;
import Model.DetVenta;
import util.SQLConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetVentaDAO implements ICrud_DAO<DetVenta> {

    private static final Logger logger = Logger.getLogger(DetVentaDAO.class.getName());
    private static final String TABLE_NAME = "DETALLE_VENTAS";
    private static final String COLUMN_ID = "ID_DET_VENTA";
    private static final String COLUMN_SALE_ID = "ID_VENTA";
    private static final String COLUMN_BOOK_ID = "ID_LIBRO";
    private static final String COLUMN_QUANTITY = "CANT_DET_VENTA";
    private static final String COLUMN_UNIT_PRICE = "PRECIO_UNIT_DET_VENTA";

    @Override
    public void guardar(DetVenta detVenta) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_ID + ", " + COLUMN_SALE_ID + ", " + COLUMN_BOOK_ID + ", "
                + COLUMN_QUANTITY + ", " + COLUMN_UNIT_PRICE + ") VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, detVenta.getIdDetVenta());
            stmt.setString(2, detVenta.getIdVenta());
            stmt.setString(3, detVenta.getIdLibro());
            stmt.setDouble(4, detVenta.getCantDetVenta());
            stmt.setDouble(5, detVenta.getPrecioUnitDetVenta());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Detalle de venta guardado correctamente: {0}", detVenta.getIdDetVenta());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al guardar detalle de venta", e);
            throw e;
        }
    }

    @Override
    public DetVenta obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearDetVenta(rs);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener detalle de venta por ID: " + id, e);
            throw e;
        }
        logger.log(Level.WARNING, "No se encontró detalle de venta con ID: {0}", id);
        return null;
    }

    @Override
    public List<DetVenta> obtenerTodos() throws SQLException {
        List<DetVenta> detallesVenta = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                detallesVenta.add(mapearDetVenta(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener todos los detalles de venta", e);
            throw e;
        }
        return detallesVenta;
    }

    @Override
    public void actualizar(DetVenta detVenta) throws SQLException {
        String sql = "UPDATE " + TABLE_NAME + " SET " + COLUMN_SALE_ID + " = ?, " + COLUMN_BOOK_ID + " = ?, "
                + COLUMN_QUANTITY + " = ?, " + COLUMN_UNIT_PRICE + " = ? WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, detVenta.getIdVenta());
            stmt.setString(2, detVenta.getIdLibro());
            stmt.setDouble(3, detVenta.getCantDetVenta());
            stmt.setDouble(4, detVenta.getPrecioUnitDetVenta());
            stmt.setString(5, detVenta.getIdDetVenta());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Detalle de venta actualizado correctamente: {0}", detVenta.getIdDetVenta());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar detalle de venta", e);
            throw e;
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
            logger.log(Level.INFO, "Detalle de venta eliminado correctamente: {0}", id);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar detalle de venta", e);
            throw e;
        }
    }

    // Método privado para mapear el ResultSet a un objeto DetVenta
    private DetVenta mapearDetVenta(ResultSet rs) throws SQLException {
        return new DetVenta(
                rs.getString(COLUMN_ID),
                rs.getString(COLUMN_SALE_ID),
                rs.getString(COLUMN_BOOK_ID),
                rs.getDouble(COLUMN_QUANTITY),
                rs.getDouble(COLUMN_UNIT_PRICE)
        );
    }
}
