package Model;

public class Modalidad {
    private String tipMod;
    private String modalidad;
    
    public Modalidad(String tipMod, String modalidad){
        this.tipMod = tipMod;
        this.modalidad = modalidad;
    }
    
    public Modalidad(){
    }
    public String getTipMod() {
        return tipMod;
    }

    public void setTipMod(String tipMod) {
        this.tipMod = tipMod;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }
}
