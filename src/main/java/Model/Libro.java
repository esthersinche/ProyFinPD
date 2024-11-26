package Model;

public class Libro {
    private String idLibro;
    private String titulo;
    private double precio;
    private String idAutor;
    private String idEdito;
    private String idGen;
    private String idIdioma;
    
    public Libro(String idLibro, String titulo, double precio, String idAutor, String idEdito, String idGen, String idIdioma) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.precio = precio;
        this.idAutor = idAutor;
        this.idEdito = idEdito;
        this.idGen = idGen;
        this.idIdioma = idIdioma;
    }
    
    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
    }

    public String getIdEdito() {
        return idEdito;
    }

    public void setIdEdito(String idEdito) {
        this.idEdito = idEdito;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
