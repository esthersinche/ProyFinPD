package Controler;

import DAO.UsuarioDAO;
import Model.Usuario;
import java.sql.SQLException;

public class CUsuario {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public Usuario autenticarUsuario(String usuario, String contrasena) throws SQLException {
        Usuario usuarioEncontrado = usuarioDAO.buscarPorUsuario(usuario);
        if (usuarioEncontrado != null && usuarioEncontrado.getContrasena().equals(contrasena)) {
            return usuarioEncontrado; // Credenciales válidas
        }
        return null; // Credenciales inválidas
    }

    public void registrarUsuario(Usuario usuario) throws SQLException {
        usuarioDAO.guardar(usuario);
    }

    public Usuario obtenerUsuarioPorId(String id) throws SQLException {
        return usuarioDAO.obtenerPorId(id);
    }

    public void actualizarUsuario(Usuario usuario) throws SQLException {
        usuarioDAO.actualizar(usuario);
    }

    public void eliminarUsuario(String id) throws SQLException {
        usuarioDAO.eliminar(id);
    }
}
