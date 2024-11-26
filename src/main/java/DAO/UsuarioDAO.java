package DAO;

import Interface.ICrud_DAO;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.SQLConexion;

public class UsuarioDAO implements ICrud_DAO<Usuario> {

    @Override
    public void guardar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO USUARIOS (ID_USUARIO, USUARIO, CONTRASEÑA, RANGO, ID_EMP) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getIdUsuario());
            stmt.setString(2, usuario.getUsuario());
            stmt.setString(3, usuario.getContrasena());
            stmt.setString(4, usuario.getRango());
            stmt.setString(5, usuario.getIdEmp());
            stmt.executeUpdate();
        }
    }

    @Override
    public Usuario obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM USUARIOS WHERE ID_USUARIO = ?";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getString("ID_USUARIO"),
                            rs.getString("USUARIO"),
                            rs.getString("CONTRASEÑA"),
                            rs.getString("RANGO"),
                            rs.getString("ID_EMP")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<Usuario> obtenerTodos() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIOS";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getString("ID_USUARIO"),
                        rs.getString("USUARIO"),
                        rs.getString("CONTRASEÑA"),
                        rs.getString("RANGO"),
                        rs.getString("ID_EMP")
                );
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    @Override
    public void actualizar(Usuario usuario) throws SQLException {
        String sql = "UPDATE USUARIOS SET USUARIO = ?, CONTRASEÑA = ?, RANGO = ?, ID_EMP = ? WHERE ID_USUARIO = ?";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getContrasena());
            stmt.setString(3, usuario.getRango());
            stmt.setString(4, usuario.getIdEmp());
            stmt.setString(5, usuario.getIdUsuario());
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM USUARIOS WHERE ID_USUARIO = ?";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }

    // Método adicional para autenticación, no está en ICrud_DAO
    public Usuario buscarPorUsuario(String usuario) throws SQLException {
        String sql = "SELECT * FROM USUARIOS WHERE USUARIO = ?";
        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getString("ID_USUARIO"),
                            rs.getString("USUARIO"),
                            rs.getString("CONTRASEÑA"),
                            rs.getString("RANGO"),
                            rs.getString("ID_EMP")
                    );
                }
            }
        }
        return null;
    }
}
