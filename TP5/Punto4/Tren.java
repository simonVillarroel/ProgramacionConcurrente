package TP5.Punto4;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Tren {
    private boolean[] asientos;
    private int cantAsientos, asientosOcupados;
    private Semaphore semAsientos, semTickets;
    private Semaphore semInicioVenta, semFinVenta;
    private Semaphore semInicioViaje, semFinViaje;

    public Tren(int cant){
        this.asientosOcupados = 0;
        this.cantAsientos = cant;
        this.asientos = new boolean[cantAsientos];
        Arrays.fill(asientos, false);
        this.semAsientos = new Semaphore(cantAsientos);

        this.semTickets = new Semaphore(0);
        this.semInicioVenta = new Semaphore(2);
        this.semFinVenta = new Semaphore(0);
        this.semInicioViaje = new Semaphore(0);
        this.semFinViaje = new Semaphore(0);
    }

    public boolean asientosLlenos(){
        return (asientosOcupados == cantAsientos);
    }
    public boolean asientosVacios(){
        return (asientosOcupados == 0);
    }

    //Metodos utilizados por Pasajero
    public void comprarTicket() throws InterruptedException{
        semTickets.acquire();
        if(semTickets.availablePermits() == 0){
            semFinVenta.release();
        }
    }
    public void subir() throws InterruptedException{
        semAsientos.acquire();
        asientosOcupados++;
        asientos[asientosOcupados-1] = true;
        if(asientosLlenos()){
            semInicioViaje.release();
        }
    }
    public void bajar() throws InterruptedException{
        semFinViaje.acquire();
        semAsientos.release();
        asientos[asientosOcupados-1] = false;
        asientosOcupados--;
        if(asientosVacios()){
            semInicioVenta.release();
        }
    }

    //Metodos utilizados por ControlTren
    public void comenzarViaje() throws InterruptedException{
        semInicioViaje.acquire(2);
    }
    public void finalizarViaje(){
        semFinViaje.release(cantAsientos);
        semInicioVenta.release();
    }

    //Metodos utilizados por VendedorTickets
    public void abrirVenta() throws InterruptedException{
        semInicioVenta.acquire(2);
        semTickets.release(cantAsientos);
    }
    public void cerrarVenta() throws InterruptedException{
        semFinVenta.acquire();
    }
    public void notificarAControl(){
        semInicioViaje.release();
    }
}