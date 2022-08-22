package TP2.Punto6;

public class Cliente {
    private String nombre;
    private int[] carroCompra;

    public Cliente(String nom, int[] carro){
        this.nombre = nom;
        this.carroCompra = carro;
    }

    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nom){
        this.nombre = nom;
    }

    public int[] getCarroCompra(){
        return this.carroCompra;
    }
    public void setCarroCompra(int[] carro){
        this.carroCompra = carro;
    }
}
