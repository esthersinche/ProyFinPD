package DAO;

import Interface.ICrud_DAO;
import Model.Venta;
import Model.DetVenta;
import util.SQLConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentaDAO implements ICrud_DAO<Venta> {

    private static final Logger logger = Logger.getLogger(VentaDAO.class.getName());
    private static final String TABLE_VENTAS = "VENTAS";
    private static final String TABLE_DET_VENTA = "DETALLE_VENTAS";
    private static final String COLUMN_ID_VENTA = "ID_VENTA";
    private static final String COLUMN_FECHA_VENTA = "FECHA_VENTA";
    private static final String COLUMN_ID_CLI = "ID_CLI";
    private static final String COLUMN_TOTAL_VENTA = "TOTAL_VENTA";
    private static final String COLUMN_ID_DET_VENTA = "ID_DET_VENTA";
    private static final String COLUMN_ID_LIBRO = "ID_LIBRO";
    private static final String COLUMN_CANT_DET_VENTA = "CANT_DET_VENTA";
    private static final String COLUMN_PRECIO_UNIT_DET_VENTA = "PRECIO_UNIT_DET_VENTA";

    @Override
    public void guardar(Venta venta) throws SQLException {
        String sqlVenta = "INSERT INTO " + TABLE_VENTAS + " (" + COLUMN_ID_VENTA + ", " + COLUMN_FECHA_VENTA + ", " + COLUMN_ID_CLI + ", " + COLUMN_TOTAL_VENTA + ") VALUES (?, ?, ?, ?)";
        String sqlDetVenta = "INSERT INTO " + TABLE_DET_VENTA + " (" + COLUMN_ID_DET_VENTA + ", " + COLUMN_ID_VENTA + ", " + COLUMN_ID_LIBRO + ", " + COLUMN_CANT_DET_VENTA + ", " + COLUMN_PRECIO_UNIT_DET_VENTA + ") VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = SQLConexion.getConexion()) {
            conn.setAutoCommit(false);
            
            String idVentaGenerado = UUID.randomUUID().toString().substring(0, 5);  // Generando un ID único

            // Asignar el ID_VENTA a la venta
            venta.setIdVenta(idVentaGenerado);

            try (PreparedStatement stmtVenta = conn.prepareStatement(sqlVenta); PreparedStatement stmtDetVenta = conn.prepareStatement(sqlDetVenta)) {

                // Insertar Venta
                stmtVenta.setString(1, venta.getIdVenta());
                stmtVenta.setDate(2, Date.valueOf(venta.getFechaVenta()));
                stmtVenta.setString(3, venta.getIdCli());
                stmtVenta.setDouble(4, venta.getTotalVenta());
                stmtVenta.executeUpdate();

                // Insertar Detalles de Venta
                for (DetVenta detVenta : venta.getDetalles()) {
                    stmtDetVenta.setString(1, detVenta.getIdDetVenta());
                    stmtDetVenta.setString(2, detVenta.getIdVenta());
                    stmtDetVenta.setString(3, detVenta.getIdLibro());
                    stmtDetVenta.setDouble(4, detVenta.getCantDetVenta());
                    stmtDetVenta.setDouble(5, detVenta.getPrecioUnitDetVenta());
                    stmtDetVenta.executeUpdate();
                }

                conn.commit();
                logger.log(Level.INFO, "Venta y detalles guardados correctamente: {0}", venta.getIdVenta());
            } catch (SQLException e) {
                conn.rollback();
                logger.log(Level.SEVERE, "Error al guardar la venta", e);
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }

    @Override
    public Venta obtenerPorId(String id) throws SQLException {
        String sqlVenta = "SELECT * FROM " + TABLE_VENTAS + " WHERE " + COLUMN_ID_VENTA + " = ?";
        String sqlDetVenta = "SELECT * FROM " + TABLE_DET_VENTA + " WHERE " + COLUMN_ID_VENTA + " = ?";

        Venta venta = null;
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmtVenta = conn.prepareStatement(sqlVenta); PreparedStatement stmtDetVenta = conn.prepareStatement(sqlDetVenta)) {

            stmtVenta.setString(1, id);
            try (ResultSet rsVenta = stmtVenta.executeQuery()) {
                if (rsVenta.next()) {
                    venta = new Venta();
                    venta.setIdVenta(rsVenta.getString(COLUMN_ID_VENTA));
                    venta.setFechaVenta(rsVenta.getDate(COLUMN_FECHA_VENTA).toLocalDate());
                    venta.setIdCli(rsVenta.getString(COLUMN_ID_CLI));
                    venta.setTotalVenta(rsVenta.getDouble(COLUMN_TOTAL_VENTA));
                }
            }

            if (venta != null) {
                List<DetVenta> detalles = new ArrayList<>();
                stmtDetVenta.setString(1, id);
                try (ResultSet rsDetVenta = stmtDetVenta.executeQuery()) {
                    while (rsDetVenta.next()) {
                        DetVenta detVenta = new DetVenta(
                                rsDetVenta.getString(COLUMN_ID_DET_VENTA),
                                rsDetVenta.getString(COLUMN_ID_VENTA),
                                rsDetVenta.getString(COLUMN_ID_LIBRO),
                                rsDetVenta.getDouble(COLUMN_CANT_DET_VENTA),
                                rsDetVenta.getDouble(COLUMN_PRECIO_UNIT_DET_VENTA)
                        );
                        detalles.add(detVenta);
                    }
                    venta.setDetalles(detalles);
                }
            }
            logger.log(Level.INFO, "Venta obtenida correctamente: {0}", id);
            return venta;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener la venta por ID: " + id, e);
            throw e;
        }
    }

    @Override
    public List<Venta> obtenerTodos() throws SQLException {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_VENTAS;

        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(rs.getString(COLUMN_ID_VENTA));
                venta.setFechaVenta(rs.getDate(COLUMN_FECHA_VENTA).toLocalDate());
                venta.setIdCli(rs.getString(COLUMN_ID_CLI));
                venta.setTotalVenta(rs.getDouble(COLUMN_TOTAL_VENTA));
                ventas.add(venta);
            }
            logger.log(Level.INFO, "Ventas obtenidas correctamente");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener todas las ventas", e);
            throw e;
        }
        return ventas;
    }

    @Override
    public void actualizar(Venta venta) throws SQLException {
        String sqlVenta = "UPDATE " + TABLE_VENTAS + " SET " + COLUMN_FECHA_VENTA + " = ?, " + COLUMN_ID_CLI + " = ?, " + COLUMN_TOTAL_VENTA + " = ? WHERE " + COLUMN_ID_VENTA + " = ?";

        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmtVenta = conn.prepareStatement(sqlVenta)) {

            stmtVenta.setDate(1, Date.valueOf(venta.getFechaVenta()));
            stmtVenta.setString(2, venta.getIdCli());
            stmtVenta.setDouble(3, venta.getTotalVenta());
            stmtVenta.setString(4, venta.getIdVenta());
            stmtVenta.executeUpdate();
            logger.log(Level.INFO, "Venta actualizada correctamente: {0}", venta.getIdVenta());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar la venta", e);
            throw e;
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sqlDetVenta = "DELETE FROM " + TABLE_DET_VENTA + " WHERE " + COLUMN_ID_VENTA + " = ?";
        String sqlVenta = "DELETE FROM " + TABLE_VENTAS + " WHERE " + COLUMN_ID_VENTA + " = ?";

        try (Connection conn = SQLConexion.getConexion()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmtDetVenta = conn.prepareStatement(sqlDetVenta); PreparedStatement stmtVenta = conn.prepareStatement(sqlVenta)) {

                stmtDetVenta.setString(1, id);
                stmtDetVenta.executeUpdate();

                stmtVenta.setString(1, id);
                stmtVenta.executeUpdate();

                conn.commit();
                logger.log(Level.INFO, "Venta y detalles eliminados correctamente: {0}", id);
            } catch (SQLException e) {
                conn.rollback();
                logger.log(Level.SEVERE, "Error al eliminar la venta", e);
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }

    // Método adicional: obtener ventas por cliente
    public List<Venta> obtenerVentasPorCliente(String idCli) throws SQLException {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_VENTAS + " WHERE " + COLUMN_ID_CLI + " = ?";

        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idCli);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Venta venta = new Venta();
                    venta.setIdVenta(rs.getString(COLUMN_ID_VENTA));
                    venta.setFechaVenta(rs.getDate(COLUMN_FECHA_VENTA).toLocalDate());
                    venta.setIdCli(rs.getString(COLUMN_ID_CLI));
                    venta.setTotalVenta(rs.getDouble(COLUMN_TOTAL_VENTA));
                    ventas.add(venta);
                }
            }
            logger.log(Level.INFO, "Ventas obtenidas para el cliente: {0}", idCli);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener ventas por cliente", e);
            throw e;
        }
        return ventas;
    }
}
