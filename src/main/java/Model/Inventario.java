package Model;

public class Inventario {
    private String idLibro;
    private String idGen;
    private String idIdioma;
    private String idEdito;
    private int stock;

    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getIdGen() {
        return idGen;
    }

    public void setIdGen(String idGen) {
        this.idGen = idGen;
    }

    public String getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(String idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getIdEdito() {
        return idEdito;
    }

    public void setIdEdito(String idEdito) {
        this.idEdito = idEdito;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
