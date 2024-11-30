package DAO;

import Interface.ICrud_DAO;
import Model.Empleado;
import util.SQLConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpleadoDAO implements ICrud_DAO<Empleado> {

    private static final Logger logger = Logger.getLogger(EmpleadoDAO.class.getName());
    private static final String TABLE_NAME = "EMPLEADO";
    private static final String COLUMN_ID = "ID_EMP";
    private static final String COLUMN_NAME = "NOM_EMP";
    private static final String COLUMN_LAST_NAME = "APE_EMP";
    private static final String COLUMN_DATE_JOINED = "FECHA_ING";
    private static final String COLUMN_POSITION = "TIP_PUESTO";
    private static final String COLUMN_SALARY = "TIP_SUELDO";
    private static final String COLUMN_MOD_TYPE = "TIP_MOD";
    private static final String COLUMN_NATIONAL_ID = "ID_NAC";

    @Override
    public void guardar(Empleado empleado) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_ID + ", " + COLUMN_NAME + ", " +
                COLUMN_LAST_NAME + ", " + COLUMN_DATE_JOINED + ", " + COLUMN_POSITION + ", " + COLUMN_SALARY + ", " +
                COLUMN_MOD_TYPE + ", " + COLUMN_NATIONAL_ID + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, empleado.getIdEmp());
            stmt.setString(2, empleado.getNomEmp());
            stmt.setString(3, empleado.getApeEmp());
            stmt.setDate(4, Date.valueOf(empleado.getFechaIng()));
            stmt.setString(5, empleado.getTipPuesto());
            stmt.setString(6, empleado.getTipSueldo());
            stmt.setString(7, empleado.getTipMod());
            stmt.setString(8, empleado.getIdNac());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Empleado guardado correctamente: {0}", empleado.getIdEmp());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al guardar empleado", e);
            throw e;
        }
    }

    @Override
    public Empleado obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearEmpleado(rs);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener empleado por ID: " + id, e);
            throw e;
        }
        logger.log(Level.WARNING, "No se encontró empleado con ID: {0}", id);
        return null;
    }

    @Override
    public List<Empleado> obtenerTodos() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                empleados.add(mapearEmpleado(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener todos los empleados", e);
            throw e;
        }
        return empleados;
    }

    @Override
    public void actualizar(Empleado empleado) throws SQLException {
        String sql = "UPDATE " + TABLE_NAME + " SET " + COLUMN_NAME + " = ?, " + COLUMN_LAST_NAME + " = ?, " +
                COLUMN_DATE_JOINED + " = ?, " + COLUMN_POSITION + " = ?, " + COLUMN_SALARY + " = ?, " + COLUMN_MOD_TYPE + " = ?, " +
                COLUMN_NATIONAL_ID + " = ? WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, empleado.getNomEmp());
            stmt.setString(2, empleado.getApeEmp());
            stmt.setDate(3, Date.valueOf(empleado.getFechaIng()));
            stmt.setString(4, empleado.getTipPuesto());
            stmt.setString(5, empleado.getTipSueldo());
            stmt.setString(6, empleado.getTipMod());
            stmt.setString(7, empleado.getIdNac());
            stmt.setString(8, empleado.getIdEmp());
            stmt.executeUpdate();
            logger.log(Level.INFO, "Empleado actualizado correctamente: {0}", empleado.getIdEmp());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar empleado", e);
            throw e;
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
        try (Connection conn = SQLConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
            logger.log(Level.INFO, "Empleado eliminado correctamente: {0}", id);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar empleado", e);
            throw e;
        }
    }

    private Empleado mapearEmpleado(ResultSet rs) throws SQLException {
        return new Empleado(
            rs.getString(COLUMN_ID),
            rs.getString(COLUMN_NAME),
            rs.getString(COLUMN_LAST_NAME),
            rs.getDate(COLUMN_DATE_JOINED).toLocalDate(),
            rs.getString(COLUMN_POSITION),
            rs.getString(COLUMN_SALARY),
            rs.getString(COLUMN_MOD_TYPE),
            rs.getString(COLUMN_NATIONAL_ID)
        );
    }
}
