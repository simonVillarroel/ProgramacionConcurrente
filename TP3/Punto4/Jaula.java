package TP3.Punto4;

public class Jaula {
    private Rueda rueda = new Rueda();
    private Hamaca hamaca = new Hamaca();
    private Plato plato = new Plato();

    public Jaula(){

    }
    public Rueda getRueda(){
        return this.rueda;
    }
    public Plato getPlato(){
        return this.plato;
    }
    public Hamaca getHamaca(){
        return this.hamaca;
    }
}
