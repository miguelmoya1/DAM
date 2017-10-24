package repasoexamen;

import java.io.Serializable;

/**
 * @author Miguel Moya Ortega
 */
public class Vehiculo implements Serializable {
    private int id;
    protected String marca;
    protected String modelo;
    
    public int getId() {
        return this.id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    Vehiculo(int id, String marca, String modelo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
    }
    
    @Override
    public String toString() {
        return id + "-" + marca + "-" + modelo;
    }
}
