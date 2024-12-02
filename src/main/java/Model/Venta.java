package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venta {

    private String idVenta;
    private LocalDate fechaVenta;
    private String idCli;
    private double totalVenta;
    private List<DetVenta> detalles;

    public Venta() {
        this.detalles = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID Venta: ").append(idVenta).append("\n");
        sb.append("Fecha: ").append(fechaVenta).append("\n");
        sb.append("Cliente: ").append(idCli).append("\n");
        sb.append("Total: ").append(totalVenta).append("\n");
        sb.append("Detalles:\n");
        for (DetVenta det : detalles) {
            sb.append("\t").append(det.toString()).append("\n");
        }
        return sb.toString();
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdCli() {
        return idCli;
    }

    public void setIdCli(String idCli) {
        this.idCli = idCli;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public List<DetVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetVenta> detalles) {
        this.detalles = detalles;
    }
}
