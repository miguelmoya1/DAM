package repasoexamen;

/**
 * @author Miguel Moya Ortega
 */
public class Modelo {
    protected String nombre;
    protected String pais;
    protected int anyo;
    
    public Modelo(String nombre, String pais, int anyo) {
        this.nombre = nombre;
        this.pais = pais;
        this.anyo = anyo;
    }
    
    @Override
    public String toString() {
        return nombre + "-" + pais + "-" + anyo;
    }
}
