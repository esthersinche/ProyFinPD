package DAO;

import Interface.ICrud_DAO;
import Model.Editorial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.SQLConexion;

public class EditorialDAO implements ICrud_DAO<Editorial> {

    @Override
    public void guardar(Editorial editorial) throws SQLException {
        String sql = "INSERT INTO EDITORIAL (ID_EDITO, NOM_EDITO, DIREC_EDITO, CEL_EDITO) VALUES (?, ?, ?, ?)";

        try (Connection conn = SQLConexion.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, editorial.getIdEdito());
            stmt.setString(2, editorial.getNomEdito());
            stmt.setString(3, editorial.getDirecEdito());
            stmt.setInt(4, editorial.getCelEdito());

            stmt.executeUpdate();
        }
    }

    @Override
    public Editorial obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM EDITORIAL WHERE ID_EDITO = ?";
        Editorial editorial = null;

        try (Connection conn = SQLConexion.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    editorial = new Editorial();
                    editorial.setIdEdito(rs.getString("ID_EDITO"));
                    editorial.setNomEdito(rs.getString("NOM_EDITO"));
                    editorial.setDirecEdito(rs.getString("DIREC_EDITO"));
                    editorial.setCelEdito(rs.getInt("CEL_EDITO"));
                }
            }
        }
        return editorial;
    }

    @Override
    public List<Editorial> obtenerTodos() throws SQLException {
        String sql = "SELECT * FROM EDITORIAL";
        List<Editorial> editoriales = new ArrayList<>();

        try (Connection conn = SQLConexion.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Editorial editorial = new Editorial();
                editorial.setIdEdito(rs.getString("ID_EDITO"));
                editorial.setNomEdito(rs.getString("NOM_EDITO"));
                editorial.setDirecEdito(rs.getString("DIREC_EDITO"));
                editorial.setCelEdito(rs.getInt("CEL_EDITO"));
                editoriales.add(editorial);
            }
        }
        return editoriales;
    }

    @Override
    public void actualizar(Editorial editorial) throws SQLException {
        String sql = "UPDATE EDITORIAL SET NOM_EDITO = ?, DIREC_EDITO = ?, CEL_EDITO = ? WHERE ID_EDITO = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, editorial.getNomEdito());
            stmt.setString(2, editorial.getDirecEdito());
            stmt.setInt(3, editorial.getCelEdito());
            stmt.setString(4, editorial.getIdEdito());

            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM EDITORIAL WHERE ID_EDITO = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }
}