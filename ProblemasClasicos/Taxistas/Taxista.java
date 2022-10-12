package ProblemasClasicos.Taxistas;

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
                taxi.llegada();
                
            } catch (InterruptedException e){
                e.printStackTrace();
            }
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
