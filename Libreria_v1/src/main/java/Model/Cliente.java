package Model;

import java.time.LocalDate;

public class Cliente {

    private String idCli;
    private int dniCli;
    private String nomCli;
    private String apeCli;
    private String direcCli;
    private int celCli;
    private LocalDate fechaReg;
    private String idNac;

    public Cliente(String idCli, int dniCli, String nomCli, String apeCli, String direcCli, int celCli, LocalDate fechaReg, String idNac) {
        this.idCli = idCli;
        this.dniCli = dniCli;
        this.nomCli = nomCli;
        this.apeCli = apeCli;
        this.direcCli = direcCli;
        this.celCli = celCli;
        this.fechaReg = fechaReg;
        this.idNac = idNac;
    }

    public String getIdCli() {
        return idCli;
    }

    public void setIdCli(String idCli) {
        this.idCli = idCli;
    }

    public String getNomCli() {
        return nomCli;
    }

    public void setNomCli(String nomCli) {
        this.nomCli = nomCli;
    }

    public String getApeCli() {
        return apeCli;
    }

    public void setApeCli(String apeCli) {
        this.apeCli = apeCli;
    }

    public String getDirecCli() {
        return direcCli;
    }

    public void setDirecCli(String direcCli) {
        this.direcCli = direcCli;
    }

    public String getIdNac() {
        return idNac;
    }

    public void setIdNac(String idNac) {
        this.idNac = idNac;
    }

    public int getDniCli() {
        return dniCli;
    }

    public void setDniCli(int dniCli) {
        this.dniCli = dniCli;
    }

    public int getCelCli() {
        return celCli;
    }

    public void setCelCli(int celCli) {
        this.celCli = celCli;
    }

    public LocalDate getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(LocalDate fechaReg) {
        this.fechaReg = fechaReg;
    }

}
