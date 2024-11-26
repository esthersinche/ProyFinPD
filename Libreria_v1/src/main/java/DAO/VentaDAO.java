package DAO;

import Interface.ICrud_DAO;
import Model.Venta;
import Model.DetVenta;
import util.SQLConexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO implements ICrud_DAO<Venta> {

    @Override
    public void guardar(Venta venta) throws SQLException {
        String sqlVenta = "INSERT INTO VENTAS (ID_VENTA, FECHA_VENTA, ID_CLI, TOTAL_VENTA) VALUES (?, ?, ?, ?)";
        String sqlDetVenta = "INSERT INTO DETALLE_VENTA (ID_DET_VENTA, ID_VENTA, ID_LIBRO, CANT_DET_VENTA, PRECIO_UNIT_DET_VENTA) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = SQLConexion.getInstancia().getConexion()) {
            conn.setAutoCommit(false);

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
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }

    @Override
    public Venta obtenerPorId(String id) throws SQLException {
        String sqlVenta = "SELECT * FROM VENTAS WHERE ID_VENTA = ?";
        String sqlDetVenta = "SELECT * FROM DETALLE_VENTA WHERE ID_VENTA = ?";

        Venta venta = null;
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmtVenta = conn.prepareStatement(sqlVenta); PreparedStatement stmtDetVenta = conn.prepareStatement(sqlDetVenta)) {

            stmtVenta.setString(1, id);
            try (ResultSet rsVenta = stmtVenta.executeQuery()) {
                if (rsVenta.next()) {
                    venta = new Venta();
                    venta.setIdVenta(rsVenta.getString("ID_VENTA"));
                    venta.setFechaVenta(rsVenta.getDate("FECHA_VENTA").toLocalDate());
                    venta.setIdCli(rsVenta.getString("ID_CLI"));
                    venta.setTotalVenta(rsVenta.getDouble("TOTAL_VENTA"));
                }
            }

            if (venta != null) {
                List<DetVenta> detalles = new ArrayList<>();
                stmtDetVenta.setString(1, id);
                try (ResultSet rsDetVenta = stmtDetVenta.executeQuery()) {
                    while (rsDetVenta.next()) {
                        DetVenta detVenta = new DetVenta(
                                rsDetVenta.getString("ID_DET_VENTA"),
                                rsDetVenta.getString("ID_VENTA"),
                                rsDetVenta.getString("ID_LIBRO"),
                                rsDetVenta.getDouble("CANT_DET_VENTA"),
                                rsDetVenta.getDouble("PRECIO_UNIT_DET_VENTA")
                        );
                        detalles.add(detVenta);
                    }
                    venta.setDetalles(detalles);
                }
            }
            return venta;
        }
    }

    @Override
    public List<Venta> obtenerTodos() throws SQLException {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM VENTAS";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(rs.getString("ID_VENTA"));
                venta.setFechaVenta(rs.getDate("FECHA_VENTA").toLocalDate());
                venta.setIdCli(rs.getString("ID_CLI"));
                venta.setTotalVenta(rs.getDouble("TOTAL_VENTA"));
                ventas.add(venta);
            }
        }
        return ventas;
    }

    @Override
    public void actualizar(Venta venta) throws SQLException {
        String sqlVenta = "UPDATE VENTAS SET FECHA_VENTA = ?, ID_CLI = ?, TOTAL_VENTA = ? WHERE ID_VENTA = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmtVenta = conn.prepareStatement(sqlVenta)) {

            stmtVenta.setDate(1, Date.valueOf(venta.getFechaVenta()));
            stmtVenta.setString(2, venta.getIdCli());
            stmtVenta.setDouble(3, venta.getTotalVenta());
            stmtVenta.setString(4, venta.getIdVenta());
            stmtVenta.executeUpdate();
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sqlDetVenta = "DELETE FROM DETALLE_VENTA WHERE ID_VENTA = ?";
        String sqlVenta = "DELETE FROM VENTAS WHERE ID_VENTA = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmtDetVenta = conn.prepareStatement(sqlDetVenta); PreparedStatement stmtVenta = conn.prepareStatement(sqlVenta)) {

                stmtDetVenta.setString(1, id);
                stmtDetVenta.executeUpdate();

                stmtVenta.setString(1, id);
                stmtVenta.executeUpdate();

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }
    // Método adicional: obtener ventas por cliente

    public List<Venta> obtenerVentasPorCliente(String idCli) throws SQLException {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM VENTAS WHERE ID_CLI = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idCli);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Venta venta = new Venta();
                    venta.setIdVenta(rs.getString("ID_VENTA"));
                    venta.setFechaVenta(rs.getDate("FECHA_VENTA").toLocalDate());
                    venta.setIdCli(rs.getString("ID_CLI"));
                    venta.setTotalVenta(rs.getDouble("TOTAL_VENTA"));
                    ventas.add(venta);
                }
            }
        }
        return ventas;
    }
}
