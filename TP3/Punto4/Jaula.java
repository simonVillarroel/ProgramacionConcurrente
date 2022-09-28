package TP3.Punto4;

public class Jaula {
    private Actividad rueda = new Actividad("Rueda");
    private Actividad hamaca = new Actividad("Hamaca");
    private Actividad plato = new Actividad("Plato");

    public Jaula(){

    }
    public Actividad getHamaca() {
        return hamaca;
    }
    public Actividad getPlato() {
        return plato;
    }
    public Actividad getRueda() {
        return rueda;
    }
}
