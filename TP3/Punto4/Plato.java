package TP3.Punto4;

public class Plato {
    private int tiempoDeComer = 3000;

    public synchronized void comer() {
        try {
            Thread.sleep(tiempoDeComer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
