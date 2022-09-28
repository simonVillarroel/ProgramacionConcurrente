package TP4.Punto4;

import java.util.concurrent.Semaphore;

public class CentroImpresion {
    private Semaphore impresoraTipoA;
    private Semaphore impresoraTipoB;

    public CentroImpresion(){
        this.impresoraTipoA = new Semaphore(1);
        this.impresoraTipoB = new Semaphore(1);
    }

    public void usarImpresoraA(){
        try {
            impresoraTipoA.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void usarImpresoraB(){
        try {
            impresoraTipoB.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void liberarImpresoraA(){
        impresoraTipoA.release();
    }
    public void liberarImpresoraB(){
        impresoraTipoB.release();
    }
}
