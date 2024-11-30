package DAO;

import Interface.ICrud_DAO;
import Model.Usuario;
import util.SQLConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO implements ICrud_DAO<Usuario> {

    private static final Logger logger = Logger.getLogger(UsuarioDAO.class.getName());
    private static final String TABLE_NAME = "USUARIOS";
    private static final String COLUMN_ID_USUARIO = "ID_USUARIO";
    private static final String COLUMN_USUARIO = "USUARIO";
    private static final String COLUMN_CONTRASENA = "CONTRASEÑA";
    private static final String COLUMN_RANGO = "RANGO";
    private static final String COLUMN_ID_EMP = "ID_EMP";

    @Override
    public void guardar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_ID_USUARIO + ", " + COLUMN_USUARIO + ", "
                + COLUMN_CONTRASENA + ", " + COLUMN_RANGO + ", " + COLUMN_ID_EMP + ") VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getIdUsuario());
            stmt.setString(2, usuario.getUsuario());
            stmt.setString(3, usuario.getContrasena());
            stmt.setString(4, usuario.getRango());
            stmt.setString(5, usuario.getIdEmp());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Usuario guardado correctamente: {0}", usuario.getIdUsuario());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al guardar usuario", e);
            throw e;
        }
    }

    @Override
    public Usuario obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID_USUARIO + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearUsuario(rs);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener usuario por ID: " + id, e);
            throw e;
        }
        return null;
    }

    @Override
    public List<Usuario> obtenerTodos() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;

        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                usuarios.add(mapearUsuario(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener todos los usuarios", e);
            throw e;
        }
        return usuarios;
    }

    @Override
    public void actualizar(Usuario usuario) throws SQLException {
        String sql = "UPDATE " + TABLE_NAME + " SET " + COLUMN_USUARIO + " = ?, " + COLUMN_CONTRASENA + " = ?, "
                + COLUMN_RANGO + " = ?, " + COLUMN_ID_EMP + " = ? WHERE " + COLUMN_ID_USUARIO + " = ?";

        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getContrasena());
            stmt.setString(3, usuario.getRango());
            stmt.setString(4, usuario.getIdEmp());
            stmt.setString(5, usuario.getIdUsuario());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Usuario actualizado correctamente: {0}", usuario.getIdUsuario());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar usuario", e);
            throw e;
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID_USUARIO + " = ?";

        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
            logger.log(Level.INFO, "Usuario eliminado correctamente: {0}", id);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar usuario", e);
            throw e;
        }
    }

    // Método adicional para autenticación, no está en ICrud_DAO
    public Usuario buscarPorUsuario(String usuario) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_USUARIO + " = ?";

        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearUsuario(rs);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al buscar usuario por nombre", e);
            throw e;
        }
        return null;
    }

    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        return new Usuario(
                rs.getString(COLUMN_ID_USUARIO),
                rs.getString(COLUMN_USUARIO),
                rs.getString(COLUMN_CONTRASENA),
                rs.getString(COLUMN_RANGO),
                rs.getString(COLUMN_ID_EMP)
        );
    }
}
