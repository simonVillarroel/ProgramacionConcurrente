package TP3.Punto3Correccion;

public class Suma {
    private int sumaTotal = 0;

    public int getSumaTotal() {
        return sumaTotal;
    }

    public synchronized void incrementar(int cantidad){
        this.sumaTotal += cantidad;
    }
}
