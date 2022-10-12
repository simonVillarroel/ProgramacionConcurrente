package TP4.Punto7;

import java.util.concurrent.Semaphore;

public class GestorCruce {
    private Semaphore semNorte;
    private Semaphore semOeste;
    private Semaphore semCambio;

    public GestorCruce(){
        this.semNorte = new Semaphore(1);
        this.semOeste = new Semaphore(0);
        this.semCambio = new Semaphore(1);
    }

    public void cruzaNorte(){
        try {
            this.semNorte.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void saleNorte(){
        this.semNorte.release();
    }

    public void cruzaOeste(){
        try {
            this.semOeste.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void saleOeste(){
        this.semOeste.release();
    }

    public void cambiaSemaforos(int senial) throws InterruptedException{
        semCambio.acquire();
        if(senial == 0){
            semNorte.acquire();
            System.out.println("Cambio de semaforos");
            semOeste.release();
        }else{
            semOeste.acquire();
            System.out.println("Cambio de semaforos");
            semNorte.release();
        }
        semCambio.release();
    }

    public Semaphore getSemCambio() {
        return semCambio;
    }
}
