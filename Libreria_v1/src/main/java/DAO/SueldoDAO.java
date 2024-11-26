package DAO;

import Interface.ICrud_DAO;
import Model.Sueldo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.SQLConexion;

public class SueldoDAO implements ICrud_DAO<Sueldo> {

    @Override
    public void guardar(Sueldo sueldo) throws SQLException {
        String sql = "INSERT INTO SUELDOS (TIP_SUELDO, CANT_SUELDO) VALUES (?, ?)";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sueldo.getTipSueldo());
            stmt.setDouble(2, sueldo.getCantSueldo());

            stmt.executeUpdate();
        }
    }

    @Override
    public Sueldo obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM SUELDOS WHERE TIP_SUELDO = ?";
        Sueldo sueldo = null;

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    sueldo = new Sueldo();
                    sueldo.setTipSueldo(rs.getString("TIP_SUELDO"));
                    sueldo.setCantSueldo(rs.getDouble("CANT_SUELDO"));
                }
            }
        }
        return sueldo;
    }

    @Override
    public List<Sueldo> obtenerTodos() throws SQLException {
        String sql = "SELECT * FROM SUELDOS";
        List<Sueldo> sueldos = new ArrayList<>();

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Sueldo sueldo = new Sueldo();
                sueldo.setTipSueldo(rs.getString("TIP_SUELDO"));
                sueldo.setCantSueldo(rs.getDouble("CANT_SUELDO"));
                sueldos.add(sueldo);
            }
        }
        return sueldos;
    }

    @Override
    public void actualizar(Sueldo sueldo) throws SQLException {
        String sql = "UPDATE SUELDOS SET CANT_SUELDO = ? WHERE TIP_SUELDO = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, sueldo.getCantSueldo());
            stmt.setString(2, sueldo.getTipSueldo());

            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM SUELDOS WHERE TIP_SUELDO = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }
}
