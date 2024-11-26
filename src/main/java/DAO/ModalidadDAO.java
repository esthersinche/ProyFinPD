package DAO;

import Interface.ICrud_DAO;
import Model.Modalidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.SQLConexion;

public class ModalidadDAO implements ICrud_DAO<Modalidad> {

    @Override
    public void guardar(Modalidad modalidad) throws SQLException {
        String sql = "INSERT INTO MODALIDAD (TIP_MOD, MODALIDAD) VALUES (?, ?)";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, modalidad.getTipMod());
            stmt.setString(2, modalidad.getModalidad());

            stmt.executeUpdate();
        }
    }

    @Override
    public Modalidad obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM MODALIDAD WHERE TIP_MOD = ?";
        Modalidad modalidad = null;

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    modalidad = new Modalidad();
                    modalidad.setTipMod(rs.getString("TIP_MOD"));
                    modalidad.setModalidad(rs.getString("MODALIDAD"));
                }
            }
        }
        return modalidad;
    }

    @Override
    public List<Modalidad> obtenerTodos() throws SQLException {
        String sql = "SELECT * FROM MODALIDAD";
        List<Modalidad> modalidades = new ArrayList<>();

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Modalidad modalidad = new Modalidad();
                modalidad.setTipMod(rs.getString("TIP_MOD"));
                modalidad.setModalidad(rs.getString("MODALIDAD"));
                modalidades.add(modalidad);
            }
        }
        return modalidades;
    }

    @Override
    public void actualizar(Modalidad modalidad) throws SQLException {
        String sql = "UPDATE MODALIDAD SET MODALIDAD = ? WHERE TIP_MOD = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, modalidad.getModalidad());
            stmt.setString(2, modalidad.getTipMod());

            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM MODALIDAD WHERE TIP_MOD = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }
}
