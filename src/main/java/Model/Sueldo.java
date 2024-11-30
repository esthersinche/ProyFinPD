package Model;

import java.math.BigDecimal;

public class Sueldo {
    private String tipSueldo;
    private double cantSueldo;
    
    public Sueldo(String tipSueldo, double cantSueldo){
        this.tipSueldo = tipSueldo;
        this.cantSueldo = cantSueldo;
    }

    public String getTipSueldo() {
        return tipSueldo;
    }

    public void setTipSueldo(String tipSueldo) {
        this.tipSueldo = tipSueldo;
    }

    public double getCantSueldo() {
        return cantSueldo;
    }

    public void setCantSueldo(double cantSueldo) {
        this.cantSueldo = cantSueldo;
    }
}
