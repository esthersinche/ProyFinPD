package util;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConexion {
    public static void main(String[] args) {
        try {
            // Obtener una conexión del pool
            Connection conn = SQLConexion.getConexion();

            // Verificar si la conexión es válida
            if (conn != null && !conn.isClosed()) {
                System.out.println("Conexión establecida correctamente con HikariCP.");
                conn.close(); // Devolver la conexión al pool
                System.out.println("Conexión devuelta al pool correctamente.");
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (SQLException e) {
            System.out.println("Error al probar la conexión: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar el pool para liberar recursos al finalizar
            SQLConexion.cerrarPool();
        }
    }
}