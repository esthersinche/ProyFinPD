package Model;

import java.time.LocalDate;
import java.util.List;

public class Venta {

    
    private String idVenta;
    private LocalDate fechaVenta;
    private String idCli;
    private double totalVenta;
    private List<DetVenta> detalles;
    
    public Venta(){
    
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
