package DAO;

import Interface.ICrud_DAO;
import Model.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.SQLConexion;

public class AutorDAO implements ICrud_DAO<Autor> {
    @Override
    public void guardar(Autor autor) throws SQLException {
        String sql = "INSERT INTO AUTOR (ID_AUTOR, NOM_AUTOR, APE_AUTOR, ID_NAC) VALUES (?, ?, ?, ?)";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, autor.getIdAutor());
            stmt.setString(2, autor.getNomAutor());
            stmt.setString(3, autor.getApeAutor());
            stmt.setString(4, autor.getIdNac());
            stmt.executeUpdate();
        }
    }

    @Override
    public Autor obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM AUTOR WHERE ID_AUTOR = ?";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Autor(
                            rs.getString("ID_AUTOR"),
                            rs.getString("NOM_AUTOR"),
                            rs.getString("APE_AUTOR"),
                            rs.getString("ID_NAC")
                    );
                }
            }
        }
        return null;  // Si no se encuentra el autor, retornamos null.
    }

    @Override
    public List<Autor> obtenerTodos() throws SQLException {
        List<Autor> autores = new ArrayList<>();
        String sql = "SELECT * FROM AUTOR";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                autores.add(new Autor(
                        rs.getString("ID_AUTOR"),
                        rs.getString("NOM_AUTOR"),
                        rs.getString("APE_AUTOR"),
                        rs.getString("ID_NAC")
                ));
            }
        }
        return autores;
    }

    @Override
    public void actualizar(Autor autor) throws SQLException {
        String sql = "UPDATE AUTOR SET NOM_AUTOR = ?, APE_AUTOR = ?, ID_NAC = ? WHERE ID_AUTOR = ?";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, autor.getNomAutor());
            stmt.setString(2, autor.getApeAutor());
            stmt.setString(3, autor.getIdNac());
            stmt.setString(4, autor.getIdAutor());
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM AUTOR WHERE ID_AUTOR = ?";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }
}
