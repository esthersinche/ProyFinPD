package Controler;
import DAO.LibroDAO;
import Model.Libro;
import java.sql.SQLException;
import java.util.List;

public class CInventario {

    private final LibroDAO libroDAO;

    public CInventario() {
        this.libroDAO = new LibroDAO();
    }

    public void actualizarStock(String idLibro, int cantidad) throws SQLException {
        Libro libro = libroDAO.obtenerPorId(idLibro);
        if (libro != null) {
            double nuevoStock = libro.getPrecio() + cantidad;
            libro.setPrecio(nuevoStock);
            libroDAO.actualizar(libro);
        }
    }

    public int consultarStock(String idLibro) throws SQLException {
        Libro libro = libroDAO.obtenerPorId(idLibro);
        return libro != null ? (int) libro.getPrecio() : 0; // Asumiendo que el precio representa el stock.
    }

    public List<Libro> obtenerLibrosConStock() throws SQLException {
        List<Libro> todosLibros = libroDAO.obtenerTodos();
        todosLibros.removeIf(libro -> libro.getPrecio() <= 0); // Filtrando libros sin stock.
        return todosLibros;
    }
}
