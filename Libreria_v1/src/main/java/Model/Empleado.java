package Model;

import java.time.LocalDate;

public class Empleado {
    private String idEmp;         
    private String nomEmp;        
    private String apeEmp;        
    private LocalDate fechaIng;   
    private String tipPuesto;     
    private String tipSueldo;     
    private String tipMod;        
    private String idNac; 

    public String getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(String idEmp) {
        this.idEmp = idEmp;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public String getApeEmp() {
        return apeEmp;
    }

    public void setApeEmp(String apeEmp) {
        this.apeEmp = apeEmp;
    }

    public LocalDate getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(LocalDate fechaIng) {
        this.fechaIng = fechaIng;
    }

    public String getTipPuesto() {
        return tipPuesto;
    }

    public void setTipPuesto(String tipPuesto) {
        this.tipPuesto = tipPuesto;
    }

    public String getTipSueldo() {
        return tipSueldo;
    }

    public void setTipSueldo(String tipSueldo) {
        this.tipSueldo = tipSueldo;
    }

    public String getTipMod() {
        return tipMod;
    }

    public void setTipMod(String tipMod) {
        this.tipMod = tipMod;
    }

    public String getIdNac() {
        return idNac;
    }

    public void setIdNac(String idNac) {
        this.idNac = idNac;
    }
}
