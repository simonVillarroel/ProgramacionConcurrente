package TP3.HamstersConSemaforo;

import java.util.concurrent.Semaphore;

public class Jaula {
    private Semaphore rueda;
    private Semaphore hamaca;
    private Semaphore plato;

    public Jaula(){
        this.rueda = new Semaphore(1);
        this.hamaca = new Semaphore(1);
        this.plato = new Semaphore(1);
    }
    public void usarHamaca() {
        try {
            hamaca.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void liberarHamaca(){
        this.hamaca.release();
    }

    public void usarPlato() {
        try {
            this.plato.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void liberarPlato(){
        this.plato.release();
    }

    public void usarRueda() {
        try {
            this.rueda.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void liberarRueda(){
        this.rueda.release();
    }
}
