package DAO;
import Model.DetVenta;
import Interface.ICrud_DAO;
import util.SQLConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetVentaDAO implements ICrud_DAO<DetVenta> {

    @Override
    public void guardar(DetVenta detVenta) throws SQLException {
        String sql = "INSERT INTO DETALLE_VENTAS (ID_DET_VENTA, ID_VENTA, ID_LIBRO, CANT_DET_VENTA, PRECIO_UNIT_DET_VENTA) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, detVenta.getIdDetVenta());
            stmt.setString(2, detVenta.getIdVenta());
            stmt.setString(3, detVenta.getIdLibro());
            stmt.setDouble(4, detVenta.getCantDetVenta());
            stmt.setDouble(5, detVenta.getPrecioUnitDetVenta());
            stmt.executeUpdate();
        }
    }

    @Override
    public DetVenta obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM DETALLE_VENTAS WHERE ID_DET_VENTA = ?";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new DetVenta(
                            rs.getString("ID_DET_VENTA"),
                            rs.getString("ID_VENTA"),
                            rs.getString("ID_LIBRO"),
                            rs.getDouble("CANT_DET_VENTA"),
                            rs.getDouble("PRECIO_UNIT_DET_VENTA")
                    );
                }
            }
        }
        return null; // Si no se encuentra el detalle de venta, retornamos null.
    }

    @Override
    public List<DetVenta> obtenerTodos() throws SQLException {
        List<DetVenta> detallesVenta = new ArrayList<>();
        String sql = "SELECT * FROM DETALLE_VENTAS";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                detallesVenta.add(new DetVenta(
                        rs.getString("ID_DET_VENTA"),
                        rs.getString("ID_VENTA"),
                        rs.getString("ID_LIBRO"),
                        rs.getDouble("CANT_DET_VENTA"),
                        rs.getDouble("PRECIO_UNIT_DET_VENTA")
                ));
            }
        }
        return detallesVenta;
    }

    @Override
    public void actualizar(DetVenta detVenta) throws SQLException {
        String sql = "UPDATE DETALLE_VENTAS SET ID_VENTA = ?, ID_LIBRO = ?, CANT_DET_VENTA = ?, PRECIO_UNIT_DET_VENTA = ? WHERE ID_DET_VENTA = ?";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, detVenta.getIdVenta());
            stmt.setString(2, detVenta.getIdLibro());
            stmt.setDouble(3, detVenta.getCantDetVenta());
            stmt.setDouble(4, detVenta.getPrecioUnitDetVenta());
            stmt.setString(5, detVenta.getIdDetVenta());
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM DETALLE_VENTAS WHERE ID_DET_VENTA = ?";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }
}
