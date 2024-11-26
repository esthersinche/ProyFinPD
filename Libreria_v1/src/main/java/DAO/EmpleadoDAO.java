package DAO;

import Interface.ICrud_DAO;
import Model.Empleado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.SQLConexion;

public class EmpleadoDAO implements ICrud_DAO<Empleado> {

    @Override
    public void guardar(Empleado empleado) throws SQLException {
        String sql = "INSERT INTO EMPLEADO (ID_EMP, NOM_EMP, APE_EMP, FECHA_ING, TIP_PUESTO, TIP_SUELDO, TIP_MOD, ID_NAC) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, empleado.getIdEmp());
            stmt.setString(2, empleado.getNomEmp());
            stmt.setString(3, empleado.getApeEmp());
            stmt.setDate(4, Date.valueOf(empleado.getFechaIng()));
            stmt.setString(5, empleado.getTipPuesto());
            stmt.setString(6, empleado.getTipSueldo());
            stmt.setString(7, empleado.getTipMod());
            stmt.setString(8, empleado.getIdNac());

            stmt.executeUpdate();
        }
    }

    @Override
    public Empleado obtenerPorId(String id) throws SQLException {
        String sql = "SELECT * FROM EMPLEADO WHERE ID_EMP = ?";
        Empleado empleado = null;

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    empleado = new Empleado();
                    empleado.setIdEmp(rs.getString("ID_EMP"));
                    empleado.setNomEmp(rs.getString("NOM_EMP"));
                    empleado.setApeEmp(rs.getString("APE_EMP"));
                    empleado.setFechaIng(rs.getDate("FECHA_ING").toLocalDate());
                    empleado.setTipPuesto(rs.getString("TIP_PUESTO"));
                    empleado.setTipSueldo(rs.getString("TIP_SUELDO"));
                    empleado.setTipMod(rs.getString("TIP_MOD"));
                    empleado.setIdNac(rs.getString("ID_NAC"));
                }
            }
        }
        return empleado;
    }

    @Override
    public List<Empleado> obtenerTodos() throws SQLException {
        String sql = "SELECT * FROM EMPLEADO";
        List<Empleado> empleados = new ArrayList<>();

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmp(rs.getString("ID_EMP"));
                empleado.setNomEmp(rs.getString("NOM_EMP"));
                empleado.setApeEmp(rs.getString("APE_EMP"));
                empleado.setFechaIng(rs.getDate("FECHA_ING").toLocalDate());
                empleado.setTipPuesto(rs.getString("TIP_PUESTO"));
                empleado.setTipSueldo(rs.getString("TIP_SUELDO"));
                empleado.setTipMod(rs.getString("TIP_MOD"));
                empleado.setIdNac(rs.getString("ID_NAC"));
                empleados.add(empleado);
            }
        }
        return empleados;
    }

    @Override
    public void actualizar(Empleado empleado) throws SQLException {
        String sql = "UPDATE EMPLEADO SET NOM_EMP = ?, APE_EMP = ?, FECHA_ING = ?, TIP_PUESTO = ?, TIP_SUELDO = ?, "
                + "TIP_MOD = ?, ID_NAC = ? WHERE ID_EMP = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, empleado.getNomEmp());
            stmt.setString(2, empleado.getApeEmp());
            stmt.setDate(3, Date.valueOf(empleado.getFechaIng()));
            stmt.setString(4, empleado.getTipPuesto());
            stmt.setString(5, empleado.getTipSueldo());
            stmt.setString(6, empleado.getTipMod());
            stmt.setString(7, empleado.getIdNac());
            stmt.setString(8, empleado.getIdEmp());

            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(String id) throws SQLException {
        String sql = "DELETE FROM EMPLEADO WHERE ID_EMP = ?";

        try (Connection conn = SQLConexion.getInstancia().getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }
}
