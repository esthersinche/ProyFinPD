package DAO;

import Interface.ICrud_DAO;
import Model.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.SQLConexion;

public class LibroDAO implements ICrud_DAO<Libro> {

    @Override
    public void guardar(Libro libro) throws SQLException {
        String sql = "INSERT INTO LIBROS (ID_LIBRO, TITULO, PRECIO, ID_AUTOR, ID_EDITO, ID_GEN, ID_IDIOMA) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, libro.getIdLibro());
            stmt.setString(2, libro.getTitulo());
            stmt.setDouble(3, libro.getPrecio());
            stmt.setString(4, libro.getIdAutor());
            stmt.setString(5, libro.getIdEdito());
            stmt.setString(6, libro.getIdGen());
            stmt.setString(7, libro.getIdIdioma());
            stmt.executeUpdate();
        }
    }

    @Override
    public Libro obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM LIBROS WHERE ID_LIBRO = ?";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Libro(
                            rs.getString("ID_LIBRO"),
                            rs.getString("TITULO"),
                            rs.getDouble("PRECIO"),
                            rs.getString("ID_AUTOR"),
                            rs.getString("ID_EDITO"),
                            rs.getString("ID_GEN"),
                            rs.getString("ID_IDIOMA")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<Libro> obtenerTodos() throws SQLException {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM LIBROS";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                libros.add(new Libro(
                        rs.getString("ID_LIBRO"),
                        rs.getString("TITULO"),
                        rs.getDouble("PRECIO"),
                        rs.getString("ID_AUTOR"),
                        rs.getString("ID_EDITO"),
                        rs.getString("ID_GEN"),
                        rs.getString("ID_IDIOMA")
                ));
            }
        }
        return libros;
    }

    @Override
    public void actualizar(Libro libro) throws SQLException {
        String sql = "UPDATE LIBROS SET TITULO = ?, PRECIO = ?, ID_AUTOR = ?, ID_EDITO = ?, ID_GEN = ?, ID_IDIOMA = ? WHERE ID_LIBRO = ?";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, libro.getTitulo());
            stmt.setDouble(2, libro.getPrecio());
            stmt.setString(3, libro.getIdAutor());
            stmt.setString(4, libro.getIdEdito());
            stmt.setString(5, libro.getIdGen());
            stmt.setString(6, libro.getIdIdioma());
            stmt.setString(7, libro.getIdLibro());
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM LIBROS WHERE ID_LIBRO = ?";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }
}
