package DAO;

import Interface.ICrud_DAO;
import Model.Puesto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.SQLConexion;

public class PuestoDAO implements ICrud_DAO<Puesto> {

    @Override
    public void guardar(Puesto puesto) throws SQLException {
        String sql = "INSERT INTO PUESTO (TIP_PUESTO, PUESTO) VALUES (?, ?)";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, puesto.getTipPuesto());
            stmt.setString(2, puesto.getPuesto());

            stmt.executeUpdate();
        }
    }

    @Override
    public Puesto obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM PUESTO WHERE TIP_PUESTO = ?";
        Puesto puesto = null;

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    puesto = new Puesto();
                    puesto.setTipPuesto(rs.getString("TIP_PUESTO"));
                    puesto.setPuesto(rs.getString("PUESTO"));
                }
            }
        }
        return puesto;
    }

    @Override
    public List<Puesto> obtenerTodos() throws SQLException {
        String sql = "SELECT * FROM PUESTO";
        List<Puesto> puestos = new ArrayList<>();

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Puesto puesto = new Puesto();
                puesto.setTipPuesto(rs.getString("TIP_PUESTO"));
                puesto.setPuesto(rs.getString("PUESTO"));
                puestos.add(puesto);
            }
        }
        return puestos;
    }

    @Override
    public void actualizar(Puesto puesto) throws SQLException {
        String sql = "UPDATE PUESTO SET PUESTO = ? WHERE TIP_PUESTO = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, puesto.getPuesto());
            stmt.setString(2, puesto.getTipPuesto());

            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM PUESTO WHERE TIP_PUESTO = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }
}
