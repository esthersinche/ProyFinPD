package Controler;
import DAO.InventarioDAO;
import DAO.LibroDAO;
import Model.Inventario;
import Model.Libro;
import java.sql.SQLException;
import java.util.List;

public class CInventario {

    private final LibroDAO libroDAO;
    private final InventarioDAO inventarioDAO;

    public CInventario() {
        this.libroDAO = new LibroDAO();
        this.inventarioDAO = new InventarioDAO();
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
        Inventario inventario = inventarioDAO.obtenerPorId(idLibro); // Usamos el DAO de Inventario para obtener el stock
        return inventario != null ? inventario.getStock() : 0; // Si el inventario existe, retornamos el stock, si no, retornamos 0
    }

    public List<Libro> obtenerLibrosConStock() throws SQLException {
        List<Libro> todosLibros = libroDAO.obtenerTodos();
        todosLibros.removeIf(libro -> libro.getPrecio() <= 0); // Filtrando libros sin stock.
        return todosLibros;
    }
}
