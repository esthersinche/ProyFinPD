package Model;

public class Editorial {
    private String idEdito;
    private String nomEdito;
    private String direcEdito;
    private int celEdito;
    
    public Editorial (String idEdito, String nomEdito, String direcEdito, int celEdito){
    this.idEdito = idEdito;
    this.nomEdito = nomEdito;
    this.direcEdito = direcEdito;
    this.celEdito = celEdito;    
    }
    
    public Editorial (){
    }
    
    public String getIdEdito() {
        return idEdito;
    }

    public void setIdEdito(String idEdito) {
        this.idEdito = idEdito;
    }

    public String getNomEdito() {
        return nomEdito;
    }

    public void setNomEdito(String nomEdito) {
        this.nomEdito = nomEdito;
    }

    public String getDirecEdito() {
        return direcEdito;
    }

    public void setDirecEdito(String direcEdito) {
        this.direcEdito = direcEdito;
    }

    public int getCelEdito() {
        return celEdito;
    }

    public void setCelEdito(int celEdito) {
        this.celEdito = celEdito;
    }
}
