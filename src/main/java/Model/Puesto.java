package Model;

public class Puesto {
    private String tipPuesto;
    private String puesto;
    
    public Puesto (String tipPuesto, String puesto){
    this.tipPuesto = tipPuesto;
    this.puesto = puesto;
    }
    
    public Puesto(){
    }

    public String getTipPuesto() {
        return tipPuesto;
    }

    public void setTipPuesto(String tipPuesto) {
        this.tipPuesto = tipPuesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
