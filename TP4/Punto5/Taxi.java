package TP4.Punto5;

import java.util.concurrent.Semaphore;

class Taxi{
    private Semaphore semPasajero;
    private Semaphore semViaje;
    private Semaphore semTaxi;

    public Taxi(){
        this.semPasajero = new Semaphore(0);
        this.semViaje = new Semaphore(0);
        this.semTaxi = new Semaphore(0);
    }

    //Metodos utilizados por el pasajero
    public void pedirTaxi() throws InterruptedException{
        semTaxi.acquire();
    }
    public void subirAlTaxi() throws InterruptedException{
        semPasajero.release();
    }
    public void bajarDelTaxi() throws InterruptedException{
        semViaje.acquire();
    }

    //Metodos utilizados por el taxista
    public void disponible() throws InterruptedException{
        semTaxi.release();
    }
    public void preguntarDestino() throws InterruptedException{
        semPasajero.acquire();
    }
    public void llegada() throws InterruptedException{
        semViaje.release();
        
    }
}
