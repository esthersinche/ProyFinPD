package DAO;

import Interface.ICrud_DAO;
import Model.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.SQLConexion;

public class GeneroDAO implements ICrud_DAO<Genero> {

    @Override
    public void guardar(Genero genero) throws SQLException {
        String sql = "INSERT INTO GENERO (ID_GEN, GENERO) VALUES (?, ?)";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, genero.getIdGen());
            stmt.setString(2, genero.getGenero());

            stmt.executeUpdate();
        }
    }

    @Override
    public Genero obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM GENERO WHERE ID_GEN = ?";
        Genero genero = null;

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    genero = new Genero();
                    genero.setIdGen(rs.getString("ID_GEN"));
                    genero.setGenero(rs.getString("GENERO"));
                }
            }
        }
        return genero;
    }

    @Override
    public List<Genero> obtenerTodos() throws SQLException {
        String sql = "SELECT * FROM GENERO";
        List<Genero> generos = new ArrayList<>();

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Genero genero = new Genero();
                genero.setIdGen(rs.getString("ID_GEN"));
                genero.setGenero(rs.getString("GENERO"));
                generos.add(genero);
            }
        }
        return generos;
    }

    @Override
    public void actualizar(Genero genero) throws SQLException {
        String sql = "UPDATE GENERO SET GENERO = ? WHERE ID_GEN = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, genero.getGenero());
            stmt.setString(2, genero.getIdGen());

            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM GENERO WHERE ID_GEN = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }
}
