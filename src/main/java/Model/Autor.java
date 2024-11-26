package Model;

public class Autor {
    private String idAutor;
    private String nomAutor;
    private String apeAutor;
    private String idNac;
    
    public Autor(String idAutor, String nomAutor, String apeAutor, String idNac){
        this.idAutor = idAutor;
        this.nomAutor = nomAutor;
        this.apeAutor = apeAutor;
        this.idNac = idNac;
    }

    public String getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
    }

    public String getNomAutor() {
        return nomAutor;
    }

    public void setNomAutor(String nomAutor) {
        this.nomAutor = nomAutor;
    }

    public String getApeAutor() {
        return apeAutor;
    }

    public void setApeAutor(String apeAutor) {
        this.apeAutor = apeAutor;
    }

    public String getIdNac() {
        return idNac;
    }

    public void setIdNac(String idNac) {
        this.idNac = idNac;
    }
}
