package TP5.Punto4;

public class ControlTren implements Runnable{
    private Tren tren;

    public ControlTren(Tren t){
        this.tren = t;
    }

    public void run(){
        while(true){
            try {
                tren.comenzarViaje();
                System.out.println(Thread.currentThread().getName()+": Se cerraron las puertas del tren. Comienza el viaje.");
                viajar();
                System.out.println(Thread.currentThread().getName()+": Terminó el viaje. Se abrieron las puertas del tren.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tren.finalizarViaje();
        }
    }

    public void viajar() throws InterruptedException{
        Thread.sleep(5000);
    }
}
