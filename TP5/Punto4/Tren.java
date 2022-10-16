package TP5.Punto4;

import java.util.concurrent.Semaphore;

public class Tren {
    private Semaphore asientos;
    private Semaphore semViaje;
    private Semaphore semPuerta; //Indica si el tren ha llenado sus asientos

    public Tren(){
        this.asientos = new Semaphore(20);
        this.semViaje = new Semaphore(1);
        this.semPuerta = new Semaphore(1);
    }

    public void subir() throws InterruptedException{
        asientos.acquire();
    }
    public void bajar(){
        asientos.release();
    }

    public void comenzarViaje() throws InterruptedException{
        semViaje.acquire();
    }
    public void terminarViaje(){
        semViaje.release();
    }

    public void cerrarPuerta() throws InterruptedException{
        semPuerta.acquire();
    }
    public void abrirPuerta(){
        semPuerta.release();
    }
}