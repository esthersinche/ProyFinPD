package DAO;

import Interface.ICrud_DAO;
import Model.Inventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.SQLConexion;

public class InventarioDAO implements ICrud_DAO<Inventario> {

    @Override
    public void guardar(Inventario inventario) throws SQLException {
        String sql = "INSERT INTO INVENTARIO (ID_LIBRO, ID_GEN, ID_IDIOMA, ID_EDITO, STOCK) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, inventario.getIdLibro());
            stmt.setString(2, inventario.getIdGen());
            stmt.setString(3, inventario.getIdIdioma());
            stmt.setString(4, inventario.getIdEdito());
            stmt.setInt(5, inventario.getStock());

            stmt.executeUpdate();
        }
    }

    @Override
    public Inventario obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM INVENTARIO WHERE ID_LIBRO = ?";
        Inventario inventario = null;

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    inventario = new Inventario();
                    inventario.setIdLibro(rs.getString("ID_LIBRO"));
                    inventario.setIdGen(rs.getString("ID_GEN"));
                    inventario.setIdIdioma(rs.getString("ID_IDIOMA"));
                    inventario.setIdEdito(rs.getString("ID_EDITO"));
                    inventario.setStock(rs.getInt("STOCK"));
                }
            }
        }
        return inventario;
    }

    @Override
    public List<Inventario> obtenerTodos() throws SQLException {
        String sql = "SELECT * FROM INVENTARIO";
        List<Inventario> inventarios = new ArrayList<>();

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Inventario inventario = new Inventario();
                inventario.setIdLibro(rs.getString("ID_LIBRO"));
                inventario.setIdGen(rs.getString("ID_GEN"));
                inventario.setIdIdioma(rs.getString("ID_IDIOMA"));
                inventario.setIdEdito(rs.getString("ID_EDITO"));
                inventario.setStock(rs.getInt("STOCK"));
                inventarios.add(inventario);
            }
        }
        return inventarios;
    }

    @Override
    public void actualizar(Inventario inventario) throws SQLException {
        String sql = "UPDATE INVENTARIO SET ID_GEN = ?, ID_IDIOMA = ?, ID_EDITO = ?, STOCK = ? WHERE ID_LIBRO = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, inventario.getIdGen());
            stmt.setString(2, inventario.getIdIdioma());
            stmt.setString(3, inventario.getIdEdito());
            stmt.setInt(4, inventario.getStock());
            stmt.setString(5, inventario.getIdLibro());

            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM INVENTARIO WHERE ID_LIBRO = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }
}
