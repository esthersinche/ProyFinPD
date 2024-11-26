package Model;

import java.math.BigDecimal;

public class DetVenta {
    private String idDetVenta;
    private String idVenta;
    private String idLibro;
    private double cantDetVenta;
    private double precioUnitDetVenta;
    
    public DetVenta(String idDetVenta, String idVenta, String idLibro, double cantDetVenta, double precioUnitDetVenta){
        this.idDetVenta = idDetVenta;
        this.idVenta = idVenta;
        this.idLibro = idLibro;
        this.cantDetVenta = cantDetVenta;
        this.precioUnitDetVenta = precioUnitDetVenta;
    }

    public String getIdDetVenta() {
        return idDetVenta;
    }

    public void setIdDetVenta(String idDetVenta) {
        this.idDetVenta = idDetVenta;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public double getCantDetVenta() {
        return cantDetVenta;
    }

    public void setCantDetVenta(double cantDetVenta) {
        this.cantDetVenta = cantDetVenta;
    }

    public double getPrecioUnitDetVenta() {
        return precioUnitDetVenta;
    }

    public void setPrecioUnitDetVenta(double precioUnitDetVenta) {
        this.precioUnitDetVenta = precioUnitDetVenta;
    }
}
