package Model;

public class Genero {
    private String idGen;
    private String genero;
    
    public Genero(String idGen, String genero){
        this.idGen = idGen;
        this.genero = genero;
    }
    
    public Genero(){
    }
    
    public String getIdGen() {
        return idGen;
    }

    public void setIdGen(String idGen) {
        this.idGen = idGen;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
