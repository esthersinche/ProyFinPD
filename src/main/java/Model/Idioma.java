package Model;

public class Idioma {
    private String idIdioma;
    private String idioma;
    
    public Idioma(String idIdioma, String idioma){
        this.idIdioma = idIdioma;
        this.idioma = idioma;
    }
    
    public Idioma(){
    }
    
    public String getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(String idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
