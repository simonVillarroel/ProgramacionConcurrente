package TP5.Punto4;

public class Pasajero implements Runnable{
    private Tren tren;

    public Pasajero(Tren t){
        this.tren = t;
    }

    public void run(){
        //Compra del ticket
        try {
            tren.comprarTicket();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" compró un ticket");

        //Subida y bajada del tren
        try {
            tren.subir();
            System.out.println(Thread.currentThread().getName()+" subió al tren");
            tren.bajar();
            System.out.println(Thread.currentThread().getName()+" bajó del tren");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}