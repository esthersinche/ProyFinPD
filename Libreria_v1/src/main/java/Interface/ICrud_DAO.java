package Interface;

import java.sql.SQLException;
import java.util.List;

public interface ICrud_DAO<T> {

    void guardar(T t) throws SQLException;

    T obtenerPorId(String id) throws SQLException;

    List<T> obtenerTodos() throws SQLException;

    void actualizar(T t) throws SQLException;

    void eliminar(String id) throws SQLException;
}
