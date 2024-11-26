package DAO;

import Interface.ICrud_DAO;
import Model.Idioma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.SQLConexion;

public class IdiomaDAO implements ICrud_DAO<Idioma> {

    @Override
    public void guardar(Idioma idioma) throws SQLException {
        String sql = "INSERT INTO IDIOMAS (ID_IDIOMA, IDIOMA) VALUES (?, ?)";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idioma.getIdIdioma());
            stmt.setString(2, idioma.getIdioma());

            stmt.executeUpdate();
        }
    }

    @Override
    public Idioma obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM IDIOMAS WHERE ID_IDIOMA = ?";
        Idioma idioma = null;

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    idioma = new Idioma();
                    idioma.setIdIdioma(rs.getString("ID_IDIOMA"));
                    idioma.setIdioma(rs.getString("IDIOMA"));
                }
            }
        }
        return idioma;
    }

    @Override
    public List<Idioma> obtenerTodos() throws SQLException {
        String sql = "SELECT * FROM IDIOMAS";
        List<Idioma> idiomas = new ArrayList<>();

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Idioma idioma = new Idioma();
                idioma.setIdIdioma(rs.getString("ID_IDIOMA"));
                idioma.setIdioma(rs.getString("IDIOMA"));
                idiomas.add(idioma);
            }
        }
        return idiomas;
    }

    @Override
    public void actualizar(Idioma idioma) throws SQLException {
        String sql = "UPDATE IDIOMAS SET IDIOMA = ? WHERE ID_IDIOMA = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idioma.getIdioma());
            stmt.setString(2, idioma.getIdIdioma());

            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM IDIOMAS WHERE ID_IDIOMA = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }
}
