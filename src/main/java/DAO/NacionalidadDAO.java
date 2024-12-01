package DAO;

import Interface.ICrud_DAO;
import Model.Nacionalidad;
import util.SQLConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NacionalidadDAO implements ICrud_DAO<Nacionalidad> {

    private static final Logger logger = Logger.getLogger(NacionalidadDAO.class.getName());
    private static final String TABLE_NAME = "NACIONALIDAD";
    private static final String COLUMN_ID_NAC = "ID_NAC";
    private static final String COLUMN_NACION = "NACION";

    @Override
    public void guardar(Nacionalidad nacionalidad) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_ID_NAC + ", " + COLUMN_NACION + ") VALUES (?, ?)";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nacionalidad.getIdNac());
            stmt.setString(2, nacionalidad.getNacion());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Nacionalidad guardada correctamente: {0}", nacionalidad.getIdNac());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al guardar nacionalidad", e);
            throw e;
        }
    }

    @Override
    public Nacionalidad obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID_NAC + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearNacionalidad(rs);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener nacionalidad por ID: " + id, e);
            throw e;
        }
        logger.log(Level.WARNING, "No se encontró nacionalidad con ID: {0}", id);
        return null;
    }

    @Override
    public List<Nacionalidad> obtenerTodos() throws SQLException {
        List<Nacionalidad> nacionalidades = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                nacionalidades.add(mapearNacionalidad(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener todas las nacionalidades", e);
            throw e;
        }
        return nacionalidades;
    }

    @Override
    public void actualizar(Nacionalidad nacionalidad) throws SQLException {
        String sql = "UPDATE " + TABLE_NAME + " SET " + COLUMN_NACION + " = ? WHERE " + COLUMN_ID_NAC + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nacionalidad.getNacion());
            stmt.setString(2, nacionalidad.getIdNac());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Nacionalidad actualizada correctamente: {0}", nacionalidad.getIdNac());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar nacionalidad", e);
            throw e;
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID_NAC + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
            logger.log(Level.INFO, "Nacionalidad eliminada correctamente: {0}", id);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar nacionalidad", e);
            throw e;
        }
    }

    private Nacionalidad mapearNacionalidad(ResultSet rs) throws SQLException {
        return new Nacionalidad(
                rs.getString(COLUMN_ID_NAC),
                rs.getString(COLUMN_NACION)
        );
    }

    public String obtenerIdNacionalidadPorNombre(String nacionalidad) throws SQLException {
        String sql = "SELECT ID_NAC FROM " + TABLE_NAME + " WHERE "+ COLUMN_NACION + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nacionalidad);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString(COLUMN_ID_NAC);  
                } else {
                    throw new SQLException("Nacionalidad no encontrada.");
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener idNac", e);
            throw e;
        }
    }

}
