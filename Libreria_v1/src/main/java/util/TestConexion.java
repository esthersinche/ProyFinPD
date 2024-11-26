package util;
import java.sql.Connection;

public class TestConexion {
    public static void main(String[] args) {
        // Obtener la instancia de SQLConexion
        SQLConexion conexion = SQLConexion.getInstancia();
        
        // Intentar obtener la conexión
        Connection conn = conexion.getConexion();
        
        // Verificar si la conexión fue exitosa
        if (conn != null) {
            System.out.println("Conexión establecida correctamente.");
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }

        // Cerrar la conexión
        conexion.cerrarConexion();
    }
}