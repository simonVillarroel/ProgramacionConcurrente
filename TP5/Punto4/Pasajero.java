package TP5.Punto4;

public class Pasajero implements Runnable{
    private Tren tren;

    public Pasajero(Tren t){
        this.tren = t;
    }

    public void run(){
        try {
            tren.comprarTicket();
            System.out.println(Thread.currentThread().getName()+" compró un ticket y subió al tren");
            tren.bajar();
            System.out.println(Thread.currentThread().getName()+" bajó del tren");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}