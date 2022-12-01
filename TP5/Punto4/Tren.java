package TP5.Punto4;

import java.util.concurrent.Semaphore;

public class Tren {
    
    private int cantAsientos, asientosOcupados;
    private Semaphore ticketsVendidos, tickets;
    private Semaphore inicioVenta;
    private Semaphore inicioViaje, bajar, mutex;

    public Tren(int cant){
        this.asientosOcupados = 0;
        this.cantAsientos = cant;
        this.inicioVenta = new Semaphore(2);
        this.tickets = new Semaphore(0);
        this.ticketsVendidos = new Semaphore(0);
        this.inicioViaje = new Semaphore(0);
        this.bajar = new Semaphore(0);
        this.mutex = new Semaphore(1);
    }

    public boolean asientosVacios(){
        return (asientosOcupados == 0);
    }

    //Metodos utilizados por Pasajero
    public void comprarTicket() throws InterruptedException{
        tickets.acquire();
        ticketsVendidos.release();
        this.mutex.acquire();
        this.asientosOcupados++;
        this.mutex.release();
    }

    public void bajar() throws InterruptedException{
        bajar.acquire();
        mutex.acquire();
        asientosOcupados--;       
        if(asientosVacios()){
            inicioVenta.release();
        }
        mutex.release();
    }

    //Metodos utilizados por ControlTren
    public void comenzarViaje() throws InterruptedException{
        inicioViaje.acquire();
    }
    public void finalizarViaje(){
        this.bajar.release(cantAsientos);
        inicioVenta.release();
    }

    //Metodos utilizados por VendedorTickets
    public void abrirVenta() throws InterruptedException{
        inicioVenta.acquire(2);
        tickets.release(cantAsientos);
    }
    public void cerrarVenta() throws InterruptedException{
        ticketsVendidos.acquire(cantAsientos);
    }
    public void notificarAControl(){
        inicioViaje.release();
    }
}