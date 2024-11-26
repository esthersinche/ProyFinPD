package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLConexion {

    private static SQLConexion instancia;
    private Connection conectar;

    private String usuario = "sa";
    private String contrasenia = "1234";
    private String bd = "BDLIBRERIA";
    private String ip = "localhost";
    private String puerto = "1433";
    private String cadena = "jdbc:sqlserver://" + ip + ":" + puerto + ";databaseName=" + bd + ";encrypt=true;trustServerCertificate=true";

    private static final Logger logger = Logger.getLogger(SQLConexion.class.getName());

    private SQLConexion() {
        try {
            conectar = DriverManager.getConnection(cadena, usuario, contrasenia);
            logger.log(Level.INFO, "Se conectó correctamente a la base de datos");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al conectar la base de datos", e);
        }
    }

    public static synchronized SQLConexion getInstancia() {
        if (instancia == null) {
            instancia = new SQLConexion();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conectar;
    }

    public void cerrarConexion() {
        if (conectar != null) {
            try {
                conectar.close();
                logger.log(Level.INFO, "Conexión cerrada correctamente.");
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error al cerrar la conexión", e);
            }
        }
    }
}
