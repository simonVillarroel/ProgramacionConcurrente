package TP3.Punto5;

public class Vehiculo {
    private String patente;
    private String modelo;
    private String marca;
    private int km;

    public Vehiculo(String pat, String mod, String mar, int km){
        this.patente = pat;
        this.modelo = mod;
        this.marca = mar;
        this.km = km;
    }

    public void aumentarKm(int cantidad){
        this.km += cantidad;
    }

    public String getPatente() {
        return patente;
    }
    public String getModelo() {
        return modelo;
    }
    public String getMarca() {
        return marca;
    }
    public int getKm() {
        return km;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setKm(int km) {
        this.km = km;
    }
}
