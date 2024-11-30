package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLConexion {

    private static final Logger logger = Logger.getLogger(SQLConexion.class.getName());
    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    static {
        try {
            // Configuración de la conexión
            config.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=BDLIBRERIA;encrypt=true;trustServerCertificate=true");
            config.setUsername("sa"); // Usuario de la base de datos
            config.setPassword("1234"); // Contraseña de la base de datos

            // Configuración del pool
            config.setMaximumPoolSize(10); // Máximo de conexiones activas
            config.setMinimumIdle(2); // Conexiones mínimas en espera
            config.setIdleTimeout(30000); // Tiempo de espera para conexiones inactivas (30 segundos)
            config.setConnectionTimeout(30000); // Tiempo para obtener una conexión (30 segundos)
            config.setLeakDetectionThreshold(20000); // Detecta posibles fugas de conexiones (20 segundos)

            // Inicializar el pool
            ds = new HikariDataSource(config);

            logger.log(Level.INFO, "HikariCP pool configurado correctamente.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al configurar HikariCP", e);
            throw new RuntimeException("Error al inicializar la conexión con la base de datos.", e);
        }
    }

    private SQLConexion() {
        // Constructor privado para evitar instanciación
    }

    // Obtener una conexión del pool
    public static Connection getConexion() throws SQLException {
        return ds.getConnection();
    }

    // Cerrar el pool al finalizar la aplicación
    public static void cerrarPool() {
        if (ds != null) {
            ds.close();
            logger.log(Level.INFO, "HikariCP pool cerrado.");
        }
    }
}
