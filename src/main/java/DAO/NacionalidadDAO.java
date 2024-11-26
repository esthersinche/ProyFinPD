package DAO;

import Interface.ICrud_DAO;
import Model.Nacionalidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.SQLConexion;

public class NacionalidadDAO implements ICrud_DAO<Nacionalidad> {

    @Override
    public void guardar(Nacionalidad nacionalidad) throws SQLException {
        String sql = "INSERT INTO NACIONALIDAD (ID_NAC, NACION) VALUES (?, ?)";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nacionalidad.getIdNac());
            stmt.setString(2, nacionalidad.getNacion());

            stmt.executeUpdate();
        }
    }

    @Override
    public Nacionalidad obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM NACIONALIDAD WHERE ID_NAC = ?";
        Nacionalidad nacionalidad = null;

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    nacionalidad = new Nacionalidad();
                    nacionalidad.setIdNac(rs.getString("ID_NAC"));
                    nacionalidad.setNacion(rs.getString("NACION"));
                }
            }
        }
        return nacionalidad;
    }

    @Override
    public List<Nacionalidad> obtenerTodos() throws SQLException {
        String sql = "SELECT * FROM NACIONALIDAD";
        List<Nacionalidad> nacionalidades = new ArrayList<>();

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Nacionalidad nacionalidad = new Nacionalidad();
                nacionalidad.setIdNac(rs.getString("ID_NAC"));
                nacionalidad.setNacion(rs.getString("NACION"));
                nacionalidades.add(nacionalidad);
            }
        }
        return nacionalidades;
    }

    @Override
    public void actualizar(Nacionalidad nacionalidad) throws SQLException {
        String sql = "UPDATE NACIONALIDAD SET NACION = ? WHERE ID_NAC = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nacionalidad.getNacion());
            stmt.setString(2, nacionalidad.getIdNac());

            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM NACIONALIDAD WHERE ID_NAC = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }
}
