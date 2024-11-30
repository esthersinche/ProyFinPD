package Model;

public class Nacionalidad {
    private String idNac;
    private String nacion;
    
    public Nacionalidad(String idNac, String nacion){
        this.idNac = idNac;
        this.nacion = nacion;
    }
    
    public Nacionalidad(){
    }

    public String getIdNac() {
        return idNac;
    }

    public void setIdNac(String idNac) {
        this.idNac = idNac;
    }

    public String getNacion() {
        return nacion;
    }

    public void setNacion(String nacion) {
        this.nacion = nacion;
    }
}
