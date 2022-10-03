package TP4.Punto5;

public class Taxista implements Runnable{
    private Taxi taxi;

    public Taxista(Taxi t){
        this.taxi = t;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+": Comienza el turno.");
       
        while(true){
            try {
                System.out.println(Thread.currentThread().getName()+
                ": Se va a dormir, espera a que algun pasajero lo despierte.");
                taxi.disponible();
                taxi.preguntarDestino();
                System.out.println(Thread.currentThread().getName()+": Comienza a conducir.");
                conducir();
                System.out.println(Thread.currentThread().getName()+": Se llego al destino");
                taxi.llegada();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+": Volviendo a la base.");
            conducir();
            System.out.println(Thread.currentThread().getName()+": llego a la base.");
        }
    }

    public void conducir(){
        int random = (int) (Math.random() * 3 + 3);
        try{
            Thread.sleep(random*1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
