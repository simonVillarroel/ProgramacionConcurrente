package TP4.Punto4;

import java.util.concurrent.Semaphore;

public class CentroImpresion {
    private Semaphore impresoraTipoA;
    private Semaphore impresoraTipoB;

    public CentroImpresion(){
        this.impresoraTipoA = new Semaphore(1);
        this.impresoraTipoB = new Semaphore(1);
    }

    public boolean usarImpresoraA(){
        boolean exito = false;
        try {
            impresoraTipoA.acquire();
            exito = true;
            System.out.println("+++"+Thread.currentThread().getName()+" usando impresora A");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---"+Thread.currentThread().getName()+" libero impresora A");
        impresoraTipoA.release();
        return exito;
    }
    public boolean usarImpresoraB(){
        boolean exito = false;
        try {
            impresoraTipoB.acquire();
            exito = true;
            System.out.println(Thread.currentThread().getName()+" usando impresora B");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---"+Thread.currentThread().getName()+" libero impresora B");
        impresoraTipoB.release();
        return exito;
    }

    public Semaphore getImpresoraTipoA() {
        return impresoraTipoA;
    }
    public Semaphore getImpresoraTipoB() {
        return impresoraTipoB;
    }
}
